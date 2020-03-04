package com.adobe.aem.guides.yamato.core.models.global;

import com.adobe.aem.guides.yamato.core.models.global.items.Label;
import com.adobe.aem.guides.yamato.core.models.global.items.NeedBalloon;
import com.adobe.aem.guides.yamato.core.models.global.items.Pages;
import com.adobe.aem.guides.yamato.core.models.global.items.RootPath;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.IteratorUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.adapter.Adaptable;
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

    private NavigationItem generateNavigationItem(Resource resource) {
        final PageManager pm = resourceResolver.adaptTo(PageManager.class);
        RootPath rootPath = new RootPath(resource);
        Page rootPage = pm.getPage(rootPath.toString());
        return new NavigationItem(new NeedBalloon(resource), rootPath, new Label(rootPage), new Pages(rootPage));
    }

    public List<NavigationItem> getNavigations() {
        return navigations;
    }

    public boolean isEmpty() {
        return navigations.isEmpty();
    }
}
