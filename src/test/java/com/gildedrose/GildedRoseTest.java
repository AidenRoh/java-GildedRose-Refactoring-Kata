package com.gildedrose;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("GildedRose Test")
class GildedRoseTest {

    //Before Refactoring
    private static Stream<Arguments> differentGoodsType() {
        return Stream.of(
            arguments("normalGoods1", 1, 1, 0),
            arguments("normalGoods2", 0, 2, 0),
            arguments("Aged Brie", 2, 0, 1),
            arguments("Aged Brie", 0, 0, 2),
            arguments("Sulfuras, Hand of Ragnaros", 0, 2, 80),
            arguments("Sulfuras, Hand of Ragnaros", 1, 2, 80),
            arguments("Conjured", 1, 4, 2),
            arguments("Conjured", 0, 4, 0),
            arguments("Backstage passes to a TAFKAL80ETC concert", 15, 0, 1),
            arguments("Backstage passes to a TAFKAL80ETC concert", 10, 0, 2),
            arguments("Backstage passes to a TAFKAL80ETC concert", 5, 0, 3),
            arguments("Backstage passes to a TAFKAL80ETC concert", 0, 0, 0)
        );
    }

    @ParameterizedTest(name = "{0}은 {1}의 남은 기간일 때, {2}의 가치는 {3}의 가치로 바뀐다.")
    @MethodSource("differentGoodsType")
    void test_each_type(String goods, int sellIn, int prevQuality, int expectedQuality) {
        Item[] items = new Item[]{new Item(goods, sellIn, prevQuality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertAll(
            () -> assertEquals(goods, app.items[0].name),
            () -> assertEquals(expectedQuality, app.items[0].quality)
        );
    }

    //template provided test
    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
}
