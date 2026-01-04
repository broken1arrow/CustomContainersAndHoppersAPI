package org.brokenarrow.storage.api.craftselltask.message;

/**
 * Represents a single message definition consisting of a key and
 * placeholder values.
 * <p>
 * A {@code MessageEntryApi} does not perform message resolution or formatting.
 * It merely encapsulates the data required to construct a message at a later
 * stage.
 */
public interface MessageEntryApi {

    /**
     * Returns the message key used to resolve a message template.
     *
     * @return the message key
     */
    String getKey();
    
    /**
     * Returns the placeholder values associated with this message.
     *
     * @return an array of placeholder objects
     */
    Object[] getPlaceholders();
}
