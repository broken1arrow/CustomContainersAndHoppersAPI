package org.brokenarrow.storage.api.Crafting;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface IngredientBuilderApi {


    /**
     * Set list of different recipes for this result/output item.
     *
     * @param listOfIngredients the different recipes for this result/output item.
     * @return this builder class.
     */
    IngredientBuilderApi setListOfIngredients(final List<IngredientsDataApi> listOfIngredients);

    /**
     * Set the itemStack some shall be used as result/output item.
     *
     * @param outputStack The item used as result/output item.
     * @return this builder class.
     */
    IngredientBuilderApi setResult(final ItemStack outputStack);

    /**
     * Set amount of result/output items shall be added.
     *
     * @param outputAmount amount of items give back from the recipe.
     * @return this builder class.
     */
    IngredientBuilderApi setResultAmount(final int outputAmount);

    /**
     * Set the name of your recipe. The spigot api
     * set Minecraft as namespacedKey and value is the
     * item (combined often how it crafted).
     *
     * @param namespacedKey key on your recipe.
     * @return this builder class.
     */
    IngredientBuilderApi setNamespacedKey(final String namespacedKey);

    /**
     * build it with the data you set.
     *
     * @return RecipeData class.
     */
    RecipeDataAPI build();

}
