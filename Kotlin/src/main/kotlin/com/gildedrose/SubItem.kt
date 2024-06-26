package com.gildedrose

abstract class SubItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality)  {
    abstract fun updateState()
}