package com.adobe.aem.guides.yamato.core.models.news.pager.items;

import java.util.HashMap;
import java.util.Map;

public class PagerLink {
    private final String tag_;
    private final String path_;
    private final int count_;
    private final String currentClass_;
    private Map<String, String> attribute_ = new HashMap<>();

    public PagerLink(int currentPageNumber, int count) {
        count_ = count;
        tag_ = (currentPageNumber == count) ? "span" : "a";
        path_ = (currentPageNumber == count) ? "" : "/content/yamato/jp/ja/news." + count + ".html";
        currentClass_ = (currentPageNumber == count) ? "current" : "";
        attribute_.put("aria-current", ariaCurrentValue(currentPageNumber, count));
        attribute_.put("title", titlePageNumber(currentPageNumber, count));
    }

    private String ariaCurrentValue(int currentPageNumber, int count) {
        return (currentPageNumber == count) ? "page" : "";
    }

    private String titlePageNumber(int currentPageNumber, int count) {
        return (currentPageNumber == count) ? "" : "Page " + count;
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

    public String getCurrentClass() {
        return currentClass_;
    }

    public Map<String, String> getAttribute() {
        return attribute_;
    }
}
