package org.brokenarrow.storage.util.builderclass;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class PreferenceSettingsData {

	private final boolean showHologramsOnPlacedContainer;
	private final boolean showEffectsWhenCrafItems;
	private final boolean showEffectsWhenSellItems;
	private final boolean soundEffectsWhenCrafItems;
	private final boolean soundEffectsWhenSellItems;
	private final boolean soundEffectsWhenOpenClose;
	private final boolean soundEffectsWhenPlaceContainer;
	private final boolean soundEffectsWhenContainerPickUpItems;
	private final boolean displayPlayerNameOnHolo;
	private final boolean showBorderSuctionWhenPlaceContainer;
	private final boolean hasLinkModeActiveTimeOrWhenTurnOf;
	private final boolean effectOnContainer;
	private final boolean effectOnContainerWhenPlaceContainer;
	private final List<UUID> partylistOfPlayers;
	private final Builder builder;

	private PreferenceSettingsData(Builder builder) {
		this.showHologramsOnPlacedContainer = builder.showHologramsOnPlacedContainer;
		this.showEffectsWhenCrafItems = builder.showEffectsWhenCrafItems;
		this.showEffectsWhenSellItems = builder.showEffectsWhenSellItems;
		this.soundEffectsWhenCrafItems = builder.soundEffectsWhenCrafItems;
		this.soundEffectsWhenSellItems = builder.soundEffectsWhenSellItems;
		this.soundEffectsWhenOpenClose = builder.soundEffectsWhenOpenClose;
		this.soundEffectsWhenPlaceContainer = builder.soundEffectsWhenPlaceContainer;
		this.soundEffectsWhenContainerPickUpItems = builder.soundEffectsWhenContainerPickUpItems;
		this.displayPlayerNameOnHolo = builder.displayPlayerNameOnHolo;
		this.showBorderSuctionWhenPlaceContainer = builder.showBorderSuctionWhenPlaceContainer;
		this.hasLinkModeActiveTimeOrWhenTurnOf = builder.hasLinkModeActiveTimeOrWhenTurnOf;
		this.effectOnContainer = builder.effectOnContainer;
		this.effectOnContainerWhenPlaceContainer = builder.effectOnContainerWhenPlaceContainer;
		this.partylistOfPlayers = builder.partylistOfPlayers;
		this.builder = builder;
	}

	/**
	 * If player has holgrams on or off.
	 *
	 * @return true if the player have it on.
	 */
	public boolean isShowHologramsOnPlacedContainer() {
		return showHologramsOnPlacedContainer;
	}

	/**
	 * If it shall show effects when craft items.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isShowEffectsWhenCrafItems() {
		return showEffectsWhenCrafItems;
	}

	/**
	 * if it shall show effects when sell items.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isShowEffectsWhenSellItems() {
		return showEffectsWhenSellItems;
	}

	/**
	 * If this is true, it will play a sound when craft.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isSoundEffectsWhenCrafItems() {
		return soundEffectsWhenCrafItems;
	}

	/**
	 * If this is true, it will play a sound when sell.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isSoundEffectsWhenSellItems() {
		return soundEffectsWhenSellItems;
	}

	/**
	 * If this is true, it will play a sound when open container.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isSoundEffectsWhenOpenClose() {
		return soundEffectsWhenOpenClose;
	}

	/**
	 * If it shall play sound when place the container.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isSoundEffectsWhenPlaceContainer() {
		return soundEffectsWhenPlaceContainer;
	}

	/**
	 * If it shall play sound when pick up items.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isSoundEffectsWhenContainerPickUpItems() {
		return soundEffectsWhenContainerPickUpItems;
	}

	/**
	 * If this is true,it will show the owner of the container
	 * on the hologram.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isDisplayPlayerNameOnHolo() {
		return displayPlayerNameOnHolo;
	}

	/**
	 * if player has suction border on or off.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isShowBorderSuctionWhenPlaceContainer() {
		return showBorderSuctionWhenPlaceContainer;
	}

	/**
	 * if player has time on or off. If this is true
	 * player will have limit time before it turn of
	 * automatic.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isHasLinkModeActiveTimeOrWhenTurnOf() {
		return hasLinkModeActiveTimeOrWhenTurnOf;
	}

	/**
	 * If this is true random particle effects will spawn on the
	 * container.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isEffectOnContainer() {
		return effectOnContainer;
	}

	/**
	 * If this is true it will spawn effects on container when player place it.
	 *
	 * @return true if the player has it on.
	 */
	public boolean isEffectOnContainerWhenPlaceContainer() {
		return effectOnContainerWhenPlaceContainer;
	}

	/**
	 * Get the partylist of players, player curently have.
	 *
	 * @return list of players or if not exist empty arraylist.
	 */
	public List<UUID> getPartylistOfPlayers() {
		return partylistOfPlayers;
	}

	/**
	 * Get instance of the builder class to get set values
	 * and change old values.
	 *
	 * @return builder instance.
	 */
	public Builder getBuilder() {
		return builder;
	}

	public static class Builder {
		private boolean showHologramsOnPlacedContainer;
		private boolean showEffectsWhenCrafItems;
		private boolean showEffectsWhenSellItems;
		private boolean soundEffectsWhenCrafItems;
		private boolean soundEffectsWhenSellItems;
		private boolean soundEffectsWhenOpenClose;
		private boolean soundEffectsWhenPlaceContainer;
		private boolean soundEffectsWhenContainerPickUpItems;
		private boolean displayPlayerNameOnHolo;
		private boolean showBorderSuctionWhenPlaceContainer;
		private boolean hasLinkModeActiveTimeOrWhenTurnOf;
		private boolean effectOnContainer;
		private boolean effectOnContainerWhenPlaceContainer;
		private List<UUID> partylistOfPlayers = new ArrayList<>();

		/**
		 * Set true if it shall show the holgrams.
		 *
		 * @param showHologramsOnPlacedContainer if not set, defult to false.
		 */
		public Builder setShowHologramsOnPlacedContainer(boolean showHologramsOnPlacedContainer) {
			this.showHologramsOnPlacedContainer = showHologramsOnPlacedContainer;
			return this;
		}

		/**
		 * Set to true if it shall show effects when craft.
		 *
		 * @param showEffectsWhenCrafItems if not set, defult to false.
		 */
		public Builder setShowEffectsWhenCrafItems(boolean showEffectsWhenCrafItems) {
			this.showEffectsWhenCrafItems = showEffectsWhenCrafItems;
			return this;
		}

		/**
		 * Set to true if it shall show effects when sell.
		 *
		 * @param showEffectsWhenSellItems if not set, defult to false.
		 */
		public Builder setShowEffectsWhenSellItems(boolean showEffectsWhenSellItems) {
			this.showEffectsWhenSellItems = showEffectsWhenSellItems;
			return this;
		}

		/**
		 * Set to true if it shall play a sound when craft.
		 *
		 * @param soundEffectsWhenCrafItems if not set, defult to false.
		 */
		public Builder setSoundEffectsWhenCrafItems(boolean soundEffectsWhenCrafItems) {
			this.soundEffectsWhenCrafItems = soundEffectsWhenCrafItems;
			return this;
		}

		/**
		 * Set to true if it shall play a sound when sell items.
		 *
		 * @param soundEffectsWhenSellItems if not set, defult to false.
		 */
		public Builder setSoundEffectsWhenSellItems(boolean soundEffectsWhenSellItems) {
			this.soundEffectsWhenSellItems = soundEffectsWhenSellItems;
			return this;
		}

		/**
		 * Set to true if it shall play a sound when open container.
		 *
		 * @param soundEffectsWhenOpenClose if not set, defult to false.
		 */
		public Builder setSoundEffectsWhenOpenClose(boolean soundEffectsWhenOpenClose) {
			this.soundEffectsWhenOpenClose = soundEffectsWhenOpenClose;
			return this;
		}

		/**
		 * Set to true if it shall play sound or not when place the container.
		 *
		 * @param soundEffectsWhenPlaceContainer if not set, defult to false.
		 */
		public Builder setSoundEffectsWhenPlaceContainer(boolean soundEffectsWhenPlaceContainer) {
			this.soundEffectsWhenPlaceContainer = soundEffectsWhenPlaceContainer;
			return this;
		}

		/**
		 * Set to true if it shall play sound or not when the container pick up items.
		 *
		 * @param soundEffectsWhenContainerPickUpItems if not set, defult to false.
		 */
		public Builder setSoundEffectsWhenContainerPickUpItems(boolean soundEffectsWhenContainerPickUpItems) {
			this.soundEffectsWhenContainerPickUpItems = soundEffectsWhenContainerPickUpItems;
			return this;
		}

		/**
		 * Set to true if you want to show the owner of the container or not.
		 *
		 * @param displayPlayerNameOnHolo if not set, defult to false..
		 */
		public Builder setDisplayPlayerNameOnHolo(boolean displayPlayerNameOnHolo) {
			this.displayPlayerNameOnHolo = displayPlayerNameOnHolo;
			return this;
		}

		/**
		 * Set to true if it shall show the border when place.
		 *
		 * @param showBorderSuctionWhenPlaceContainer if not set, defult to false.
		 */
		public Builder setShowBorderSuctionWhenPlaceContainer(boolean showBorderSuctionWhenPlaceContainer) {
			this.showBorderSuctionWhenPlaceContainer = showBorderSuctionWhenPlaceContainer;
			return this;
		}

		/**
		 * Set to true it shall automatic turn off linkmode.
		 *
		 * @param linkModeActiveTimeOrWhenTurnOff if not set, defult to false.
		 */
		public Builder setHasLinkModeActiveTimeOrTurnOfAuto(boolean linkModeActiveTimeOrWhenTurnOff) {
			this.hasLinkModeActiveTimeOrWhenTurnOf = linkModeActiveTimeOrWhenTurnOff;
			return this;
		}

		/**
		 * Set to true if it shall spawn particels on this players containers.
		 *
		 * @param effectOnContainer if not set, defult to false.
		 */
		public Builder setEffectOnContainer(boolean effectOnContainer) {
			this.effectOnContainer = effectOnContainer;
			return this;
		}

		/**
		 * If this is true it will spawn effects on container when player place it.
		 *
		 * @param effectOnContainerWhenPlaceContainer if not set, defult to false.
		 */

		public Builder setEffectOnContainerWhenPlaceContainer(boolean effectOnContainerWhenPlaceContainer) {
			this.effectOnContainerWhenPlaceContainer = effectOnContainerWhenPlaceContainer;
			return this;
		}

		/**
		 * Add a player to the partylist
		 *
		 * @param partylistOfPlayers the player some shall be added.
		 */
		public Builder setPartylistOfPlayers(List<UUID> partylistOfPlayers) {
			this.partylistOfPlayers = partylistOfPlayers;
			return this;
		}

		/**
		 * build your data you have set before.
		 *
		 * @return PreferenceSettingsData  instance;
		 */
		public PreferenceSettingsData build() {
			return new PreferenceSettingsData(this);
		}
	}
}
