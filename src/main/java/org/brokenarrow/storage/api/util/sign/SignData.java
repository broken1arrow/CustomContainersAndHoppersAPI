package org.brokenarrow.storage.api.util.sign;

import org.broken.arrow.serialize.library.utility.converters.LocationSerializer;
import org.broken.arrow.serialize.library.utility.serialize.ConfigurationSerializable;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.broken.arrow.serialize.library.utility.converters.LocationSerializer.serializeLoc;

/**
 * Represents data associated with a sign.
 */
public class SignData implements ConfigurationSerializable {

	private final Location containerLocation;

	private Color color;
	private PlacingSignMode placeSignMode;
	private Material signMaterial;

	/**
	 * Constructs a SignData object with the specified container location.
	 *
	 * @param containerLocation The location of the container where the sign is placed.
	 */
	public SignData(final Location containerLocation) {
		this.containerLocation = containerLocation;

	}

	/**
	 * Gets the color of the sign text.
	 *
	 * @return The color of the sign text.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the sign text.
	 *
	 * @param color The color to set.
	 * @return This SignData object.
	 */
	public SignData setColor(final Color color) {
		this.color = color;
		return this;
	}

	/**
	 * Gets the mode of placing the sign.
	 *
	 * @return The mode of placing the sign.
	 */
	public PlacingSignMode getPlaceSignMode() {
		return placeSignMode;
	}

	/**
	 * Sets the mode of placing the sign.
	 *
	 * @param placeSignMode The mode to set.
	 * @return This SignData object.
	 */
	public SignData setPlaceSignMode(final PlacingSignMode placeSignMode) {
		this.placeSignMode = placeSignMode;
		return this;
	}

	/**
	 * Gets the material of the sign.
	 *
	 * @return The material of the sign.
	 */
	public Material getSignMaterial() {
		return signMaterial;
	}

	/**
	 * Sets the material of the sign.
	 *
	 * @param signMaterial The material to set.
	 * @return This SignData object.
	 */
	public SignData setSignMaterial(final Material signMaterial) {
		this.signMaterial = signMaterial;
		return this;
	}

    @NotNull
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("container_loc", serializeLoc(containerLocation));
		map.put("sign_color", color);
		map.put("sign_mode", placeSignMode);
		map.put("sign_material", signMaterial);
		return map;
	}

	/**
	 * Deserializes a SignData object from a map.
	 *
	 * @param map The map containing serialized data.
	 * @return The deserialized SignData object.
	 */
	public static SignData deserialize(final Map<String, Object> map) {
		Location containerLoc = LocationSerializer.deserializeLoc(map.get("container_loc"));
		String color = (String) map.get("sign_color");
		String signMode = (String) map.get("sign_mode");
		Material signMaterial = Material.getMaterial((String) map.get("sign_material"));

		SignData signData = new SignData(containerLoc);
		//signData.setColor(Color.WHITE);
		signData.setPlaceSignMode(PlacingSignMode.of(signMode));
		signData.setSignMaterial(signMaterial);

		return signData;
	}

}
