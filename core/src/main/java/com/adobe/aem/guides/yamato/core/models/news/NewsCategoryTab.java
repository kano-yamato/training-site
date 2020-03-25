package com.adobe.aem.guides.yamato.core.models.news;

import java.util.HashMap;
import java.util.Map;

import com.day.cq.wcm.api.Page;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class NewsCategoryTab {
    private static final String ALL_CATEGORY_PATH = "/content/yamato/jp/ja/news";
    private static final String INFO_CATEGORY_PATH = "/content/yamato/jp/ja/news/category/info";
    private static final String PRODUCTS_CATEGORY_PATH = "/content/yamato/jp/ja/news/category/products";
    private static final String COLUMNS_CATEGORY_PATH = "/content/yamato/jp/ja/news/category/columns";

    private Map<String, String> allAttr = new HashMap<String, String>();
    private Map<String, String> infoAttr = new HashMap<String, String>();
    private Map<String, String> productsAttr = new HashMap<String, String>();
    private Map<String, String> columnsAttr = new HashMap<String, String>();

    @ScriptVariable
    private Page currentPage;

    private String generateCurrentAttr(String path) {
        return StringUtils.equals(currentPage.getPath(), path) ? "is-current" : "";
    }

    private String href(String currentAttribute, String path) {
        return StringUtils.isEmpty(currentAttribute) ? path + ".html" : "";
    }

    public Map<String, String> getAllAttr() {
        final String currentAttribute = generateCurrentAttr(ALL_CATEGORY_PATH);
        allAttr.put("class", currentAttribute);
        allAttr.put("href", href(currentAttribute, ALL_CATEGORY_PATH));
        return allAttr;
    }

    public Map<String, String> getInfoAttr() {
        final String currentAttribute = generateCurrentAttr(INFO_CATEGORY_PATH);
        infoAttr.put("class", currentAttribute);
        infoAttr.put("href", href(currentAttribute, INFO_CATEGORY_PATH));
        return infoAttr;
    }

    public Map<String, String> getProductsAttr() {
        final String currentAttribute = generateCurrentAttr(PRODUCTS_CATEGORY_PATH);
        productsAttr.put("class", currentAttribute);
        productsAttr.put("href", href(currentAttribute, PRODUCTS_CATEGORY_PATH));
        return productsAttr;
    }

    public Map<String, String> getColumnsAttr() {
        final String currentAttribute = generateCurrentAttr(COLUMNS_CATEGORY_PATH);
        columnsAttr.put("class", currentAttribute);
        columnsAttr.put("href", href(currentAttribute, COLUMNS_CATEGORY_PATH));
        return columnsAttr;
    }

    public String getAllTag() {
        return StringUtils.isEmpty(generateCurrentAttr(ALL_CATEGORY_PATH)) ? "a" : "span";
    }

    public String getProductsTag() {
        return StringUtils.isEmpty(generateCurrentAttr(PRODUCTS_CATEGORY_PATH)) ? "a" : "span";
    }

    public String getInfoTag() {
        return StringUtils.isEmpty(generateCurrentAttr(INFO_CATEGORY_PATH)) ? "a" : "span";
    }

    public String getColumnsTag() {
        return StringUtils.isEmpty(generateCurrentAttr(COLUMNS_CATEGORY_PATH)) ? "a" : "span";
    }
}
