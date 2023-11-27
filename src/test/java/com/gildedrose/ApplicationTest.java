package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class ApplicationTest {

    @DisplayName("프로그램 전체 테스트")
    @Test
    void test() {
        //given
        Item[] items = {
            new Item("Kraken Slayer", 10, 10),
            new Item("Aged Brie", 10, 10),
            new Item("Sulfuras, Hand of Ragnaros", 10, 80),
            new Item("Sulfuras, Hand of Ragnaros", 1, 80),
            new Item("Sulfuras, Hand of Ragnaros", -10, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10),
            new Item("Conjured Mana Cake", 10, 10),
            new Item("Conjured Mana Cake", 1, 6)
        };

        GildedRose app = new GildedRose(items);

        //when & then
        app.updateQuality();
        testDayOne(items);
        //when & then
        app.updateQuality();
        testDayTwo(items);
    }

    private void testDayOne(Item[] items) {
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(items[0].sellIn).isEqualTo(9);
            softAssertions.assertThat(items[0].quality).isEqualTo(9);

            softAssertions.assertThat(items[1].sellIn).isEqualTo(9);
            softAssertions.assertThat(items[1].quality).isEqualTo(11);

            softAssertions.assertThat(items[2].sellIn).isEqualTo(9);
            softAssertions.assertThat(items[2].quality).isEqualTo(80);
            softAssertions.assertThat(items[3].sellIn).isEqualTo(0);
            softAssertions.assertThat(items[3].quality).isEqualTo(80);
            softAssertions.assertThat(items[4].sellIn).isEqualTo(-11);
            softAssertions.assertThat(items[4].quality).isEqualTo(80);

            softAssertions.assertThat(items[5].sellIn).isEqualTo(14);
            softAssertions.assertThat(items[5].quality).isEqualTo(11);
            softAssertions.assertThat(items[6].sellIn).isEqualTo(9);
            softAssertions.assertThat(items[6].quality).isEqualTo(12);
            softAssertions.assertThat(items[7].sellIn).isEqualTo(4);
            softAssertions.assertThat(items[7].quality).isEqualTo(13);
            softAssertions.assertThat(items[8].sellIn).isEqualTo(0);
            softAssertions.assertThat(items[8].quality).isEqualTo(13);

            softAssertions.assertThat(items[9].sellIn).isEqualTo(9);
            softAssertions.assertThat(items[9].quality).isEqualTo(8);
            softAssertions.assertThat(items[10].sellIn).isEqualTo(0);
            softAssertions.assertThat(items[10].quality).isEqualTo(4);
        });
    }

    private void testDayTwo(Item[] items) {
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(items[0].sellIn).isEqualTo(8);
            softAssertions.assertThat(items[0].quality).isEqualTo(8);

            softAssertions.assertThat(items[1].sellIn).isEqualTo(8);
            softAssertions.assertThat(items[1].quality).isEqualTo(12);

            softAssertions.assertThat(items[2].sellIn).isEqualTo(8);
            softAssertions.assertThat(items[2].quality).isEqualTo(80);
            softAssertions.assertThat(items[3].sellIn).isEqualTo(-1);
            softAssertions.assertThat(items[3].quality).isEqualTo(80);
            softAssertions.assertThat(items[4].sellIn).isEqualTo(-12);
            softAssertions.assertThat(items[4].quality).isEqualTo(80);

            softAssertions.assertThat(items[5].sellIn).isEqualTo(13);
            softAssertions.assertThat(items[5].quality).isEqualTo(12);
            softAssertions.assertThat(items[6].sellIn).isEqualTo(8);
            softAssertions.assertThat(items[6].quality).isEqualTo(14);
            softAssertions.assertThat(items[7].sellIn).isEqualTo(3);
            softAssertions.assertThat(items[7].quality).isEqualTo(16);
            softAssertions.assertThat(items[8].sellIn).isEqualTo(-1);
            softAssertions.assertThat(items[8].quality).isEqualTo(0);

            softAssertions.assertThat(items[9].sellIn).isEqualTo(8);
            softAssertions.assertThat(items[9].quality).isEqualTo(6);
            softAssertions.assertThat(items[10].sellIn).isEqualTo(-1);
            softAssertions.assertThat(items[10].quality).isEqualTo(0);
        });
    }

}
