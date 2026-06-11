package org.brokenarrow.storage.api.containerholder.teleport;

import org.brokenarrow.storage.api.builders.ContainerSettingsApi;
import org.brokenarrow.storage.api.customevents.PreHopperTeleportEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public interface TeleportWriter {
    TeleportWriter setTransferHandler(TeleportTransferHandler transferHandler);

    TeleportWriter setPreEvent(Predicate<PreHopperTeleportEvent> preEvent);

    TeleportWriter setUpdateBlock(Predicate<ContainerSettingsApi> updateBlock);

    TeleportWriter setItemAmount(@Nonnull final ToIntFunction<ItemStack[]> amountResolver);

    int getAmountToTeleport();
}
