package org.brokenarrow.storage.api.player.modal;

import org.brokenarrow.storage.api.menu.util.ContainerFeatureMode;
import org.brokenarrow.storage.api.menu.util.LinkSuctionMode;

/**
 * Represents player-specific settings scoped to a specific container type.
 *
 * <p>
 * These settings are separated from global  {@link org.brokenarrow.storage.api.builders.PreferenceSettingsWriter}
 * and only apply to containers of a specific type (e.g., based on filename).
 * </p>
 *
 */
public interface PlayerContainerTypeSettingsAPI {

    /**
     * Returns the current {@link LinkSuctionMode} for this container type.
     *
     * @return the configured link suction mode
     */
    LinkSuctionMode getLinkSuctionMode();

    /**
     * Sets the {@link LinkSuctionMode} for this container type.
     *
     * @param linkSuctionMode the new link suction mode
     */
    void setLinkSuctionMode(LinkSuctionMode linkSuctionMode);

    /**
     * Returns the current {@link ContainerFeatureMode}.
     *
     * @return the configured container feature mode
     */
    ContainerFeatureMode getContainerFeatureMode();

    /**
     * Sets the {@link ContainerFeatureMode}.
     *
     * @param containerFeatureMode the new container feature mode
     */
    void setContainerFeatureMode(ContainerFeatureMode containerFeatureMode);
}
