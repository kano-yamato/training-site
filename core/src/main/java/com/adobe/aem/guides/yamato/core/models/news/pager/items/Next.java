package com.adobe.aem.guides.yamato.core.models.news.pager.items;

public class Next {
    private final boolean exists_;
    private final String prevPath_;

    public Next(int currentPageNumber, int pagerCount) {
        exists_ = currentPageNumber != pagerCount;
        prevPath_ = "/content/yamato/jp/ja/news." + String.valueOf(currentPageNumber + 1) + ".html";
    }

    public boolean exists() {
        return exists_;
    }

    public String getPrevPath() {
        return prevPath_;
    }
}
