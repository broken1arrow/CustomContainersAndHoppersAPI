package org.brokenarrow.storage.api.Crafting.util;

import org.bukkit.Material;

/**
 * The group the material belongs to.
 * It uses the alphabeted to terminate
 * what group a recipe belongs too.
 */
public enum MaterialGroup {
    /**
     * Letter A.
     */
    A,
    /**
     * Letter B.
     */
    B,
    /**
     * Letter C.
     */
    C,
    /**
     * Letter D.
     */
    D,
    /**
     * Letter E.
     */
    E,
    /**
     * Letter F.
     */
    F,
    /**
     * Letter G.
     */
    G,
    /**
     * Letter H.
     */
    H,
    /**
     * Letter I.
     */
    I,
    /**
     * Letter J.
     */
    J,
    /**
     * Letter U.
     */
    K,
    /**
     * Letter L.
     */
    L,
    /**
     * Letter M.
     */
    M,
    /**
     * Letter N.
     */
    N,
    /**
     * Letter O.
     */
    O,
    /**
     * Letter P.
     */
    P,
    /**
     * Letter Q.
     */
    Q,
    /**
     * Letter R.
     */
    R,
    /**
     * Letter S.
     */
    S,
    /**
     * Letter T.
     */
    T,
    /**
     * Letter U.
     */
    U,
    /**
     * Letter V.
     */
    V,
    /**
     * Letter W.
     */
    W,
    /**
     * Letter X.
     */
    X,
    /**
     * Letter W.
     */
    Y,
    /**
     * Letter Z.
     */
    Z;

    /**
     * This sets the material to a group
     *
     * @param material the material you want to retrieve the assassinated value.
     * @return the MaterialGroup value.
     */
    public static MaterialGroup getGroupForMaterial(final Material material) {
        // get the first letter of the material's name, ignoring case
        final char firstLetter = Character.toUpperCase(material.name().charAt(0));

        // convert the letter to an integer from 0 to 25, where 'A' is 0 and 'Z' is 25
        final int groupNumber = (int) firstLetter - (int) 'A';

        // return the corresponding enum value
        return values()[groupNumber];
    }
}