package org.brokenarrow.storage.util;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Almost settings on the continer can you get here.
 * You can get file and upgrade name in the cache.
 * {@link org.brokenarrow.storage.api.ContainerRegistryAPI#getContainerFileName(Location)}
 * {@link org.brokenarrow.storage.api.ContainerRegistryAPI#getCurrentUpdate(Location)}
 */
@SuppressWarnings("unused")
public class YamlSettingsContainers {

	/**
	 * Get lore on the item. You can see this when
	 * have the item inside an inventory.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return new ArrayList string if null or not set and if not return Lore.
	 */
	public static List<String> getLore(String fileName, String containerUpdate, Object... placolders) {
		return new ArrayList<>();
	}

	/**
	 * Get display name on the item. You can see this when an open container
	 * or have the item inside an inventory.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return DisplayName.
	 */
	public static String getDisplayName(String fileName, String containerUpdate, Object... placolders) {
		return "";
	}

	/**
	 * Get the displayname cost placeholder.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @param menuName        Get the menu
	 * @param values          Get the yaml key for this menu
	 * @param amountOfPages   aomut of pages the continer have.
	 * @return 0 if it not find the type of container or a string with double.
	 */
	public static String getDisplayNameCostPlaceholder(String fileName, String containerUpdate, String menuName, String values, int amountOfPages) {
		return "0";
	}

	/**
	 * Get type of container.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return null if it not find the type of container.
	 */
	public static String getContainerType(String fileName, String containerUpdate) {
		return null;
	}

	/**
	 * get how many pages it shall have defult.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 1 if null or not set and if not return defultaomut of pages.
	 */
	public static int getDefultPagesAmount(String fileName, String containerUpdate) {
		return 1;
	}

	/**
	 * get how many pages it shall have at max.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 1 if null or not set and if not return max aomut pages.
	 */
	public static int getMaxamountOfPages(String fileName, String containerUpdate) {
		return 1;
	}

	/**
	 * Get the max the container can store (only used for the container some can store 1 item type).
	 * Is set to -1 if it shall store unlimited or else limit amount items it can store.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return -1 if null or shall store unlimited and if not return amount.
	 */
	public static String getMaxAmountItemsSomeCanBeStored(String fileName, String containerUpdate) {
		return "-1";
	}

	/**
	 * Get the gui size of the container. Only some containers it are no use for this setting.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 9 if null or not set and if not return gui size.
	 */
	public static int getGuiSize(String fileName, String containerUpdate) {
		return 9;
	}

	/**
	 * Get the upgrade cost.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 0.0 if null or not set and if not return double amount.
	 */
	public static double getCostForUpdate(String fileName, String containerUpdate) {
		return 0.0;
	}

	/**
	 * Get suction range , how fare way from container it allow pick up items.
	 * Will be formated 5,5,5.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return string with range.
	 */
	public static String getSuctionRange(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get suction range placeholder, how fare way from container it allow pick up items.
	 * Will be formated after language.yml file.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return string with range.
	 */
	public static String getSuctionRangePlaceholder(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get link range, how fare way from one container to another container
	 * it allows the connection.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 1 if null or not set and if not return amount.
	 */

	public static int getLinkRange(String fileName, String containerUpdate) {
		return 1;
	}

	/**
	 * Get link range placeholder (if it active or not).
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return String.
	 */
	public static String getLinkRangePlaceholder(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get max amount of links you can do with one container.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 1 if null or not set and if not return amount.
	 */
	public static int getMaxAmountContainersCanBeLinked(String fileName, String containerUpdate) {
		return 1;
	}

	/**
	 * Get next upgrade for container.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return next upgrade.
	 */
	public static String getUppgrade(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get the current mode some are used, for when the container is destroyed
	 * and if items shall stay in the container or drop on the ground.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 1 if not set or null. 1 if items shall drop on the grund or 2 if it shall stay in container.
	 */
	public static int getItemDropMetod(String fileName, String containerUpdate) {
		return 1;
	}

	/**
	 * If the item shall glow when hive it inside the inventory, not work on chest.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return false if glow if off or not set.
	 */
	public static boolean isGlowOnOff(String fileName, String containerUpdate) {
		return false;
	}

	/**
	 * Get the list of items some are not allowed to add in gui for ether for filter or for crafting.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return new ArrayList if it not valid or null and if not return list with all blacklisted items.
	 */
	public static List<String> getBlacklistedItems(String fileName, String containerUpdate) {
		return new ArrayList<>();
	}

	/**
	 * this is used for when hopper shall pick up items or teleport items.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 5 if it not valid or null and if not null it return a nummber from 1 to x amount.
	 */
	public static int getSecondsForPickupTeleport(String fileName, String containerUpdate) {
		return 5;
	}

	/**
	 * run for example sell or crafting task
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return -1 if it not valid or null and if not null it return a nummber from 1 to x amount.
	 */
	public static long getSecondsForRunTask(String fileName, String containerUpdate) {
		return -1;
	}

	/**
	 * Get the effect name the border have for suction range.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return the effect enum name.
	 */
	public static String getEffectSuctionBorder(String fileName, String containerUpdate) {
		return null;
	}

	/**
	 * Get the effect time it will run the border have for suction range.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 1 if null or not set and if not return the time.
	 */
	public static int getEffectBorderShowTime(String fileName, String containerUpdate) {
		return 1;
	}

	/**
	 * Get the effect time it will run on/arund the container.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return new ArrayList if null or not set and if not return a list of effects.
	 */
	public static List<String> getEffectTypeOnContainer(String fileName, String containerUpdate) {
		return new ArrayList<>();
	}

	/**
	 * Get the effect it will run on/arund the container when place it.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return new ArrayList if null or not set and if not return a list of effects.
	 */
	public static List<String> getEffectTypeWhenPlaceContainer(String fileName, String containerUpdate) {
		return new ArrayList<>();
	}

	/**
	 * Get the sound effect it will play on the container when place it.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return a sound effect.
	 */
	public static String getSoundTypeWhenPlaceContainer(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get the sound effect it will play on the container when open.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return a sound effect.
	 */
	public static String getSoundTypeWhenOpenContainer(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get the sound effect it will play on the container when close.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return a sound effect.
	 */
	public static String getSoundTypeWhenCloseContainer(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get the sound effect it will play on the container when run a task.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return a sound effect.
	 */
	public static String getSoundWhenContainerRunTask(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get the effect it will run on/arund the container when run a task.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return new ArrayList if null or not set and if not return a list of effects.
	 */
	public static List<String> getEffectWhenContainerRunTask(String fileName, String containerUpdate) {
		return new ArrayList<>(0);
	}


	/**
	 * Get if it shall cost to place a container.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return true if it on or false if it not set or not turn it on.
	 */
	public static boolean getShallCostItBeActiveWhenPlace(String fileName, String containerUpdate) {
		return false;
	}

	/**
	 * Get amount of free placements for the container.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 2 if null or not set and if not return the amount.
	 */
	public static int getAmountPlaceForFree(String fileName, String containerUpdate) {
		return 2;
	}

	/**
	 * Get time before it reset the free placements on the container.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 600 if null or not set and if not return the time.
	 */
	public static long getTimeBeforeReset(String fileName, String containerUpdate) {
		return 600;
	}

	/**
	 * Get aomunt of money it will take from player if container not have free placements.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return 0 if null or not set and if not return the cost.
	 */
	public static double getMoneyToTakeFromPlayer(String fileName, String containerUpdate) {
		return 0;
	}

	/**
	 * Get if it will take levels or exp from player if container not have free placements.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return EXP if null or not set and if not return the option.
	 */
	public static String getTakeLevelOrExp(String fileName, String containerUpdate) {
		return "EXP";
	}

	/**
	 * Get the amount of levels or exp it will take from player if container not have free placements.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return EXP if null or not set and if not return the option.
	 */
	public static int getExperienceToTakePlayer(String fileName, String containerUpdate) {
		return 0;
	}

	/**
	 * Get the Block Visualization type, when activated link mode and
	 * it will show containers it linking too.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return the block type.
	 */
	public static String getBlockVisualizationBlocktype(String fileName, String containerUpdate) {
		return "";
	}

	/**
	 * Get the Block Visualization message, when activated link mode and
	 * it will show text on top of containers it linking too.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return empty string if null or not set and if not return the text.
	 */
	public static String getBlockVisualizationMessageOnTop(String fileName, String containerUpdate, Object... placolders) {
		return "";
	}

	/**
	 * Get the placeholder item used for the continer some store one item type.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return null if not set and if not return itemstack.
	 */
	public static ItemStack getPlaceholderItemStack(String fileName, String containerUpdate) {
		return null;
	}

	/**
	 * Get if the items shall glow, used for the continer some store one item type.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return true if it shall glow.
	 */
	public static boolean isPlaceholderItemStackisGlow(String fileName, String containerUpdate) {
		return false;
	}

	/**
	 * Get if the container are in sellmode or not.
	 *
	 * @param fileName        Chests_and_HoppersSettings folder
	 * @param containerUpdate the continers curent update or next update.
	 * @return true if it are in sell mode.
	 */
	public static boolean isInSellMode(String fileName, String containerUpdate) {
		return false;
	}

	/**
	 * translate {0} placeholders.
	 *
	 * @param rawText      the text you want to get translated.
	 * @param placeholders array of values you want to replace {number}
	 * @return text with placeholderrs translated.
	 */
	public static String translatePlaceholders(String rawText, Object... placeholders) {
		if (rawText != null && placeholders != null)
			for (int i = 0; i < placeholders.length; i++) {
				rawText = rawText.replace("{" + i + "}", placeholders[i].toString());
			}
		return rawText;
	}

	/**
	 * translate {0} placeholders, translate array of strangs.
	 *
	 * @param rawText      the text you want to get translated.
	 * @param placeholders array of values you want to replace {number}
	 * @return text with placeholderrs translated.
	 */
	public static List<String> translatePlaceholders(List<String> rawText, Object... placeholders) {
		List<String> textList = new ArrayList<>();
		for (String text : rawText) {
			for (int i = 0; i < placeholders.length; i++) {
				text = text.replace("{" + i + "}", placeholders[i].toString());
			}
			textList.add(text);
		}
		return textList;
	}
}
