package com.adobe.aem.guides.yamato.core.models.global;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.adobe.aem.guides.yamato.core.models.global.items.Label;
import com.adobe.aem.guides.yamato.core.models.global.items.ShowChild;
import com.adobe.aem.guides.yamato.core.models.global.items.Pages;
import com.adobe.aem.guides.yamato.core.models.global.items.RootPath;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.Model;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Header {
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

    protected NavigationItem generateNavigationItem(Resource resource) {
        final PageManager pm = resourceResolver.adaptTo(PageManager.class);
        RootPath rootPath = new RootPath(resource);
        Page rootPage = pm.getPage(rootPath.toString());
        return new NavigationItem(new ShowChild(resource), rootPath, new Label(rootPage), new Pages(rootPage));
    }


    public List<NavigationItem> getNavigations() {
        return navigations;
    }

    public boolean isEmpty() {
        return navigations.isEmpty();
    }
}
