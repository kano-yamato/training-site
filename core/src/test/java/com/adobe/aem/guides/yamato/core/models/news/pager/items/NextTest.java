package com.adobe.aem.guides.yamato.core.models.news.pager.items;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NextTest {
    @Test
    public void testExists() {
        assertTrue(new Next(4, 5).exists());
    }

    @Test
    public void testNotExists() {
        assertFalse(new Next(5, 5).exists());
    }

    @Test
    public void testPreviewPath() {
        assertEquals("/content/yamato/jp/ja/news.3.html", new Next(2, 5).getPrevPath());
    }
}

