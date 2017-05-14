package ch12ex14;
import static net.mindview.util.Print.*;

public class OnOffSwitch {
  private static Switch sw = new Switch();
  static Integer[] integers = new Integer[2];
  public static void f() throws OnOffException1,OnOffException2 {}
  public static void main(String[] args) {
    try {
      sw.on();
      print();
      // Code that can throw exceptions...
      f();
      // Code that throws RuntimeException, switch is left on:
      print(integers[2]);
      sw.off();
    } catch(OnOffException1 e) {
      System.out.println("OnOffException1");
      sw.off();
    } catch(OnOffException2 e) {
      System.out.println("OnOffException2");
      sw.off();
    }
  }
}

/* Output:
on

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
	at ch12ex14.OnOffSwitch.main(OnOffSwitch.java:16)
*/