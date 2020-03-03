package com.adobe.aem.guides.yamato.core.models.global;

import java.util.List;

import com.day.cq.wcm.api.Page;

public class NavigationItem {
    private final boolean needBalloon;
    private final String rootPath;
    private final String label;
    private final List<Page> pages;

    public NavigationItem(boolean needBalloon, String rootPath, String label, List<Page> pages) {
        this.needBalloon = needBalloon;
        this.rootPath = rootPath;
        this.label = label;
        this.pages = pages;
    }

    public boolean isNeedBalloon() {
        return needBalloon;
    }

    public String getRootPath() {
        return rootPath;
    }

    public String getLabel() {
        return label;
    }

    public List<Page> getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return String.valueOf(needBalloon) + ", " + rootPath + ", " + label + ", " + pages.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + (needBalloon ? 1231 : 1237);
        result = prime * result + ((pages == null) ? 0 : pages.hashCode());
        result = prime * result + ((rootPath == null) ? 0 : rootPath.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NavigationItem other = (NavigationItem) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (needBalloon != other.needBalloon)
            return false;
        if (pages == null) {
            if (other.pages != null)
                return false;
        } else if (!pages.equals(other.pages))
            return false;
        if (rootPath == null) {
            if (other.rootPath != null)
                return false;
        } else if (!rootPath.equals(other.rootPath))
            return false;
        return true;
    }
}
