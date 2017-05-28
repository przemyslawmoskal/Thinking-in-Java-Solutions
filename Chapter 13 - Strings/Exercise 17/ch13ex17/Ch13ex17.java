package ch13ex17;
// { Args used: Ch13ex17.java }
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.mindview.util.TextFile;
/* Comment 1 */

public class Ch13ex17 {
// Comment 2
	public static void main(String[] args) throws Exception {
		/* Comment 3
		 * ...
		 * ...
		 * ...
		*/
		if(args.length < 1) {
			System.out.println("Usage: java Ch13ex17 file");
			System.exit(0); // Comment 4
		}
		String s = TextFile.read(args[0]);
		int index = 1;
		Matcher m = Pattern.compile("(/\\*([^*]|[\r\n]|(\\*+([^*/]|[\r\n])))*\\*+/)|(//.*)").matcher(s);
		/**** Comment 5 ****/
		while(m.find()) {
			System.out.println(index++ + ". " + m.group());
			System.out.println();
		}
	}
}

//  Output:
//	1. // { Args used: Ch13ex17.java }
//
//	2. /* Comment 1 */
//
//	3. // Comment 2
//
//	4. /* Comment 3
//			 * ...
//			 * ...
//			 * ...
//			*/
//
//	5. // Comment 4
//
//	6. //.*)").matcher(s);
//
//	7. /**** Comment 5 ****/

