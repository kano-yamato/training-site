package com.adobe.aem.guides.yamato.core.models.form;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CurrentFlow {
    @ValueMapValue
    private String currentFlow;

    private Map<String, String> inputFlowAttr = new LinkedHashMap<String, String>();
    private Map<String, String> modifyFlowAttr = new LinkedHashMap<String, String>();
    private Map<String, String> completeFlowAttr = new LinkedHashMap<String, String>();

    @PostConstruct
    public void init() {
        inputFlowAttr.put("class", currentClassName("入力"));
        modifyFlowAttr.put("class", currentClassName("確認"));
        completeFlowAttr.put("class", currentClassName("完了"));
    }

    private String currentClassName(final String flow) {
        return StringUtils.equals(flow, currentFlow) ? "is-current" : "";
    }

    public Map<String, String> getInputFlowAttr() {
        return inputFlowAttr;
    }

    public Map<String, String> getModifyFlowAttr() {
        return modifyFlowAttr;
    }

    public Map<String, String> getCompleteFlowAttr() {
        return completeFlowAttr;
    }
}
