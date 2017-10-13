package net.mindview.util;

import java.io.*;
import java.text.*;
import java.util.*;

public class ProcessFiles {
	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String ext;

	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}

	public void start(String[] args) {
		try {
			if (args.length == 0)
				processDirectoryTree(new File("."));
			else
				for (String arg : args) {
					File fileArg = new File(arg);
					if (fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						// Allow user to leave off extension:
						if (!arg.endsWith("." + ext))
							arg += "." + ext;
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext))
			strategy.process(file.getCanonicalFile());
	}

	// Demonstration of how to use it:
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage: directory date(mm/dd/yyyy)");
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		new ProcessFiles(new ProcessFiles.Strategy() {
			public void process(File file) {
				Date modificationDate = new Date(file.lastModified());
				try {
					if(modificationDate.after(dateFormat.parse(args[1])))
						System.out.println(file);
				}catch(ParseException e) {
					System.out.println(e.getMessage());
				}
			}
		}, "java").start(args);
	}
}

/*
(Execute to see output)
*/