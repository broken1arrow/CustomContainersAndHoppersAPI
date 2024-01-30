package org.brokenarrow.storage.api.util.sign;

import org.broken.arrow.logging.library.Logging;

import java.util.ArrayList;
import java.util.List;

public class SignText {
	private static final Logging log = new Logging(SignText.class);
	private final List<String> signLines;

	public SignText() {
		this(new ArrayList<>(4));
	}

	public SignText(final List<String> signLines) {
		this.signLines = signLines;
	}

	public List<String> getSignLines() {
		return signLines;
	}

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

	public String getSignLine(final int index) {
		if (signLines == null || index >= signLines.size()) return null;
		return signLines.get(index);
	}
}