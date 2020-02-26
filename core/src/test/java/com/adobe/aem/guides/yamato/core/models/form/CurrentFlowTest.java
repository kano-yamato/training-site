package com.adobe.aem.guides.yamato.core.models.form;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AemContextExtension.class)
public class CurrentFlowTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() {
        ctx.addModelsForClasses(CurrentFlow.class);
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/form/form-page.json", "/content/yamato/jp/ja/");
    }

    @Test
    public void currentFlowIsInputTest() throws Exception {
        ctx.currentResource("/content/yamato/jp/ja/form-page/jcr:content/root/responsivegrid/container/form_current_flow");
        CurrentFlow cf = ctx.request().adaptTo(CurrentFlow.class);
        Map<String, Boolean> expected = new ImmutableMap.Builder<String, Boolean>()
                .put("入力", Boolean.TRUE)
                .put("確認", Boolean.FALSE)
                .put("完了", Boolean.FALSE).build();
        Map<String, Boolean> actual = cf.getFlowNameToHtmlClass();
        assertEquals(expected, actual);
    }
}
