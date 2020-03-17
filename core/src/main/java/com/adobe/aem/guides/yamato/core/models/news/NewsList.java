package com.adobe.aem.guides.yamato.core.models.news;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;
import com.day.cq.wcm.api.PageManager;
import com.google.common.collect.ImmutableMap;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.Model;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class NewsList {
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
        // listChildren()の戻り値は、createPageFilter()で作成されたPageFilterオブジェクトによって決まる
        Iterator<Page> children = rootPage == null ? IteratorUtils.emptyIterator() : rootPage.listChildren(createPageFilter());
        List<Page> sortedChildren = IteratorUtils.toList(children).stream().sorted(
            Comparator.comparing(Page::getLastModified).reversed()
        ).collect(Collectors.toList());
        sortedChildren.forEach(child -> articlePages.add(generateArticlePage(child)));
    }

    /**
     * PageオブジェクトからArticlePageオブジェクトを生成するメソッド
     * @param page 記事ページ
     * @return ArticlePageオブジェクト
     */
    private ArticlePage generateArticlePage(final Page page) {
        final ValueMap articleProperties = page.getContentResource("root/responsivegrid/article").getValueMap();
        final String title = page.getTitle();
        final String path = page.getPath();
        final String category = articleProperties.get("category", "all");
        final String categoryDisplayName = categoryToDisplayName.get(category);
        return new ArticlePage(page.getLastModified().getTime(), title, path, category, categoryDisplayName);
    }

    /**
     * page.listChildren()メソッドの引数となるPageFilterを生成するメソッド
     * page.listChildren(pageFilter)が返すページ群は以下のルールで決定される
     * ・currentPageのjcr:titleが「ニュース・コラム」の場合、全てのニュース記事ページが対象となる
     * ・currentPageのjcr:titleが「お知らせ」の場合、記事コンポーネントのcategoryプロパティがinfoのページが検索対象となる
     * ・currentPageのjcr:titleが「製品・サービス」の場合、記事コンポーネントのcategoryプロパティがproductsのページが検索対象となる
     * ・currentpageのjcr:titleが「コラム」の場合、記事コンポーネントのcategoryプロパティがcolumnsのページが検索対象となる
     * @return page.listChildren()が返すイテレータを絞り込むためのPageFilterオブジェクト
     */
    private PageFilter createPageFilter() {
        return new PageFilter() {
            @Override
            public boolean includes(final Page page) {
                final String currentCategory = titleToCategory.getOrDefault(currentPage.getTitle(), "all");
                // pageが記事ページでない場合、root/responsivegrid/articleノードが存在しないため、getContentResource()がnullを返す。
                // その場合、childResource.getValueMap()でNPEを送出するため、その前にfalseを返却する
                final Resource childResource = page.getContentResource("root/responsivegrid/article");
                if (childResource == null) return false;
                final String childCategory = childResource.getValueMap().get("category", "all");
                return StringUtils.equals(childCategory, currentCategory) || StringUtils.equals("all", currentCategory);
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
