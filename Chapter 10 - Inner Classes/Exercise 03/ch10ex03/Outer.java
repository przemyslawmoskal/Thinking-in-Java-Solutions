package ch10ex03;
import static ptmoskal.Print.*;

public class Outer {
	private String s;
	Outer(String s) {
		print("Outer()");
		this.s = s;
	}
	class Inner {
		Inner() { print("Inner()"); }
		public String toString() {
			return s;
		}
	}
	Inner createInner() {
		return new Inner();
	}
	public static void main(String[] args) {
		Outer o = new Outer("Hello");
		Inner i = o.createInner();
		System.out.println(i);
	}
	
}

/* Output:
Outer()
Inner()
Hello
*/