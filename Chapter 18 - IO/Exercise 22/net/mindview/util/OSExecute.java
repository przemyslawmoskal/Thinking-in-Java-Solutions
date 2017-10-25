package net.mindview.util;

import java.io.*;
import java.util.*;

public class OSExecute {
	public static List<String> command(String command) {
		boolean err = false;
		List<String> list = new ArrayList<String>();
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while ((s = results.readLine()) != null)
				list.add(s);
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			// Report errors and return nonzero value
			// to calling process if there are problems:
			while ((s = errors.readLine()) != null) {
				list.add(s);
				err = true;
			}
			return list;
		} catch (Exception e) {
			// Compensate for Windows 2000, which throws an
			// exception for the default command line:
			if (!command.startsWith("CMD /C"))
				command("CMD /C" + command);
			else
				throw new RuntimeException(e);
		}
		if (err)
			throw new OSExecuteException("Errors executing " + command);
		return null;
	}
} /// :~
