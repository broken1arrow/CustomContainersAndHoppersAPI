package org.brokenarrow.storage.api.containerholder.teleport;

import javax.annotation.Nonnull;

/**
 * Handle the pickup items on ground.
 */
@FunctionalInterface
public interface SuctionItemHandler {
    /**
     *  Applies item filtering rules for the suction process.
     *
     *  @param suctionFilter the filter used to define which items are eligible for pickup
     */
    void apply(@Nonnull final SuctionFilter suctionFilter);
}
