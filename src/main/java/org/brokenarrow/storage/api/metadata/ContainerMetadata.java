package org.brokenarrow.storage.api.metadata;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.math.BigInteger;

/**
 * Get the containers set metadata, these methods is used when player place or pick up container.
 */
public interface ContainerMetadata extends Metadata {

	/**
	 * Retrieves the container type ID from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The container type ID or null if not found.
	 */
	default String getContainerId(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerId(itemStack);
	}

	/**
	 * Retrieves the container filename from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The container filename or null if not found.
	 */
	default String getContainerFileName(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerFileName(itemStack);
	}

	/**
	 * Retrieves the container upgrade from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The container upgrade or null if not found.
	 */
	default String getContainerUpgrade(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerUpgrade(itemStack);
	}

	/**
	 * Retrieves the container contents from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The container contents as a base64 string or empty string if not found.
	 */
	default String getContainerContents(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerContents(itemStack);
	}

	/**
	 * Retrieves the amount of pages in the container from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The amount of pages or null if not found.
	 */
	default String getContainerPagesAmount(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerPagesAmount(itemStack);
	}

	/**
	 * Retrieves the amount of items in the container from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The amount of items or 0 if not found.
	 */
	default BigInteger getContainerAmountOfItems(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerAmountOfItems(itemStack);
	}

	/**
	 * Retrieves the filter contents of the container from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The filter contents as a base64 string or null if not found.
	 */
	default String getContainerFilterContents(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerFilterContents(itemStack);
	}

	/**
	 * Determines whether the filter for the container is set to black or white.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return True if it is a white list, false if it is a black list, or null if not found.
	 */
	default boolean isContainerBlackOrWhite(final ItemStack itemStack) {
		return this.getContainerMetadata().isContainerBlackOrWhite(itemStack);
	}

	/**
	 * Retrieves the owner of the container from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The container owner or null if not found.
	 */
	default String getContainerOwner(final ItemStack itemStack) {
		return this.getContainerMetadata().getContainerOwner(itemStack);
	}

	/**
	 * Retrieves the time left before free placements reset for the container from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The time left or 0 if not found.
	 */
	default long getTimeLeftBeforeResetFreePlacements(final ItemStack itemStack){
		return this.getContainerMetadata().getAmountOfFreePlacements(itemStack);
	}
	

	/**
	 * Retrieves the number of free placements left for the container from an ItemStack.
	 *
	 * @param itemStack The ItemStack to check.
	 * @return The number of free placements or 0 if not found.
	 */
	default int getAmountOfFreePlacements(final ItemStack itemStack) {
		return this.getContainerMetadata().getAmountOfFreePlacements(itemStack);
	}

	/**
	 * Retrieves the metadata value for this itemStack.
	 *
	 * @param itemStack         The itemStack you want to retrieve the metadata.
	 * @return The matched metadata value set to string or 'null' if the key don't exist on the item.
	 */
	@Nullable
	default String getMetadata(@Nonnull ItemStack itemStack) {
		return this.getMetadata(itemStack, String.class);
	}

	/**
	 * Retrieves the metadata value associated with the specified key for this itemStack and casts it to the provided class.
	 *
	 * <p>
	 * When you don't want to specify the 'valueClazz' argument, you can set it to 'String.class' or use the
	 * {@link #getMetadata(ItemStack)} method overload. This method is particularly useful
	 * when you know the expected class of the value you want to retrieve.
	 * </p>
	 *
	 * @param itemStack         The itemStack for which you want to retrieve the metadata.
	 * @param valueClazz        The class to which the metadata value should be cast.
	 * @param <T> the type to set the metadata value to.
	 * @return The matched metadata value cast to the provided class, or 'null' if no match is found or the class does not match.
	 */
	@Nullable
	default <T> T getMetadata(@Nonnull ItemStack itemStack, @Nonnull Class<T> valueClazz){
		return this.getContainerMetadata().getMetadata(itemStack, valueClazz, this);
	}

	/**
	 * Check if the itemStack has this metadata.
	 *
	 * @param itemStack The itemStack you want to check the metadata.
	 * @return true if the player has this metadata key.
	 */
	default boolean hasMetadata(ItemStack itemStack) {
		return this.getContainerMetadata().hasMetadata(itemStack, this);
	}

	/**
	 * Set the metadata on the player with no value set.
	 *
	 * @param itemStack The itemStack you want to set the metadata.
	 */
	default void setMetadata(@Nonnull ItemStack itemStack) {
		this.setMetadata(itemStack,  "");
	}

	/**
	 * Set the metadata on the itemStack with value.
	 *
	 * @param itemStack The itemStack you want to set the metadata.
	 * @param value     The value to set for the specific player or null/empty
	 *                  string if value is not needed.
	 */
	default void setMetadata(@Nonnull ItemStack itemStack, @Nonnull Object value) {
		this.getContainerMetadata().setMetadata(itemStack,this, value);
	}

	/**
	 * Note: not implemented.
	 * <p>
	 * Remove the metadata from the itemStack.
	 * </p>
	 *
	 * @param itemStack The itemStack you want to remove the specific metadata.
	 */
	default void removeMetadata(@Nonnull ItemStack itemStack) {
	}

	/**
	 * Get the ItemMetadataHelper instance.
	 * 
	 * @return the ItemMetadataHelper instance.
	 */
	ItemMetadataHelper getContainerMetadata();
}
