package org.brokenarrow.storage.api.player.modal;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

public interface PlayerMetaCache {

    void writeLiveData(Player player, Consumer<PlayerMeta> preferencesCallback);

    <T> T writeLiveData(Player player, Function<PlayerMeta, T> preferencesCallback);

    Map<UUID, PlayerMeta> getCache();
}
