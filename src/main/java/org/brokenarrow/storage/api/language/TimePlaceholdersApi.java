package org.brokenarrow.storage.api.language;

/**
 * The class give you access to the converted time.
 */
public interface TimePlaceholdersApi {

	/**
	 * Retrieve day set.
	 *
	 * @return the day or empty string.
	 */
	String getDay();

	/**
	 * Retrieve the hour set.
	 *
	 * @return the hour or empty string.
	 */
	String getHour();

	/**
	 * Retrieve the minute set.
	 *
	 * @return the minute or empty string.
	 */
	String getMinute();

	/**
	 * Retrieve the second set.
	 *
	 * @return the second or empty string.
	 */
	String getSecond();

	/**
	 * Retrieve the days  set.
	 *
	 * @return the day  string.
	 */
	String getDays();

	/**
	 * Retrieve the hours set.
	 *
	 * @return the hours or empty string.
	 */
	String getHours();

	/**
	 * Retrieve the minutes set.
	 *
	 * @return the minutes or empty string.
	 */
	String getMinutes();

	/**
	 * Retrieve the seconds set.
	 *
	 * @return the seconds or empty string.
	 */
	String getSeconds();

}
