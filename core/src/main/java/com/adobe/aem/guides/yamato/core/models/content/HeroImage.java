package com.adobe.aem.guides.yamato.core.models.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroImage {
    @ValueMapValue
    private List<String> items;

    private List<Image> heroImages = new ArrayList<Image>();

    @PostConstruct
    public void init() {
        if (items == null) items = Collections.emptyList();
        items.stream().forEach(item -> {
            heroImages.add(new Image(item));
        });
    }

    public List<Image> getHeroImages() {
        return heroImages;
    }

    public boolean isEmpty() {
        return heroImages.isEmpty();
    }
}