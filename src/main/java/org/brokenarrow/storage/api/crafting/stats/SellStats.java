package org.brokenarrow.storage.api.crafting.stats;

import org.brokenarrow.storage.api.stats.Stats;

/**
 * Statistics specific to selling-related tasks.
 * <p>
 * In addition to tracking item amounts, this interface also
 * records monetary values associated with sales.
 */
public interface SellStats extends Stats {

    /**
     * Adds to the total number of items sold.
     *
     * @param amountItemsSold the number of items sold
     */
    void addAmountItemsSold(int amountItemsSold);
    
    /**
     * Adds to the total earnings from sold items.
     *
     * @param costAmount the monetary value earned
     */
    void addItemsCost(double costAmount);
    
    /**
     * Returns the total earnings from all selling tasks.
     *
     * @return the total earnings
     */
    double getTotalEarnings();
}
