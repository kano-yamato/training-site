package com.adobe.aem.guides.yamato.core.models.form;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.google.common.collect.ImmutableList;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    resourceType = {CurrentFlow.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CurrentFlow {
    protected static final String RESOURCE_TYPE = "yamato/components/form/form-current-flow";
    @ValueMapValue
    private String currentFlow;

    private Map<String, Boolean> flowNameToHtmlClass = new LinkedHashMap<String, Boolean>();

    @PostConstruct
    public void init() {
        List<String> flows = new ImmutableList.Builder<String>()
                .add("入力")
                .add("確認")
                .add("完了").build();
        flows.stream().forEach(flow -> flowNameToHtmlClass.put(flow, isActive(flow)));
    }

    private Boolean isActive(final String flow) {
        return StringUtils.equals(flow, currentFlow);
    }

    public Map<String, Boolean> getFlowNameToHtmlClass() {
        return flowNameToHtmlClass;
    }
}
