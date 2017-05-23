package ch13ex16;

//{Args to use: file name/folder name "regular expression"}
import java.io.File;
import java.util.regex.*;
import net.mindview.util.*;

public class JGrep {
	public static String regex;
	public static void searchForFiles(String directoryName) {
		File[] fileList = new File(directoryName).listFiles();
		for(File file : fileList) {
			if(file.isFile()) {
				String filePath = file.getPath();
				System.out.println(filePath + " : ");
				Pattern p = Pattern.compile(regex);
				int index = 0;
				Matcher m = p.matcher("");
				for(String line : new TextFile(filePath)) {
					m.reset(line);
					while(m.find())
						System.out.println(index++ + ": " + m.group() + ": " + m.start());
				}
				
				} else if(file.isDirectory()) {
					searchForFiles(file.getPath());
		    	}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		if(args.length < 2) {
			System.out.println("Usage: java JGrep file/folder regex");
			System.exit(0);
			}
		regex = args[1];
		if(new File(args[0]).listFiles() == null) {
			System.out.println("No such file/directory: " + args[0]);
			System.exit(0);
		}
		System.out.println("Searching for files in " + args[0] + "...");
		System.out.println("Regular expression: " + regex);
		System.out.println("********************");
		System.out.println();
		searchForFiles(args[0]);
	}
}

/* Output:
*/
