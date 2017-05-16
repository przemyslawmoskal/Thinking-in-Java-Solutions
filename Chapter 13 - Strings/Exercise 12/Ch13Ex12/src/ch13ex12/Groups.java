package ch13ex12;

import java.util.regex.*;
import static net.mindview.util.Print.*;
import java.util.*;

public class Groups {
  static public final String POEM =
    "Twas brillig, and the slithy toves\n" +
    "Did gyre and gimble in the wabe.\n" +
    "All mimsy were the borogoves,\n" +
    "And the mome raths outgrabe.\n\n" +
    "Beware the Jabberwock, my son,\n" +
    "The jaws that bite, the claws that catch.\n" +
    "Beware the Jubjub bird, and shun\n" +
    "The frumious Bandersnatch.";
  public static void main(String[] args) {
    Matcher m =
      Pattern.compile("(^[a-z]|\\s+[a-z])\\w+")
        .matcher(POEM);
    Set<String> words = new TreeSet<String>();
    while(m.find()) {
    	words.add(m.group());
    }
    print(words);
    print("Number of unique words that do not start with a capital letter: " + words.size());
  }
}

/* Output:
[ and,  bird,  bite,  borogoves,  brillig,  catch,  claws,  frumious,  gimble,  gyre,  in,  jaws,  mimsy,  mome,  my,  outgrabe,  raths,  shun,  slithy,  son,  that,  the,  toves,  wabe,  were]
Number of unique words that do not start with a capital letter: 25
*/