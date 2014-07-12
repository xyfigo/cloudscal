package org.xiaofei.cloudscal.shell.exceptions;

import org.apache.commons.lang.StringUtils;
import org.xiaofei.cloudscal.shell.exceptions.CLIException;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        Extends {@link CLIException}, includes more details to support
 *        formatted messages.
 */
public class CLIStatusException extends CLIException {

	private static final long serialVersionUID = -399277091070772297L;
	private final String reasonCode;
	private final Object[] args;

	private final String verboseData;

	/*public CLIStatusException(final ErrorStatusException restException) {
		super("reasonCode: " + restException.getReasonCode(), restException);
		this.args = restException.getArgs();
		this.reasonCode = restException.getReasonCode();
		this.verboseData = restException.getVerboseData();
	}*/

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            The Throwable that caused this exception to be thrown.
	 * @param reasonCode
	 *            A reason code, by which a formatted message can be retrieved
	 *            from the message bundle
	 * @param args
	 *            Optional arguments to embed in the formatted message
	 */
	public CLIStatusException(final Throwable cause, final String reasonCode, final Object... args) {
		super("reasonCode: " + reasonCode, cause);
		this.args = args;
		this.reasonCode = reasonCode;
		this.verboseData = null;
	}

	/**
	 * Constructor.
	 * 
	 * @param reasonCode
	 *            A reason code, by which a formatted message can be retrieved
	 *            from the message bundle
	 * @param args
	 *            Optional arguments to embed in the formatted message
	 */
	public CLIStatusException(final String reasonCode, final Object... args) {
		super("reasonCode: " + reasonCode);
		this.reasonCode = reasonCode;
		this.args = args;
		this.verboseData = null;
	}

	/**
	 * Gets the reason code.
	 * 
	 * @return A reason code, by which a formatted message can be retrieved from
	 *         the message bundle
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * Gets the arguments that complete the reason-code based message.
	 * 
	 * @return An array of arguments
	 */
	public Object[] getArgs() {
		return args;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "CLIStatusException, reason code: " + reasonCode + ", message arguments: "
				+ StringUtils.join(args, ", ");
	}

	public String getVerboseData() {
		return verboseData;
	}
}
