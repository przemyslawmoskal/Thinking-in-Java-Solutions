// Using protected methods in the same package is allowed

package packagea;

public class ClassB {

	public static void main(String[] args) {
		ClassA obj = new ClassA();
		obj.f();
	}

}

/* Output:
ClassA()
ClassA.f()
*/