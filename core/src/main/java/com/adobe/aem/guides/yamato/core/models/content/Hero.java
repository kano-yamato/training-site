package com.adobe.aem.guides.yamato.core.models.content;


import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

@Model( adaptables = { SlingHttpServletRequest.class },
        resourceType = { Hero.RESOURCE_TYPE }, 
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class Hero  {
    protected static final String RESOURCE_TYPE = "yamato/components/content/heroimage";

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String caption;

    @ValueMapValue
    private String buttonLabel;

    @ValueMapValue
    private String buttonLinkURL;


    public String getTitle() {
        return this.title;
    }

    public String getCaption() {
        return this.caption;
    }

    public String getButtonLabel() {
        return this.buttonLabel;
    }

    public String getButtonLinkURL() {
        return this.buttonLinkURL;
    }
}