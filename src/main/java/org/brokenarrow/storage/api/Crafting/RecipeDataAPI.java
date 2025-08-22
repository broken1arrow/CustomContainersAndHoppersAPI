package org.brokenarrow.storage.api.Crafting;


import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * This class are used to create a recipe you later can use when
 * add to RecipeCache and later used for auto crafter container.
 * <p>
 * See this class for methods to add to cache:
 * {@link RecipeCacheAPI}
 */
public interface RecipeDataAPI {

	/**
	 * Get list of ingredients you need to craft the item (every object in the list
	 * are one recipe with different ingredients and amount you needed to make the recipe).
	 * <p>
	 * It will have like this:
	 * <p>
	 * Recipe need 8 oak planks to make on chest.
	 * But it can be also contain recipe some need 8 tnt to make on chest(If a custom recipe is
	 * added on the server or added through the api).
	 *
	 * @return IngredientsData class you can get the data for all different recipes you can make one result/output item.
	 */
	List<IngredientsDataApi> getIngredientsDataList();

	/**
	 * Get amount of items you get for a recipe.
	 *
	 * @return amount of items you get as result/output.
	 */
	int getResultAmount();

	/**
	 * Get itemStack you get for a recipe.
	 *
	 * @return the itemStack as result/output for the recipe.
	 */
	ItemStack getResult();

	/**
	 * get the name of the recipe.
	 *
	 * @return the name of the recipe.
	 */
	String getNamespacedKey();
}
