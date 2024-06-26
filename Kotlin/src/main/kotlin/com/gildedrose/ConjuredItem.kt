package com.gildedrose

class ConjuredItem(name: String, sellIn: Int, quality: Int) : SubItem(name, sellIn, quality)  {
    override fun updateState() {
        this.sellIn = (this.sellIn - 1)
        this.quality = when {
            this.sellIn < 0 -> (this.quality - 4).coerceAtLeast(0)
            else -> (this.quality - 2).coerceAtLeast(0)
        }
    }
}