package com.gildedrose

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

           

            if (items[i].name == "+5 Dexterity Vest" || items[i].name == "Elixir og the Mongoose") {

                if (items[i].sellIn < 0) {
                    items[i].quality -= 2
                } else {
                    items[i].quality -= 1
                }
            }

            if (items[i].name == "Conjured Mana Cake") {

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
