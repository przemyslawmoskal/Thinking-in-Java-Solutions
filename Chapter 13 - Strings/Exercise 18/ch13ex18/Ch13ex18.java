package ch13ex18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.mindview.util.TextFile;

public class Ch13ex18 {

	public static void main(String[] args) {
		if(args.length <1 ) {
			System.out.println("Usage: java Ch13ex18 fileName");
			System.exit(0);
		}
		String s = TextFile.read(args[0]);
		int index = 1;
		Matcher m = Pattern.compile("\"(.*)\"").matcher(s);
		while(m.find()) {
			System.out.println(index++ + ". " + m.group(1));
			System.out.println();
		}
	}
}

/* Output:
1. Usage: java Ch13ex18 file

2. \"(.*)\"

3. . 
*/