package io.github.pylonmc.pylon.furniture

import io.github.pylonmc.pylon.furniture.items.WoodenStool
import io.github.pylonmc.pylon.core.item.PylonItem
import io.github.pylonmc.pylon.core.recipe.RecipeType
import org.bukkit.Material
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.recipe.CraftingBookCategory

class PylonItems {
    init {
        throw AssertionError("Utility class")
    }

    companion object {
        init {
            PylonItem.register(WoodenStool.Item::class.java, WoodenStool.STACK, WoodenStool.KEY)
            GuidePages.SEATING.addItem(WoodenStool.KEY)
            val recipe = ShapedRecipe(WoodenStool.KEY, WoodenStool.STACK)
                .shape("   ", " P ", " L ")
                .setIngredient('P', Material.OAK_PLANKS)
                .setIngredient('L', Material.OAK_LOG)
            recipe.setCategory(CraftingBookCategory.BUILDING)
            RecipeType.VANILLA_SHAPED.addRecipe(recipe)
        }
    }
}