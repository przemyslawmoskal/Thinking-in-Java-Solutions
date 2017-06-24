package ch10ex15;
import static ptmoskal.Print.*;

class MyClass1 {
	int i;
	MyClass1(int i) {
		print("MyClass(" + i + ")");
		this.i = i;
	}
	void test() { print("Hello!"); }
}

public class MyClass2 {
	MyClass1 createMyClass1(int i) {
		return new MyClass1(i) {} ;
	}
	public static void main(String[] args) {
		MyClass2 myclass2obj = new MyClass2();
		myclass2obj.createMyClass1(10).test();
	}

}

/* Output:
MyClass(10)
Hello!
*/
