package com.gildedrose;

public record MatchResult(String goodsName) {

    public boolean checkExistInList(String name) {
        return goodsName.equals(name);
    }
}
