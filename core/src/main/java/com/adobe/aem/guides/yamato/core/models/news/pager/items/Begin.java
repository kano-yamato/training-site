package com.adobe.aem.guides.yamato.core.models.news.pager.items;

public class Begin {
    private int begin_;

    public Begin(int displayCount, int currentPageNumber) {
        begin_ = displayCount * (currentPageNumber - 1);
    }

    public int value() {
        return begin_;
    }
}
