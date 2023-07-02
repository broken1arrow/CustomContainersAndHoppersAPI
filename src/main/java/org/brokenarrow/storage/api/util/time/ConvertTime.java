package org.brokenarrow.storage.api.util.time;

import org.broken.arrow.serialize.library.utility.converters.time.TimeFormatter;
import org.brokenarrow.storage.CCH;


/**
 * Convert millseconds to days, houers,minutes,seconds.
 */

public class ConvertTime {

	private static final long millisToSeconds = 1000;
	private static final long millisToMinute = millisToSeconds * 60;
	private static final long millisTohours = millisToMinute * 60;
	private static final long millisToDays = millisTohours * 24;
	private static final CCH plugin = CCH.getInstance();
	public static String toTimeFromMillis(long milliseconds) {
		return toTime(milliseconds / 1000);
	}

	public static String toTime(long seconds) {

		long time = System.currentTimeMillis() + (1000 * seconds);
		long currentTime = System.currentTimeMillis();
		long second = 0;
		long min = 0;
		long hours = 0;
		long days = 0;

		if (!((time - currentTime) / millisToSeconds % 60 == 0))
			second = (time - currentTime) / millisToSeconds % 60;
		if (!((time - currentTime) / millisToMinute % 60 == 0))
			min = (time - currentTime) / millisToMinute % 60;
		hours = (time - currentTime) / millisTohours % 24;
		days = (time - currentTime) / millisToDays;
		if (min < 0)
			min = 0;
		if (hours < 0)
			hours = 0;
		if (days < 0)
			days = 0;
		TimeFormatter timeConversion = plugin.timeConversion();
		if (timeConversion == null)
			return "";
		return timeConversion.convertTime(days, hours,min,second);
	}
}
