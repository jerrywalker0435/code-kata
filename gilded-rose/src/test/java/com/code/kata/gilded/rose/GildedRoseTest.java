package com.code.kata.gilded.rose;

import com.code.kata.gilded.rose.item.Item;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

/**
 * @author zhangyu201
 * @date 2020/11/28
 */
public class GildedRoseTest {
    @Test
    @UseReporter({JunitReporter.class})
    public void updateQuality() {
        //given
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[]{"foo","Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"},
                new Integer[]{-1,0,2,6,11},
                new Integer[]{0,1,49,50}
        );
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{Item.createItem(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
//        assertEquals("foo", app.items[0].toString());
        return app.items[0].toString();
    }
}