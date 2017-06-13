package ch10ex05;
import static ptmoskal.Print.*;

class Outer {
	Outer() { print("Outer"); }
	class Inner {
		Inner() { print("Inner"); }
	}
}

public class Ch10ex05 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
	}

}

/* Output:
Outer
Inner
*/