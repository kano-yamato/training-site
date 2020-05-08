package com.adobe.aem.guides.yamato.core.models.news;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EndTest {
    @Test
    public void endIndexTest() {
        assertEquals(9, new End(new Begin(10, 1), 10).value());
        assertEquals(19, new End(new Begin(10, 2), 10).value());
        assertEquals(29, new End(new Begin(10, 3), 10).value());
    }
}

