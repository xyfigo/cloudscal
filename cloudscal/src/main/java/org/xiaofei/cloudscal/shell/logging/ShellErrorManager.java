package org.xiaofei.cloudscal.shell.logging;

import java.text.MessageFormat;
import java.util.logging.ErrorManager;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        This extension of {@link ErrorManager} prints data about occurring exceptions to the error stream.
 * 
 */
public class ShellErrorManager extends ErrorManager {

	/**
	 * Constructs an instance of {@code ErrorManager}.
	 */
	public ShellErrorManager() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final String message, final Exception exception, final int errorCode) {

		System.err.println(MessageFormat.format("Error occurred: {0}. For more details refer to the full logs.",
				exception.getCause()));

		exception.printStackTrace(System.err);
	}
}
