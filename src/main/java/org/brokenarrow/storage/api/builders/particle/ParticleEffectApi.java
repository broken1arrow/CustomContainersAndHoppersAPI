package org.brokenarrow.storage.api.builders.particle;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.jetbrains.annotations.Nullable;

public interface ParticleEffectApi {

	@Nullable Particle getParticle();

	@Nullable Effect getEffect();

	@Nullable Material getMaterial();

	int getData();

	Class<?> getDataType();

	ParticleDustOptionsApi getParticleDustOptions();

}
