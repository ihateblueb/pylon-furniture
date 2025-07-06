package io.github.pylonmc.pylon.furniture

import io.github.pylonmc.pylon.core.block.PylonBlock
import io.github.pylonmc.pylon.furniture.items.WoodenStool

class PylonBlocks {
    init { throw AssertionError("Utility class") }
    companion object {
        init {
            PylonBlock.register(WoodenStool.KEY, WoodenStool.MATERIAL, WoodenStool::class.java)
        }
    }
}