package org.brokenarrow.storage.api.containerholder.menu.actions;

import org.brokenarrow.storage.api.containerholder.menu.MenuContext;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

/**
 * Capability interface for container holders that support
 * handling a filter button interaction from a menu.
 *
 * <p>
 * This method is invoked by the menu layer when the configured
 * filter button is clicked by a player. Implementations define
 * what the filter interaction means for the specific container
 * type (e.g. locking to a specific item, toggling filter mode,
 * updating internal filter state, etc.).
 * </p>
 */
public interface SupportsFilterButton {

    /**
     * Handles a filter button click originating from the menu.
     *
     * @param context immutable context describing the player interaction
     */
    void onFilterButtonClick(@Nonnull final MenuContext context);

    boolean isFilterActive(@Nonnull Player player);
}