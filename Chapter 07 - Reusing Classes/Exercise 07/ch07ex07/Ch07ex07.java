package ch07ex07;
import static ptmoskal.Print.*;

class A {
	A(int i) { print("A(" + i + ")"); }
}

class B {
	B(String s) { print("B(" + s + ")"); }
}

class C extends A {
	C(int i, String s) {
		super(i);
		b = new B(s);
	}
	B b;
}

public class Ch07ex07 {

	public static void main(String[] args) {
		C c = new C(8,"sixteen");
	}

}

/* Output:
A(8)
B(sixteen)
*/