package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.forEachIndexed { index, element ->
            items[index].sellIn = updateSellInValue(element)
            items[index].quality = updateQualityValue(element)
        }
    }

    private fun updateSellInValue(i: Item) : Int {
        return when(i.name) {
            "Sulfuras, Hand of Ragnaros" -> i.sellIn
            else -> {
                i.sellIn - 1
            }
        }
    }

    //TODO Fix to set to Starts With -> Works with any ticket
    fun updateQualityValue(i: Item) : Int {

        var conjured = 1
        if (i.name.contains("Conjured")){ conjured = 2 }

        if (i.name.contains("Backstage pass")) {i.name = "Backstage pass"}

        return when(i.name) {
            "Sulfuras, Hand of Ragnaros" -> i.quality

            "Aged Brie"  -> {(i.quality + 1).coerceAtMost(50)}

            "Backstage pass" -> {
                if (i.sellIn == 0) {0}
                else if (i.sellIn <= 5) {(i.quality+3).coerceAtMost(50)}
                else if (i.sellIn <= 10) {(i.quality+2).coerceAtMost(50)}
                else {(i.quality + 1).coerceAtMost(50)}
            }

            else -> {
                if (i.sellIn < 0) {
                    (i.quality - 2 * conjured).coerceAtLeast(0)
                } else {
                    (i.quality - 1 * conjured).coerceAtLeast(0)
                }
            }
        }
    }
}

