package com.adobe.aem.guides.yamato.core.models.news.pager.items;

import java.util.HashMap;
import java.util.Map;

public class PagerLink {
    private final String tag_;
    private final String path_;
    private final int count_;
    private final String currentAttribute_;
    private Map<String, String> ariaCurrent_ = new HashMap<String, String>();
    private Map<String, String> title_ = new HashMap<String, String>();

    public PagerLink(int currentPageNumber, int count) {
        count_ = count;
        tag_ = (currentPageNumber == count) ? "span" : "a";
        path_ = (currentPageNumber == count) ? "" : "/content/yamato/jp/ja/news." + String.valueOf(count) + ".html";
        currentAttribute_ = (currentPageNumber == count) ? "current" : "";
        ariaCurrent_.put("aria-current", ariaCurrentValue(currentPageNumber, count));
        title_.put("title", titlePageNumber(currentPageNumber, count));
    }

    private String ariaCurrentValue(int currentPageNumber, int count) {
        return (currentPageNumber == count) ? "page" : "";
    }

    private String titlePageNumber(int currentPageNumber, int count) {
        return (currentPageNumber == count) ? "" : "Page " + String.valueOf(count);
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

    public String getCurrentAttribute() {
        return currentAttribute_;
    }

    public Map<String, String> getAriaCurrent() {
        return ariaCurrent_;
    }

    public Map<String, String> getTitle() {
        return title_;
    }
}
