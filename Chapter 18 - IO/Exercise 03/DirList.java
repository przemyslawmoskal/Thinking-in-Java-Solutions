import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList {
	public static void main(String[] args) {
		File path = new File("src\\");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFilter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		long size = 0;
		for (String dirItem : list) {
			System.out.format("%-45s", dirItem);
			File f = new File(path, dirItem);
			System.out.format(" [size: " + "%25s"  + "]\n", f.length());
			size += f.length();
		}
		System.out.format("%-45s %32s", "Total size:", size);
			
		
	}
}

class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}

/* Output:
DirectoryDemo.java                            [size:                      1011]
DirList.java                                  [size:                      1316]
DirList2.java                                 [size:                       942]
DirList3.java                                 [size:                       807]
Total size:                                                               4076
*/
