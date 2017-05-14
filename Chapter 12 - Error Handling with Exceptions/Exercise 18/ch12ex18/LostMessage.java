package ch12ex18;

class VeryImportantException extends Exception {
  public String toString() {
    return "A very important exception!";
  }
}

class HoHumException extends Exception {
  public String toString() {
    return "A trivial exception";
  }
}

class MostTrivialException extends Exception {
	public String toString() {
		return "A most trivial exception";
	}
}

public class LostMessage {
  void f() throws VeryImportantException {
    throw new VeryImportantException();
  }
  void g() throws MostTrivialException {
	  throw new MostTrivialException();
  }
  void dispose() throws HoHumException {
    throw new HoHumException();
  }
  public static void main(String[] args) {
    try {
      LostMessage lm = new LostMessage();
      try {
        try {
        	lm.f();
        	lm.dispose();
        } finally {
        	lm.g();
        }
      } catch(Exception e) {
    	  System.out.println(e);
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}

/* Output:
A most trivial exception
*/
