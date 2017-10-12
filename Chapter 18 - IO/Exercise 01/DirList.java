// { args: Dir.* }

import java.util.regex.*;
import java.io.*;
import java.util.*;
import net.mindview.util.TextFile;

public class DirList {
	public static void main(String[] args) {
		File path = new File("src\\");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFilter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}
}

class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name) {
		Set<String> words = new HashSet<String>();
		TextFile tf = new TextFile(dir.getAbsolutePath().toString() + "\\" + name, "\\W++");
		for(String s : tf) {
			words.add(s);
		}
		for(String s : words) {
			if(pattern.matcher(s).matches()) {
				return true;
			}
		}
		return false;
	}
}

/* Output:
DirectoryDemo.java
DirList.java
*/