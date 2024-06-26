package com.gildedrose

class GildedRose(var items: List<SubItem>) {
    fun updateQuality() {
        items.forEach{ element ->
            element.updateState()
        }
    }
}

