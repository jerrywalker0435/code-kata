package com.code.kata.gilded.rose.item;

/**
 * @author zhangyu201
 * @date 2020/11/30
 */
public class SulfurasItem extends Item {
    public SulfurasItem(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros",sellIn,quality);
    }

    @Override
    public void doUpdateQuality() {

    }
}
