package org.xiaofei.cloudscal.shell;

import org.apache.felix.service.command.CommandSession;

/**
 * @author xiaofei
 * since 2.0.0
 * A callback for the console ( {@link ConsoleWithProps} )
 */
class CloseCallback implements Runnable {

	private CommandSession session;

	/**
	 * {@inheritDoc}
	 */
	
	public void run() {
		final AdminFacade adminFacade = (AdminFacade) session.get(Constants.ADMIN_FACADE);
		try {
			//disconnects from the server
			//adminFacade.disconnect();

			if (session.get(Constants.INTERACTIVE_MODE) != null) {
				final boolean isInteractive = (Boolean) session.get(Constants.INTERACTIVE_MODE);
				if (!isInteractive) {
					//if an exception was thrown and this is not an interactive mode - exit with code "1"
					if (session.get(Constants.LAST_COMMAND_EXCEPTION) != null) {
						// Throwable t = (Throwable) session.get(Constants.LAST_COMMAND_EXCEPTION);
						System.exit(1);
					}
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void setSession(final CommandSession session) {
		this.session = session;
	}
}
