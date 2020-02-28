package com.adobe.aem.guides.yamato.core.models.form;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    resourceType = Option.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Option {
    protected static final String RESOURCE_TYPE = "yamato/components/form/options";
    @SlingObject
    private Resource currentResource;

    private List<OptionItem> optionItems = new ArrayList<OptionItem>();

    @PostConstruct
    public void init() {
        if (currentResource.hasChildren()) {
            currentResource.getChild("items").getChildren().forEach(resource -> optionItems.add(generateOptionItem(resource)));
        }
    }

    private OptionItem generateOptionItem(Resource resource) {
        final boolean selected = resource.getValueMap().get("selected", false);
        final boolean disabled = resource.getValueMap().get("disabled", false);
        final String text = resource.getValueMap().get("text", "");
        final String value = resource.getValueMap().get("value", "");
        return new OptionItemImpl(selected, disabled, text, value);
    }

    public List<OptionItem> getOptionItems() {
        return optionItems;
    }
}
