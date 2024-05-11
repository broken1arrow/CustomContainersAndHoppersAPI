package org.brokenarrow.storage.api.util.sign;

import org.broken.arrow.logging.library.Logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the text content of a sign.
 */
public class SignText {
	private static final Logging log = new Logging(SignText.class);
	private final List<String> signLines;

	/**
	 * Constructs an empty SignText object.
	 */
	public SignText() {
		this(new ArrayList<>(4));
	}

	/**
	 * Constructs a SignText object with the given list of sign lines.
	 *
	 * @param signLines The list of sign lines.
	 */
	public SignText(final List<String> signLines) {
		this.signLines = signLines;
	}

	/**
	 * Gets the list of sign lines.
	 *
	 * @return The list of sign lines.
	 */
	public List<String> getSignLines() {
		return signLines;
	}

	/**
	 * Adds lines to the sign text.
	 *
	 * @param lines The lines to add.
	 * @return This SignText object.
	 */
	public SignText addSignLines(String... lines) {
		if (signLines.size() < 4 && lines != null && lines.length < 4) {
			for (final String line : lines) {
				if (signLines.size() < 4)
					signLines.add(line);
				else
					log.log(()-> Logging.of("Can't add this line '" + line + "', because this doesn't fit inside the sign."));
			}
		}
		return this;
	}

	/**
	 * Sets the sign text to the specified lines.
	 *
	 * @param lines The lines to set.
	 * @return This SignText object.
	 */
	public SignText setSignLines(String... lines) {
		signLines.clear();
		if (lines != null) {
			for (final String line : lines) {
				if (signLines.size() < 4) {
					signLines.add(line);
				}
				else {
					log.log(() -> Logging.of("Can't add this line '" + line + "', because this doesn't fit inside the sign."));
				}
			}
		}
		return this;
	}

	/**
	 * Sets the line at the specified index.
	 *
	 * @param index The index of the line to set.
	 * @param line  The line to set.
	 * @return This SignText object.
	 */
	public SignText setSignLine(int index, String line) {
		if (index > 3) {
			log.log(()-> Logging.of("You can't have more than 4 rows on a sign, you try to access index '" + index + "'."));
			return this;
		}
		if (signLines.size() > index) {
			signLines.add(index, line);
		}
		else {
			log.log(() -> Logging.of("Index number '" + index + "' is out of range."));
		}
		return this;
	}

	/**
	 * Gets the line at the specified index.
	 *
	 * @param index The index of the line to get.
	 * @return The line at the specified index, or null if the index is out of range.
	 */
	public String getSignLine(final int index) {
		if (signLines == null || index >= signLines.size()) return null;
		return signLines.get(index);
	}
}