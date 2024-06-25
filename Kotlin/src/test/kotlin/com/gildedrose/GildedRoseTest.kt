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

    @Test
    fun updateQuality_agedBrie_maximumQuality_is50() {
        val items = listOf(Item("Aged Brie", 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateQuality_qualityIs_notNegative() {
        val items = listOf(Item("Turnip", 20, 10))
        val app = GildedRose(items)
        repeat(15) { app.updateQuality() }
        assertEquals(0, app.items[0].quality)
        assertEquals(5, app.items[0].sellIn)
    }

    @Test
    fun updateQuality_sellIn_lessZero_degradesTwiceAsFast() {
        val items = listOf(Item("Orange", 5, 50))
        val app = GildedRose(items)
        repeat(15) { app.updateQuality() }
        assertEquals(25, app.items[0].quality)
        assertEquals(-10, app.items[0].sellIn)
    }


    fun updateQuality_whenSellIn_equalsZero_backStagePass_equalsZero() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 50))
        val app = GildedRose(items)
        repeat(10) { app.updateQuality() }
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }

    fun updateQuality_whenSellIn_equalsZero_backStagePass_equalsZero() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(25, app.items[0].quality)
        assertEquals(53, app.items[0].sellIn)
    }

}


