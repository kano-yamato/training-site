package com.adobe.aem.guides.yamato.core.models.global.items;

import com.day.cq.wcm.api.Page;

public class Label {
    private final String _label;

    public Label(Page page) {
        _label = page.getTitle();
    }

    @Override
    public String toString() {
        return _label;
    }
}
