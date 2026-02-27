package org.brokenarrow.storage.api.builders;


import org.brokenarrow.storage.api.player.modal.HolderMode;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public interface ContainerMode {
    @NotNull Location getChestLocation();

    @NotNull HolderMode getMode();
}
