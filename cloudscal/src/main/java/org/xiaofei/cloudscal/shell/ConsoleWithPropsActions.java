package org.xiaofei.cloudscal.shell;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        This interface define two methods to be implemented, regarding the console's prompt text and the
 *        properties to be used.
 */
public interface ConsoleWithPropsActions {

	/**
	 * Gets the prompt to be used in this console. If the current application name is not null - it is
	 * embedded in the prompt.
	 * 
	 * @param currentAppName
	 *            The name of the current application.
	 * @return The prompt string
	 */
	String getPromptInternal(String currentAppName);

	/**
	 * Gets the path to the branding properties of this console.
	 * 
	 * @return The path to the properties file
	 */
	String getBrandingPropertiesResourcePath();

}
