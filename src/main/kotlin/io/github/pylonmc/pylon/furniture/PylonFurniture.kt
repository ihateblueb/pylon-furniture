package io.github.pylonmc.pylon.furniture

import io.github.pylonmc.pylon.core.addon.PylonAddon
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TranslatableComponent
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class PylonFurniture : JavaPlugin(), PylonAddon {
    override fun onEnable() {
        instance = this

        registerWithPylon()

        PylonItems.Companion
        PylonBlocks.Companion
        PylonEntities.Companion
        GuidePages.Companion
    }

    override val javaPlugin: JavaPlugin
        get() = this

    override val displayName: TranslatableComponent
        get() = Component.translatable("pylon.pylonfurniture.addon")

    override val material: Material = Material.OAK_STAIRS

    override val languages: MutableSet<Locale>
        get() = mutableSetOf(Locale.ENGLISH)

    companion object {
        lateinit var instance: PylonFurniture
    }
}