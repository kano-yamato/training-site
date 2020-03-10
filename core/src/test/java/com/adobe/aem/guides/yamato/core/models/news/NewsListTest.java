package com.adobe.aem.guides.yamato.core.models.news;

import java.util.GregorianCalendar;
import java.util.List;

import com.google.common.collect.ImmutableList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(AemContextExtension.class)
public class NewsListTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() {
        ctx.addModelsForClasses(NewsList.class);
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/news/news.json", "/content/yamato/jp/ja/");
    }

    @Test
    public void testGetArticlePages() {
        ctx.currentPage("/content/yamato/jp/ja/news");
        ctx.currentResource("/content/yamato/jp/ja/news/jcr:content/root/responsivegrid/list");
        NewsList nw = ctx.request().adaptTo(NewsList.class);
        List<ArticlePage> expected = new ImmutableList.Builder<ArticlePage>()
                .add(new ArticlePage(new GregorianCalendar(2020, 2, 5).getTime(), "第1回 CARA ハンズオン会のご報告", "/content/yamato/jp/ja/news/20200131-1502", "products", "製品・サービス"))
                .add(new ArticlePage(new GregorianCalendar(2020, 0, 1).getTime(), "2020年　年頭のご挨拶", "/content/yamato/jp/ja/news/20200101-721", "info", "お知らせ"))
                .add(new ArticlePage(new GregorianCalendar(2020, 1, 4).getTime(), "コラム", "/content/yamato/jp/ja/news/20200103-731", "columns", "コラム")).build();
        List<ArticlePage> actual = nw.getArticlePages();
        assertIterableEquals(expected, actual);
    }
}
