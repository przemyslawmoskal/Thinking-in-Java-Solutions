package ch13ex13;
import java.util.regex.*;
import static net.mindview.util.Print.*;

public class StartEnd {
  public static final String POEM =
	"Twas brillig, and the slithy toves\n" +
	"Did gyre and gimble in the wabe.\n" +
	"All mimsy were the borogoves,\n" +
	"And the mome raths outgrabe.\n\n" +
	"Beware the Jabberwock, my son,\n" +
	"The jaws that bite, the claws that catch.\n" +
	"Beware the Jubjub bird, and shun\n" +
	"The frumious Bandersnatch.";
  private static class Display {
    private boolean regexPrinted = false;
    private String regex;
    Display(String regex) { this.regex = regex; }
    void display(String message) {
      if(!regexPrinted) {
        print(regex);
        regexPrinted = true;
      }
      print(message);
    }
  }
  static void examine(String s, String regex) {
    Display d = new Display(regex);
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(s);
    while(m.find())
      d.display("find() '" + m.group() +
        "' start = "+ m.start() + " end = " + m.end());
    if(m.lookingAt())
      d.display("lookingAt() start = "
        + m.start() + " end = " + m.end());
    if(m.matches())
      d.display("matches() start = "
        + m.start() + " end = " + m.end());
  }
  public static void main(String[] args) {
    for(String in : POEM.split("\n")) {
      print("input : " + in);
      for(String regex : new String[]{"\\w*ar\\w*",
        "\b[A-Z].b\\w+", "T\\w+", "All.*"})
        examine(in, regex);
    }
  }
}

/* Output:
input : Twas brillig, and the slithy toves
T\w+
find() 'Twas' start = 0 end = 4
lookingAt() start = 0 end = 4
input : Did gyre and gimble in the wabe.
input : All mimsy were the borogoves,
All.*
find() 'All mimsy were the borogoves,' start = 0 end = 29
lookingAt() start = 0 end = 29
matches() start = 0 end = 29
input : And the mome raths outgrabe.
input : 
input : Beware the Jabberwock, my son,
\w*ar\w*
find() 'Beware' start = 0 end = 6
lookingAt() start = 0 end = 6
input : The jaws that bite, the claws that catch.
T\w+
find() 'The' start = 0 end = 3
lookingAt() start = 0 end = 3
input : Beware the Jubjub bird, and shun
\w*ar\w*
find() 'Beware' start = 0 end = 6
lookingAt() start = 0 end = 6
input : The frumious Bandersnatch.
T\w+
find() 'The' start = 0 end = 3
lookingAt() start = 0 end = 3
*/