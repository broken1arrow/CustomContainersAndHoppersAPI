package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public interface TeleportContextWrapper {

    /**
     * Sets the handler responsible for teleporting items.
     * <p>
     * The handler is executed after validating that the target container
     * can accept the items.
     * <p>
     * The {@link TeleportTarget} provides access to both vanilla and custom
     * inventories. Always check {@link TeleportTarget#isCustom()} before
     * directly accessing a custom inventory implementation, as doing so
     * without validation may cause errors.
     *
     * @param itemStacks the itemStacks that should be teleported
     * @param itemTeleportHelper the helper responsible for processing item teleportation
     */
    void setTeleportItemsHandler(@Nonnull ItemStack[] itemStacks, @Nonnull Consumer<TeleportWriter> itemTeleportHelper);
}
