package ch17ex04;
import java.util.*;
import net.mindview.util.*;

public class Ch17ex04 {
	public static Collection<String> showWords(String filename) {
		Set<String> words = new TreeSet<String>(new TextFile(filename, "\\W++"));
		return words;
	}

	public static void main(String[] args) {
		System.out.println(showWords("Ch17ex04.java"));
	}

}

/* Output:
[Arrays, Ch17ex04, Collection, String, System, TextFile, args, arr, asList, ch17ex04, class, createColl, import, java, main, mindview, name, net, out, package, println, public, read, return, split, static, util, void]
*/