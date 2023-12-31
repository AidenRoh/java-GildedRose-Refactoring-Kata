package com.gildedrose;

import java.util.function.Supplier;

public class GoodsPolicy {

    public static Item gildedRoseDefault(Item item) {
        if (item.sellIn != 0) {
            return updateItem(item, GoodsList.DEFAULT, () -> item.quality - 1);
        }
        return updateItem(item, GoodsList.DEFAULT, () -> item.quality - 2);
    }

    public static Item agedBrie(Item item) {
        if (item.sellIn != 0) {
            return updateItem(item, GoodsList.AGED_BRIE, () -> item.quality + 1);
        }
        return updateItem(item, GoodsList.AGED_BRIE, () -> item.quality + 2);
    }

    public static Item sulfuras(Item item) {
        return updateItem(item, GoodsList.SULFURAS, () -> 80);
    }

    public static Item backStage(Item item) {
        if (item.sellIn > 10) {
            return updateItem(item, GoodsList.BACKSTAGE, () -> item.quality + 1);
        }
        if (item.sellIn > 5) {
            return updateItem(item, GoodsList.BACKSTAGE, () -> item.quality + 2);
        }
        if (item.sellIn > 0) {
            return updateItem(item, GoodsList.BACKSTAGE, () -> item.quality + 3);
        }
        return updateItem(item, GoodsList.BACKSTAGE, () -> 0);
    }

    public static Item conjured(Item item) {
        if (item.sellIn != 0) {
            return updateItem(item, GoodsList.CONJURED, () -> item.quality - 2);
        }
        return updateItem(item, GoodsList.CONJURED, () -> item.quality - 4);
    }

    private static Item updateItem(Item item, GoodsList goods, Supplier<Integer> supplier) {
        item.sellIn -= 1;
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
