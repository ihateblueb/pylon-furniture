package io.github.pylonmc.pylon.furniture

import io.github.pylonmc.pylon.core.addon.PylonAddon
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class PylonFurniture : JavaPlugin(), PylonAddon {
    override fun onEnable() {
        instance = this

        registerWithPylon()

        PylonItems.Companion
        PylonBlocks.Companion
        PylonEntities.Companion
    }

    override val javaPlugin: JavaPlugin
        get() = this

    override val displayName: String
        get() = "Furniture"

    override val languages: MutableSet<Locale>
        get() = mutableSetOf(Locale.ENGLISH)

    companion object {
        lateinit var instance: PylonFurniture
    }
}