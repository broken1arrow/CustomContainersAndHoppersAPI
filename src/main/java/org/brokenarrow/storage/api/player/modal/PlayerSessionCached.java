package org.brokenarrow.storage.api.player.modal;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

public interface PlayerSessionCached {

    void writeLiveData(final Player player,final Consumer<PlayerMeta> callback);

    <T> T writeLiveData(final Player player,final Function<PlayerMeta, T> callback);

    void removePlayer(final Player player);

    Map<UUID, PlayerMeta> getCache();
}
