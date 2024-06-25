package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun updateQuality_isSulfuras_Equal() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(10, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun updateQuality_agedBrie_Increase() {
        val items = listOf(Item("Aged Brie", 3, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
        assertEquals(2, app.items[0].sellIn)
    }


    @Test
    fun updateQuality_normalItem_Decrease() {
        val items = listOf(Item("Cake", 5, 8))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(7, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun updateQuality_sellIn_equalsZero() {
        val items = listOf(Item("Fruit", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

}


