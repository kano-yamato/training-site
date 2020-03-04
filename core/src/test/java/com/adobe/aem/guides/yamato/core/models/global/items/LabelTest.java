package com.adobe.aem.guides.yamato.core.models.global.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.day.cq.wcm.api.Page;

@ExtendWith(AemContextExtension.class)
public class LabelTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() {
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/header/content.json", "/content/yamato/");
    }

    @Test
    public void testLabel() {
        Page page = ctx.currentPage("/content/yamato/jp/ja/ecm");
        Label label = new Label(page);
        String expected = "ECM事業部";
        assertEquals(expected, label.toString());
    }
}
