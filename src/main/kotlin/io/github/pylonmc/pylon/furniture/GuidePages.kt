package io.github.pylonmc.pylon.furniture

import io.github.pylonmc.pylon.core.guide.PylonGuide
import io.github.pylonmc.pylon.core.guide.pages.base.SimpleStaticGuidePage
import io.github.pylonmc.pylon.furniture.util.KeyUtils.Companion.pylonKey
import org.bukkit.Material

class GuidePages {
    companion object {
        val FURNITURE = SimpleStaticGuidePage(pylonKey("furniture"), Material.OAK_STAIRS)

        val SEATING = SimpleStaticGuidePage(pylonKey("seating"), Material.OAK_STAIRS)
        val TABLES = SimpleStaticGuidePage(pylonKey("tables"), Material.SCAFFOLDING)

        init {
            FURNITURE.addPage(SEATING)
            FURNITURE.addPage(TABLES)

            PylonGuide.rootPage.addPage(FURNITURE)
        }
    }
}