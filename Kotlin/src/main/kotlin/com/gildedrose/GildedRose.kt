package com.gildedrose

import java.security.KeyStore.TrustedCertificateEntry

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
    //TODO Swap Coerce to Max/Min
    fun updateQualityValue(i: Item) : Int {

        return when(i.name) {
            "Sulfuras, Hand of Ragnaros" -> i.quality

            "Aged Brie"  -> {(i.quality + 1).coerceAtMost(50)}

            "Backstage passes to a TAFKAL80ETC concert" -> {
                if (i.sellIn == 0) {0}
                else if (i.sellIn <= 5) {(i.quality+3).coerceAtMost(50)}
                else if (i.sellIn <= 10) {(i.quality+2).coerceAtMost(50)}
                else {(i.quality + 1).coerceAtMost(50)}
            }

            else -> {
                if (i.sellIn < 0) {
                    (i.quality - 2).coerceAtLeast(0)
                } else {
                    (i.quality - 1).coerceAtLeast(0)
                }
            }
        }
    }




}

