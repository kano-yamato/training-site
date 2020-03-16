package com.adobe.aem.guides.yamato.core.models.content;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class HeroTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() throws Exception {
        ctx.addModelsForClasses(Hero.class);
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/content/hero-image.json", "/content/yamato/jp/ja/");
    }

    @Test
    public void getNormalValueOfTitle() {
        ctx.currentResource("/content/yamato/jp/ja/current-page/jcr:content/root/responsivegrid/heroimage");
        Hero hero = ctx.request().adaptTo(Hero.class);
        String title = hero.getTitle();
        assertEquals("タイトル", title);
        }

    @Test
    public void getNormalValueOfCaption() {
        ctx.currentResource("/content/yamato/jp/ja/current-page/jcr:content/root/responsivegrid/heroimage");
        Hero hero = ctx.request().adaptTo(Hero.class);
        String caption = hero.getCaption();
        assertEquals("概要", caption);
        }

    @Test
    public void getNormalValueOfButtonLabel() {
        ctx.currentResource("/content/yamato/jp/ja/current-page/jcr:content/root/responsivegrid/heroimage");
        Hero hero = ctx.request().adaptTo(Hero.class);
        String buttonLabel = hero.getButtonLabel();
        assertEquals("ボタンラベル", buttonLabel);
        }

    @Test
    public void getNormalValueOfButtonLinkURL() {
        ctx.currentResource("/content/yamato/jp/ja/current-page/jcr:content/root/responsivegrid/heroimage");
        Hero hero = ctx.request().adaptTo(Hero.class);
        String buttonLinkURL = hero.getButtonLinkURL();
        assertEquals("/yamato/test-page", buttonLinkURL);
        }
}