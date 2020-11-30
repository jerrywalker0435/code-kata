package com.code.kata.gilded.rose.item;

/**
 * @author zhangyu201
 * @date 2020/11/30
 */
public class BackstageItem extends Item {
    public BackstageItem(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert",sellIn,quality);
    }

    @Override
    public void doUpdateQuality() {
                if (quality < 50) {
                    quality = quality + 1;

                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }

                sellIn = sellIn - 1;

                if (sellIn < 0) {
                    quality = quality - quality;
                }
    }
}
