package org.brokenarrow.storage.api.util.sign;

import java.util.List;
import java.util.function.Consumer;

/**
 * The SignUtility class manages the sign text for both the front and back sides of a sign (if you are on at least Minecraft version 1.20).
 * It provides methods to set lines of text for each side and retrieve the current text for either side.
 */
public class SignUtility {
	private final SignText front;
	private final SignText back;

	/**
	 * Constructs a SignUtility object and initializes the sign text for both the front and back sides.
	 * The provided consumer handles the logic for setting the lines for a sign.
	 *
	 * @param signUtility the consumer that handles the logic for setting the lines for a sign.
	 */
	public SignUtility(final Consumer<SignUtility> signUtility) {
		this.front = new SignText();
		this.back = new SignText();


		signUtility.accept(this);
	}

	/**
	 * Add the lines of text for the front side of the sign.
	 *
	 * @param line the lines of text to be added.
	 * @return the SignText object representing the front side of the sign.
	 */
	public SignText applyFrontLines(String... line) {
		return setSignText(line,true);
	}

	/**
	 * Sets the lines of text for the front side of the sign.
	 *
	 * @param line the lines of text to be added.
	 * @return the SignText object representing the front side of the sign.
	 */
	public SignText applyFrontLines(final List<String> line) {
		return setSignText(line.toArray(new String[0]),true);
	}

	/**
	 * Sets the lines of text for the back side of the sign.
	 *
	 * @param line the lines of text to be added.
	 * @return the SignText object representing the back side of the sign
	 */
	public SignText applyBackLines(String... line) {
		return setSignText(line,false);
	}

	/**
	 * Sets the lines of text for the back side of the sign.
	 *
	 * @param lines the lines of text be added.
	 * @return the SignText object representing the back side of the sign
	 */
	public SignText applyBackLines(final List<String> lines) {
		return setSignText(lines.toArray(new String[0]),false);
	}

	/**
	 * Retrieves the current text set for the front side of the sign.
	 *
	 * @return the SignText object representing the current text set for the front side of the sign.
	 */
	public SignText getFront() {
		return front;
	}

	/**
	 * Retrieves the current text set for the back side of the sign.
	 *
	 * @return the SignText object representing the current text set for the back side of the sign.
	 */
	public SignText getBack() {
		return back;
	}

	private SignText setSignText(final String[] signText, boolean front) {
		if (front)
			return this.front.addSignLines(signText);
		else
			return this.back.addSignLines(signText);
	}

}