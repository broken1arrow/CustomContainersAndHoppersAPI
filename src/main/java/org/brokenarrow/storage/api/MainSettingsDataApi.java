package org.brokenarrow.storage.api;

import java.util.List;
import java.util.Map;

public interface MainSettingsDataApi {

	/**
	 * Language some is set. defult is it english.
	 *
	 * @return the short format for a language to load.
	 */
	String getLanguage();

	/**
	 * If it shall take levels or exp from player
	 * global setting (you can override this for every container type you have)
	 *
	 * @return string ether EXP or LVL (depending on what you want).
	 */
	String getCostWhenPlaceGlobaTakelevelOrExp();

	/**
	 * If it shall show the misssing permissions in the
	 * console.
	 *
	 * @return true if it shall print it in console.
	 */

	boolean isShowNeedPermissionsInConsole();

	/**
	 * If it shall as defult spawn effects on container
	 * players can turn this off.
	 *
	 * @return true if it shall spawn effects.
	 */
	boolean isDefultEffectsOnContainer();

	/**
	 * Shall show effects on container when place.
	 *
	 * @return true if it shall spawn effects.
	 */
	boolean isDefultEffectsOnChestWhenPlace();

	/**
	 * Check if it allow items if filter is empty.
	 *
	 * @return true if shall allow items when filter is empty.
	 */
	boolean isDefultIfFilterEmpty();

	/**
	 * Check if it allow suction border to be displayed to player.
	 *
	 * @return true if shall show suction border.
	 */
	boolean isTurnOffSuctionBorder();

	/**
	 * Check if it allow spawn of holos.
	 *
	 * @return true if shall spawn holos.
	 */
	boolean isTurnOffhologramsOnOff();

	/**
	 * Check if it allow effects on a container.
	 *
	 * @return true if shall allow effects.
	 */
	boolean isTurnOffEffectsOnContainers();

	/**
	 * Check if it allow effects on a container when place it.
	 *
	 * @return true if shall allow effects when place container.
	 */
	boolean isTurnOffEffectsOnChestWhenPlaceContainer();

	/**
	 * Check if it allow sound effect on a container when place it.
	 *
	 * @return true if shall allow sound effect when place container.
	 */
	boolean isTurnOffESoundsOnChestWhenPlaceContainer();

	/**
	 * If it shall generate defult container files (To get some help how you can create own container type).
	 *
	 * @return true if it shall generate the defult container files.
	 */
	boolean isGenerateFiles();

	/**
	 * Limit amount of x block player can place inside an aria.
	 * Recommend use it on hoppers or similar.
	 *
	 * @return true if it shall limit hopperplacement.
	 */
	boolean isBlockLimitEnable();

	/**
	 * If it as defult show suction border. If it false players need turn this on self.
	 *
	 * @return true if shall show the border as defult for players.
	 */
	boolean isDefultShowSuctionBorder();

	/**
	 * If defult white or black filter on every hopper
	 * when get placed first time. If it white filter it allow
	 * All items you add to the list.
	 *
	 * @return true if it white list.
	 */
	boolean isDefultFilter();

	/**
	 * If it shall defult spawn holograms or
	 * players need turn this on.
	 *
	 * @return true if it shall spawn holos defult.
	 */
	boolean isDefultSpawnholograms();

	/**
	 * If it shall update holograms when player
	 * close a continer.
	 *
	 * @return true if it update holo.
	 */
	boolean isHologramsUpdatewhenCloseContainer();

	/**
	 * If it shall update holograms when hopper
	 * move items from or to container.
	 *
	 * @return true if it update holo.
	 */
	boolean isHologramsUpdatewhenHopperMoveitems();

	/**
	 * If it shall defult have timer insted of player need turn this of manually
	 * it will then turn of linkmode auto if this is true.
	 *
	 * @return true if it shall turn of link mode auto.
	 */
	boolean isDefultHasTimerInLinkingMode();

	/**
	 * Check if it defult shall show effect on a container when it craft items
	 * players can changes this.
	 *
	 * @return true if shall effect on a container when it craft items.
	 */
	boolean isDefultEffectsWhenCraftitems();

	/**
	 * Check if it defult shall play effect on a container when it sell items
	 * players can changes this.
	 *
	 * @return true if shall effect on a container when it sell items.
	 */
	boolean isDefultEffectsWhenSellitems();

	/**
	 * Check if it defult shall play sound effect on a container when it craft items
	 * players can changes this.
	 *
	 * @return true if shall sound effect on a container when it craft items.
	 */
	boolean isDefultSoundWhenCraftitems();

	/**
	 * Check if it defult shall play sound effect on a container when it sell items
	 * players can changes this.
	 *
	 * @return true if shall sound effect on a container when it sell items.
	 */
	boolean isDefultSoundWhenSellitems();

	/**
	 * Check if it defult shall play sound effect on a container when open or close
	 * players can changes this.
	 *
	 * @return true if shall sound effect on a container when open or close.
	 */
	boolean isDefultSoundWhenOpenCloseContainer();

	/**
	 * Check if it defult shall play show owner on holos, players can changes this.
	 *
	 * @return true if shall show owner.
	 */
	boolean isDefultShowOwnerOnHolograms();

	/**
	 * Check if it defult shall play  sound effect when container pick up items,
	 * players can changes this.
	 *
	 * @return true if shall have sound effect.
	 */
	boolean isSoundWhenContainerPickUpItems();

	/**
	 * Check if it defult shall play sound effect when place a container,
	 * players can changes this.
	 *
	 * @return true if shall have sound effect.
	 */
	boolean isDefultSoundWhenPlaceContainer();

	/**
	 * Check if sound is of when open or closed container globally ,
	 * players can't turn this on ether.
	 *
	 * @return true if shall have sound effect when open or close.
	 */
	boolean isTurnOffSoundOnChestWhenOpenContainer();

	/**
	 * Check if shall log when it sell items.
	 *
	 * @return true if shall log everyting player sell.
	 */
	boolean isLogAmountSold();

	/**
	 * Check if shall log when it crafting items.
	 *
	 * @return true if shall log everyting player craft.
	 */
	boolean isLogAmountCrafted();

	/**
	 * Debug crafting to see amount of time the task take ,
	 * this will cost little preformance to run. (use it only if needed)
	 *
	 * @return true if shall debug crafting.
	 */
	boolean isDebugCrafting();

	/**
	 * Debug teleport and pickup to see amount of time the task take ,
	 * this will cost little preformance to run. (use it only if needed)
	 *
	 * @return true if shall debug teleport and pickup.
	 */
	boolean isDebugTeleportPickupItems();

	/**
	 * If it shall cost to place a any type of container.
	 * You can set amount of free placements and time
	 * before it resets.
	 *
	 * @return true if it shall use this setting.
	 */
	boolean isCostWhenPlaceGlobalActive();

	/**
	 * If it shall run faster speed.
	 *
	 * @return true if it shall run faster.
	 */
	boolean isFastMode();

	/**
	 * When run the container task.This taks teleport items,
	 * sell items or craft items.
	 *
	 * @return true if you want to log the itame to run the task.
	 */
	boolean isDebugContainerTask();

	/**
	 * Get if it shall format numbers or not.
	 *
	 * @return true if it shall format the number.
	 */
	boolean isFormatNumbers();

	/**
	 * Get if it shall format numbers or not on the container.
	 *
	 * @return true if it shall format the number.
	 */
	boolean isFormatNumbersContainer();

	/**
	 * Get if it shall format numbers with letter.
	 *
	 * @return true if it shall format the number with letter in the end.
	 */
	boolean isFormatNumbersUseLetters();

	/**
	 * The time between every brodcast to player amount he sold or crafted.
	 *
	 * @return time in seconds.
	 */
	int getNotisTaskMessageTime();

	/**
	 * How long time player can set showtime for suction border to show.
	 *
	 * @return time in seconds.
	 */
	int getMaxShowtimeborder();

	/**
	 * How often holos get updated. Can also be updated when player close container check this  {@link #isHologramsUpdatewhenCloseContainer()} or
	 * {@link #isHologramsUpdatewhenHopperMoveitems()}
	 *
	 * @return time in seconds when it shall update.
	 */
	int getHologramsUpdateinterval();

	/**
	 * Time when turn of link mode for player auto. If he not change
	 * So he need turn it of self.
	 *
	 * @return seconds it will turn of linkmode.
	 */
	int getTimeBeforeItTurnOff();

	/**
	 * Limit of blocks in radius it shall check. if you turn on {@link #isBlockLimitEnable()}
	 *
	 * @return amount of block to check.
	 */
	int getBlockLimitRadius();

	/**
	 * Limit of blocks in hight it shall check. if you turn on {@link #isBlockLimitEnable()}
	 *
	 * @return amount of block to check in hight (y derection).
	 */
	int getBlockLimitRadiusHight();

	/**
	 * If {@link #isDefultEffectsOnChestWhenPlace()} is true or player turn this on.
	 * This tell amount of seconds it will show the effect.
	 *
	 * @return seconds it will show the effect.
	 */
	int getEffectOnContainerShowTime();

	/**
	 * Global time for when it shall craft or sell items, you can override this with
	 * settings for every container type.
	 *
	 * @return amount of time in seconds.
	 */
	int getDefultTaskTime();

	/**
	 * Get the procent when run container tasks. Like link/suction, sell and crafting.
	 *
	 * @return procent it should use.
	 */
	int getProcentContainertaskAlledToUse();

	/**
	 * Global what drop mode it will cost to place a container (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 * So you can chose if only when items is keept inside the container
	 * or when items is tropped on ground also.
	 * <p>
	 * Look in the yml file for the diffrent containers to see diffrent modes.
	 *
	 * @return -1 if it shall be on all modes or a number from 1.
	 */
	int getCostWhenPlaceGlobalActiveInDropMode();

	/**
	 * Amount of placements for free (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return amount of free placements.
	 */
	int getCostWhenPlaceGlobalAmountplaceforfree();

	/**
	 * Cost in lvels or experiens to place it (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return amount of levels or experiens to take from player.
	 */
	int getCostWhenPlaceGlobalExperienceToTake();

	/**
	 * Time before it reset (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return time in seconds.
	 */
	long getCostWhenPlaceGlobalTimebeforereset();

	/**
	 * Cost in money for player (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 * Only works if vault is installed.
	 *
	 * @return amount of money to take from player.
	 */
	double getCostWhenPlaceGlobalMoneytotake();

	/**
	 * the speed the hopper shall move items. If set to -1 it will use delfult speed from
	 * spigot.yml.
	 *
	 * @return the tickspeed or -1 if it is turned of.
	 */
	int getHopperSpeed();

	/**
	 * The amount of items it shall move. If it set to -1 it will use
	 * settings from spigot.yml.
	 *
	 * @return amount you want to move or -1 if you wanmt use defult.
	 */
	int getHopperAmount();

	/**
	 * Get the number of the custom item stack. This is used
	 * to set unic id on the item, so it could not be mixed up
	 * with normal items.
	 *
	 * @return the generated random generated number, note the number is not always updated
	 * (it will be updated when first item is moved from container or to custom container).
	 */
	double getRandomStackNumber();

	/**
	 * List of debug keys (to debug diffrent parts of the plugin).
	 *
	 * @return list of debug keys or empty list.
	 */
	List<String> getDebugMessages();

	/**
	 * List of matrials you want to limit.
	 *
	 * @return list of matrials or empty list.
	 */
	Map<String, Integer> getListOfBlocksToCheck();

	/**
	 * List of container types and there lore (used for holos).
	 *
	 * @return map of keys and continer types or empty map.
	 */
	Map<String, List<String>> getContainerList();

	MainSettingsDataApiBuilder getBuilder();
}
