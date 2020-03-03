package com.adobe.aem.guides.yamato.core.models.global;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.IteratorUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Navigation {
    @SlingObject
    private Resource currentResource;

    @SlingObject
    private ResourceResolver resourceResolver;

    private List<NavigationItem> navigations = new ArrayList<NavigationItem>();

    @PostConstruct
    public void init() {
        if (currentResource.hasChildren()) {
            currentResource.getChild("items").getChildren().forEach(
                resource -> navigations.add(generateNavigationItem(resource))
            );
        }
    }

    @SuppressWarnings("unchecked")
    private NavigationItem generateNavigationItem(Resource resource) {
        final boolean needBalloon = resource.getValueMap().get("needBalloon", false);
        final String rootPath = resource.getValueMap().get("naviRoot", "/content/yamato/jp/ja");
        final PageManager pm = resourceResolver.adaptTo(PageManager.class);
        final Page rootPage = pm.getPage(rootPath);
        final String label = rootPage.getTitle();
        final List<Page> pages = IteratorUtils.toList(rootPage.listChildren());
        return new NavigationItem(needBalloon, rootPath, label, pages);
    }

    public List<NavigationItem> getNavigations() {
        return navigations;
    }

    public boolean isEmpty() {
        return navigations.isEmpty();
    }
}
