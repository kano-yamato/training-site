package com.adobe.aem.guides.yamato.core.models.form;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(AemContextExtension.class)
public class OptionTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() {
        ctx.addModelsForClasses(Option.class);
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/form/form-page.json", "/content/yamato/jp/ja/");
    }

    @Test
    public void testGetItems() throws Exception {
        ctx.currentResource("/content/yamato/jp/ja/form-page/jcr:content/root/responsivegrid/container/options");
        Option op = ctx.request().adaptTo(Option.class);
        List<OptionItem> expected = new ImmutableList.Builder<OptionItem>()
                .add(new OptionItemImpl(true, false, "選択してください", ""))
                .add(new OptionItemImpl(false, false, "製品・ソリューションについて", "製品・ソリューションについて"))
                .add(new OptionItemImpl(false, true, "無効", "無効")).build();
        List<OptionItem> actual = op.getOptionItems();
        assertIterableEquals(expected, actual);
    }
}
