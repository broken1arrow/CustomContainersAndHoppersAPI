package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.util.sign.PlacingSignMode;

import java.util.List;
import java.util.UUID;

public interface PreferenceSettingsDataAPIBuilder {


	/**
	 * Set true if it shall show the holgrams.
	 *
	 * @param showHologramsOnPlacedContainer if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setShowHologramsOnPlacedContainer(boolean showHologramsOnPlacedContainer);

	/**
	 * Set to true if it shall show effects when craft.
	 *
	 * @param showEffectsWhenCrafItems if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setShowEffectsWhenCrafItems(boolean showEffectsWhenCrafItems);

	/**
	 * Set to true if it shall show effects when sell.
	 *
	 * @param showEffectsWhenSellItems if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setShowEffectsWhenSellItems(boolean showEffectsWhenSellItems);

	/**
	 * Set to true if it shall play a sound when craft.
	 *
	 * @param soundEffectsWhenCrafItems if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setSoundEffectsWhenCrafItems(boolean soundEffectsWhenCrafItems);

	/**
	 * Set to true if it shall play a sound when sell items.
	 *
	 * @param soundEffectsWhenSellItems if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setSoundEffectsWhenSellItems(boolean soundEffectsWhenSellItems);

	/**
	 * Set to true if it shall play a sound when open container.
	 *
	 * @param soundEffectsWhenOpenClose if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setSoundEffectsWhenOpenClose(boolean soundEffectsWhenOpenClose);

	/**
	 * Set to true if it shall play sound or not when place the container.
	 *
	 * @param soundEffectsWhenPlaceContainer if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setSoundEffectsWhenPlaceContainer(boolean soundEffectsWhenPlaceContainer);

	/**
	 * Set to true if it shall play sound or not when the container pick up items.
	 *
	 * @param soundEffectsWhenContainerPickUpItems if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setSoundEffectsWhenContainerPickUpItems(boolean soundEffectsWhenContainerPickUpItems);

	/**
	 * Set to true if you want to show the owner of the container or not.
	 *
	 * @param displayPlayerNameOnHolo if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setDisplayPlayerNameOnHolo(boolean displayPlayerNameOnHolo);

	/**
	 * Set to true if it shall show the border when place.
	 *
	 * @param showBorderSuctionWhenPlaceContainer if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setShowBorderSuctionWhenPlaceContainer(boolean showBorderSuctionWhenPlaceContainer);

	/**
	 * Set to true it shall automatic turn off linkmode.
	 *
	 * @param linkModeActiveTimeOrWhenTurnOff if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setHasLinkModeActiveTimeOrTurnOfAuto(boolean linkModeActiveTimeOrWhenTurnOff);

	/**
	 * Set to true if it shall spawn particels on this players containers.
	 *
	 * @param effectOnContainer if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setEffectOnContainer(boolean effectOnContainer);

	/**
	 * If this is true it will spawn effects on container when player place it.
	 *
	 * @param effectOnContainerWhenPlaceContainer if not set, defult to false.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setEffectOnContainerWhenPlaceContainer(boolean effectOnContainerWhenPlaceContainer);

	PreferenceSettingsDataAPIBuilder setPlacingSignMode(PlacingSignMode placingSignMode);

	/**
	 * If it shall show the message to player when craft or sell.
	 *
	 * @param showNotesMessage sert this to true if you want to show the message.
	 * @return this class.
	 */
	PreferenceSettingsDataAPIBuilder setShowNotesMessage(boolean showNotesMessage);

	/**
	 * Add a player to the partylist
	 *
	 * @param partylistOfPlayers the player some shall be added.
	 * @return a instance of  PreferenceSettingsDataAPIBuilder.
	 */
	PreferenceSettingsDataAPIBuilder setPartylistOfPlayers(List<UUID> partylistOfPlayers);

	/**
	 * build your data you have set before.
	 *
	 * @return PreferenceSettingsDataAPI instance;
	 */
	PreferenceSettingsDataAPI build();
}
