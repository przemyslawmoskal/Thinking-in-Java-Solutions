import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class SortedDirList {
	private String[] list;

	SortedDirList(File filepath) {
		this.list = filepath.list();
		Arrays.sort(this.list, String.CASE_INSENSITIVE_ORDER);
	}

	public String[] list() {
		return list;
	}

	public String[] list(String regex) {
		List<String> matchingFiles = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		for (String s : list) {
			if (p.matcher(s).matches()) {
				matchingFiles.add(s);
			}
		}
		return matchingFiles.toArray(new String[matchingFiles.size()]);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s + "\n");
		}
		return sb.toString();
	}

}

public class Ch18ex02 {

	public static void main(String[] args) {
		SortedDirList sdl = new SortedDirList(new File(".\\\\src"));

		System.out.println(sdl);

		for (String s : sdl.list()) {
			System.out.println(s);
		}
		System.out.println();

		for (String s : sdl.list("Ch.*")) {
			System.out.println(s);
		}

	}

}

/* Output:
Ch18ex02.java
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java

Ch18ex02.java
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java

Ch18ex02.java
*/
