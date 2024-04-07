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

public class SignData implements ConfigurationSerializable {

	private final Location containerLocation;

	private Color color;
	private PlacingSignMode placeSignMode;
	private Material signMaterial;


	public SignData(final Location containerLocation) {
		this.containerLocation = containerLocation;

	}

	public Color getColor() {
		return color;
	}

	public SignData setColor(final Color color) {
		this.color = color;
		return this;
	}

	public PlacingSignMode getPlaceSignMode() {
		return placeSignMode;
	}

	public SignData setPlaceSignMode(final PlacingSignMode placeSignMode) {
		this.placeSignMode = placeSignMode;
		return this;
	}

	public Material getSignMaterial() {
		return signMaterial;
	}

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
