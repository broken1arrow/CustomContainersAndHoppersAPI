package org.brokenarrow.storage.api.metadata;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.math.BigInteger;

/**
 * Get the itemstack set metadata, these methods is used when player place or pick up container.
 */
public interface ItemMetadataHelper {

	/**
	 * Retrieves the container type ID from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The container type ID or null if not found.
	 */
	String getContainerId(final ItemStack item);

	/**
	 * Retrieves the container filename from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The container filename or null if not found.
	 */
	String getContainerFileName(final ItemStack item);

	/**
	 * Retrieves the container upgrade from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The container upgrade or null if not found.
	 */
	String getContainerUpgrade(final ItemStack item);

	/**
	 * Retrieves the container contents from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The container contents as a base64 string or empty string if not found.
	 */
	String getContainerContents(final ItemStack item);

	/**
	 * Retrieves the amount of pages in the container from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The amount of pages or null if not found.
	 */
	String getContainerPagesAmount(final ItemStack item);

	/**
	 * Retrieves the amount of items in the container from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The amount of items or 0 if not found.
	 */
	BigInteger getContainerAmountOfItems(final ItemStack item);

	/**
	 * Retrieves the filter contents of the container from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The filter contents as a base64 string or null if not found.
	 */
	String getContainerFilterContents(final ItemStack item);

	/**
	 * Determines whether the filter for the container is set to black or white.
	 *
	 * @param item The ItemStack to check.
	 * @return True if it is a white list, false if it is a black list, or null if not found.
	 */
	boolean isContainerBlackOrWhite(final ItemStack item);

	/**
	 * Retrieves the owner of the container from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The container owner or null if not found.
	 */
	String getContainerOwner(final ItemStack item);

	/**
	 * Retrieves the time left before free placements reset for the container from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The time left or 0 if not found.
	 */
	long getTimeLeftBeforeResetFreePlacements(final ItemStack item);

	/**
	 * Retrieves the number of free placements left for the container from an ItemStack.
	 *
	 * @param item The ItemStack to check.
	 * @return The number of free placements or 0 if not found.
	 */
	int getAmountOfFreePlacements(final ItemStack item);

	/**
	 * Retrieves the metadata value for this itemStack.
	 *
	 * @param itemStack         The itemStack you want to retrieve the metadata.
	 * @param containerMetadata The metadata key.
	 * @return The matched metadata value set to string or 'null' if the key don't exist on the item.
	 */
	@Nullable String getMetadata(@Nonnull ItemStack itemStack, @Nonnull ContainerMetadata containerMetadata);

	/**
	 * Retrieves the metadata value associated with the specified key for this itemStack and casts it to the provided class.
	 *
	 * <p>
	 * When you don't want to specify the 'valueClazz' argument, you can set it to 'String.class' or use the
	 * {@link #getMetadata(ItemStack, ContainerMetadata)} method overload. This method is particularly useful
	 * when you know the expected class of the value you want to retrieve.
	 * </p>
	 *
	 * @param itemStack         The itemStack for which you want to retrieve the metadata.
	 * @param valueClazz        The class to which the metadata value should be cast.
	 * @param containerMetadata The key associated with the metadata.
	 * @return The matched metadata value cast to the provided class, or 'null' if no match is found or the class does not match.
	 */
	@Nullable <T> T getMetadata(@Nonnull ItemStack itemStack, @Nonnull Class<T> valueClazz, @Nonnull ContainerMetadata containerMetadata);

	/**
	 * Check if the itemStack has this metadata.
	 *
	 * @param itemStack The itemStack you want to check the metadata.
	 * @return true if the player has this metadata key.
	 */
	boolean hasMetadata(ItemStack itemStack, ContainerMetadata containerMetadata);

	/**
	 * Set the metadata on the player with no value set.
	 *
	 * @param itemStack The itemStack you want to set the metadata.
	 */
	void setMetadata(@Nonnull ItemStack itemStack, @Nonnull ContainerMetadata containerMetadata);

	/**
	 * Set the metadata on the itemStack with value.
	 *
	 * @param itemStack The itemStack you want to set the metadata.
	 * @param value     The value to set for the specific player or null/empty
	 *                  string if value is not needed.
	 */
	void setMetadata(@Nonnull ItemStack itemStack, @Nonnull ContainerMetadata containerMetadata, @Nonnull Object value);

	/**
	 * Note: not implemented.
	 * <p>
	 * Remove the metadata from the itemStack.
	 *
	 * @param itemStack The itemStack you want to remove the specific metadata.
	 */
	default void removeMetadata(@Nonnull ItemStack itemStack) {
	}

}
