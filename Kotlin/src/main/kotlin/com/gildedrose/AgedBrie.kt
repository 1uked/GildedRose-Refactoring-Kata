package com.gildedrose

class AgedBrie(name: String, sellIn: Int, quality: Int) : SubItem(name, sellIn, quality) {

    override fun updateState() {
        this.sellIn = (this.sellIn - 1)
        this.quality = (this.quality + 1).coerceAtMost(50)
    }
}