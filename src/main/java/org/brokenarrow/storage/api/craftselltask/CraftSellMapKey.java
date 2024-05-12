package org.brokenarrow.storage.api.craftselltask;

import org.bukkit.Location;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * This interface handle the key for crafting and selling cache.
 */
public interface CraftSellMapKey {

    /**
     * Retrieve the location for the map key.
     *
     * @return the location this key is using.
     */
    @NotNull
    Location getLocation();

    /**
     * Retrieve the material for the map key.
     *
     * @return the material set for the key.
     */
    Material getMaterial();
}
