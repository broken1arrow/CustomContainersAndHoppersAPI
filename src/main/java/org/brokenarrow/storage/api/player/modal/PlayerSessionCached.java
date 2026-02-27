package org.brokenarrow.storage.api.player.modal;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

public interface PlayerSessionCached {

    void writeLiveData(Player player, Consumer<PlayerMeta> preferencesCallback);

    <T> T writeLiveData(Player player, Function<PlayerMeta, T> preferencesCallback);

    void removePlayer(Player player);

    Map<UUID, PlayerMeta> getCache();
}
