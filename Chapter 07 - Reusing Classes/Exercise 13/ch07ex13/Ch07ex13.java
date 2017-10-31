package ch07ex13;

/* Create a class with a method that is overloaded three times. Inherit a new 
* class, add a new overloading of the method, and show that all four methods are
* available in the derived class.
* */

class Base {
	public void test() {
		System.out.println("Base.test()");
		
	}
	public void test(int i) {
		System.out.println("Base.test(int i)");
		
	}
	public void test(String s) {
		System.out.println("Base.test(String s)");
		
	}
}

 class Derived extends Base {
	public void test(float f) {
		System.out.println("Derived.test(float f)");
	}
}

public class Ch07ex13 {

	public static void main(String[] args) {
		Derived obj = new Derived();
		obj.test();
		obj.test(2);
		obj.test("Sample string");
		obj.test(2.0f);
		
	}

}

/* Output:
Base.test()
Base.test(int i)
Base.test(String s)
Derived.test(float f)
*/