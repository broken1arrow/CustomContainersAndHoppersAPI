package org.brokenarrow.storage.api.language;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * The messages used in the plugins.
 */
public interface PluginMessagesApi {

	/**
	 * Retrieve a list of messages.
	 * @param key the key to receive the message, it uses the key in the language file.
	 * @return List of messages tied to the key.
	 */
	@Nonnull
	List<String> getMessage(String key);

	/**
	 * Retrieve the cache with all messages.
	 *
	 * @return map with all messages loaded.
	 */
	Map<String, List<String>> getMessagesCache();

	/**
	 * Retrieve the class instance.
	 *
	 * @return the class instance.
	 */
	@Nullable
	PluginMessagesApi getPluginMessages();

	/**
	 * Retrieve the plugin name.
	 *
	 * @return the plugin name.
	 */
	@Nullable
	String getPluginName();

	/**
	 * Retrieve the decor used before the message.
	 *
	 * @return the decor or null if not set.
	 */
	@Nullable
	String getPrefixDecor();

	/**
	 * Retrieve the decor used after the message.
	 *
	 * @return the decor or null if not set.
	 */
	@Nullable
	String getSuffixDecor();
}
