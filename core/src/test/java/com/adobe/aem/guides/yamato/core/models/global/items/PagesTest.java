package com.adobe.aem.guides.yamato.core.models.global.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import com.day.cq.wcm.api.Page;
import com.google.common.collect.ImmutableList;

@ExtendWith(AemContextExtension.class)
public class PagesTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() {
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/header/content.json", "/content/yamato/");
    }

    @Test
    public void testPages_hasChild() {
        Page rootPage = ctx.currentPage("/content/yamato/jp/ja/ecm/");
        Pages pages = new Pages(rootPage);
        List<Page> expected = new ImmutableList.Builder<Page>()
                .add(ctx.currentPage("/content/yamato/jp/ja/ecm/solution"))
                .add(ctx.currentPage("/content/yamato/jp/ja/ecm/case01")).build();
        assertEquals(expected, pages.toList());
    }

    @Test
    public void testPages_notHasChild() {
        Page rootPage = ctx.currentPage("/content/yamato/jp/ja/advantage/");
        Pages pages = new Pages(rootPage);
        List<Page> expected = Collections.emptyList();
        assertEquals(expected, pages.toList());
    }
}
