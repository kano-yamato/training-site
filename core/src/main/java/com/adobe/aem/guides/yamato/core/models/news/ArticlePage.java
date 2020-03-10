package com.adobe.aem.guides.yamato.core.models.news;

import java.util.Date;

public class ArticlePage {
    private final Date _date;
    private final String _title;
    private final String _path;
    private final String _category;
    private final String _categoryDisplayName;

    public ArticlePage(Date date, String title, String path, String category, String categoryDisplayName) {
        this._date = date;
        this._title = title;
        this._path = path;
        this._category = category;
        this._categoryDisplayName = categoryDisplayName;
    }

    public Date getDate() {
        return _date;
    }

    public String getTitle() {
        return _title;
    }

    public String getPath() {
        return _path;
    }

    public String getCategory() {
        return _category;
    }

    public String getCategoryDisplayName() {
        return _categoryDisplayName;
    }

    @Override
    public String toString() {
        return String.format("date: %s, title: %s, path: %s, category: %s, categoryDisplayName: %s", _date.toString(), _title, _path, _category, _categoryDisplayName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_category == null) ? 0 : _category.hashCode());
        result = prime * result + ((_date == null) ? 0 : _date.hashCode());
        result = prime * result + ((_title == null) ? 0 : _title.hashCode());
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
        ArticlePage other = (ArticlePage) obj;
        if (_category == null) {
            if (other._category != null)
                return false;
        } else if (!_category.equals(other._category))
            return false;
        if (_date == null) {
            if (other._date != null)
                return false;
        } else if (!_date.equals(other._date))
            return false;
        if (_title == null) {
            if (other._title != null)
                return false;
        } else if (!_title.equals(other._title))
            return false;
        return true;
    }
}
