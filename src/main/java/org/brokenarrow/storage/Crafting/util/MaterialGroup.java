package org.brokenarrow.storage.Crafting.util;

import org.bukkit.Material;

public enum MaterialGroup {
	A,
	B,
	C,
	D,
	E,
	F,
	G,
	H,
	I,
	J,
	K,
	L,
	M,
	N,
	O,
	P,
	Q,
	R,
	S,
	T,
	U,
	V,
	W,
	X,
	Y,
	Z;

	// method to assign a material to a group
	public static MaterialGroup getGroupForMaterial(final Material material) {
		// get the first letter of the material's name, ignoring case
		final char firstLetter = Character.toUpperCase(material.name().charAt(0));

		// convert the letter to an integer from 0 to 25, where 'A' is 0 and 'Z' is 25
		final int groupNumber = (int) firstLetter - (int) 'A';

		// return the corresponding enum value
		return values()[groupNumber];
	}
}