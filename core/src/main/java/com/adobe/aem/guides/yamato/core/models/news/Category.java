package com.adobe.aem.guides.yamato.core.models.news;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Category {
    @ValueMapValue
    private String category;

    public String getCategoryDisplayName() {
        Map<String, String> categoryToDisplayName = new ImmutableMap.Builder<String, String>()
                .put("info", "お知らせ")
                .put("products", "製品・サービス")
                .put("columns", "コラム").build();
        return categoryToDisplayName.get(category);
    }
}
