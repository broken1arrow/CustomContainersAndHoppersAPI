package org.brokenarrow.storage.api.Crafting;

import org.brokenarrow.storage.api.Crafting.util.MaterialGroup;
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
 * {@link RecipeDataAPI}
 */
public interface RecipeCacheAPI {

	/**
	 * Set one or several recipe´s to the cache. It will store this and be used in auto-crafter container.
	 *
	 * @param materialGroup  group for the recipe
	 * @param recipeDataList the data like amount, itemstack, amount output item and the itemstack output.
	 */

	void setRecipes(final MaterialGroup materialGroup, final List<RecipeDataAPI> recipeDataList);

	/**
	 * Set one or several recipe´s to the cache. It will store this and be used in auto-crafter container.
	 *
	 * @param materialGroup   group for the recipe
	 * @param recipeList      the ingriens and amount.
	 * @param namespacedKey   the key for the recipe.
	 * @param outputAmount    amount of items added back of the new item.
	 * @param itemstackoutput the output item you want as result.
	 */
	void setRecipes(final MaterialGroup materialGroup, final List<IngredientsDataApi> recipeList, final String namespacedKey, final int outputAmount, final ItemStack itemstackoutput);

	/**
	 * Add one or several recipe´s to the cache. If key exist it will try to add the new values
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

	void addRecipes(final MaterialGroup materialGroup, final List<IngredientsDataApi> recipeList, final String namespacedKey, final int outputAmount, final ItemStack itemstackoutput);

	/**
	 * Get the group a recipe output item belongs too.
	 *
	 * @param material the material you want to check.
	 * @return the MaterialGroup first matching letter.
	 */
	MaterialGroup getMaterialGroup(final Material material);

	/**
	 * Get the map with all recipes
	 *
	 * @return return all recipes.
	 */

	Map<MaterialGroup, List<RecipeDataAPI>> getRecipes();


	/**
	 * Check if itemstack is same as the recipe ingredients.
	 *
	 * @param ingredientsData class some contains ingredients
	 * @param itemStacks      the items you want to check against the ingredients.
	 * @return true if it finds a match.
	 */
	boolean itemIsSimilar(IngredientsDataApi ingredientsData, ItemStack... itemStacks);

	/**
	 * Check if itemstack is same as the recipe ingredients.
	 *
	 * @param ingredientsData class some contains ingredients
	 * @param itemStack       the items you want to check against the ingredients.
	 * @return true if find a match.
	 */
	boolean itemIsSimilar(IngredientsDataApi ingredientsData, ItemStack itemStack);

	/**
	 * Get the Recipe Data some contains
	 * recipe info.
	 *
	 * @param key the recipe group key.
	 * @return return all recipes.
	 */
	List<RecipeDataAPI> getRecipe(MaterialGroup key);

	/**
	 * Get all recipes key in map.
	 *
	 * @return a set of recipes.
	 */
	Set<MaterialGroup> getKeyList();

	/**
	 * Get List of all info both ingredients and result with amount.
	 *
	 * @param data List of recipes search inside for the ingredients.
	 * @return RecipeData class you can access all recipe data like ingredients and result.
	 */
	List<IngredientsDataApi> getRecipeDataList(RecipeDataAPI data);

	/**
	 * Get List of ingredients for one of the ingredient need for the recipe.
	 *
	 * @param ingredientsData class some contains the ingredient or ingredients.
	 * @return a list of ingredients if is set, other case will it be empty.
	 */
	List<ItemStack> getIngredientsList(IngredientsDataApi ingredientsData);

	/**
	 * Get IngredientsData with ingredients and amount needed for the output item.
	 *
	 * @param data        List of recipes search inside for the ingredients.
	 * @param ingredients the ingredient you want to know amount of items.
	 * @return itemStackData class you can access ingredients and amount getters.
	 */

	IngredientsDataApi getIngredientsData(RecipeDataAPI data, ItemStack ingredients);

	/**
	 * Get list of matching recipe from this cache.
	 *
	 * @param recipe itemstack you want from the cache.
	 * @return list of recipe some match the recipe.
	 */
	List<RecipeDataAPI> getRecipes(ItemStack recipe);

	/**
	 * Check if it prevents override or not.
	 *
	 * @return true if it prevents override.
	 */
	boolean isPreventOverride();

	/**
	 * Set this too false to override a recipe in cache.
	 * Do not override recipes some start with 'minecraft:'
	 *
	 * @param preventOverride set it to false if you want to override recipe in cache.
	 */
	void setPreventOverride(boolean preventOverride);

}
