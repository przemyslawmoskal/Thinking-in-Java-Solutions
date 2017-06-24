package ch10ex18;
import static ptmoskal.Print.*;

public class Ch10ex18 {
	private static class Nested {
		Nested() { print("Nested()"); }
		public void test() { print("Nested.test()"); }
		
	}
	
	public static void main(String[] args) {
		Nested obj = new Nested();
		obj.test();
	}

}

/* Output:
Nested()
Nested.test()
*/