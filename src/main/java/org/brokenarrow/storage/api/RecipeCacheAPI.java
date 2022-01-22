package org.brokenarrow.storage.api;

import org.brokenarrow.storage.api.builder.RecipeCacheDataAPI;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Set;

public interface RecipeCacheAPI {


	void addRecipes(ItemStack recipes, Set<ItemStack> material1, Set<ItemStack> material2, Set<ItemStack> material3, Set<ItemStack> material4, Set<ItemStack> material5,
	                int amount1, int amount2, int amount3, int amount4, int amount5, int totalAmount);

	/**
	 * Get the map with all recipes
	 *
	 * @return return all recipes.
	 */

	Map<ItemStack, RecipeCacheDataAPI> getRecipe();

	/**
	 * Get all recipes as a setlist
	 *
	 * @return a list of recipes.
	 */

	Set<ItemStack> getRecipes();

	/**
	 * Get one recipe from this cache
	 *
	 * @param recipe the recipe you want the ingridens.
	 * @return the recipe ingridens.
	 */

	RecipeCacheDataAPI getRecipe(ItemStack recipe);

	/**
	 * Get the matrial needed for a recipe.
	 *
	 * @param recipe       the recipe you want to make
	 * @param materialType matrial
	 * @return
	 */
	Set<ItemStack> getIngredients(ItemStack recipe, MaterialType materialType);

	int getIngredientsAmount(ItemStack recipe, MatrialAmount matrialAmount);

	enum MaterialType {
		MATERIAL_1,
		MATERIAL_2,
		MATERIAL_3,
		MATERIAL_4,
		MATERIAL_5
	}

	enum MatrialAmount {
		AMOUNT1,
		AMOUNT2,
		AMOUNT3,
		AMOUNT4,
		AMOUNT5

	}

}
