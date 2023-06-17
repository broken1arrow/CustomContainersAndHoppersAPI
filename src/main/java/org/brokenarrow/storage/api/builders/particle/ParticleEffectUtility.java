package org.brokenarrow.storage.api.builders.particle;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * Represents a particle effect with various utility methods for managing particle effects.
 * @param <T> the type of class for get data from the list.
 */
public  interface ParticleEffectUtility<T> {

	/**
	 * Adds a single particle effect to the specified effect type.
	 *
	 * @param type     The effect type to add the particle effect to.
	 * @param particle The name of the particle.
	 */
	void addParticleEffect(@Nonnull final EffectType type,@Nonnull final String particle);
	/**
	 * Converts a list of particle names to a list of ParticleEffect instances.
	 *
	 * @param type      The effect type to add the particle effects to.
	 * @param particles The list of particle names.
	 * @return true if the particles were successfully added, false otherwise.
	 */
	boolean addParticlesEffect(@Nonnull final EffectType type,@Nullable final List<String> particles);

	/**
	 * Adds multiple particle effects to the specified effect type based on a serialized map.
	 *
	 * @param type          The effect type to add the particle effects to.
	 * @param path          The path in the serialized map where the particle effects are located.
	 * @param serializedMap The serialized map containing the particle effects.
	 */
	void addAllParticleEffect(@Nonnull final EffectType type,@Nonnull final String path,@Nonnull final Map<String, Object> serializedMap);

	/**
	 * Retrieves the list of particle effects for the specified effect type.
	 *
	 * @param type The effect type to retrieve the particle effects for.
	 * @return The list of particle effects, or null if none exist for the given effect type.
	 */
	@Nullable
	List<T> getEffects(@Nonnull final EffectType type);

	/**
	 * Retrieves the first particle effect for the specified effect type.
	 *
	 * @param type The effect type to retrieve the particle effect for.
	 *
	 * @return The first particle effect, or null if none exist for the given effect type.
	 */
	@Nullable
	T getFirstEffect(@Nonnull final EffectType type);

	/**
	 * Executes the particle effects at the specified location for the given effect type and player.
	 *
	 * @param location The location to execute the particle effects at.
	 * @param type     The effect type to execute.
	 * @param player   The player associated with the particle effects.
	 * @return true if the particle effects were successfully executed, false otherwise.
	 */
	boolean exicute(@Nonnull Location location, @Nonnull EffectType type,@Nullable Player player);

	/**
	 * Executes the particle effects at the specified location for the given effect type and player.
	 *
	 * @param location The location to execute the particle effects at.
	 * @param type     The effect type to execute.
	 * @param player   The player associated with the particle effects.
	 * @param defaultParticle The default particle effect to use if no specific particle effect is defined.
	 * @return true if the particle effects were successfully executed, false otherwise.
	 */
	boolean exicute(@Nonnull final Location location,@Nonnull final EffectType type,@Nullable final Player player,@Nullable final Particle defaultParticle);
}
