package com.adobe.aem.guides.yamato.core.models.news.pager.items;

public class PagerLink {
    private final String tag_;
    private final String path_;
    private final int count_;

    public PagerLink(int pagerCount, int currentPageNumber, int count) {
        count_ = count;
        tag_ = (currentPageNumber == count) ? "span" : "a";
        path_ = "/content/yamato/jp/ja/news." + String.valueOf(count) + ".html";
    }

    public String getTag() {
        return tag_;
    }

    public String getPath() {
        return path_;
    }

    public int getCount() {
        return count_;
    }

}
