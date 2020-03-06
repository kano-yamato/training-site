package com.adobe.aem.guides.yamato.core.models.news;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;
import com.day.cq.wcm.api.PageManager;
import com.google.common.collect.ImmutableMap;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.models.annotations.Model;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class NewsList {
    private static final Logger LOG = LoggerFactory.getLogger(NewsList.class);
    @SlingObject
    private ResourceResolver resourceResolver;

    @ScriptVariable
    private Page currentPage;

    @ValueMapValue
    private String rootPath;

    private final List<ArticlePage> articlePages = new ArrayList<ArticlePage>();

    private final Map<String, String> titleToCategory = new ImmutableMap.Builder<String, String>()
            .put("ニュース・コラム", "all")
            .put("お知らせ", "info")
            .put("製品・サービス", "products")
            .put("コラム", "columns").build();

    private final Map<String, String> categoryToDisplayName = new ImmutableMap.Builder<String, String>()
            .put("info", "お知らせ")
            .put("products", "製品・サービス")
            .put("columns", "コラム").build();

    @PostConstruct
    public void init() {
        final PageManager pm = resourceResolver.adaptTo(PageManager.class);
        final Page rootPage = pm.getPage(rootPath);
        Iterator<Page> children = rootPage.listChildren(createPageFilter());
        while (children.hasNext()) {
            final Page child = children.next();
            articlePages.add(generateArticlePage(child));
        }
    }

    private ArticlePage generateArticlePage(final Page page) {
        final ValueMap articleProperties = page.getContentResource("root/responsivegrid/article").getValueMap();
        final Date date = articleProperties.get("date", new Date());
        final String title = page.getTitle();
        final String path = page.getPath();
        final String category = articleProperties.get("category", "all");
        final String categoryDisplayName = categoryToDisplayName.get(category);
        return new ArticlePage(date, title, path, category, categoryDisplayName);
    }

    private PageFilter createPageFilter() {
        return new PageFilter() {
            @Override
            public boolean includes(final Page page) {
                final String currentCategory = titleToCategory.getOrDefault(currentPage.getTitle(), "all");
                final Resource childResource = page.getContentResource("root/responsivegrid/article");
                if (childResource == null) return false;
                final String childCategory = childResource.getValueMap().get("category", "all");
                return childCategory.equals(currentCategory) || StringUtils.equals("all", currentCategory);
            }
        };
    }

    public List<ArticlePage> getArticlePages() {
        return articlePages;
    }

    public boolean isEmpty() {
        return articlePages.isEmpty();
    }
}
