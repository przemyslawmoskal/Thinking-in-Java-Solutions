package ch10ex01;
import static ptmoskal.Print.*;

public class Outer {
	
	Outer() { print("Outer()"); }
	class Inner {
		Inner() { print("Inner()"); }
	}
	Inner createInner() {
		return new Inner();
	}
	public static void main(String[] args) {
		Outer o = new Outer();
		Inner i = o.createInner();
	}
	
}

/* Output:
Outer()
Inner()
*/