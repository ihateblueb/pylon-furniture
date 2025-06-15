package io.github.pylonmc.furniture.util

import io.github.pylonmc.furniture.PylonFurniture
import org.bukkit.NamespacedKey

class KeyUtils private constructor() {
    init {
        throw AssertionError("Utility class")
    }

    companion object {
        fun pylonKey(key: String): NamespacedKey {
            return NamespacedKey(PylonFurniture.instance, key)
        }
    }
}