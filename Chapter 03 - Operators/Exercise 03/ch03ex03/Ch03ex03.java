package ch03ex03;
import static ptmoskal.Print.*;

class MyClass {
	float f;
}


public class Ch03ex03 {
	public static void g(MyClass x) {
		x.f = 1000;
	}

	public static void main(String[] args) {
		MyClass obj1 = new MyClass();
		obj1.f = 10;
		print("obj1.f = " + obj1.f);
		g(obj1);
		print("obj1.f = " + obj1.f);

	}

}

/* Output:
obj1.f = 10.0
obj1.f = 1000.0
*/