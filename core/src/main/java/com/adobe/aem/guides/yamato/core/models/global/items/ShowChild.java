package com.adobe.aem.guides.yamato.core.models.global.items;

import org.apache.sling.api.resource.Resource;

public class ShowChild {
    private final boolean _needBalloon;

    public ShowChild(Resource resource) {
        _needBalloon = resource.getValueMap().get("showChild", false);
    }

    public boolean value() {
        return _needBalloon;
    }
}
