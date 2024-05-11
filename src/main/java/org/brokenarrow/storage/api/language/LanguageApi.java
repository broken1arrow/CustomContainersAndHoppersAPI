package org.brokenarrow.storage.api.language;

/**
 * The localization for the plugin.
 */
public interface LanguageApi {
	/**
	 * Retrieve the text used for the placeholders.
	 *
	 * @return the instance of the 	PlaceholderTextApi.
	 */
	PlaceholderTextApi getPlaceholderText();

	/**
	 * Retrieve the messages.
	 *
	 * @return the instance of the 	PluginMessagesApi .
	 */
	PluginMessagesApi getPluginMessages();
}
