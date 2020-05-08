package com.adobe.aem.guides.yamato.core.models.news;

public class End {
    private int end_;

    public End(Begin begin, int displayCount) {
        end_ = begin.value() + displayCount - 1;
    }

    public int value() {
        return end_;
    }
}
