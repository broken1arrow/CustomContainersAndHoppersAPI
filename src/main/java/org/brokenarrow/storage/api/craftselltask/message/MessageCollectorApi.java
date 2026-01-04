package org.brokenarrow.storage.api.craftselltask.message;

import org.brokenarrow.storage.api.MainSettingsDataApi;

import java.util.UUID;

/**
 * Collects and manages message entries during task message construction.
 * <p>
 * {@code MessageSenderApi} acts as a mutable message-definition context used
 * while assembling task-related messages (headers, body entries, and footers).
 * Implementations store a message key and its associated placeholder values,
 * which can later be resolved, formatted, and dispatched to the appropriate
 * output (for example, a player, log, or UI component).
 * <p>
 * This interface does not define how messages are sent or formatted. Its sole
 * responsibility is to capture message definitions produced by task-related
 * providers.
 */
public interface MessageCollectorApi {

    /**
     * Returns the unique identifier of the player associated with the current
     * message construction context.
     *
     * @return the player's {@link UUID}
     */
    UUID getUuid();

    /**
     * Returns the main configuration settings used during message construction.
     * <p>
     * These settings are typically sourced from the plugin's configuration
     * (for example, {@code config.yml}) and may influence message keys,
     * formatting behavior, or conditional message inclusion.
     *
     * @return the main settings data
     */
    MainSettingsDataApi getMainSettings();

    /**
     * Returns the task message section currently being processed.
     * <p>
     * This provides contextual access to information about the task group
     * (such as task type or location) while defining message entries.
     * <p>
     * Implementations may choose not to rely on this method directly if the
     * required context is already available through other means.
     *
     * @return the current {@link TaskMessageSectionApi}
     */
    TaskMessageSectionApi getTaskSection();

    /**
     * Registers a message entry using the specified key and placeholder values.
     * <p>
     * The provided key is later used to resolve a message template, while the
     * placeholders are applied during formatting.
     * <p>
     * Calling this method overwrites any previously registered message entry
     * until it is retrieved or reset.
     *
     * @param key the message key used to resolve a message template
     * @param placeholders values to substitute into the resolved message
     */
    void setMessageEntry(String key, Object... placeholders);

    /**
     * Returns the currently registered message entry.
     * <p>
     * The returned entry represents the most recently defined message key and
     * its associated placeholder values.
     *
     * @return the current {@link MessageEntryApi}
     */
    MessageEntryApi getMessageEntry();

    /**
     * Clears the currently registered message entry.
     * <p>
     * This is typically called after a message entry has been processed to
     * prepare the sender for the next message definition.
     */
    void resetMessageEntry();
}
