package org.brokenarrow.storage.api.containerholder.teleport;


import org.brokenarrow.storage.api.util.builderclass.ContainerTeleportState;

import javax.annotation.Nonnull;

/**
 * Functional callback executed when a valid teleport target container
 * has been resolved.
 *
 * <p>
 * Implementations define the logic for transferring items to the
 * provided {@link TeleportTarget}, using the supplied
 * {@link ContainerTeleportState} as execution context.
 * </p>
 *
 * <p>
 * The target may represent different container types
 * (e.g., Bukkit inventory, custom container, or aggregated storage),
 * and should be interacted with only through the {@link TeleportTarget}
 * abstraction.
 * </p>
 */
@FunctionalInterface
public interface TeleportTransferHandler {

    /**
     * Executes teleport logic for the resolved target container.
     *
     * @param context the teleport execution context, including any
     *                cached or temporary data related to the operation
     * @param target  the resolved teleport target to which items
     *                should be transferred
     */
    void apply(@Nonnull final ContainerTeleportState context, @Nonnull final TeleportTarget target);
}
