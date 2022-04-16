package org.brokenarrow.storage.util.builderclass;

import org.brokenarrow.storage.api.builder.RecipeCacheDataAPI;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public final class RecipeData implements RecipeCacheDataAPI {
	private final List<ItemStackData> itemStackDataList;
	private final int outputAmount;
	private final ItemStack outputStack;
	private final Bulider bulider;


	private RecipeData(Bulider bulider) {
		this.itemStackDataList = bulider.listOfIngriens;
		this.outputStack = bulider.outputStack;
		this.outputAmount = bulider.outputAmount;
		this.bulider = bulider;
	}

	@Override
	public List<ItemStackData> getItemStackDataList() {
		return itemStackDataList;
	}

	@Override
	public int getOutputAmount() {
		return outputAmount;
	}

	@Override
	public ItemStack getOutputStack() {
		return outputStack;
	}

	@Override
	public Bulider getBulider() {
		return bulider;
	}

	public static class Bulider {
		private List<ItemStackData> listOfIngriens;
		private ItemStack outputStack;
		private int outputAmount;

		/**
		 * Set list of diffrent recipes for this recult/outupt item.
		 *
		 * @param listOfIngriens the diffrent recipes for this result/outupt item.
		 * @return this builder class.
		 */
		public final Bulider setListOfIngriens(List<ItemStackData> listOfIngriens) {
			this.listOfIngriens = listOfIngriens;

			return this;
		}

		/**
		 * Set the itemstack some shall be used as output item.
		 *
		 * @param outputStack The item used as result/output item.
		 * @return this builder class.
		 */
		public Bulider setOutputStack(ItemStack outputStack) {
			this.outputStack = outputStack;
			return this;
		}

		/**
		 * Set amount of result/output items shall be added.
		 *
		 * @param outputAmount amount of items give back from the recipe.
		 * @return this builder class.
		 */
		public Bulider setOutputAmount(int outputAmount) {
			this.outputAmount = outputAmount;
			return this;
		}

		/**
		 * build it with the data you set.
		 *
		 * @return RecipeData class.
		 */
		public RecipeData build() {
			return new RecipeData(this);
		}
	}

	public static class ItemStackData {
		private final ItemStack[] itemStacks;
		private final int amountNeeded;

		/**
		 * Set array of items you want as sugestion for the recipe.
		 * For example chest can you craft from diffrent matrials
		 * so add all matrial in same array to give player several
		 * diffrent matrail he can use or add only one item.
		 *
		 * @param itemStacks   you want to use as ingredients to make a recipe.
		 * @param amountNeeded for this ingredients to make the recipe.
		 */
		public ItemStackData(ItemStack[] itemStacks, int amountNeeded) {
			this.itemStacks = itemStacks;
			this.amountNeeded = amountNeeded;
		}

		/**
		 * Get the list of items you can use for this recipe.
		 *
		 * @return itemstack array of ingredients some can be used.
		 */
		public ItemStack[] getItemStacks() {
			return itemStacks;
		}

		/**
		 * Get amount you need for this recipe.
		 *
		 * @return amount you need to make the recipe.
		 */
		public int getAmountNeeded() {
			return amountNeeded;
		}
	}
}
