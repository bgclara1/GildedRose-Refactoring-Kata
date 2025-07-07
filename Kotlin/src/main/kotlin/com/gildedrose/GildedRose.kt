package com.gildedrose


abstract class UpdatableItem(val item: Item) {
    abstract fun update()

    fun decreaseSellIn() {
        item.sellIn -= 1
    }

    fun increaseQuality(amount: Int) {
        item.quality = minOf(50, item.quality + amount)
    }

    fun decreaseQuality(amount: Int ) {
        item.quality = maxOf(0, item.quality - amount)
    }

    fun maintainQuality() {
        item.quality = item.quality
        item.sellIn = item.sellIn
    }

    fun QualityToZero() {
        item.quality = 0
    }
}

class NormalItem(item: Item) : UpdatableItem(item) {
    override fun update() {
        val staticGoods = arrayOf("Sulfuras, Hand of Ragnaros")
        if (staticGoods.contains(item.name)) maintainQuality()
        else decreaseSellIn()
    //    val appreciatingGoods = arrayOf("Aged Brie", "Backstage passes to a TAFKAL80ETC concert")
        val depreciatingGoods = arrayOf("+5 Dexterity Vest", "Elixir of the Mongoose")
        if (item.name == "Aged Brie") increaseQuality(1)
        if (item.sellIn > 10 && item.name == "Backstage passes to a TAFKAL80ETC concert") increaseQuality(1)
        if (item.sellIn in 6..9 && item.name == "Backstage passes to a TAFKAL80ETC concert") increaseQuality(2)
        if (item.sellIn in 1..5 && item.name == "Backstage passes to a TAFKAL80ETC concert") increaseQuality(3)
        if (item.sellIn < 0 && item.name == "Backstage passes to a TAFKAL80ETC concert") QualityToZero()
        if (item.sellIn > 0 && depreciatingGoods.contains(item.name)) decreaseQuality(1)
        if (item.sellIn < 0 && depreciatingGoods.contains(item.name)) decreaseQuality(2)
        if (item.sellIn > 0 && item.name.startsWith("Conjured")) decreaseQuality(2)
        if (item.sellIn < 0 && item.name.startsWith("Conjured")) decreaseQuality(4)



    }
}

/*
class GildedRose(val items: List<Item>) {

    //
    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn -= 1
            }
            if (items[i].name == "Aged Brie") {
                if (items[i].sellIn < 0) {
                    items[i].quality += 2
                } else {
                    items[i].quality += 1
                }
            }

            if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].sellIn < 0) {
                    items[i].quality = 0
                } else if (items[i].sellIn in 6..10) {
                    items[i].quality += 2
                } else if (items[i].sellIn in 0..5) {
                    items[i].quality += 3
                } else {
                    items[i].quality += 1
                }
            }

            if (items[i].name == "+5 Dexterity Vest" || items[i].name == "Elixir og the Mongoose") {

                if (items[i].sellIn < 0) {
                    items[i].quality -= 2
                } else {
                    items[i].quality -= 1
                }
            }

            if (items[i].name.startsWith("Conjured")) {

                if (items[i].sellIn < 0) {
                    items[i].quality -= 4
                } else {
                    items[i].quality -= 2
                }
            }

            if (items[i].name == "Elixir of the Mongoose") {

                if (items[i].sellIn < 0) {
                    items[i].quality -= 2
                } else {
                    items[i].quality -= 1
                }
            }

            if (items[i].quality >= 50 && items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].quality = 50
            }

            if (items[i].quality < 0) {
                items[i].quality = 0
            }

        }
    }


}
*/
