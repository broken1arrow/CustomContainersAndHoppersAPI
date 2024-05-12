package org.brokenarrow.storage.api.craftselltask;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * The provider for the sell and crafting task.
 */
public interface CraftSellProvider {

	/**
	 * Get the output item some either get crafted or sold.
	 *
	 * @return output item.
	 */
	@Nullable
	ItemStack getItemStack();

}
