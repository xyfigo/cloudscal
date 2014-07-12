package org.xiaofei.cloudscal.shell.exceptions;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        Represents exceptions in the scope of the command line interface.
 *        This exception is mainly used for error on the client side.
 */
public class CLIException extends Exception {

	private static final long serialVersionUID = 1295396747968774683L;
    private String verbose;

    public String getVerbose() {
        return verbose;
    }

    /**
	 * Empty Construction.
	 */
	public CLIException() {
	}

	/**
	 * Constructor.
	 * @param message A detailed message about the exception
	 */
	public CLIException(final String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * @param cause The Throwable that caused this exception to be thrown.
	 */
	public CLIException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 * @param message A detailed message about the exception
	 * @param cause The Throwable that caused this exception to be thrown.
	 */
	public CLIException(final String message, final Throwable cause) {
		super(message, cause);
	}

    /**
     * Constructor.
     * @param message A detailed message about the exception
     * @param cause The Throwable that caused this exception to be thrown.
     */
    public CLIException(final String message, final Throwable cause, final String verbose) {
        super(message, cause);
        this.verbose = verbose;
    }


}
