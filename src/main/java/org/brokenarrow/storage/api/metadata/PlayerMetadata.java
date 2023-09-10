package org.brokenarrow.storage.api.metadata;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

import static org.broken.arrow.serialize.library.utility.converters.LocationSerializer.deserializeLoc;
import static org.broken.arrow.serialize.library.utility.converters.LocationSerializer.serializeLoc;

/**
 * A set of methods to interact with metadata associated with a player.
 */
public interface PlayerMetadata extends Metadata {

	/**
	 * Retrieves all metadata values associated with a player using the specified key.
	 *
	 * <p>
	 * This method returns a list of all metadata values set on the player with the key
	 * obtained from {@link #getKey()}.
	 * </p>
	 *
	 * @param player The player from whom you want to retrieve the metadata.
	 * @return A list of metadata values or an empty list if no metadata is found.
	 */
	@Nonnull
	default List<MetadataValue> getAllMetadata(Player player) {
		return player.getMetadata(this.getKey());
	}

	/**
	 * Retrieves the first metadata value from the metadata list associated with a player.
	 * <p>&nbsp; </p>
	 * <p>
	 * Although the first entry in the list is often the desired value, there is no guarantee
	 * that it is the correct one. For better control, consider using
	 * {@link #getMetadata(org.bukkit.entity.Player, Class)} or
	 * {@link #getMetadata(org.bukkit.entity.Player, Class, Object)}.
	 * </p>
	 *
	 * @param player The player from whom you want to retrieve the metadata.
	 * @return The first metadata value, or an empty value if the list is empty.
	 */
	@Nonnull
	default String getFirstValue(Player player) {
		List<MetadataValue> metadata = player.getMetadata(this.getKey());
		return metadata.size() > 0 ? metadata.get(0).value() + "" : "";
	}

	/**
	 * Retrieves the first metadata entry from the metadata list associated with a player.
	 * <p>&nbsp; </p>
	 * <p>
	 * Although the first entry in the list is often the desired value, there is no guarantee
	 * that it is the correct one. For better control, consider using
	 * {@link #getMetadata(org.bukkit.entity.Player, Class)} or
	 * {@link #getMetadata(org.bukkit.entity.Player, Class, Object)}.
	 * </p>
	 *
	 * @param player The player from whom you want to retrieve the metadata.
	 * @return The first MetadataValue instance, with empty value if the list is empty.
	 */
	@Nonnull
	default MetadataValue getFirstMetadata(Player player) {
		List<MetadataValue> metadata = player.getMetadata(this.getKey());
		return metadata.size() > 0 ? metadata.get(0) : new FixedMetadataValue(this.getPlugin(), "");
	}

	/**
	 * Retrieves the metadata that matches the specified class for a player.
	 *
	 * <p>
	 * This method finds the first metadata entry that matches the given class.
	 * </p>
	 *
	 * @param player     The player from whom you want to retrieve the metadata.
	 * @param valueClazz The class to check the metadata value against.
	 * @return The matched metadata value or 'null' if no match is found.
	 */
	default @Nullable <T> T getMetadata(Player player, Class<T> valueClazz) {
		return this.getMetadata(player, valueClazz, null);
	}

	/**
	 * Retrieves the metadata that matches the specified class and value for a player.
	 *
	 * <p>
	 * This method finds the first metadata entry that matches both the given class and the
	 * specified value. You can omit the 'dataToMatch' argument by setting it to 'null' or
	 * using the {@link #getMetadata(org.bukkit.entity.Player, Class)} method overload.
	 * </p>
	 *
	 * @param player      The player from whom you want to retrieve the metadata.
	 * @param valueClazz  The class to check the metadata value against.
	 * @param dataToMatch The value to match (can be 'null' to skip the matching by value).
	 * @return The matched metadata value or 'null' if no match is found.
	 */
	default @Nullable <T> T getMetadata(Player player, Class<T> valueClazz, Object dataToMatch) {
		List<MetadataValue> metadata = player.getMetadata(this.getKey());
		if (metadata.size() > 0) {
			return metadata.stream().map(metadataValue -> {
				Object value = metadataValue.value();
				if (valueClazz.isInstance(value) && this.matchValue(value, dataToMatch))
					return valueClazz.cast(value);
				return null;
			}).findFirst().orElse(null);
		}
		return null;
	}

	/**
	 * Check if the player has this metadata.
	 *
	 * @param player The player from whom you want to check the metadata.
	 * @return true if the player has this metadata key.
	 */
	default boolean hasMetadata(Player player) {
		return player.hasMetadata(this.getKey());
	}

	/**
	 * Set the metadata on the player with no value set.
	 *
	 * @param player The player from whom you want to set the metadata.
	 */
	default void setMetadata(@Nonnull Player player) {
		this.setMetadata(player, "");
	}

	/**
	 * Set the metadata on the player with value.
	 *
	 * @param player The player from whom you want to set the metadata.
	 * @param value  The value to set for the specific player or null/empty
	 *               string if value is not needed.
	 */
	default void setMetadata(@Nonnull Player player, @Nullable Object value) {
		player.setMetadata(this.getKey(), new FixedMetadataValue(this.getPlugin(), value));
	}

	/**
	 * Remove the metadata from the player.
	 *
	 * @param player The player from whom you want to remove the specific metadata.
	 */
	default void removeMetadata(@Nonnull Player player) {
		player.removeMetadata(this.getKey(), this.getPlugin());
	}

	/**
	 * Retrieves the location of the open container or its associated menu for the player.
	 *
	 * @param player The player to check for metadata.
	 * @return The location of the open container or its associated menu, or null if not set.
	 */
	default Location getLocation(final Player player) {
		return deserializeLoc(this.getFirstValue(player));
	}

	/**
	 * Sets the location of the open container or its associated menu for the player.
	 *
	 * @param player   The player to set the metadata for.
	 * @param location The location to set.
	 */
	default void setLocation(final Player player, final Location location) {
		this.setMetadata(player, serializeLoc(location));
	}

}
