package com.gildedrose;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("test for picking valid goods by name")
class GoodsListTest {

    private static Stream<Arguments> goodsArguments() {
        return Stream.of(
            arguments(
                new Item("Aged Brie",0, 0),
                GoodsList.AGED_BRIE
            ),
            arguments(
                new Item("Sulfuras, Hand of Ragnaros", 0, 0),
                GoodsList.SULFURAS
            ),
            arguments(
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
                GoodsList.BACKSTAGE
            ),
            arguments(
                new Item("Conjured", 0, 0),
                GoodsList.CONJURED
            ),
            arguments(
                new Item("None of above item", 0, 0),
                GoodsList.DEFAULT
            )
        );
    }

    @ParameterizedTest(name = "{0}이 주어질 때, {1}의 Enum 상수가 나온다.")
    @MethodSource("goodsArguments")
    void goodsTest(Item testItem, GoodsList expectedResult) {
        //given
        Item item = testItem;
        //when && then
        Assertions.assertThat(GoodsList.find(item)).isEqualTo(expectedResult);
    }
}
