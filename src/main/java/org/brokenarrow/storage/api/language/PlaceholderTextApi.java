package org.brokenarrow.storage.api.language;

import javax.annotation.Nonnull;
import java.util.Map;

public interface PlaceholderTextApi {

	@Nonnull
	String getPlaceholder(String key);

	Map<String, String> getPlaceholders();

	PlaceholderTextApi getPlaceholderText();

	TimePlaceholdersApi getTimePlaceholders();
}
