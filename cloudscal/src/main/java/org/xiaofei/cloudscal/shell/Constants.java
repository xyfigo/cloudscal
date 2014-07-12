package org.xiaofei.cloudscal.shell;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        Constant values to be used for CLI configuration or implementation.
 */
public final class Constants {

	private Constants() {
	}

	/**
	 * The key to the admin facade setting on the console's command session.
	 */
	public static final String ADMIN_FACADE = "gsAdminFacade";

	/**
	 * The key to the recipes setting on the console's command session.
	 */

	public static final String RECIPES = "gsRecipes";
	/**
	 * The property holding the current application.
	 */
	public static final String ACTIVE_APP = "current.application";

	/**
	 * The property holding the interactive mode.
	 */
	public static final String INTERACTIVE_MODE = "interactive.mode";

	/**
	 * The property holding the last command exception.
	 */
	public static final String LAST_COMMAND_EXCEPTION = "last.command.exception";

	/**
	 * The property holding the proxy configuration.
	 */
	public static final String ENABLE_PROXY_CONFIGURATION_PROPERTY = "org.cloudifysource.cli.proxy.enable";

}
