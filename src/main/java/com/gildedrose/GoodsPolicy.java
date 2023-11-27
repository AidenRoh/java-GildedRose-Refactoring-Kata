package com.gildedrose;

import java.util.function.Supplier;

public class GoodsPolicy {

    public static Item gildedRoseDefault(Item item) {
        if (item.sellIn != 0) {
            return validQuality(item, GoodsList.DEFAULT, () -> item.quality - 1);
        }
        return validQuality(item, GoodsList.DEFAULT, () -> item.quality - 2);
    }

    public static Item agedBrie(Item item) {
        if (item.sellIn != 0) {
            return validQuality(item, GoodsList.AGED_BRIE, () -> item.quality + 1);
        }
        return validQuality(item, GoodsList.AGED_BRIE, () -> item.quality + 2);
    }

    public static Item sulfuras(Item item) {
        return validQuality(item, GoodsList.SULFURAS, () -> 80);
    }

    public static Item backStage(Item item) {
        if (item.sellIn > 10) {
            return validQuality(item, GoodsList.BACKSTAGE, () -> item.quality + 1);
        }
        if (item.sellIn > 5) {
            return validQuality(item, GoodsList.BACKSTAGE, () -> item.quality + 2);
        }
        if (item.sellIn > 0) {
            return validQuality(item, GoodsList.BACKSTAGE, () -> item.quality + 3);
        }
        return validQuality(item, GoodsList.BACKSTAGE, () -> 0);
    }

    public static Item conjured(Item item) {
        if (item.sellIn != 0) {
            return validQuality(item, GoodsList.CONJURED, () -> item.quality - 2);
        }
        return validQuality(item, GoodsList.CONJURED, () -> item.quality - 4);
    }

    private static Item validQuality(Item item, GoodsList goods, Supplier<Integer> supplier) {
        item.quality = supplier.get();

        if (item.quality < 0) {
            item.quality = 0;
            return item;
        }
        if (item.quality > goods.getMaximumQuality()) {
            item.quality = goods.getMaximumQuality();
            return item;
        }
        return item;
    }
}
