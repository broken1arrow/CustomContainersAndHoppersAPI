package org.brokenarrow.storage.api.containerholder.teleport;


import org.brokenarrow.storage.api.util.builderclass.TeleportWrapper;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface TeleportItemHandler {

    void apply(@Nonnull final TeleportWrapper context, @Nonnull final TeleportTarget target);
}
