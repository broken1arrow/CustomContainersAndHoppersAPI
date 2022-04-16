package org.brokenarrow.storage.api;

import org.brokenarrow.storage.util.builderclass.RecipeData;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RecipeCacheAPI {


	/**
	 * Set one or several recipe´s to the cache. It will store this and be used in autocrafter container.
	 *
	 * @param recipeKey  unique recipe name
	 * @param recipeData the data like amount, itemstack, amount output item and the itemstack output.
	 */

	public void setRecipes(final String recipeKey, final RecipeData recipeData);

	/**
	 * Set one or several recipe´s to the cache. It will store this and be used in autocrafter container.
	 *
	 * @param recipeKey       unique recipe name
	 * @param recipeList      the ingriens and amount.
	 * @param outputAmount    amount of items added back of the new item.
	 * @param itemstackoutput the output item you want as result.
	 */
	public void setRecipes(final String recipeKey, final List<RecipeData.ItemStackData> recipeList, final int outputAmount, ItemStack itemstackoutput);

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

	public void addRecipes(final String recipeKey, final List<RecipeData.ItemStackData> recipeList, final int outputAmount, ItemStack itemstackoutput);

	/**
	 * Get the map with all recipes
	 *
	 * @return return all recipes.
	 */

	public Map<String, RecipeData> getRecipes();

	/**
	 * Get the Recipe Data some contains
	 * recipe info.
	 *
	 * @return return all recipes.
	 */
	public RecipeData getRecipe(String key);

	/**
	 * Get all recipes key in map.
	 *
	 * @return a list of recipes.
	 */
	public Set<String> getKeyList();

	/**
	 * Get ItemStackData with ingredients and amount needed for the output item.
	 *
	 * @param data        List of recipes seach inside for the ingredients.
	 * @param ingredients the ingredient you want to know amount of items.
	 * @return itemStackData class you can acces ingredients and amount getters.
	 */

	public RecipeData.ItemStackData getItemStackData(RecipeData data, ItemStack ingredients);

	/**
	 * Get list of matching recipe from this cache.
	 *
	 * @param recipe itemstack you want from the cache.
	 * @return list of recipe some match the recipe.
	 */

	public List<RecipeData> getRecipes(ItemStack recipe);

}
