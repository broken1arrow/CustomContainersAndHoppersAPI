package org.brokenarrow.storage.api.builder;

import org.brokenarrow.storage.util.builderclass.RecipeData;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface RecipeDataAPI {

	/**
	 * Get list of ingredients you need to craft the item (every object in the list
	 * are one recipe with diffrent ingrediens and amount you needd make the recipe).
	 * <p>
	 * It will have like this:
	 * <p>
	 * <p>
	 * Recipe need 8 oak planks to make on chest.
	 * But it can be also Recipe need 8 tnt to make on chest(If a custom recipe is
	 * addeed on the server or added thru the api).
	 *
	 * @return ItemStackData class you can get the data for all diffrent recipes you can make one result/output item.
	 */
	public List<RecipeData.ItemStackData> getItemStackDataList();

	/**
	 * Get amount of items you get for a recipe.
	 *
	 * @return amount of items you get as result/output.
	 */
	public int getOutputAmount();

	/**
	 * Get itemstack you get for a recipe.
	 *
	 * @return the itemstack as result/output for the recipe.
	 */
	public ItemStack getOutputStack();

	/**
	 * Get the builder to get old data when want to only add new data.
	 *
	 * @return the builder you can set new data.
	 */
	public RecipeData.Bulider getBulider();


}
