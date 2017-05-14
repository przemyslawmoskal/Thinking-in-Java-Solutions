package ch12ex15;
import static net.mindview.util.Print.*;

public class WithFinally {
  static Switch sw = new Switch();
  static Integer[] integers = new Integer[2];
  public static void main(String[] args) {
    try {
      sw.on();
      // Code that can throw exceptions...
      OnOffSwitch.f();
      // Code that throws RuntimeException, switch is left off:
      print(integers[2]);
    } catch(OnOffException1 e) {
      System.out.println("OnOffException1");
    } catch(OnOffException2 e) {
      System.out.println("OnOffException2");
    } finally {
      sw.off();
    }
  }
}

/* Output:
on
off
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
	at ch12ex15.WithFinally.main(WithFinally.java:12)
*/
