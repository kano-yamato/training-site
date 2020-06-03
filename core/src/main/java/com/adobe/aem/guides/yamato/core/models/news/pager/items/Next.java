package com.adobe.aem.guides.yamato.core.models.news.pager.items;

public class Next {
    private final boolean exists;
    private final String path;

    public Next(int currentPageNumber, int pagerCount) {
        exists = currentPageNumber != pagerCount;
        path = "/content/yamato/jp/ja/news." + (currentPageNumber + 1) + ".html";
    }

    public boolean exists() {
        return exists;
    }

    public String getPath() {
        return path;
    }
}
