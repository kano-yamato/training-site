package com.adobe.aem.guides.yamato.core.models.news.pager.items;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PagerLinkTest {
    @Test
    public void testPagerLinkSpanTag() {
        assertEquals("span", new PagerLink(1, 1).getTag());
    }

    @Test
    public void testPagerLinkATag() {
        assertEquals("a", new PagerLink(1, 2).getTag());
    }

    @Test
    public void testPagerLinkCount() {
        assertEquals(2, new PagerLink(2, 2).getCount());
    }

    @Test
    public void testPagerLinkPath() {
        assertEquals("/content/yamato/jp/ja/news.1.html", new PagerLink(1, 1).getPath());
    }
}
