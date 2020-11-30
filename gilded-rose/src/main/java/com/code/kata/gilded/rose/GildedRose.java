package com.code.kata.gilded.rose;

import com.code.kata.gilded.rose.item.Item;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            item.doUpdateQuality();
        }
    }

}