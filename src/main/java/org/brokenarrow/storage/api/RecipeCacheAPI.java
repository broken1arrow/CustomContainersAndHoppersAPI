package org.brokenarrow.storage.api;

import org.brokenarrow.storage.Crafting.util.MaterialGroup;
import org.brokenarrow.storage.util.builderclass.RecipeData;
import org.brokenarrow.storage.util.builderclass.RecipeData.IngredientsData;
import org.bukkit.Material;
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
	 * @param materialGroup  group for the recipe
	 * @param recipeDataList the data like amount, itemstack, amount output item and the itemstack output.
	 */

	void setRecipes(final MaterialGroup materialGroup, final List<RecipeData> recipeDataList);

	/**
	 * Set one or several recipe´s to the cache. It will store this and be used in autocrafter container.
	 *
	 * @param materialGroup   group for the recipe
	 * @param recipeList      the ingriens and amount.
	 * @param namespacedKey   the key for the recipe.
	 * @param outputAmount    amount of items added back of the new item.
	 * @param itemstackoutput the output item you want as result.
	 */
	void setRecipes(final MaterialGroup materialGroup, final List<IngredientsData> recipeList, final String namespacedKey, final int outputAmount, final ItemStack itemstackoutput);

	/**
	 * Add one or several recipe´s to the cache. If key exist it will try add the new values
	 * (if not it will put new data to cache). If you want to replace all data use {@link #setRecipes(MaterialGroup, List)} or
	 * {@link #setRecipes(MaterialGroup, List, String, int, ItemStack)}.
	 * <p>
	 * It will store this and be used in autocrafter container.
	 *
	 * @param materialGroup   group for the recipe
	 * @param recipeList      the ingriens and amount.
	 * @param outputAmount    amount of items added back of the new item.
	 * @param namespacedKey   the key for the recipe.
	 * @param itemstackoutput the output item you want as result.
	 */

	void addRecipes(final MaterialGroup materialGroup, final List<IngredientsData> recipeList, final String namespacedKey, final int outputAmount, final ItemStack itemstackoutput);

	/**
	 * Get the group a recipe outupt item belongs too.
	 *
	 * @param material the matrial you want to check.
	 * @return the MaterialGroup first maching letter.
	 */
	MaterialGroup getMaterialGroup(final Material material);

	/**
	 * Get the map with all recipes
	 *
	 * @return return all recipes.
	 */

	Map<MaterialGroup, List<RecipeData>> getRecipes();


	/**
	 * Check if itemstack is same as the recipe ingredients.
	 *
	 * @param ingredientsData class some contains ingredients
	 * @param itemStacks      the items you want to check against the ingredients.
	 * @return true if find a match.
	 */
	boolean itemIsSimilar(RecipeData.IngredientsData ingredientsData, ItemStack... itemStacks);

	/**
	 * Check if itemstack is same as the recipe ingredients.
	 *
	 * @param ingredientsData class some contains ingredients
	 * @param itemStack       the items you want to check against the ingredients.
	 * @return true if find a match.
	 */
	boolean itemIsSimilar(RecipeData.IngredientsData ingredientsData, ItemStack itemStack);

	/**
	 * Get the Recipe Data some contains
	 * recipe info.
	 *
	 * @return return all recipes.
	 */
	List<RecipeData> getRecipe(MaterialGroup key);

	/**
	 * Get all recipes key in map.
	 *
	 * @return a list of recipes.
	 */
	Set<MaterialGroup> getKeyList();

	/**
	 * Get List of all info both ingredients and result with amount.
	 *
	 * @param data List of recipes seach inside for the ingredients.
	 * @return RecipeData class you can acces all recipe data like ingredients and result.
	 */
	List<RecipeData.IngredientsData> getRecipeDataList(RecipeData data);

	/**
	 * Get List of ingredients for one of the ingredient need for the recipe.
	 *
	 * @param ingredientsData class some contains the ingredient or ingredients.
	 * @return true if find a match.
	 */
	List<ItemStack> getIngredientsList(RecipeData.IngredientsData ingredientsData);

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
	 * Do not override recipes some start with 'minecraft:'
	 *
	 * @param preventOverride set it to false if you want to override recipe in cache.
	 */
	void setPreventOverride(boolean preventOverride);
}
