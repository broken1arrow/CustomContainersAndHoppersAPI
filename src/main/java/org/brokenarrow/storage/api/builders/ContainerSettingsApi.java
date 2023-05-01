package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.builders.particle.ParticleEffectApi;
import org.brokenarrow.storage.api.containerholders.util.TypeOfContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ContainerSettingsApi {


	/**
	 * Get what type container it is.
	 *
	 * @return the type of container.
	 * @see org.brokenarrow.storage.api.containerholders.util.TypeOfContainer
	 */
	TypeOfContainer getContainerType();

	/**
	 * Get if it shall update the block or not
	 *
	 * @return true if it shall update the block.
	 */
	boolean isUpdateblock();

	/**
	 * Get sound type when place contanier.
	 *
	 * @return sound enum name.
	 */
	org.bukkit.Sound getSoundWhenPlaceContainer();

	/**
	 * Get sound type when open contanier.
	 *
	 * @return sound enum name.
	 */
	org.bukkit.Sound getSoundWhenOpenContainer();

	/**
	 * Get sound type when close contanier.
	 *
	 * @return sound enum name.
	 */
	org.bukkit.Sound getSoundWhenCloseContainer();

	/**
	 * Get sound type when run a task (for example after it have sold or craft or pick up item).
	 *
	 * @return sound enum name.
	 */
	org.bukkit.Sound getSoundWhenContainerRunTask();

	/**
	 * Get type of block it shall use for visualization (it is used to show
	 * what container you have linked to).
	 *
	 * @return Matrial enum name.
	 */
	Material getBlockVisualizationBlocktypeTo();

	/**
	 * Get type of block it shall use for visualization (it is used to show
	 * what container you have linked from).
	 *
	 * @return Matrial enum name.
	 */
	Material getBlockVisualizationBlocktypeFrom();

	/**
	 * Get message some are ontop of the block you link too.
	 *
	 * @return message you want on top of the container.
	 */
	String getBlockVisualizationMessageOnTop();

	/**
	 * Get items some shall be blacklisted (Is for filter and crafting list to allow or disallow items can be added).
	 *
	 * @return List of items some are blacklisted.
	 */
	List<String> getBlackListedItems();

	/**
	 * Get custom name on a effect.
	 *
	 * @return name on custom effect.
	 */
	String getPreMadeEffects();

	/**
	 * Get effects some will spawn random arund the container.
	 *
	 * @return list of visible effects some shall spawn on the container.
	 */
	List<ParticleEffectApi> getEffectOnContainer();

	/**
	 * When container run a task, like crafting,sell or pick up items.
	 * Get effects it shall run on the chest.
	 *
	 * @return list of diffrent effects or same effect several times.
	 */
	List<ParticleEffectApi> getEffectWhenContainerRunTask();

	/**
	 * Get list of effects shall show when place container.
	 *
	 * @return list of diffrent effects or same effect several times.
	 */
	List<ParticleEffectApi> getEffectWhenPlaceContainer();

	/**
	 * Get the type of effect you want to use to show the suction border.
	 *
	 * @return enum name on the effect and in 1.18 can it be matrial enum too.
	 */
	ParticleEffectApi getSuctionBorderEffect();

	/**
	 * Get how long time it will show border in seconds.
	 *
	 * @return number of seconds.
	 */
	int getSuctionBorderShowTime();

	/**
	 * Get if shall use exp or level from player.
	 * <p>
	 * This method set how much it will take {@link #setExperienceToTakePlayer(int)}.
	 *
	 * @return EXP or LVL.
	 */
	String getTakeLevelOrExp();

	/**
	 * Get cost for place the container.
	 *
	 * @return cost with decimals.
	 */
	double getMoneyToTakeFromPlayer();

	/**
	 * How much it will cost when place container when is no free placement left.
	 *
	 * @return amunt of xp or levels to take.
	 */
	int getExperienceToTakePlayer();

	/**
	 * Get amount of free placements.
	 *
	 * @return amount of free placements.
	 */
	int getAmountPlaceForFree();


	/**
	 * Get time before it will reset your placements. it will be in seconds.
	 *
	 * @return time in seconds it will be reseted.
	 */
	long getTimeBeforeReset();

	/**
	 * Get if cost and xp shall be active for that type of container when place.
	 *
	 * @return true if cost are active on container.
	 */
	boolean isShallCostBeActiveWhenPlaceContainer();

	/**
	 * Get placeholder item.
	 *
	 * @return material type.
	 */
	ItemStack getPlaceholderItem();

	/**
	 * Get if placeholder items shall glow.
	 *
	 * @return true if item shall glow.
	 */
	boolean isPlaceholderItemStackisGlow();

}
