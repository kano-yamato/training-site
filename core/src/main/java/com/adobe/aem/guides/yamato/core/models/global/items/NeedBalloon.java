package com.adobe.aem.guides.yamato.core.models.global.items;

import org.apache.sling.api.resource.Resource;

public class NeedBalloon {
    private final boolean _needBalloon;

    public NeedBalloon(Resource resource) {
        _needBalloon = resource.getValueMap().get("needBalloon", false);
    }

    public boolean value() {
        return _needBalloon;
    }
}
