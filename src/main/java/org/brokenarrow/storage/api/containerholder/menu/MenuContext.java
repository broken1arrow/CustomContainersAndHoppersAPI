package org.brokenarrow.storage.api.containerholder.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/**
 * Immutable value object describing a menu button interaction.
 *
 * <p>
 * Instances of this class are created by the menu layer and
 * passed to container capability handlers when a configured
 * menu button is clicked.
 * </p>
 *
 */
public final class MenuContext {
    private final Player player;
    private final int slot;
    private final ClickType clickType;

    /**
     * Creates a new {@link MenuContext}.
     *
     * @param player    the player who clicked the menu button
     * @param slot      the slot index that was clicked
     * @param clickType the Bukkit {@link ClickType} of the interaction
     */
    public MenuContext(final Player player, final int slot, final ClickType clickType) {
        this.player = player;
        this.slot = slot;
        this.clickType = clickType;
    }

    /**
     * The player that clicked on the button.
     *
     * @return the player who triggered the menu interaction
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the slot index that was clicked in the menu
     */
    public int getSlot() {
        return slot;
    }

    /**
     * The action preformed.
     *
     * @return the Bukkit {@link ClickType} describing how the slot was clicked
     */
    public ClickType getClickType() {
        return clickType;
    }
}