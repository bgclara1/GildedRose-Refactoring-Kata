package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `Dexterity vest quality decreases by one before expiry`() {
        val item = Item("+5 Dexterity Vest", 10, 20)
        val app = GuildedRose(item)
        app.update()
        assertEquals("+5 Dexterity Vest", app.item.name)
        assertEquals(9, app.item.sellIn)
        assertEquals(19, app.item.quality)
    }

    @Test
    fun `Dexterity vest quality decreases by 2 day after expiry`() {
        val item = Item("+5 Dexterity Vest", 0, 20)
        val app = GuildedRose(item)
        app.update()
        assertEquals("+5 Dexterity Vest", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(18, app.item.quality)
    }

    @Test
    fun `Aged brie quality increases by 1 before expiry`() {
        val item = Item("Aged Brie", 2, 0)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Aged Brie", app.item.name)
        assertEquals(1, app.item.sellIn)
        assertEquals(2, app.item.quality)
    }

    @Test
    fun `Aged brie quality increases by 2 on expiry`() {
        val item = Item("Aged Brie", 0, 0)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Aged Brie", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(2, app.item.quality)
    }

    @Test
    fun `Aged brie quality increases by 2 after expiry`() {
        val item = Item("Aged Brie", -1, 0)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Aged Brie", app.item.name)
        assertEquals(-2, app.item.sellIn)
        assertEquals(2, app.item.quality)
    }



    @Test
    fun `Elixir of the mongoose decreases in quality by one before expiry`() {
        val item = Item("Elixir of the Mongoose", 5, 7)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Elixir of the Mongoose", app.item.name)
        assertEquals(4, app.item.sellIn)
        assertEquals(6, app.item.quality)
    }

    @Test
    fun `Elixir of the mongoose quality decreases by 2 day after expiry`() {
        val item = Item("Elixir of the Mongoose", 0, 7)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Elixir of the Mongoose", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(5, app.item.quality)
    }


    @Test
    fun `Sulfuras hand of ragnaros quality and sale date unchanged at day 0`() {
        val item = Item("Sulfuras, Hand of Ragnaros", 0, 80)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name)
        assertEquals(0, app.item.sellIn)
        assertEquals(80, app.item.quality)
    }

    @Test
    fun `Sulfuras hand of ragnaros quality and sale date unchanged day after 'expiry'`() {
        val item = Item("Sulfuras, Hand of Ragnaros", -1, 80)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(80, app.item.quality)
    }

    @Test
    fun `backstage passes increase in quality by 1 with over 10 days to expiry`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(14, app.item.sellIn)
        assertEquals(21, app.item.quality)
    }

    @Test
    fun `backstage passes increase in quality with 10 days to go, maxing out at 50`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(9, app.item.sellIn)
        assertEquals(50, app.item.quality)
    }

    @Test
    fun `backstage passes increase in quality by 1 with 5 days to go, maxing out at 50`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(4, app.item.sellIn)
        assertEquals(50, app.item.quality)
    }

    @Test
    fun `backstage passes increase in quality by 2 with 10 days to expiry`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 10, 30)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(9, app.item.sellIn)
        assertEquals(32, app.item.quality)
    }


    @Test
    fun `backstage passes increase in quality by 3 with 5 days to expiry`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 5, 30)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(4, app.item.sellIn)
        assertEquals(33, app.item.quality)
    }

    @Test
    fun `backstage passes drop to zero quality day of expiry`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(0, app.item.quality)
    }

    @Test
    fun `backstage passes drop to zero quality after expiry`() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", -1, 0)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name)
        assertEquals(-2, app.item.sellIn)
        assertEquals(0, app.item.quality)
    }



    @Test
    fun `conjured product decreases in quality by 2 before expiry`() {
        val item = Item("Conjured Mana Cake", 3, 6)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Conjured Mana Cake", app.item.name)
        assertEquals(2, app.item.sellIn)
        assertEquals(4, app.item.quality)
    }

    @Test
    fun `conjured product decreases in quality by 4 after expiry`() {
        val item = Item("Conjured Mana Cake", 0, 6)
        val app = GuildedRose(item)
        app.update()
        assertEquals("Conjured Mana Cake", app.item.name)
        assertEquals(-1, app.item.sellIn)
        assertEquals(2, app.item.quality)
    }


}
