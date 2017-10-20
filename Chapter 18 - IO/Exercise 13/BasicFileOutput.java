
//: io/BasicFileOutput.java
import java.io.*;

public class BasicFileOutput {
	static String file = "src\\BasicFileOutput.txt";

	public static void main(String[] args) throws IOException {
		LineNumberReader in = new LineNumberReader(new BufferedReader(new FileReader("src\\BasicFileOutput.java")));
		PrintWriter out = new PrintWriter(file);
		String s;
		while ((s = in.readLine()) != null)
			out.println(in.getLineNumber() + ": " + s);
		in.close();
		out.close();
		// Show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}
}

/* Output:
1: 
2: //: io/BasicFileOutput.java
3: import java.io.*;
4: 
5: public class BasicFileOutput {
6: 	static String file = "src\\BasicFileOutput.txt";
7: 
8: 	public static void main(String[] args) throws IOException {
9: 		LineNumberReader in = new LineNumberReader(new BufferedReader(new FileReader("src\\BasicFileOutput.java")));
10: 		PrintWriter out = new PrintWriter(file);
11: 		String s;
12: 		while ((s = in.readLine()) != null)
13: 			out.println(in.getLineNumber() + ": " + s);
14: 		in.close();
15: 		out.close();
16: 		// Show the stored file:
17: 		System.out.println(BufferedInputFile.read(file));
18: 	}
19: }
20: 
*/