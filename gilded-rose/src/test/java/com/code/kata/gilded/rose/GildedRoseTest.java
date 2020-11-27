package com.code.kata.gilded.rose;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangyu201
 * @date 2020/11/28
 */
public class GildedRoseTest {
    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
}