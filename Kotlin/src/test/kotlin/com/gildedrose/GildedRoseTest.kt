package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun dexterityVestNormalBehaviour() {
        val item = Item("+5 Dexterity Vest", 10, 20)
        val app = NormalItem(item)
        app.update()
        assertEquals("+5 Dexterity Vest", app.item.name)
        assertEquals(9, app.item.sellIn)
        assertEquals(19, app.item.quality)
    }

    @Test
    fun dexterityVestNegativeSellInBehaviour() {
        val item = (Item("+5 Dexterity Vest", 0, 20))
        val app = NormalItem(item)
        app.update()
        assertEquals("+5 Dexterity Vest", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(18, app.item.quality)
    }

    @Test
    fun agedBrieNormalBehaviour() {
        val item = (Item("Aged Brie", 2, 0))
        val app = NormalItem(item)
        app.update()
        assertEquals("Aged Brie", app.item.name)
        assertEquals(1, app.item.sellIn)
        assertEquals(1, app.item.quality)
    }

    @Test
    fun elixirOfTheMongooseNormalBehaviour() {
        val item = (Item("Elixir of the Mongoose", 5, 7))
        val app = NormalItem(item)
        app.update()
        assertEquals("Elixir of the Mongoose", app.item.name)
        assertEquals(4, app.item.sellIn)
        assertEquals(6, app.item.quality)
    }

    @Test
    fun elixirOfTheMongooseNegativeSellInBehaviour() {
        val item = (Item("Elixir of the Mongoose", 0, 7))
        val app = NormalItem(item)
        app.update()
        assertEquals("Elixir of the Mongoose", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(5, app.item.quality)
    }


    @Test
    fun sulfurasAt0Behaviour() {
        val item = (Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = NormalItem(item)
        app.update()
        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name)
        assertEquals(0, app.item.sellIn)
        assertEquals(80, app.item.quality)
    }

    @Test
    fun sulfurasAtMinus1Behaviour() {
        val item = (Item("Sulfuras, Hand of Ragnaros", -1, 80))
        val app = NormalItem(item)
        app.update()
        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(80, app.item.quality)
    }

    @Test
    fun backstagePassesMoreThan10Behaviour() {
        val item = (Item("Backstage passes to a TAFKAL80ETC concert", 15, 20))
        val app = NormalItem(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(14, app.item.sellIn)
        assertEquals(21, app.item.quality)
    }

    @Test
    fun backstagePassesReached50at10Behaviour() {
        val item = (Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
        val app = NormalItem(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(9, app.item.sellIn)
        assertEquals(50, app.item.quality)
    }

    @Test
    fun backstagePassesReached50at5Behaviour() {
        val item = (Item("Backstage passes to a TAFKAL80ETC concert", 5, 49))
        val app = NormalItem(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(4, app.item.sellIn)
        assertEquals(50, app.item.quality)
    }

    @Test
    fun backstagePassesAt10Behaviour() {
        val item = (Item("Backstage passes to a TAFKAL80ETC concert", 10, 30))
        val app = NormalItem(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(9, app.item.sellIn)
        assertEquals(32, app.item.quality)
    }


    @Test
    fun backstagePassesAt5Behaviour() {
        val item = (Item("Backstage passes to a TAFKAL80ETC concert", 5, 30))
        val app = NormalItem(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(4, app.item.sellIn)
        assertEquals(33, app.item.quality)
    }

    @Test
    fun backstagePassesAt0Behaviour() {
        val item = (Item("Backstage passes to a TAFKAL80ETC concert", 0, 30))
        val app = NormalItem(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(0, app.item.quality)
    }


    @Test
    fun conjuredBasicBehaviour() {
        val item = (Item("Conjured Mana Cake", 3, 6))
        val app = NormalItem(item)
        app.update()
        assertEquals("Conjured Mana Cake", app.item.name)
        assertEquals(2, app.item.sellIn)
        assertEquals(4, app.item.quality)
    }

    @Test
    fun conjuredBasicNegativeSellInBehaviour() {
        val item = (Item("Conjured Mana Cake", 0, 6))
        val app = NormalItem(item)
        app.update()
        assertEquals("Conjured Mana Cake", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(2, app.item.quality)
    }


}
