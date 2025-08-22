package org.brokenarrow.storage.api.Crafting.util;

import org.brokenarrow.storage.api.MainSettingsDataApi;

import java.util.UUID;

public interface MessageSenderApi {
    UUID getUuid();

    MainSettingsDataApi getMainSettings();

    TaskSectionApi getTaskSection();

    void setMessageEntry(String key, Object... placeholders);

    MessageEntryApi getMessageEntry();


}
