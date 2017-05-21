package ch13ex15;
// { Args used: JGrep.java "\b[sct]\w++" "Pattern.CASE_INSENSITIVE" }
import java.util.regex.*;
import net.mindview.util.*;

public class JGrep {
  public static void main(String[] args) throws Exception {
    if(args.length < 3) {
      System.out.println("Usage: java JGrep file regex flag");
      System.exit(0);
    }
    int flag = 0;
    if(args[2].equals("Pattern.CANON_EQ"))
    	flag = Pattern.CANON_EQ;
    else if(args[2].equals("Pattern.CASE_INSENSITIVE"))
    	flag = Pattern.CASE_INSENSITIVE;
    else if(args[2].equals("Pattern.COMMENTS"))
    	flag = Pattern.COMMENTS;
    else if(args[2].equals("Pattern.DOTALL"))
    	flag = Pattern.DOTALL;
    else if(args[2].equals("Pattern.LITERAL"))
    	flag = Pattern.LITERAL;
    else if(args[2].equals("Pattern.MULTILINE"))
    	flag = Pattern.MULTILINE;
    else if(args[2].equals("Pattern.UNICODE_CASE"))
    	flag = Pattern.UNICODE_CASE;
    else if(args[2].equals("Pattern.UNIX_LINES"))
    	flag = Pattern.UNIX_LINES;
    Pattern p = Pattern.compile(args[1], flag);
    int index = 0;
    Matcher m = p.matcher("");
    for(String line : new TextFile(args[0])) {
    	m.reset(line);
    	while(m.find())
    		System.out.println(index++ + ": " +
    			m.group() + ": " + m.start());
    }
    
  }
}
  
  
/* Output:
0: ch13ex15: 8
1: Ssct: 26
2: class: 7
3: static: 9
4: String: 26
5: throws: 41
6: System: 6
7: System: 6
8: CANON_EQ: 31
9: CANON_EQ: 20
10: CASE_INSENSITIVE: 36
11: CASE_INSENSITIVE: 20
12: COMMENTS: 36
13: COMMENTS: 20
14: compile: 24
15: String: 8
16: TextFile: 26
17: System: 6
18: start: 28
19: Sample: 14
20: strings: 3
21: simple: 3
22: the: 3
23: Ssct: 3
24: class: 3
25: static: 3
26: String: 3
27: throws: 3
28: System: 3
29: System: 3
30: compile: 4
31: through: 4
32: the: 4
33: the: 4
34: String: 4
35: System: 4
36: start: 4
*/
