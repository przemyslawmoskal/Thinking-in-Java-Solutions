// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.
package ch12ex29;

class BaseballException extends RuntimeException {}
class Foul extends RuntimeException {}
class Strike extends RuntimeException {}

abstract class Inning {
  public Inning() {}
  public void event() {}
  public abstract void atBat();
  public void walk() {}
}

class StormException extends RuntimeException {}
class RainedOut extends RuntimeException {}
class PopFoul extends RuntimeException {}

interface Storm {
  public void event();
  public void rainHard();
}

public class StormyInning extends Inning implements Storm {
  public StormyInning() {}
  public StormyInning(String s) {}
  public void walk() {}
  public void event() {}
  public void rainHard() {}
  public void atBat() {}
  public static void main(String[] args) {
      StormyInning si = new StormyInning();
      si.atBat();
      // What happens if you upcast?
      Inning i = new StormyInning();
      i.atBat();
  }
}

/* Output:
*/
