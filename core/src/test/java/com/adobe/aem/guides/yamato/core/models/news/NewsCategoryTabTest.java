package com.adobe.aem.guides.yamato.core.models.news;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class NewsCategoryTabTest {
    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() {
        ctx.addModelsForClasses(NewsCategoryTab.class);
        ctx.load().json("/com/adobe/aem/guides/yamato/core/models/news/news.json", "/content/yamato/jp/ja/");
    }

    @Test
    public void testGetAllAttr_currentIsAll() {
        ctx.currentPage("/content/yamato/jp/ja/news");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "is-current")
            .put("href", "").build();
        Map<String, String> actual = nct.getAllAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllAttr_currentIsProducts() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/products");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "")
            .put("href", "/content/yamato/jp/ja/news.html").build();
        Map<String, String> actual = nct.getAllAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetInfoAttr_currentIsInfo() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/info");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "is-current")
            .put("href", "").build();
        Map<String, String> actual = nct.getInfoAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetInfoAttr_currentIsAll() {
        ctx.currentPage("/content/yamato/jp/ja/news");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "")
            .put("href", "/content/yamato/jp/ja/news/category/info.html").build();
        Map<String, String> actual = nct.getInfoAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProductsAttr_currentIsProducts() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/products");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "is-current")
            .put("href", "").build();
        Map<String, String> actual = nct.getProductsAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProductsAttr_currentIsColumns() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/columns");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "")
            .put("href", "/content/yamato/jp/ja/news/category/products.html").build();
        Map<String, String> actual = nct.getProductsAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetColumnsAttr_currentIsColumns() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/columns");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "is-current")
            .put("href", "").build();
        Map<String, String> actual = nct.getColumnsAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetColumnsAttr_currentIsInfo() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/info");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        Map<String, String> expected = new ImmutableMap.Builder<String, String>()
            .put("class", "")
            .put("href", "/content/yamato/jp/ja/news/category/columns.html").build();
        Map<String, String> actual = nct.getColumnsAttr();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllTag_currentIsAll() {
        ctx.currentPage("/content/yamato/jp/ja/news");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "span";
        String actual = nct.getAllTag();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllTag_currentIsInfo() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/info");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "a";
        String actual = nct.getAllTag();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetInfoTag_currentIsInfo() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/info");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "span";
        String actual = nct.getInfoTag();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetInfoTag_currentIsAll() {
        ctx.currentPage("/content/yamato/jp/ja/news");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "a";
        String actual = nct.getInfoTag();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProductsTag_currentIsProducts() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/products");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "span";
        String actual = nct.getProductsTag();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProductsTag_currentIsInfo() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/info");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "a";
        String actual = nct.getProductsTag();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetColumnsTag_currentIsColumn() {
        ctx.currentPage("/content/yamato/jp/ja/news/category/columns");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "span";
        String actual = nct.getColumnsTag();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetColumnsTag_currentIsAll() {
        ctx.currentPage("/content/yamato/jp/ja/news");
        NewsCategoryTab nct = ctx.request().adaptTo(NewsCategoryTab.class);
        String expected = "a";
        String actual = nct.getColumnsTag();
        assertEquals(expected, actual);
    }
}