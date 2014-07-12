package org.xiaofei.cloudscal.shell;

/**
 * @author xiaofei
 * @since 2.0.0
 * 
 *        An implementation of {@link ConsoleWithPropsActions}, to be used on an non-interactive console.
 */
public class ConsoleWithPropsNonInteractive implements ConsoleWithPropsActions {

	/**
	 * {@inheritDoc}
	 */
	
	public String getPromptInternal(final String currentAppName) {
		return ">>> ";
	}

	/**
	 * {@inheritDoc}
	 */
	
	public String getBrandingPropertiesResourcePath() {
		return "META-INF/shell/noninteractive.branding.properties";
	}

}