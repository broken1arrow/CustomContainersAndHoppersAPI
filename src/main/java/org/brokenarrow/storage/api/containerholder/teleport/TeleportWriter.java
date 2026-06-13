package org.brokenarrow.storage.api.containerholder.teleport;

import org.brokenarrow.storage.api.builders.ContainerSettingsApi;
import org.brokenarrow.storage.api.customevents.PreHopperTeleportEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 * Utility class to handle teleport events.
 */
public interface TeleportWriter {

    /**
     * Sets a predicate to evaluate the pre-teleport event.
     * This can be used to inspect the event state or perform
     * actions if the event is canceled.
     *
     * @param preEvent the predicate handling the {@link PreHopperTeleportEvent}
     * @return this instance for method chaining
     */
    TeleportWriter setPreEvent(@Nonnull final Predicate<PreHopperTeleportEvent> preEvent);

    /**
     * Defines the logic executed during the teleport operation.
     * This determines how and which items are transferred.
     *
     * @param transferHandler the handler responsible for performing
     *                        the transfer using the target container
     *                        and execution context
     * @return this instance for method chaining
     */
    TeleportWriter setTransferHandler(@Nonnull final TeleportTransferHandler transferHandler);

    /**
     * Determines whether the target block should be updated after the operation.
     * Updating the block may incur a small performance cost.
     *
     * @param updateBlock predicate that decides if the block should be updated,
     *                    with access to the container settings
     * @return this instance for method chaining
     */
    TeleportWriter setUpdateBlock(@Nonnull final Predicate<ContainerSettingsApi> updateBlock);

    /**
     * Overrides the default calculation for how many items will be teleported.
     *
     * @param amountResolver function that calculates the number of items
     *                       based on the provided item array
     * @return this instance for method chaining
     */
    TeleportWriter setItemAmount(@Nonnull final ToIntFunction<ItemStack[]> amountResolver);

    /**
     * Gets the number of items to be teleported.
     *
     * @return the calculated amount, either from
     * {@link #setItemAmount(ToIntFunction)} or the default implementation
     */
    int getAmountToTeleport();
}
