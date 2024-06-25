package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

//            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
//                items[i].sellIn = items[i].sellIn - 1
//            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }



    fun updateQuality_new() {
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

    fun updateQualityValue(i: Item) : Int {

        return when(i.name) {
            "Sulfuras, Hand of Ragnaros" -> i.quality

            "Aged Brie"  -> {
                if (i.quality < 50) {
                    i.quality + 1
                }
                i.quality
            }

            //contains("Backstage") ->


            else -> {
                if (i.sellIn < 0) {
                    (i.quality - 2).coerceAtLeast(0)
                } else {
                    (i.quality - 1).coerceAtLeast(0)
                }
            }
        }


        return 0
    }




}

