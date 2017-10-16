import java.util.*;
import java.io.*;

public class Ch18ex07 {

	public static String readAndReverseLines(String filename) throws IOException {
		LinkedList<String> ll = new LinkedList<String>();
		BufferedReader in = new BufferedReader(new FileReader(new File("src\\" + filename)));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			ll.add(s);
		ListIterator<String> it = ll.listIterator(ll.size());
		while(it.hasPrevious())
			System.out.println(it.previous());
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		readAndReverseLines("Ch18ex07.java");
	}

}

/* Output:
}

	}
		readAndReverseLines("Ch18ex07.java");
	public static void main(String[] args) throws IOException {
	}
		return sb.toString();
		in.close();
			System.out.println(it.previous());
		while(it.hasPrevious())
		ListIterator<String> it = ll.listIterator(ll.size());
			ll.add(s);
		while((s = in.readLine()) != null)
		StringBuilder sb = new StringBuilder();
		String s;
		BufferedReader in = new BufferedReader(new FileReader(new File("src\\" + filename)));
		LinkedList<String> ll = new LinkedList<String>();
	public static String readAndReverseLines(String filename) throws IOException {

public class Ch18ex07 {

import java.io.*;
import java.util.*;

*/