package org.brokenarrow.storage.api;

import org.brokenarrow.storage.util.builderclass.RecipeData;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class is used for cache recipes. You can ether use
 * any of set methods or add method for put a recipe to cache.
 * <p>
 * For build a recipe to add to cache see:
 * {@link RecipeData}
 */
public interface RecipeCacheAPI {

	/**
	 * Set one or several recipe´s to the cache. It will store this and be used in autocrafter container.
	 *
	 * @param recipeKey  unique recipe name
	 * @param recipeData the data like amount, itemstack, amount output item and the itemstack output.
	 */

	void setRecipes(final String recipeKey, final RecipeData recipeData);

	/**
	 * Set one or several recipe´s to the cache. It will store this and be used in autocrafter container.
	 *
	 * @param recipeKey       unique recipe name
	 * @param recipeList      the ingriens and amount.
	 * @param outputAmount    amount of items added back of the new item.
	 * @param itemstackoutput the output item you want as result.
	 */
	void setRecipes(final String recipeKey, final List<RecipeData.IngredientsData> recipeList, final int outputAmount, ItemStack itemstackoutput);

	/**
	 * Add one or several recipe´s to the cache. If key exist it will try add the new values
	 * (if not it will put new data to cache). If you want to replace all data use {@link #setRecipes(String, RecipeData)} or
	 * {@link #setRecipes(String, List, int, ItemStack)}.
	 * <p>
	 * It will store this and be used in autocrafter container.
	 *
	 * @param recipeKey       unique recipe name
	 * @param recipeList      the ingriens and amount.
	 * @param outputAmount    amount of items added back of the new item.
	 * @param itemstackoutput the output item you want as result.
	 */

	void addRecipes(final String recipeKey, final List<RecipeData.IngredientsData> recipeList, final int outputAmount, ItemStack itemstackoutput);

	/**
	 * Get the map with all recipes
	 *
	 * @return return all recipes.
	 */

	Map<String, RecipeData> getRecipes();

	/**
	 * Get the Recipe Data some contains
	 * recipe info.
	 *
	 * @return return all recipes.
	 */
	RecipeData getRecipe(String key);

	/**
	 * Get all recipes key in map.
	 *
	 * @return a list of recipes.
	 */
	Set<String> getKeyList();

	/**
	 * Get IngredientsData with ingredients and amount needed for the output item.
	 *
	 * @param data        List of recipes seach inside for the ingredients.
	 * @param ingredients the ingredient you want to know amount of items.
	 * @return itemStackData class you can acces ingredients and amount getters.
	 */

	RecipeData.IngredientsData getIngredientsData(RecipeData data, ItemStack ingredients);

	/**
	 * Get list of matching recipe from this cache.
	 *
	 * @param recipe itemstack you want from the cache.
	 * @return list of recipe some match the recipe.
	 */

	List<RecipeData> getRecipes(ItemStack recipe);

	/**
	 * Check if it prevent override or not.
	 *
	 * @return true if it prevent override.
	 */
	boolean isPreventOverride();

	/**
	 * Set this to false to override a recipe in cache.
	 * <p>
	 * IMPORTANT: Do not override recipes some start with 'minecraft:'
	 *
	 * @param preventOverride set it to false if you want to override recipe in cache.
	 */
	void setPreventOverride(boolean preventOverride);

}
