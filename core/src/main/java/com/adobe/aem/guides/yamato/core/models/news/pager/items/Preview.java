package com.adobe.aem.guides.yamato.core.models.news.pager.items;

public class Preview {
    private final boolean exists;
    private final String path;

    public Preview(int currentPageNumber) {
        exists = currentPageNumber != 1;
        path = "/content/yamato/jp/ja/news." + (currentPageNumber - 1) + ".html";
    }

    public boolean exists() {
        return exists;
    }

    public String getPath() {
        return path;
    }
}
