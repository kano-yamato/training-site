package com.adobe.aem.guides.yamato.core.models.news.pager.items;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PreviewTest {
    @Test
    public void testExists() {
        assertTrue(new Preview(2).exists());
    }

    @Test
    public void testNotExists() {
        assertFalse(new Preview(1).exists());
    }

    @Test
    public void testPreviewPath() {
        assertEquals("/content/yamato/jp/ja/news.1.html", new Preview(2).getPrevPath());
    }
}
