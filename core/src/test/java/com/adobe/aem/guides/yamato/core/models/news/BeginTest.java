package com.adobe.aem.guides.yamato.core.models.news;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BeginTest {
    @Test
    public void beginIndexTest() {
        assertEquals(0, new Begin(10, 1).value());
        assertEquals(10, new Begin(10, 2).value());
        assertEquals(20, new Begin(10, 3).value());
    }
}
