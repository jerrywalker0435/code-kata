package com.code.kata.gilded.rose.item;

/**
 * @author zhangyu201
 * @date 2020/11/30
 */
public class AgedItem extends Item {
    public AgedItem(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void doUpdateQuality() {
        if (quality < 50) {
            quality = quality + 1;

        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }

    }
}
