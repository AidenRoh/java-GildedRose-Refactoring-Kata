package com.gildedrose;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public enum GoodsList {
    AGED_BRIE("Aged Brie", GoodsPolicy::agedBrie, 50),
    SULFURAS("Sulfuras, Hand of Ragnaros", GoodsPolicy::sulfuras, 80),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert", GoodsPolicy::backStage, 50),
    CONJURED("Conjured Mana Cake", GoodsPolicy::conjured, 50),
    DEFAULT("DEFAULT", GoodsPolicy::gildedRoseDefault, 50);

    private final Predicate<String> matchResult;
    private final Function<Item, Item> goodsPolicy;
    private final int maximumQuality;

    GoodsList(String goodsName, Function<Item, Item> goodsPolicy, int maximumQuality) {
        this.goodsPolicy = goodsPolicy;
        this.maximumQuality = maximumQuality;

        final var matchResult = new MatchResult(goodsName);
        this.matchResult = matchResult::checkExistInList;
    }

    public static GoodsList find(Item item) {
        return Arrays.stream(values())
            .filter(row -> row.matchResult.test(item.name))
            .findAny()
            .orElse(DEFAULT);
    }

    public void update(Item item) {
        this.goodsPolicy.apply(item);
    }

    public int getMaximumQuality() {
        return this.maximumQuality;
    }
}
