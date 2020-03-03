package com.adobe.aem.guides.yamato.core.models.global;

import org.apache.commons.collections.IteratorUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

import java.util.List;

import com.day.cq.wcm.api.Page;
import com.google.common.collect.ImmutableList;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class})
public class NavigationTest {
    private final AemContext ctx = new AemContext();

    @Mock
    private Page page;

    @BeforeEach
    public void setUp() {
        ctx.addModelsForClasses(Navigation.class);
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/header/navigation.json", "/content/experience-fragments/yamato/jp/ja/site/");
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/header/content.json", "/content/yamato/");
        lenient().when(page.getTitle()).thenReturn("");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetNavigation() throws Exception {
        ctx.currentResource("/content/experience-fragments/yamato/jp/ja/site/header/master/jcr:content/root/responsivegrid/responsivegrid/navigation");
        Navigation navigation = ctx.request().adaptTo(Navigation.class);
        Page advantage = ctx.currentPage("/content/yamato/jp/ja/advantage");
        Page ecm = ctx.currentPage("/content/yamato/jp/ja/ecm");
        Page wcm = ctx.currentPage("/content/yamato/jp/ja/wcm");
        List<NavigationItem> expected = new ImmutableList.Builder<NavigationItem>()
                .add(new NavigationItem(false, advantage.getPath(), advantage.getTitle(), IteratorUtils.toList(advantage.listChildren())))
                .add(new NavigationItem(true, ecm.getPath(), ecm.getTitle(), IteratorUtils.toList(ecm.listChildren())))
                .add(new NavigationItem(true, wcm.getPath(), wcm.getTitle(), IteratorUtils.toList(wcm.listChildren())))
                .build();
        List<NavigationItem> actual = navigation.getNavigations();
        assertEquals(expected, actual);
    }
}
