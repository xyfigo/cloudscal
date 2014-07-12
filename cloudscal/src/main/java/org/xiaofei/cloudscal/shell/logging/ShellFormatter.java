package org.xiaofei.cloudscal.shell.logging;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

import org.xiaofei.cloudscal.shell.ShellUtils;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        This extension of {@link SimpleFormatter} supplies custom formatting for log records
 *        that refer to thrown exceptions.
 * 
 */
public class ShellFormatter extends SimpleFormatter {

	private final static String NEW_LINE_CHAR = System.getProperty("line.separator");
	protected ResourceBundle messages = ShellUtils.getMessageBundle();

	/**
	 * Constructor.
	 */
	public ShellFormatter() {
		super();
	}

	/**
	 * {@inheritDoc} If an exception was thrown, a generic error message is used, and specific details about
	 * the current exception are added to it (including the stack trace is available).
	 */
	@Override
	public String format(final LogRecord record) {
		// TODO: append exception message to output
		String outputMessage;
		// This means that an exception was thrown. print the ex message to the log.
		if (record.getThrown() != null) {
			final Throwable t = record.getThrown();

			String message;
			if (t.getStackTrace().length == 0) {
				message = t.getLocalizedMessage();
			} else {
				final StringWriter sw = new StringWriter();
				t.printStackTrace(new PrintWriter(sw));
				message = sw.toString();
			}
			outputMessage = MessageFormat.format(messages.getString("op_failed"), message);

			if (record.getMessage() != null && !record.getMessage().isEmpty()) {
				outputMessage = super.formatMessage(record) + ": " + outputMessage;
			}
		} else {
			outputMessage = super.formatMessage(record);
		}

		// don't use message formatter here since outputMessage may contain illegal "{}" string.
		return outputMessage + NEW_LINE_CHAR;
	}

}
