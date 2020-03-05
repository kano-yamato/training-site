package com.adobe.aem.guides.yamato.core.models.global;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
public class Footer extends Header {
    @SlingObject
    private Resource currentResource;

    @SlingObject
    private ResourceResolver resourceResolver;

    private List<List<NavigationItem>> footerNavigations = new ArrayList<List<NavigationItem>>();

    @PostConstruct
    public void init() {
        currentResource.getChildren()
            .forEach(resource -> footerNavigations.add(generateNavigations(resource)));
    }

    private List<NavigationItem> generateNavigations(Resource resource) {
        List<NavigationItem> navigationItems = new ArrayList<NavigationItem>();
        resource.getChild("items").getChildren().forEach(child -> navigationItems.add(generateNavigationItem(child)));
        return navigationItems;
    }

    public List<List<NavigationItem>> getFooterNavigations() {
        return footerNavigations;
    }

    public boolean isEmpty() {
        return footerNavigations.isEmpty();
    }
}
