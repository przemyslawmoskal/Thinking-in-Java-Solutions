package ch10ex20;
import static ptmoskal.Print.*;

interface MyInterface {
	static class Nested {
		Nested() { print("Nested()"); }
		int i = 128;
		void showI() { print("i = " + i); }
	}
}

public class Ch10ex20 {

	public static void main(String[] args) {
		MyInterface.Nested s = new MyInterface.Nested();
		s.showI();
	}

}

/* Output:
Nested()
i = 128
*/