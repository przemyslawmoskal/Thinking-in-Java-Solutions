import java.util.regex.*;
import net.mindview.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.io.*;

// args: {JGrep.java "\b[Ssct]\w++"}

public class JGrep {
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		String filename = "src\\" + args[0];
		FileChannel fc = new FileInputStream(filename).getChannel();
		MappedByteBuffer in = fc.map(FileChannel.MapMode.READ_ONLY, 0, new File(filename).length());
		// Decoding bytes to chars and creating array of lines of file:
		String[] lines = Charset.forName(System.getProperty("file.encoding")).decode(in).toString().split("\n");
		Pattern p = Pattern.compile(args[1]);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher("");
		for (String line : lines) {
			m.reset(line);
			while (m.find())
				System.out.println(index++ + ": " + m.group() + ": " + m.start());
		}
		fc.close();
	}
}

/* Output:
0: channels: 16
1: charset: 16
2: class: 7
3: static: 8
4: String: 25
5: throws: 40
6: System: 3
7: System: 3
8: String: 2
9: src: 21
10: to: 20
11: chars: 23
12: creating: 33
13: String: 2
14: System: 35
15: toString: 83
16: split: 94
17: compile: 22
18: through: 13
19: the: 21
20: the: 34
21: String: 7
22: System: 4
23: start: 61
24: close: 5
25: Sample: 13
26: strings: 24
27: simple: 38
28: the: 52
29: Ssct: 63
30: class: 4
31: static: 16
32: String: 29
33: throws: 43
34: System: 57
35: System: 70
36: compile: 10
37: through: 26
38: the: 42
39: the: 54
40: String: 66
41: System: 8
42: start: 22
*/
