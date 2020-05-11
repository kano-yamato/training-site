package com.adobe.aem.guides.yamato.core.models.news.pager.items;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.Test;

public class PagerLinkTest {
    @Test
    public void testGetTag_currentIsTrue() {
        assertEquals("span", new PagerLink(1, 1).getTag());
    }

    @Test
    public void testGetTag_currentIsFalse() {
        assertEquals("a", new PagerLink(1, 2).getTag());
    }

    @Test
    public void testGetCount() {
        assertEquals(2, new PagerLink(2, 2).getCount());
    }

    @Test
    public void testGetPath_hrefIsEmpty() {
        assertEquals("", new PagerLink(1, 1).getPath());
    }

    @Test
    public void testGetPath_hrefIsNotEmpty() {
        assertEquals("/content/yamato/jp/ja/news.2.html", new PagerLink(1, 2).getPath());
    }

    @Test
    public void testGetCurrentClass_currentIsTrue() {
        assertEquals("current", new PagerLink(1, 1).getCurrentClass());
    }

    @Test
    public void testGetCurrentClass_currentIsFalse() {
        assertEquals("", new PagerLink(1, 2).getCurrentClass());
    }

    @Test
    public void testGetAttribute_currentIsTrue() {
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
                .put("aria-current", "page")
                .put("title", "").build();
        Map<String, String> actual = new PagerLink(1, 1).getAttribute();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAriaCurrent_currentIsFalse() {
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
                .put("aria-current", "")
                .put("title", "Page 2").build();
        Map<String, String> actual = new PagerLink(1, 2).getAttribute();
        assertEquals(expected, actual);
    }
}
