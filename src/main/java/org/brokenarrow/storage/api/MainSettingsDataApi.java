package org.brokenarrow.storage.api;

import java.util.List;
import java.util.Map;

public interface MainSettingsDataApi {

	/**
	 * Language some is set. default is it english.
	 *
	 * @return the short format for a language to load.
	 */
	String getLanguage();

	/**
	 * If it shall take levels or exp from a player
	 * global setting (you can override this for every container type you have)
	 *
	 * @return string ether EXP or LVL (depending on what you want).
	 */
	String getCostWhenPlaceGlobalTakeLevelOrExp();

	/**
	 * If it shall show the missing permissions in the
	 * console.
	 *
	 * @return true if it shall print it in the console.
	 */

	boolean isShowNeedPermissionsInConsole();

	/**
	 * If it shall as default spawn effects on container
	 * players can turn this off.
	 *
	 * @return true if it shall spawn effects.
	 */
	boolean isDefaultEffectsOnContainer();

	/**
	 * Shall show effects on the container when placed.
	 *
	 * @return true if it shall spawn effects.
	 */
	boolean isDefaultEffectsOnChestWhenPlace();

	/**
	 * Check if it allows items if filter is empty.
	 *
	 * @return true if shall allow items when filter is empty.
	 */
	boolean isDefaultIfFilterEmpty();

	/**
	 * Check if it allows suction border to be displayed to player.
	 *
	 * @return true if it shall show suction border.
	 */
	boolean isTurnOffSuctionBorder();

	/**
	 * Check if it allows spawn of holos.
	 *
	 * @return true if it shall spawn holos.
	 */
	boolean isShowHolograms();

	/**
	 * Check if it allows effects on a container.
	 *
	 * @return true if it shall allow effects.
	 */
	boolean isTurnOffEffectsOnContainers();

	/**
	 * Check if it allows effects on a container when place it.
	 *
	 * @return true if it shall allow effects when place container.
	 */
	boolean isTurnOffEffectsOnChestWhenPlaceContainer();

	/**
	 * Check if it allows sound effect on a container when place it.
	 *
	 * @return true if it shall allow sound effect when place container.
	 */
	boolean isTurnOffESoundsOnChestWhenPlaceContainer();

	/**
	 * If it shall generate default container files (To get some help how you can create own container type).
	 *
	 * @return true if it shall generate the default container files.
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
	 * If it as default show suction border. If it false players need turn this on self.
	 *
	 * @return true if it shall show the border as default for players.
	 */
	boolean isDefaultShowSuctionBorder();

	/**
	 * If default white or black filter on every hopper
	 * when get placed first time. If it is white filter it allow
	 * All items you add to the list.
	 *
	 * @return true if it is white list.
	 */
	boolean isDefaultFilter();

	/**
	 * If it shall default spawn holograms or
	 * players need turn this on.
	 *
	 * @return true if it shall spawn holos default.
	 */
	boolean isDefaultSpawnHolograms();

	/**
	 * If it shall update holograms when player
	 * close a container.
	 *
	 * @return true if it updates holo.
	 */
	boolean isHologramsUpdateWhenCloseContainer();

	/**
	 * If it shall update holograms when hopper
	 * move items from or to container.
	 *
	 * @return true if it updates holo.
	 */
	boolean isHologramsUpdateWhenHopperMoveitems();

	/**
	 * If it shall default have timer insted of player need turn this of manually
	 * it will then turn of linkmode auto if this is true.
	 *
	 * @return true if it shall turn of link mode auto.
	 */
	boolean isDefaultHasTimerInLinkingMode();

	/**
	 * Check if it defaults shall show effect on a container when it crafts items
	 * players can change this.
	 *
	 * @return true if it shall effect on a container when it crafts items.
	 */
	boolean isDefaultEffectsWhenCraftItems();

	/**
	 * Check if it defaults shall play effect on a container when it sells items
	 * players can change this.
	 *
	 * @return true if it shall effect on a container when it sells items.
	 */
	boolean isDefaultEffectsWhenSellItems();

	/**
	 * Check if it defaults shall play sound effect on a container when it crafts items
	 * players can change this.
	 *
	 * @return true if shall sound effect on a container when it crafts items.
	 */
	boolean isDefaultSoundWhenCraftItems();

	/**
	 * Check if it defaults shall play sound effect on a container when it sells items
	 * players can change this.
	 *
	 * @return true if it shall sound effect on a container when it sells items.
	 */
	boolean isDefaultSoundWhenSellItems();

	/**
	 * Check if it defult shall play sound effect on a container when open or close
	 * players can changes this.
	 *
	 * @return true if it shall sound effect on a container when open or close.
	 */
	boolean isDefaultSoundWhenOpenCloseContainer();

	/**
	 * Check if it default shall play show owner on holos, players can change this.
	 *
	 * @return true if it shall show owner.
	 */
	boolean isDefaultShowOwnerOnHolograms();

	/**
	 * Check if it defaults shall play sound effect when container pick up items,
	 * players can change this.
	 *
	 * @return true if it shall have sound effect.
	 */
	boolean isSoundWhenContainerPickUpItems();

	/**
	 * Check if it defaults shall play sound effect when place a container,
	 * players can change this.
	 *
	 * @return true if it shall have sound effect.
	 */
	boolean isDefaultSoundWhenPlaceContainer();

	/**
	 * Check if sound is of when open or closed container globally,
	 * players can't turn this on ether.
	 *
	 * @return true if it shall have sound effect when open or close.
	 */
	boolean isTurnOffSoundOnChestWhenOpenContainer();

	/**
	 * Check if it shall log when it sells items.
	 *
	 * @return true if it shall log everything player sell.
	 */
	boolean isLogAmountSold();

	/**
	 * Check if it shall log when crafting items.
	 *
	 * @return true if shall log everything player craft.
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
	 * this will cost little performance to run. (use it only if needed)
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
	 * When run the container task. This takes teleport items,
	 * sell items or craft items.
	 *
	 * @return true if you want to log the time to run the task.
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
	 * Get if it shall format numbers with a letter.
	 *
	 * @return true if it shall format the number with letter in the end.
	 */
	boolean isFormatNumbersUseLetters();

	/**
	 * The time between every broadcast to player amount he sold or crafted.
	 *
	 * @return time in seconds.
	 */
	int getNotesTaskMessageTime();

	/**
	 * How long time player can set showtime for suction border to show.
	 *
	 * @return time in seconds.
	 */
	int getMaxShowTimeBorder();

	/**
	 * How often holos get updated. Can also be updated when player close container check this  {@link #isHologramsUpdateWhenCloseContainer()} or
	 * {@link #isHologramsUpdateWhenHopperMoveitems()}
	 *
	 * @return time in seconds when it shall update.
	 */
	int getHologramsUpdateInterval();

	/**
	 * Time when turn of link mode for player auto. If he not changes,
	 * So he need to turn it off self.
	 *
	 * @return seconds it will turn of linkmode.
	 */
	int getTimeBeforeItTurnOff();

	/**
	 * Get if it shall show the settings menu or only the fitter menu.
	 *
	 * @return true if it shall show the settings menu.
	 */
	boolean isShowSettingsMenu();
	/**
	 * Limit of blocks in a radius it shall check. If you turn on {@link #isBlockLimitEnable()}
	 *
	 * @return amount of block to check.
	 */
	int getBlockLimitRadius();

	/**
	 * Limit of blocks in height it shall check. If you turn on {@link #isBlockLimitEnable()}
	 *
	 * @return amount of block to check y direction.
	 */
	int getBlockLimitRadiusHeight();

	/**
	 * If {@link #isDefaultEffectsOnChestWhenPlace()} is true or player turn this on.
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
	int getDefaultTaskTime();

	/**
	 * Get the procent when run container tasks. Like link/suction, sell and crafting.
	 *
	 * @return procent it should use.
	 */
	int getPercentContainerTaskAllowedToUse();

	/**
	 * Global what drop mode it will cost to place a container (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 * So you can choose if only when items is keep inside the container
	 * or when items is dropped on ground as well.
	 * <p>
	 * Look in the yml file for the different containers to see diffrent modes.
	 *
	 * @return -1 if it shall be on all modes, or a number from 1.
	 */
	int getCostWhenPlaceGlobalActiveInDropMode();

	/**
	 * Amount of placements for free (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return amount of free placements.
	 */
	int getCostWhenPlaceGlobalAmountPlaceForFree();

	/**
	 * Cost in levels or experiens to place it (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return amount of levels or experience to take from a player.
	 */
	int getCostWhenPlaceGlobalExperienceToTake();

	/**
	 * Time before it reset (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 *
	 * @return time in seconds.
	 */
	long getCostWhenPlaceGlobalTimebeforereset();

	/**
	 * Cost in money for a player (only works if {@link #isCostWhenPlaceGlobalActive()} is true).
	 * Only works if vault is installed.
	 *
	 * @return amount of money to take from a player.
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
	 * @return amount you want to move or -1 if you want use default.
	 */
	int getHopperAmount();

	/**
	 * Get the amount the custom item stack. This is used
	 * to set a unique ID on the item, so it could not be mixed up
	 * with normal items.
	 *
	 * @return the generated random generated number, note the number is not always updated
	 * (it will be updated when first item is moved from container or to custom container).
	 */
	double getRandomStackNumber();

	/**
	 * List of debug keys (to debug different parts of the plugin).
	 *
	 * @return list of debug keys or empty list.
	 */
	List<String> getDebugMessages();

	/**
	 * List of materials you want to limit.
	 *
	 * @return list of materials or empty list.
	 */
	Map<String, Integer> getListOfBlocksToCheck();

	/**
	 * List of container types and there lore (used for holos).
	 *
	 * @return map of keys and container types or empty map.
	 */
	Map<String, List<String>> getContainerList();

	MainSettingsDataApiBuilder getBuilder();
}
