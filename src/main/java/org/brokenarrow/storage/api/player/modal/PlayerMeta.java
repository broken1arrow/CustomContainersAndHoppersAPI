package org.brokenarrow.storage.api.player.modal;

import org.brokenarrow.storage.api.builders.ContainerHolderPlayerMode;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PlayerMeta {

    void setContainerHolderMode(@NotNull Location chestLocation, @NotNull HolderMode mode);

    @Nullable
    ContainerHolderPlayerMode getContainerHolderMode();

    boolean isInMode(HolderMode mode);

    void resetContainerHolderMode();
}
