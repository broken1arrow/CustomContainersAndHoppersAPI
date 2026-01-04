package org.brokenarrow.storage.api.stats;

/**
 * Statistics specific to crafting-related tasks.
 */
public interface CraftStats extends Stats {

    /**
     * Adds to the total number of items crafted.
     *
     * @param amountCrafted the number of items crafted
     */
    void addAmountCrafted(int amountCrafted);

}
