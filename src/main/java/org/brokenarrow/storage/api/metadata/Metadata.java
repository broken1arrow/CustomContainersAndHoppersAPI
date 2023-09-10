package org.brokenarrow.storage.api.metadata;

import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

/**
 * The metadata methods that is used in this plugin.
 */
public interface Metadata {

	/**
	 * Check if the first value match the seconds.
	 *
	 * @param value       the value to match with the second one.
	 * @param dataToMatch the value to check with or set to null to not check.
	 * @return true if dataToMatch is 'null', or the values match.
	 */
	default boolean matchValue(@Nonnull Object value, Object dataToMatch) {
		if (dataToMatch == null)
			return true;
		return value.equals(dataToMatch);
	}

	/**
	 * Get meta key set.
	 *
	 * @return The metadata key set.
	 */
	@Nonnull
	String getKey();

	/**
	 * Get the plugin.
	 *
	 * @return the plugin.
	 */
	Plugin getPlugin();
}
