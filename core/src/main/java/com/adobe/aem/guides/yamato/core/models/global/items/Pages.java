package com.adobe.aem.guides.yamato.core.models.global.items;

import java.util.Collections;
import java.util.List;

import com.day.cq.wcm.api.Page;

import org.apache.commons.collections.IteratorUtils;

public class Pages {
    private final List<Page> _pages;

    @SuppressWarnings("unchecked")
    public Pages(Page rootPage) {
        _pages = rootPage.listChildren() == null ? Collections.emptyList() : IteratorUtils.toList(rootPage.listChildren());
    }

    public List<Page> toList() {
        return _pages;
    }
}
