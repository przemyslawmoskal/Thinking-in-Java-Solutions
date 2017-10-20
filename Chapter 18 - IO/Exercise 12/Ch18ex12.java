import java.util.*;
import java.io.*;

// args: { Ch18ex12.java }

public class Ch18ex12 {
	public static String readAndReverseLines(String filename) throws IOException {
		LinkedList<String> ll = new LinkedList<String>();
		BufferedReader in = new BufferedReader(new FileReader(new File("src\\" + filename)));
		String s;
		StringBuilder sb = new StringBuilder();
		String[] nameAndExtension = filename.split("\\.");
		File reversedFile = new File("src\\" + nameAndExtension[0] + "Reversed." + nameAndExtension[1]);
		PrintWriter out = new PrintWriter(reversedFile);
		int lineCount = 1;
		while((s = in.readLine()) != null) {
			ll.add(lineCount++ + ": " + s);
		}
		ListIterator<String> it = ll.listIterator(ll.size());
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		it = ll.listIterator(ll.size());
		while(it.hasPrevious()) {
			String t = it.previous();
			out.println(t);
			sb.append(t + "\n");
		}
		in.close();
		out.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			System.out.println("Usage: Enter file name.");
			System.exit(0);
		}
		readAndReverseLines(args[0]);
	}

}

/* Output:
42: }
41: 
40: 	}
39: 		readAndReverseLines(args[0]);
38: 		}
37: 			System.exit(0);
36: 			System.out.println("Usage: Enter file name.");
35: 		if(args.length != 1) {
34: 	public static void main(String[] args) throws IOException {
33: 
32: 	}
31: 		return sb.toString();
30: 		out.close();
29: 		in.close();
28: 		}
27: 			sb.append(t + "\n");
26: 			out.println(t);
25: 			String t = it.previous();
24: 		while(it.hasPrevious()) {
23: 		it = ll.listIterator(ll.size());
22: 		}
21: 			System.out.println(it.previous());
20: 		while(it.hasPrevious()) {
19: 		ListIterator<String> it = ll.listIterator(ll.size());
18: 		}
17: 			ll.add(lineCount++ + ": " + s);
16: 		while((s = in.readLine()) != null) {
15: 		int lineCount = 1;
14: 		PrintWriter out = new PrintWriter(reversedFile);
13: 		File reversedFile = new File("src\\" + nameAndExtension[0] + "Reversed." + nameAndExtension[1]);
12: 		String[] nameAndExtension = filename.split("\\.");
11: 		StringBuilder sb = new StringBuilder();
10: 		String s;
9: 		BufferedReader in = new BufferedReader(new FileReader(new File("src\\" + filename)));
8: 		LinkedList<String> ll = new LinkedList<String>();
7: 	public static String readAndReverseLines(String filename) throws IOException {
6: public class Ch18ex12 {
5: 
4: // args: { Ch18ex12.java }
3: 
2: import java.io.*;
1: import java.util.*;
*/
