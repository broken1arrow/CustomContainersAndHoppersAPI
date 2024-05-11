package org.brokenarrow.storage.api.Crafting;

import org.bukkit.inventory.ItemStack;

/**
 * The ingredients for the crafting recipe.
 */
public interface IngredientsDataApi {

	/**
	 * Get the list of items you can use for this recipe.
	 *
	 * @return itemstack array of ingredients some can be used.
	 */
	ItemStack[] getIngredientsList();

	/**
	 * Get amount you need for this recipe.
	 *
	 * @return amount you need to make the recipe.
	 */
	int getAmountNeeded() ;

}
