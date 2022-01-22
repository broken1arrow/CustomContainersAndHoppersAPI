package org.brokenarrow.storage.api;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Set;

public interface CheckItemsForCraftingApi {

	/**
	 * Remove the items inside the inventory if it exist in the inventory
	 *
	 * @param inventory the inventory the items shall be removed from.
	 * @param itemStack the item you want to remove.
	 */
	void removeItems(Inventory inventory, ItemStack itemStack);

	/**
	 * Get amount that should be added to inventory of recipe output.
	 *
	 * @param material             some are used to create output item.
	 * @param recipeOutputItemList item some shall be created.
	 * @return amount it will add to inventory.
	 */
	int amountToAdd(Material material, ItemStack recipeOutputItemList);

	/**
	 * Check special item if shall add extra items (for some complex recipes).
	 *
	 * @param outputRecipeItem item some shall be created.
	 * @param inventoryItems   map if items from inventory.
	 * @return true if item match.
	 */

	boolean checkIfItSpacialItem(ItemStack outputRecipeItem, Map<Material, ItemStack> inventoryItems);

	/**
	 * check if is a Boneblock as ingredients.
	 *
	 * @param itemUsecrafting ingredients used for craftoutputItem.
	 * @return true if is a Boneblock.
	 */
	boolean checkIfItBoneBlock(Material itemUsecrafting);

	/**
	 * check if is a Bamboo as ingredients.
	 *
	 * @param itemUsecrafting ingredients used for craftoutputItem
	 * @return true if is Bamboo.
	 */
	boolean checkIfItBamboo(Material itemUsecrafting);

	/**
	 * Check if it a color recipe, is for bypass the check if the recipe has more an one matral to use and the
	 * items you has added only demand 1 for the recipe, it will dynamicly chose right type after amount items
	 * for the recipe.
	 * <p>
	 * So for example light_gray_dye has two diffrent type of recipe one ony need one item and second need two diffrent item.
	 * It will shose that type some fith the cuurent added items.
	 *
	 * @param outputRecipeItem the recipe you whant to check aginst.
	 * @param inventoryItems   the items inside the inventory
	 * @return if the item inside the inventory match the items inside the recipe
	 */

	boolean ifItAreColor(ItemStack outputRecipeItem, Map<Material, ItemStack> inventoryItems);

	/**
	 * Check if it a tall flower
	 *
	 * @param itemUsecrafting the item you added inside the inventory to check
	 * @return true if the item are a tall flower.
	 */
	boolean checkIfItTallFlowers(Material itemUsecrafting);

	/**
	 * check if colors match if the recipe has more an 2 diffrent recipe ingredens and bypass the check.
	 * Is for recipe some has 1,2 and 3 diffreent items, but only added 2 matched items inside the inventory.
	 *
	 * @param outputRecipeItem the recipe you want to check against
	 * @param inventoryItems   the contents of the inventory
	 * @return true if the items match the recipe demand.
	 */
	boolean ifItAreColorMatchTwoItems(ItemStack outputRecipeItem, Map<Material, ItemStack> inventoryItems);

	/**
	 * Simpel check if it a color.
	 *
	 * @param outputItem the item you want to make.
	 * @return true if it a color recipe.
	 */
	boolean isAColor(ItemStack outputItem);

	/**
	 * Check if it a color and add extra item if it is a special color some has more items as output.
	 *
	 * @param itemToTake the item you has added to the inventory
	 * @param outputItem the recipe output.
	 * @return a number if it a match or 0 if not.
	 */


	int addExtraIfSpecialcolor(Material itemToTake, ItemStack outputItem);

	/**
	 * check type of item and add extra amount if it a recipe some use
	 * more ingredients or same recipe has diffrent ingredients amount
	 *
	 * @param outputItem the recipe output you want to match aginst.
	 * @return amount some shall be removed from inventory.
	 */
	int checkifSpecialItem(ItemStack outputItem);

	/**
	 * Amount shall add back to inventory
	 *
	 * @param recipeOutputItem the recipe output you want to match aginst.
	 * @param itemStack        from inventory to check amount
	 * @param itemToTake       type of ingrident curently whant to use for recipe.
	 * @param matrialAmount    what ingrident amount should be checked.
	 * @return amount after it has removed aoumt if ingrident need for recipe.
	 */
	int amountAddBack(ItemStack recipeOutputItem, ItemStack itemStack, Material itemToTake, RecipeCacheAPI.MatrialAmount matrialAmount);

	/**
	 * check if it a special recipe and return true if it is.
	 *
	 * @param recipeOutput     the recipe it curently try to make
	 * @param itemUsedInrecipe the item you want to check if the recipe contains the item.
	 * @return true if it match a special color.
	 */
	boolean checkAdvanceRecipes(ItemStack recipeOutput, Material itemUsedInrecipe);

	/**
	 * Check if a item match the item demanded for the recipe.
	 *
	 * @param outputRecipe     the recipe item you want to make
	 * @param ingredientsItems the items you want to check if it match the curent recipe ingredients.
	 * @param materialType     what ingredients you want to check against .
	 * @return true if the items match the curent recipe.
	 */

	boolean isMatrialMatch(ItemStack outputRecipe, ItemStack ingredientsItems, RecipeCacheAPI.MaterialType materialType);
	
	/**
	 * Check recipe ingrediens to the items inside the inventory.
	 *
	 * @param ingrediens the recipe ingridens.
	 * @param map        the contents of your inventory.
	 * @return a item if it match or null if it not find any match.
	 */

	Material returnItemToRecipe(Set<ItemStack> ingrediens, Map<Material, Integer> map);

	/**
	 * Check if the map contains the needed recipe ingrediens.
	 *
	 * @param materialType     what ingredients you want to check against.
	 * @param recipeOutputItem the recipe you want to make.
	 * @param map              the inventory contents
	 * @return true if the item match recipe ingredien.
	 */
	boolean isMapContainsRecipeIngrediens(RecipeCacheAPI.MaterialType materialType, ItemStack recipeOutputItem, Map<Material, Integer> map);

	/**
	 * Some recipe has several diffrent items you can choose from, this will split up the recipe ingrediens
	 * and check every one aginst the item inside the inventory and return a item if it match.
	 *
	 * @param itemFromInventory    the item inside the inventory
	 * @param ingrediensFromRecipe the recipe ingridens some it deamand
	 * @return the matching item if it exist or return null if it not a match.
	 */

	Material splitIngrediens(Material itemFromInventory, Set<ItemStack> ingrediensFromRecipe);

	void setRecipeChache(RecipeCacheAPI recipeCache);
}
