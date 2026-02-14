package org.brokenarrow.storage.api.builders;

import org.broken.arrow.library.serialize.utility.converters.particleeffect.ParticleEffectAccessor;
import org.brokenarrow.storage.api.builders.particle.ParticleEffectUtility;
import org.brokenarrow.storage.api.containerholder.util.TypeOfContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * The container settings.
 */
public interface ContainerSettingsApi {


	/**
	 * Get what type container it is.
	 *
	 * @return the type of container.
	 * @see TypeOfContainer
	 */
	TypeOfContainer getContainerType();

	/**
	 * Get if it shall update the block or not
	 *
	 * @return true if it shall update the block.
	 */
	boolean isUpdateBlock();

	/**
	 * Get sound type when place container.
	 *
	 * @return sound enum name.
	 */
	org.bukkit.Sound getSoundWhenPlaceContainer();

	/**
	 * Get sound type when open container.
	 *
	 * @return sound enum name.
	 */
	org.bukkit.Sound getSoundWhenOpenContainer();

	/**
	 * Get sound type when close container.
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
	Material getBlockVisualizationBlockTypeTo();

	/**
	 * Get type of block it shall use for visualization (it is used to show
	 * what container you have linked from).
	 *
	 * @return Matrial enum name.
	 */
	Material getBlockVisualizationBlockTypeFrom();

	/**
	 * Get message some are ontop of the block you link too.
	 *
	 * @return message you want on top of the container.
	 */
	String getBlockVisualizationMessageOnTop();

	/**
	 * Get items some shall be blacklisted (Is for the filter and crafting list to allow or disallow items can be added).
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
	 * Get all effects set on this container.
	 *
	 * @return the ParticleEffectUtility instance.
	 */
	ParticleEffectUtility<ParticleEffectAccessor> getParticleEffect();

	/**
	 * Get how long time it will show border in seconds.
	 *
	 * @return number of seconds.
	 */
	int getSuctionBorderShowTime();

	/**
	 * Get if it shall use exp or level from player.
	 * <p>&nbsp;</p>
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
	 * If the sign placing is enable or not.
	 *
	 * @return true if it turns on.
	 */
	boolean isSignIsEnable();

	/**
	 * Retrieve the preferred facing of the sign.
	 *
	 * @return the facing.
	 */
	String getPreferredSignFace();

	/**
	 * Retrieve a copy of the text.
	 *
	 * @return the sign text copy.
	 */
	List<String> getSignText();

	/**
	 * Retrieve a copy of the text and replace placeholders.
	 *
	 * @param placeholders the placeholders you want to replace.
	 * @return the sign text with the placeholders translated.
	 */
	List<String> getSignText(Object... placeholders);

	/**
	 * Retrieve the default Material for the sign.
	 *
	 * @return the material set as default.
	 */
	Material getDefaultSignMaterial();

	/**
	 * Retrieve placeholder item, used as placeholder.
	 *
	 * @return item-stack set for the placeholder.
	 */
	ItemStack getPlaceholderItem();

	/**
	 * Get if placeholder items shall glow.
	 *
	 * @return true if item shall glow.
	 */
	boolean isPlaceholderItemStacksGlow();

}
