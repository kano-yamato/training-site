package com.adobe.aem.guides.yamato.core.models.global;

import java.util.List;

import com.adobe.aem.guides.yamato.core.models.global.items.Label;
import com.adobe.aem.guides.yamato.core.models.global.items.NeedBalloon;
import com.adobe.aem.guides.yamato.core.models.global.items.Pages;
import com.adobe.aem.guides.yamato.core.models.global.items.RootPath;
import com.day.cq.wcm.api.Page;

public class NavigationItem {
    private final NeedBalloon needBalloon;
    private final RootPath rootPath;
    private final Label label;
    private final Pages pages;

    public NavigationItem(NeedBalloon needBalloon, RootPath rootPath, Label label, Pages pages) {
        this.needBalloon = needBalloon;
        this.rootPath = rootPath;
        this.label = label;
        this.pages = pages;
    }

    public boolean isNeedBalloon() {
        return needBalloon.value();
    }

    public String getRootPath() {
        return rootPath.toString();
    }

    public String getLabel() {
        return label.toString();
    }

    public List<Page> getPages() {
        return pages.toList();
    }
}
