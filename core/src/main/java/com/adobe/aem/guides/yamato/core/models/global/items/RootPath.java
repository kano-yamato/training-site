package com.adobe.aem.guides.yamato.core.models.global.items;

import org.apache.sling.api.resource.Resource;

public class RootPath {
    private final String _rootPath;

    public RootPath(Resource resource) {
        _rootPath = resource.getValueMap().get("naviRoot", "/content/yamato/jp/ja");
    }

    @Override
    public String toString() {
        return _rootPath;
    }
}
