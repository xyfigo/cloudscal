package org.xiaofei.cloudscal.shell;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        An implementation of {@link ConsoleWithPropsActions}, to be used on an interactive console.
 */
public class ConsoleWithPropsInteractive implements ConsoleWithPropsActions {

	/**
	 * {@inheritDoc}
	 */
	
	public String getPromptInternal(final String currentAppName) {
		return "\u001B[1mcloudify" + (currentAppName != null ? "@" + currentAppName : "") + "> \u001B[0m";
	}

	/**
	 * {@inheritDoc}
	 */
	
	public String getBrandingPropertiesResourcePath() {
		return "META-INF/shell/branding.properties";
	}

}