package com.gildedrose

class GildedRose(var items: List<SubItem>) {
    fun updateQuality() {
        items.forEachIndexed { index, element ->
            items[index].updateState()
        }
    }
}

