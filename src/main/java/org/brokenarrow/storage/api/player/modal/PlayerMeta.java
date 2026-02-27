package org.brokenarrow.storage.api.player.modal;

import org.brokenarrow.storage.api.builders.ContainerMode;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PlayerMeta {

    void setContainerMode(@NotNull Location chestLocation, @NotNull HolderMode mode);

    @Nullable
    ContainerMode getContainerMode();

    boolean isInMode(HolderMode mode);

    void resetContainerHolderMode();
}
