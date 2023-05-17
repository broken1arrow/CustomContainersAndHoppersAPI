package org.brokenarrow.storage.api.language;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public interface PluginMessagesApi {

	@Nonnull
	List<String> getMessage(String key);

	Map<String, List<String>> getMessagesCache();

	@Nullable
	PluginMessagesApi getPluginMessages();

	@Nullable
	String getPluginName();

	@Nullable
	String getPrefixDecor();

	@Nullable
	String getSuffixDecor();
}
