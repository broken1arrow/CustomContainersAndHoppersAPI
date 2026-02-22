package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.menu.util.ContainerFeatureMode;
import org.brokenarrow.storage.api.menu.util.LinkSuctionMode;
import org.brokenarrow.storage.api.util.sign.PlacingSignMode;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Preferences for the player.
 */
public interface PreferenceSettingsDataAPI {


	/**
	 * If player has holograms on or off.
	 *
	 * @return true if the player have it on.
	 */
	boolean isShowHologramsOnPlacedContainer();

	/**
	 * If it shall show effects when craft items.
	 *
	 * @return true if the player has it on.
	 */
	boolean isShowEffectsWhenCrafItems();

	/**
	 * if it shall show effects when sell items.
	 *
	 * @return true if the player has it on.
	 */
	boolean isShowEffectsWhenSellItems();

	/**
	 * If this is true, it will play a sound when craft.
	 *
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenCrafItems();

	/**
	 * If this is true, it will play a sound when sell.
	 *
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenSellItems();

	/**
	 * If this is true, it will play a sound when open container.
	 *
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenOpenClose();

	/**
	 * If it shall play sound when place the container.
	 *
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenPlaceContainer();

	/**
	 * If it shall play sound when pick up items.
	 *
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenContainerPickUpItems();

	/**
	 * If this is true,it will show the owner of the container
	 * on the hologram.
	 *
	 * @return true if the player has it on.
	 */
	boolean isDisplayPlayerNameOnHolo();

	/**
	 * if player has suction border on or off.
	 *
	 * @return true if the player has it on.
	 */
	boolean isShowBorderSuctionWhenPlaceContainer();

	/**
	 * if player has time on or off. If this is true
	 * player will have limit time before it turn of
	 * automatic.
	 *
	 * @return true if the player has it on.
	 */
	boolean isHasLinkModeActiveTimeOrWhenTurnOf();

	/**
	 * If this is true random particle effects will spawn on the
	 * container.
	 *
	 * @return true if the player has it on.
	 */
	boolean isEffectOnContainer();

	/**
	 * If this is true it will spawn effects on container when player place it.
	 *
	 * @return true if the player has it on.
	 */
	boolean isEffectOnContainerWhenPlaceContainer();

	/**
	 * Get the partylist of players, player curently have.
	 *
	 * @return list of players or if not exist empty arraylist.
	 */
	List<UUID> getPartyListOfPlayers();

	/**
	 * If player wants a message when the container craft or sell items.
	 *
	 * @return true if player want the message.
	 */
	boolean isShowNotesMessage();

	/**
	 * Get the placing mode for the sign.
	 *
	 * @return the mode used for sign placement.
	 */
	PlacingSignMode getPlacingSignMode();

    LinkSuctionMode getLinkSuctionMode();

    ContainerFeatureMode getContainerFeatureMode();
	/**
	 * Get instance of the builder class to get set values
	 * and change old values.
	 *
	 * @return builder instance.
	 */
	PreferenceSettingsDataAPIBuilder getBuilder();

	/**
	 * This method serilze the data.
	 *
	 * @return map with key and values.
	 */
	Map<String, Object> serialize();

;
}
