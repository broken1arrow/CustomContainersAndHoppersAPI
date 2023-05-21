package org.brokenarrow.storage.api.util.conversion;

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
		Time timeConversion = plugin.timeConversion();
		if (timeConversion == null)
			return "";
		String convertTime = timeConversion.convertTime(days, hours,min,second);
		if (convertTime == null)
			convertTime = "";
		return convertTime;
	}
/*	public static Time timeConversion() {
		StringBuilder builder = new StringBuilder();
		return (days, hours, minutes, seconds)-> {
			builder.append(day(days));
			if (days > 0 && hours > 0) {
				builder.append(" ");
			}
			builder.append(hour(hours));
			if ((days > 0 || hours > 0) && minutes > 0) {
				builder.append(" ");
			}
			builder.append(minute(minutes));
			if ((days > 0 || hours > 0 || minutes > 0) && seconds > 0) {
				builder.append(" ");
			}
			builder.append(second(seconds));
			return builder.toString();
		};
	}*/

	public static String day(long amount) {
		if (amount == 0)
			return "";
		if (amount <= 1)
			return amount + plugin.getPlaceholder("Day");
		else
			return amount + plugin.getPlaceholder("Days");
	}

	public static String hour(long amount) {
		if (amount == 0)
			return "";
		if (amount <= 1)
			return amount + plugin.getPlaceholder("Hour");
		else
			return amount + plugin.getPlaceholder("Hours");
	}

	public static String minute(long amount) {
		if (amount == 0)
			return "";
		if (amount <= 1)
			return 	amount + plugin.getPlaceholder("Minute");
		else
			return	amount + plugin.getPlaceholder("Minutes");
	}

	public static String second(long amount) {
		if (amount == 0)
			return "";
		if (amount <= 1)
			return amount + plugin.getPlaceholder("Second");
		else
			return amount + plugin.getPlaceholder("Seconds");
	}

}
