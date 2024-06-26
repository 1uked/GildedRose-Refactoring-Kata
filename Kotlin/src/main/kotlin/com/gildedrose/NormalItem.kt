package com.gildedrose

class NormalItem(name: String, sellIn: Int, quality: Int) : SubItem(name, sellIn, quality)  {
    override fun updateState() {
        this.sellIn = (this.sellIn - 1)
        this.quality = when {
            this.sellIn < 0 -> (this.quality - 2).coerceAtLeast(0)
            else -> (this.quality - 1).coerceAtLeast(0)
        }
    }
}