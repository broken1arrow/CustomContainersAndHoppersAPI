package org.brokenarrow.storage.util.builderclass;

import java.util.List;
import java.util.Map;

public final class MainSettingsData {

	private String language;
	private String costWhenPlaceGlobaTakelevelOrExp;

	private boolean showNeedPermissionsInConsole;
	private boolean defultEffectsOnContainer;
	private boolean defultEffectsOnChestWhenPlace;
	private boolean defultIfFilterEmpty;
	private boolean turnOffSuctionBorder;
	private boolean turnOffhologramsOnOff;
	private boolean turnOffEffectsOnContainers;
	private boolean turnOffEffectsOnChestWhenPlaceContainer;
	private boolean turnOffESoundsOnChestWhenPlaceContainer;
	private boolean generateFiles;
	private boolean blockLimitEnable;
	private boolean defultShowSuctionBorder;
	private boolean defultFilter;
	private boolean defultSpawnholograms;
	private boolean hologramsUpdatewhenCloseContainer;
	private boolean hologramsUpdatewhenHopperMoveitems;
	private boolean defultHasTimerInLinkingMode;
	private boolean defultEffectsWhenCraftitems;
	private boolean defultEffectsWhenSellitems;
	private boolean defultSoundWhenCraftitems;
	private boolean defultSoundWhenSellitems;
	private boolean defultSoundWhenOpenCloseContainer;
	private boolean defultShowOwnerOnHolograms;
	private boolean soundWhenContainerPickUpItems;
	private boolean defultSoundWhenPlaceContainer;
	private boolean turnOffSoundOnChestWhenOpenContainer;
	private boolean logAmountSold;
	private boolean logAmountCrafted;
	private boolean debugCrafting;
	private boolean debugTeleportPickupItems;
	private boolean costWhenPlaceGlobalActive;

	private int notisTaskMessageTime;
	private int maxShowtimeborder;
	private int hologramsUpdateinterval;
	private int timeBeforeItTurnOff;
	private int blockLimitRadius;
	private int blockLimitRadiusHight;
	private int effectOnContainerShowTime;
	private int sellCraftingTaskTime;
	private int costWhenPlaceGlobalActiveInDropMode;
	private int costWhenPlaceGlobalAmountplaceforfree;
	private int costWhenPlaceGlobalExperienceToTake;

	private long costWhenPlaceGlobalTimebeforereset;

	private double costWhenPlaceGlobalMoneytotake;

	private List<String> debugMessages;
	private Map<String, Integer> listOfBlocksToCheck;
	private Map<String, List<String>> containerList;
	private final Builder builder;

	public MainSettingsData(Builder builder) {
		this.builder = builder;
	}

	/**
	 * Language some is set. defult is it english.
	 *
	 * @return the short format for a language to load.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * If it shall take levels or exp from player
	 * global setting (you can override this for every container type you have)
	 *
	 * @return string ether EXP or LVL (depending on what you want).
	 */
	public String getCostWhenPlaceGlobaTakelevelOrExp() {
		return costWhenPlaceGlobaTakelevelOrExp;
	}

	/**
	 * If it shall show the misssing permissions in the
	 * console.
	 *
	 * @return true if it shall print it in console.
	 */

	public boolean isShowNeedPermissionsInConsole() {
		return showNeedPermissionsInConsole;
	}

	/**
	 * If it shall as defult spawn effects on container
	 * players can turn this off.
	 *
	 * @return true if it shall spawn effects.
	 */
	public boolean isDefultEffectsOnContainer() {
		return defultEffectsOnContainer;
	}

	/**
	 * Shall show effects on container when place.
	 *
	 * @return true if it shall spawn effects.
	 */
	public boolean isDefultEffectsOnChestWhenPlace() {
		return defultEffectsOnChestWhenPlace;
	}

	/**
	 * Check if it allow items if filter is empty.
	 *
	 * @return true if shall allow items when filter is empty.
	 */
	public boolean isDefultIfFilterEmpty() {
		return defultIfFilterEmpty;
	}

	/**
	 * Check if it allow suction border to be displayed to player.
	 *
	 * @return true if shall show suction border.
	 */
	public boolean isTurnOffSuctionBorder() {
		return turnOffSuctionBorder;
	}

	/**
	 * Check if it allow spawn of holos.
	 *
	 * @return true if shall spawn holos.
	 */
	public boolean isTurnOffhologramsOnOff() {
		return turnOffhologramsOnOff;
	}

	/**
	 * Check if it allow effects on a container.
	 *
	 * @return true if shall allow effects.
	 */
	public boolean isTurnOffEffectsOnContainers() {
		return turnOffEffectsOnContainers;
	}

	/**
	 * Check if it allow effects on a container when place it.
	 *
	 * @return true if shall allow effects when place container.
	 */
	public boolean isTurnOffEffectsOnChestWhenPlaceContainer() {
		return turnOffEffectsOnChestWhenPlaceContainer;
	}

	/**
	 * Check if it allow sound effect on a container when place it.
	 *
	 * @return true if shall allow sound effect when place container.
	 */
	public boolean isTurnOffESoundsOnChestWhenPlaceContainer() {
		return turnOffESoundsOnChestWhenPlaceContainer;
	}

	/**
	 * If it shall generate defult container files (To get some help how you can create own container type).
	 *
	 * @return true if it shall generate the defult container files.
	 */
	public boolean isGenerateFiles() {
		return generateFiles;
	}

	/**
	 * Limit amount of x block player can place inside an aria.
	 * Recommend use it on hoppers or similar.
	 *
	 * @return true if it shall limit hopperplacement.
	 */
	public boolean isBlockLimitEnable() {
		return blockLimitEnable;
	}

	/**
	 * If it as defult show suction border. If it false players need turn this on self.
	 *
	 * @return true if shall show the border as defult for players.
	 */
	public boolean isDefultShowSuctionBorder() {
		return defultShowSuctionBorder;
	}

	/**
	 * If defult white or black filter on every hopper
	 * when get placed first time. If it white filter it allow
	 * All items you add to the list.
	 *
	 * @return true if it white list.
	 */
	public boolean isDefultFilter() {
		return defultFilter;
	}

	/**
	 * If it shall defult spawn holograms or
	 * players need turn this on.
	 *
	 * @return true if it shall spawn holos defult.
	 */
	public boolean isDefultSpawnholograms() {
		return defultSpawnholograms;
	}

	/**
	 * If it shall update holograms when player
	 * close a continer.
	 *
	 * @return true if it update holo.
	 */
	public boolean isHologramsUpdatewhenCloseContainer() {
		return hologramsUpdatewhenCloseContainer;
	}

	/**
	 * If it shall update holograms when hopper
	 * move items from or to container.
	 *
	 * @return true if it update holo.
	 */
	public boolean isHologramsUpdatewhenHopperMoveitems() {
		return hologramsUpdatewhenHopperMoveitems;
	}

	/**
	 * If it shall defult have timer insted of player need turn this of manually
	 * it will then turn of linkmode auto if this is true.
	 *
	 * @return true if it shall turn of link mode auto.
	 */
	public boolean isDefultHasTimerInLinkingMode() {
		return defultHasTimerInLinkingMode;
	}

	/**
	 * Check if it defult shall show effect on a container when it craft items
	 * players can changes this.
	 *
	 * @return true if shall effect on a container when it craft items.
	 */
	public boolean isDefultEffectsWhenCraftitems() {
		return defultEffectsWhenCraftitems;
	}

	/**
	 * Check if it defult shall play effect on a container when it sell items
	 * players can changes this.
	 *
	 * @return true if shall effect on a container when it sell items.
	 */
	public boolean isDefultEffectsWhenSellitems() {
		return defultEffectsWhenSellitems;
	}

	/**
	 * Check if it defult shall play sound effect on a container when it craft items
	 * players can changes this.
	 *
	 * @return true if shall sound effect on a container when it craft items.
	 */
	public boolean isDefultSoundWhenCraftitems() {
		return defultSoundWhenCraftitems;
	}

	/**
	 * Check if it defult shall play sound effect on a container when it sell items
	 * players can changes this.
	 *
	 * @return true if shall sound effect on a container when it sell items.
	 */
	public boolean isDefultSoundWhenSellitems() {
		return defultSoundWhenSellitems;
	}

	/**
	 * Check if it defult shall play sound effect on a container when open or close
	 * players can changes this.
	 *
	 * @return true if shall sound effect on a container when open or close.
	 */
	public boolean isDefultSoundWhenOpenCloseContainer() {
		return defultSoundWhenOpenCloseContainer;
	}

	/**
	 * Check if it defult shall play show owner on holos, players can changes this.
	 *
	 * @return true if shall show owner.
	 */
	public boolean isDefultShowOwnerOnHolograms() {
		return defultShowOwnerOnHolograms;
	}

	/**
	 * Check if it defult shall play  sound effect when container pick up items,
	 * players can changes this.
	 *
	 * @return true if shall have sound effect.
	 */
	public boolean isSoundWhenContainerPickUpItems() {
		return soundWhenContainerPickUpItems;
	}

	/**
	 * Check if it defult shall play sound effect when place a container,
	 * players can changes this.
	 *
	 * @return true if shall have sound effect.
	 */
	public boolean isDefultSoundWhenPlaceContainer() {
		return defultSoundWhenPlaceContainer;
	}

	/**
	 * Check if sound is of when open or closed container globally ,
	 * players can't turn this on ether.
	 *
	 * @return true if shall have sound effect when open or close.
	 */
	public boolean isTurnOffSoundOnChestWhenOpenContainer() {
		return turnOffSoundOnChestWhenOpenContainer;
	}

	/**
	 * Check if shall log when it sell items.
	 *
	 * @return true if shall log everyting player sell.
	 */
	public boolean isLogAmountSold() {
		return logAmountSold;
	}

	/**
	 * Check if shall log when it crafting items.
	 *
	 * @return true if shall log everyting player craft.
	 */
	public boolean isLogAmountCrafted() {
		return logAmountCrafted;
	}

	/**
	 * Debug crafting to see amount of time the task take ,
	 * this will cost little preformance to run. (use it only if needed)
	 *
	 * @return true if shall debug crafting.
	 */
	public boolean isDebugCrafting() {
		return debugCrafting;
	}

	/**
	 * Debug teleport and pickup to see amount of time the task take ,
	 * this will cost little preformance to run. (use it only if needed)
	 *
	 * @return true if shall debug teleport and pickup.
	 */
	public boolean isDebugTeleportPickupItems() {
		return debugTeleportPickupItems;
	}

	/**
	 * If it shall cost to place a any type of container.
	 * You can set amount of free placements and time
	 * before it resets.
	 *
	 * @return true if it shall use this setting.
	 */
	public boolean isCostWhenPlaceGlobalActive() {
		return costWhenPlaceGlobalActive;
	}

	/**
	 * The time between every brodcast to player amount he sold or crafted.
	 *
	 * @return time in seconds.
	 */
	public int getNotisTaskMessageTime() {
		return notisTaskMessageTime;
	}

	/**
	 * How long time player can set showtime for suction border to show.
	 *
	 * @return time in seconds.
	 */
	public int getMaxShowtimeborder() {
		return maxShowtimeborder;
	}

	/**
	 * How often holos get updated. Can also be updated when player close container check this  {@link #isHologramsUpdatewhenCloseContainer()} or
	 * {@link #isHologramsUpdatewhenHopperMoveitems()}
	 *
	 * @return time in seconds when it shall update.
	 */
	public int getHologramsUpdateinterval() {
		return hologramsUpdateinterval;
	}

	/**
	 * Time when turn of link mode for player auto. If he not change
	 * So he need turn it of self.
	 *
	 * @return seconds it will turn of linkmode.
	 */
	public int getTimeBeforeItTurnOff() {
		return timeBeforeItTurnOff;
	}

	/**
	 * Limit of blocks in radius it shall check. if you turn on {@link #isBlockLimitEnable()}
	 *
	 * @return amount of block to check.
	 */
	public int getBlockLimitRadius() {
		return blockLimitRadius;
	}

	/**
	 * Limit of blocks in hight it shall check. if you turn on {@link #isBlockLimitEnable()}
	 *
	 * @return amount of block to check in hight (y derection).
	 */
	public int getBlockLimitRadiusHight() {
		return blockLimitRadiusHight;
	}

	/**
	 * If {@link #isDefultEffectsOnChestWhenPlace()} is true or player turn this on.
	 * This tell amount of seconds it will show the effect.
	 *
	 * @return seconds it will show the effect.
	 */
	public int getEffectOnContainerShowTime() {
		return effectOnContainerShowTime;
	}

	/**
	 * Global time for when it shall craft or sell items, you can override this with
	 * settings for every container type.
	 *
	 * @return amount of time in seconds.
	 */
	public int getSellCraftingTaskTime() {
		return sellCraftingTaskTime;
	}

	/**
	 * Global what drop mode it will cost to place a container (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 * So you can chose if only when items is keept inside the container
	 * or when items is tropped on ground also.
	 * <p>
	 * Look in the yml file for the diffrent containers to see diffrent modes.
	 *
	 * @return -1 if it shall be on all modes or a number from 1.
	 */
	public int getCostWhenPlaceGlobalActiveInDropMode() {
		return costWhenPlaceGlobalActiveInDropMode;
	}

	/**
	 * Amount of placements for free (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return amount of free placements.
	 */
	public int getCostWhenPlaceGlobalAmountplaceforfree() {
		return costWhenPlaceGlobalAmountplaceforfree;
	}

	/**
	 * Cost in lvels or experiens to place it (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return amount of levels or experiens to take from player.
	 */
	public int getCostWhenPlaceGlobalExperienceToTake() {
		return costWhenPlaceGlobalExperienceToTake;
	}

	/**
	 * Time before it reset (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return time in seconds.
	 */
	public long getCostWhenPlaceGlobalTimebeforereset() {
		return costWhenPlaceGlobalTimebeforereset;
	}

	/**
	 * Cost in money for player (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 * Only works if vault is installed.
	 *
	 * @return amount of money to take from player.
	 */
	public double getCostWhenPlaceGlobalMoneytotake() {
		return costWhenPlaceGlobalMoneytotake;
	}

	/**
	 * List of debug keys (to debug diffrent parts of the plugin).
	 *
	 * @return list of debug keys or empty list.
	 */
	public List<String> getDebugMessages() {
		return debugMessages;
	}

	/**
	 * List of matrials you want to limit.
	 *
	 * @return list of matrials or empty list.
	 */
	public Map<String, Integer> getListOfBlocksToCheck() {
		return listOfBlocksToCheck;
	}

	/**
	 * List of container types and there lore (used for holos).
	 *
	 * @return map of keys and continer types or empty map.
	 */
	public Map<String, List<String>> getContainerList() {
		return containerList;
	}

	public Builder getBuilder() {
		return builder;
	}

	public static class Builder {
	}
}
