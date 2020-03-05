package com.adobe.aem.guides.yamato.core.models.global.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.api.resource.Resource;

@ExtendWith(AemContextExtension.class)
public class NeedBalloonTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() {
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/header/navigation.json", "/content/experience-fragments/yamato/jp/ja/site/");
    }

    @Test
    public void testNeedBalloon_propertiesExists() {
        Resource currentResource = ctx.currentResource("/content/experience-fragments/yamato/jp/ja/site/header/master/jcr:content/root/responsivegrid/responsivegrid/navigation/items/item1/");
        ShowChild showChild = new ShowChild(currentResource);
        boolean expected = true;
        assertEquals(expected, showChild.value());
    }

    @Test
    public void testNeedBalloon_propertiesNotExists() {
        Resource currentResource = ctx.currentResource("/content/experience-fragments/yamato/jp/ja/site/header/master/jcr:content/root/responsivegrid/responsivegrid/navigation/items/item0/");
        ShowChild showChild = new ShowChild(currentResource);
        boolean expected = false;
        assertEquals(expected, showChild.value());
    }
}

