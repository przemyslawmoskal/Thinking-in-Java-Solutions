package ch13ex10;
import java.util.regex.*;

/*
Args used: "Java now has regular expressions" "^Java" "\Breg.*" "n.w\s+h(a|i)s" "s?" "s*" "s+" "s{4}" "s{1}." "s{0,3}"
*/

public class TestRegularExpression {
  public static void main(String[] args) {
    if(args.length < 2) {
      System.out.println("Usage:\njava TestRegularExpression " +
        "characterSequence regularExpression+");
      System.exit(0);
    }
    System.out.println("Input: \"" + args[0] + "\"");
    for(String arg : args) {
    	System.out.println("Regular expression: \"" + arg + "\"");
      Pattern p = Pattern.compile(arg);
      Matcher m = p.matcher(args[0]);
      if(!m.find()) 
    	  System.out.println("No match found for " + "\"" + arg + "\"");
      m.reset();
      while(m.find()) {
    	  System.out.println("Match \"" + m.group() + "\" at position " +
          m.start() + ((m.end() - m.start() < 2) ? "" : ("-" + (m.end() - 1))));
      }
    }
  }
}

/* Output:
Input: "Java now has regular expressions"
Regular expression: "Java now has regular expressions"
Match "Java now has regular expressions" at position 0-31
Regular expression: "^Java"
Match "Java" at position 0-3
Regular expression: "\Breg.*"
No match found for "\Breg.*"
Regular expression: "n.w\s+h(a|i)s"
Match "now has" at position 5-11
Regular expression: "s?"
Match "" at position 0
Match "" at position 1
Match "" at position 2
Match "" at position 3
Match "" at position 4
Match "" at position 5
Match "" at position 6
Match "" at position 7
Match "" at position 8
Match "" at position 9
Match "" at position 10
Match "s" at position 11
Match "" at position 12
Match "" at position 13
Match "" at position 14
Match "" at position 15
Match "" at position 16
Match "" at position 17
Match "" at position 18
Match "" at position 19
Match "" at position 20
Match "" at position 21
Match "" at position 22
Match "" at position 23
Match "" at position 24
Match "" at position 25
Match "s" at position 26
Match "s" at position 27
Match "" at position 28
Match "" at position 29
Match "" at position 30
Match "s" at position 31
Match "" at position 32
Regular expression: "src"
No match found for "src"
Regular expression: "s+"
Match "s" at position 11
Match "ss" at position 26-27
Match "s" at position 31
Regular expression: "s{4}"
No match found for "s{4}"
Regular expression: "s{1}."
Match "s " at position 11-12
Match "ss" at position 26-27
Regular expression: "s{0,3}"
Match "" at position 0
Match "" at position 1
Match "" at position 2
Match "" at position 3
Match "" at position 4
Match "" at position 5
Match "" at position 6
Match "" at position 7
Match "" at position 8
Match "" at position 9
Match "" at position 10
Match "s" at position 11
Match "" at position 12
Match "" at position 13
Match "" at position 14
Match "" at position 15
Match "" at position 16
Match "" at position 17
Match "" at position 18
Match "" at position 19
Match "" at position 20
Match "" at position 21
Match "" at position 22
Match "" at position 23
Match "" at position 24
Match "" at position 25
Match "ss" at position 26-27
Match "" at position 28
Match "" at position 29
Match "" at position 30
Match "s" at position 31
Match "" at position 32
*/
