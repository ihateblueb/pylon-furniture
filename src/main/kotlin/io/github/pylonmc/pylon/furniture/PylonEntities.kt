package io.github.pylonmc.pylon.furniture

import io.github.pylonmc.pylon.core.entity.PylonEntity
import io.github.pylonmc.pylon.furniture.items.WoodenStool
import org.bukkit.entity.ItemDisplay

class PylonEntities {
    init { throw AssertionError("Utility class") }
    companion object {
        init {
            PylonEntity.register(WoodenStool.SeatDisplay.KEY, ItemDisplay::class.java, WoodenStool.SeatDisplay::class.java)
            PylonEntity.register(WoodenStool.LegDisplay.KEY, ItemDisplay::class.java, WoodenStool.LegDisplay::class.java)
        }
    }
}