package ch13ex08;
import java.util.*;

public class Splitting {
  public static String knights =
    "Then, when you have found the shrubbery, you must " +
    "cut down the mightiest tree in the forest... " +
    "with... a herring!";
  public static void split(String regex) {
    System.out.println(
      Arrays.toString(knights.split(regex)));
  }
  public static void main(String[] args) {
    split("the|you");
  }
}

/* Output:
[Then, when ,  have found ,  shrubbery, ,  must cut down ,  mightiest tree in ,  forest... with... a herring!]
*/