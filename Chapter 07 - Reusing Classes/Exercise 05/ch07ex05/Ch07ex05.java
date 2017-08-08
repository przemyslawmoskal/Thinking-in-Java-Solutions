package ch07ex05;
import static ptmoskal.Print.*;

class A {
	A() { print("A()"); }
}

class B {
	B() { print("B()"); }
}

class C extends A {
	B b = new B();
}

public class Ch07ex05 {

	public static void main(String[] args) {
		C c = new C();
		// First: Class A constructor, second: class B constructor;
		
	}

}

/* Output:
A()
B()
*/