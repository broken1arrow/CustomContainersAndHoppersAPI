package org.brokenarrow.storage.util.builderclass;

import org.brokenarrow.storage.api.builder.RecipeDataAPI;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * This class are used to create a recipe you later can use when
 * add to RecipeCache and later used for autocrafter container.
 * <p>
 * See this class for methods to add to cache:
 * {@link org.brokenarrow.storage.api.RecipeCacheAPI}
 */
public final class RecipeData implements RecipeDataAPI {
	private final List<IngredientsData> ingredientsDataList;
	private final int outputAmount;
	private final ItemStack outputStack;
	private final Bulider bulider;


	private RecipeData(Bulider bulider) {
		this.ingredientsDataList = bulider.listOfIngriens;
		this.outputStack = bulider.outputStack;
		this.outputAmount = bulider.outputAmount;
		this.bulider = bulider;
	}

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
	@Override
	public List<IngredientsData> getIngredientsDataList() {
		return ingredientsDataList;
	}

	/**
	 * Get amount of items you get for a recipe.
	 *
	 * @return amount of items you get as result/output.
	 */
	@Override
	public int getOutputAmount() {
		return outputAmount;
	}

	/**
	 * Get itemstack you get for a recipe.
	 *
	 * @return the itemstack as result/output for the recipe.
	 */
	@Override
	public ItemStack getResult() {
		return outputStack;
	}

	/**
	 * Get the builder to get old data when want to only add new data.
	 *
	 * @return the builder you can set new data.
	 */
	@Override
	public Bulider getBulider() {
		return bulider;
	}

	public static class Bulider {
		private List<IngredientsData> listOfIngriens;
		private ItemStack outputStack;
		private int outputAmount;

		/**
		 * Set list of diffrent recipes for this recult/outupt item.
		 *
		 * @param listOfIngriens the diffrent recipes for this result/outupt item.
		 * @return this builder class.
		 */
		public final Bulider setListOfIngriens(List<IngredientsData> listOfIngriens) {
			this.listOfIngriens = listOfIngriens;

			return this;
		}

		/**
		 * Set the itemstack some shall be used as result/output item.
		 *
		 * @param outputStack The item used as result/output item.
		 * @return this builder class.
		 */
		public Bulider setResult(ItemStack outputStack) {
			this.outputStack = outputStack;
			return this;
		}

		/**
		 * Set amount of result/output items shall be added.
		 *
		 * @param outputAmount amount of items give back from the recipe.
		 * @return this builder class.
		 */
		public Bulider setResultAmount(int outputAmount) {
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

	public static class IngredientsData {
		private final ItemStack[] ingredientsList;
		private final int amountNeeded;

		/**
		 * Set array of items you want as sugestion for the recipe.
		 * For example chest can you craft from diffrent material
		 * so add all material in same array to give player several
		 * diffrent material he can use or add only one item.
		 *
		 * @param ingredientsList of your itemstacks you want as ingredients to make a recipe.
		 * @param amountNeeded    for this ingredients to make the recipe.
		 */
		public IngredientsData(ItemStack[] ingredientsList, int amountNeeded) {
			this.ingredientsList = ingredientsList;
			this.amountNeeded = amountNeeded;
		}

		/**
		 * Get the list of items you can use for this recipe.
		 *
		 * @return itemstack array of ingredients some can be used.
		 */
		public ItemStack[] getIngredientsList() {
			return ingredientsList;
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
