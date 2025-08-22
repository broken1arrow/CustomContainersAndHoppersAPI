package org.brokenarrow.storage.api.craftselltask.message;

import org.brokenarrow.storage.api.MainSettingsDataApi;

import java.util.UUID;

public interface MessageSenderApi {
    UUID getUuid();

    MainSettingsDataApi getMainSettings();

    TaskMessageSectionApi getTaskSection();

    void setMessageEntry(String key, Object... placeholders);

    MessageEntryApi getMessageEntry();


    void resetMessageEntry();
}
