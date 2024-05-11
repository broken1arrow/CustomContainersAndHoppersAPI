package org.brokenarrow.storage.api;

/**
 * Used for set the random itemstack number fpor the placeholder item.
 * <p>
 * Note: this is not in use anymore, due to performance issues.
 */
public interface MainSettingsDataApiBuilder {

    /**
     * setts the stack number for the placeholder item.
     *
     * @param randomStackNumber the random number.
     * @return the MainSettingsDataApiBuilder instance.
     */
    MainSettingsDataApiBuilder setRandomStackNumber(double randomStackNumber);

    /**
     * Bulds the data set.
     * @return the new MainSettingsDataApiBuilder instance.
     */
    MainSettingsDataApi build();
}
