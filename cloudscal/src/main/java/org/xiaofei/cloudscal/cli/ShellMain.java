package org.xiaofei.cloudscal.cli;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import org.apache.felix.gogo.commands.Action;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.service.command.CommandSession;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.Main;

/**
 * 
 * @author xiaof
 *
 *Extends the Karaf framework Main object to start the shell/console.
 */
@Command(name = "cloudscal", scope = "cloudscal", description = "Executes a cloudscal command interpreter")
public class ShellMain extends Main implements Action {

	private static final String EXIT_COMMAND = "exit\n";
	private static ShellMain instance;
	//private ConsoleWithProps console;
	private final boolean isInteractive;
	
	@Argument(name = "args", description = "Cloudify sub command arguments", multiValued = true)
	private String[] args;
	
	/**
	 * This is the shell's main method. It starts the shell, sets the logging configurations, and the proxy if
	 * configured. Arguments, if passed, are expected in 1 of these 2 formats: -f <file_name> OR <command 1>;<command
	 * 2>;<command 3>;.... Passing commands set the interactive mode off.
	 *
	 * @param args
	 *            The commands to be executed, either in a file or as a list.
	 * @throws Exception
	 *             Reporting a failure to start the shell or execute the commands
	 */
	public static void main(final String[] args)
			throws Exception {
		String[] actualArgs = args;
		initializeLogConfiguration();

		initializeProxyConfiguration();
		InputStream is = null;
		SequenceInputStream sis = null;
		final InputStream exitInputStream = new ByteArrayInputStream(EXIT_COMMAND.getBytes());
		boolean isInteractive = true;

		try {
			if (args.length > 0) {

				isInteractive = false;

				if (args[0].startsWith("-f=")) {
					final String filename = args[0].substring("-f=".length());
					final File file = new File(filename);
					if (!file.exists()) {
						throw new IllegalArgumentException(filename + " does not exist");
					}

					is = new FileInputStream(filename);
				} else {
					String commandString = "";
					for (String arg : args) {
						commandString = commandString.concat(arg + " ");
					}
					if (!commandString.endsWith(";")) {
						commandString = commandString.concat(";");
					}
					commandString = commandString.replace(";", System.getProperty("line.separator"));

					is = new ByteArrayInputStream(commandString.getBytes("UTF-8"));
				}

				sis = new SequenceInputStream(is, exitInputStream);
				System.setIn(sis);
				actualArgs = new String[0];

			}

			instance = new GigaShellMain(isInteractive);
			instance.setApplication("cloudify");
			Ansi.ansi();

			instance.run(actualArgs);
		} finally {
			if (is != null) {
				is.close();
			}
			if (sis != null) {
				sis.close();
			}
			exitInputStream.close();
		}
	}
	
	private static void initializeLogConfiguration() {

		// Replace the console Handler's formatter.
		final Handler[] handlers = Logger.getLogger("").getHandlers();
		for (final Handler handler : handlers) {
			if (handler.getClass().getName().equals(ConsoleHandler.class.getName())) {
				handler.setFormatter(new ShellFormatter());
				handler.setErrorManager(new ShellErrorManager());
				handler.setLevel(Level.INFO);
				break;
			}
		}

		// block info printouts from specific internal components.
		for (final String loggerName : BLOCKED_LOGGERS) {
			Logger.getLogger(loggerName).setLevel(Level.WARNING);
		}
	}
	
	public Object execute(CommandSession session) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
