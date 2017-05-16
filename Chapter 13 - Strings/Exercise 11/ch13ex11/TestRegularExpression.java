package ch13ex11;
import java.util.regex.*;
import static net.mindview.util.Print.*;

/*
Args used: "Arline ate eight apples and one orange while Anita hadn't any" (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
*/

public class TestRegularExpression {
  public static void main(String[] args) {
    if(args.length < 2) {
      print("Usage:\njava TestRegularExpression " +
        "characterSequence regularExpression+");
      System.exit(0);
    }
    print("Input: \"" + args[0] + "\"");
    for(String arg : args) {
      print("Regular expression: \"" + arg + "\"");
      Pattern p = Pattern.compile(arg);
      Matcher m = p.matcher(args[0]);
      if(!m.find()) {
    	  print("Nothing found for " + "\"" + arg + "\"");
      }
      m.reset();
      while(m.find()) {
        print("Match \"" + m.group() + "\" at position " +
          m.start() + ((m.end() - m.start() < 2) ? "" : ("-" + (m.end() - 1))));
      }
    }
  }
}

/* Output:
Input: "Arline ate eight apples and one orange while Anita hadn't any"
Regular expression: "Arline ate eight apples and one orange while Anita hadn't any"
Match "Arline ate eight apples and one orange while Anita hadn't any" at position 0-60
Regular expression: "(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"
Match "Arline" at position 0-5
Match " ate" at position 6-9
Match " one" at position 27-30
Match " orange" at position 31-37
Match " Anita" at position 44-49
*/