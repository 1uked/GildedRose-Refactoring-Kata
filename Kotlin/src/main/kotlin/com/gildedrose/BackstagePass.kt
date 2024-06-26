package com.gildedrose

class BackstagePass(name: String, sellIn: Int, quality: Int) : SubItem(name, sellIn, quality) {

    override fun updateState() {
        this.sellIn = (this.sellIn - 1)
        this.quality = when {
            this.sellIn == 0 -> 0
            this.sellIn <= 5 -> (this.quality+3).coerceAtMost(50)
            this.sellIn <= 10 -> (this.quality+2).coerceAtMost(50)
            else -> (this.quality + 1).coerceAtMost(50)
        }
    }
}