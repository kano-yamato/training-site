package com.adobe.aem.guides.yamato.core.models.news.pager.items;

public class Preview {
    private final boolean exists_;
    private final String prevPath_;

    public Preview(int currentPageNumber) {
        exists_ = currentPageNumber != 1;
        prevPath_ = "/content/yamato/jp/ja/news." + String.valueOf(currentPageNumber - 1) + ".html";
    }

    public boolean exists() {
        return exists_;
    }

    public String getPrevPath() {
        return prevPath_;
    }
}
