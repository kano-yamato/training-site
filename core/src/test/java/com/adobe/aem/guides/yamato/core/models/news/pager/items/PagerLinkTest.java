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
    public void testGetCurrentAttr_currentIsTrue() {
        assertEquals("current", new PagerLink(1, 1).getCurrentAttribute());
    }

    @Test
    public void testGetCurrentAttr_currentIsFalse() {
        assertEquals("", new PagerLink(1, 2).getCurrentAttribute());
    }

    @Test
    public void testGetAriaCurrent_currentIsTrue() {
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
                .put("aria-current", "page").build();
        Map<String, String> actual = new PagerLink(1, 1).getAriaCurrent();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAriaCurrent_currentIsFalse() {
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
                .put("aria-current", "").build();
        Map<String, String> actual = new PagerLink(1, 2).getAriaCurrent();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTitle_currentIsTrue() {
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
                .put("title", "").build();
        Map<String, String> actual = new PagerLink(1, 1).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTitle_currentIsFalse() {
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
                .put("title", "Page 2").build();
        Map<String, String> actual = new PagerLink(1, 2).getTitle();
        assertEquals(expected, actual);
    }
}
