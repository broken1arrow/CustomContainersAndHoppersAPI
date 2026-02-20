package org.brokenarrow.storage.api.containerholder.teleport;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface SuctionItemHandler {
    void apply(@Nonnull final Filter item);
}
