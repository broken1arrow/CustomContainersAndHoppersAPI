package org.brokenarrow.storage.api.Crafting;


import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * This class are used to create a recipe you later can use when
 * add to RecipeCache and later used for autocrafter container.
 * <p>
 * See this class for methods to add to cache:
 * {@link RecipeCacheAPI}
 */
public interface RecipeDataAPI {

	/**
	 * Get list of ingredients you need to craft the item (every object in the list
	 * are one recipe with diffrent ingrediens and amount you needd make the recipe).
	 * <p>
	 * It will have like this:
	 * <p>
	 * <p>
	 * Recipe need 8 oak planks to make on chest.
	 * But it can be also contain recipe some need 8 tnt to make on chest(If a custom recipe is
	 * addeed on the server or added thru the api).
	 *
	 * @return IngredientsData class you can get the data for all diffrent recipes you can make one result/output item.
	 */
	List<IngredientsDataApi> getIngredientsDataList();

	/**
	 * Get amount of items you get for a recipe.
	 *
	 * @return amount of items you get as result/output.
	 */
	int getResultAmount();

	/**
	 * Get itemstack you get for a recipe.
	 *
	 * @return the itemstack as result/output for the recipe.
	 */
	ItemStack getResult();

	/**
	 * Get the builder to get old data when want to only add new data.
	 *
	 * @return the builder you can set new data.
	 */

	/**
	 * get the name of the recipe.
	 *
	 * @return the name of the recipe.
	 */
	String getNamespacedKey();
}
