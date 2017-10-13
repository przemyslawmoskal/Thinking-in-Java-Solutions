import java.io.*;
import net.mindview.util.*;

public class Ch18ex04 {

	public static void main(String[] args) {
		long totalSize = 0;
		if(args.length == 0) {
			System.out.println("All files:");
			for(File f : Directory.walk("src\\").files) {
				System.out.println("\t" + f + " [size: " + f.length() + "]");
				totalSize += f.length();
			}
			System.out.println("Total size: " + totalSize);
		}
		else {
			for(String arg : args) {
				System.out.println("Searching for \"" + arg + "\":");
				for(File f : Directory.walk("src\\", arg).files) {
					System.out.println("\t" + f + " [size: " + f.length() + "]");
					totalSize += f.length();
				}
			}
			System.out.println("Total size: " + totalSize);
		}
		
	}

}

/* Output:
Searching for "Dir.*.java":
	src\DirectoryDemo.java [size: 1021]
	src\DirList.java [size: 877]
	src\DirList2.java [size: 942]
	src\DirList3.java [size: 807]
Total size: 3647
*/