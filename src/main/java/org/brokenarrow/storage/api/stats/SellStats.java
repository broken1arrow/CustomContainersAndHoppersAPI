package org.brokenarrow.storage.api.stats;

public interface SellStats extends Stats{

    void addAmountItemsSold(int amountItemsSold);

    void addItemsCost(double costAmount);

    double getTotalErnings();
}
