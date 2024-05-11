package org.brokenarrow.storage.api.builders.particle;

/**
 * What for type of effect set for the container.
 * Used to retrieve the effects from a map.
 */
public enum EffectType {

	/**
	 * The effect on the container
	 */
	EFFECT_ON_CONTAINER,

	/**
	 * The effect when container run a task.
	 */
	EFFECT_WHEN_CONTAINER_RUNTASK,

	/**
	 * The effect when place the container.
	 */
	EFFECT_WHEN_PLACE_CONTAINER,

	/**
	 * The effect for the border for example
	 * the suction border.
	 */
	SUCTION_BORDER_EFFECT,

	/**
	 * The effect when container pick up items.
	 */
	SUCTION_EFFECT,
	
	/**
	 * The effect for the border for example
	 * the suction border.
	 */
	BORDER_EFFECT
	;
}
