package org.brokenarrow.storage.api.language;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * The placeholders used in the plugins.
 */
public interface PlaceholderTextApi {

	/**
	 * Retrieve the set placeholder.
	 *
	 * @param key the key to receive the placeholder, it uses the key in the language file.
	 * @return The placeholder tied to the key or empty string if not found.
	 */
	@Nonnull
	String getPlaceholder(String key);

	/**
	 * Retrieve the cache with all placeholders.
	 *
	 * @return map with all placeholders loaded.
	 */
	Map<String, String> getPlaceholders();

	/**
	 * Retrieve the class instance.
	 *
	 * @return the class instance.
	 */
	PlaceholderTextApi getPlaceholderText();

	/**
	 * Retrieve the class instance for time.
	 *
	 * @return the class instance.
	 */
	TimePlaceholdersApi getTimePlaceholders();
}
