package io.github.pylonmc.pylon.furniture.items

import io.github.pylonmc.pylon.furniture.util.KeyUtils.Companion.pylonKey
import io.github.pylonmc.pylon.core.block.PylonBlock
import io.github.pylonmc.pylon.core.block.base.PylonEntityHolderBlock
import io.github.pylonmc.pylon.core.block.context.BlockCreateContext
import io.github.pylonmc.pylon.core.entity.EntityStorage.add
import io.github.pylonmc.pylon.core.entity.PylonEntity
import io.github.pylonmc.pylon.core.entity.base.PylonInteractableEntity
import io.github.pylonmc.pylon.core.entity.display.ItemDisplayBuilder
import io.github.pylonmc.pylon.core.entity.display.transform.TransformBuilder
import io.github.pylonmc.pylon.core.item.PylonItem
import io.github.pylonmc.pylon.core.item.builder.ItemStackBuilder.Companion.pylonItem
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.block.Block
import org.bukkit.entity.ItemDisplay
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataContainer

class WoodenStool : PylonBlock, PylonEntityHolderBlock {
    class Item(stack: ItemStack) : PylonItem(stack)

    @Suppress("unused")
    constructor(block: Block, context: BlockCreateContext) : super(block) {
        block.type = Material.STRUCTURE_VOID
    }

    @Suppress("unused")
    constructor(block: Block, pdc: PersistentDataContainer) : super(block)

    override fun createEntities(context: BlockCreateContext): Map<String, PylonEntity<*>> {
        val seat = SeatDisplay.make(block)
        val leg1Display = LegDisplay.make(block, -0.25, -0.25)
        val leg2Display = LegDisplay.make(block, 0.25, -0.25)
        val leg3Display = LegDisplay.make(block, -0.25, 0.25)
        val leg4Display = LegDisplay.make(block, 0.25, 0.25)

        return mapOf(
            "seat" to seat,
            "leg1" to leg1Display,
            "leg2" to leg2Display,
            "leg3" to leg3Display,
            "leg4" to leg4Display,
        )
    }


    class SeatDisplay : PylonEntity<ItemDisplay>, PylonInteractableEntity {
        @Suppress("unused")
        constructor(entity: ItemDisplay) : super(entity)

        constructor(block: Block) : super(
            KEY, ItemDisplayBuilder()
                .material(MATERIAL)
                .transformation(
                    TransformBuilder()
                        .scale(0.75, 1.0, 0.75)
                )
                .build(block.location.toCenterLocation().add(0.0, 0.5, 0.0))
        )

        override fun onInteract(event: PlayerInteractEntityEvent) {
            println("SeatDisplay onInteract")

            val player = event.getPlayer()
            event.rightClicked.addPassenger(player)
        }

        companion object {
            val KEY: NamespacedKey = pylonKey("wooden_stool_seat")

            fun make(block: Block): SeatDisplay {
                val display = SeatDisplay(block)
                add(display)
                return display
            }
        }
    }

    class LegDisplay : PylonEntity<ItemDisplay> {
        @Suppress("unused")
        constructor(entity: ItemDisplay) : super(entity)

        constructor(block: Block, x: Double, z: Double) : super(
            KEY, ItemDisplayBuilder()
                .material(LEG_MATERIAL)
                .transformation(
                    TransformBuilder()
                        .scale(0.15, 0.5, 0.15)
                )
                .build(block.location.toCenterLocation().add(x, (-0.5 / 2), z))
        )

        companion object {
            val KEY: NamespacedKey = pylonKey("wooden_stool_leg")

            fun make(block: Block, x: Double, z: Double): LegDisplay {
                val display = LegDisplay(block, x, z)
                add(display)
                return display
            }
        }
    }

    companion object {
        val KEY: NamespacedKey = pylonKey("wooden_stool")

        val MATERIAL: Material = Material.OAK_PRESSURE_PLATE
        val LEG_MATERIAL: Material = Material.OAK_LOG

        val STACK: ItemStack = pylonItem(MATERIAL, KEY).build()
    }
}