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

    fun setQualityToZero() {
        item.quality = 0
    }
}

class GuildedRose(item: Item) : UpdatableItem(item) {
    override fun update() {
        if (item.name != "Sulfuras, Hand of Ragnaros") decreaseSellIn()
        when {
            item.name == "Sulfuras, Hand of Ragnaros" -> {}
            item.name == "Aged Brie" -> if (item.sellIn < 0) increaseQuality(2) else increaseQuality(2)
            item.name.startsWith("Backstage passes") -> {
                    if (item.sellIn < 0) setQualityToZero()
                    else if (item.sellIn in 1..5)  increaseQuality(3)
                    else if (item.sellIn in 6..10)  increaseQuality(2)
                    else increaseQuality(1)
            }
            item.name.startsWith("Conjured") -> if (item.sellIn >= 0) decreaseQuality(2) else decreaseQuality(4)

            else -> if (item.sellIn < 0) decreaseQuality(2) else decreaseQuality(1)
        }

    }
}
