package ch03ex02;
import static ptmoskal.Print.*;

class MyClass {
	float f;
}


public class Ch03ex02 {

	public static void main(String[] args) {
		MyClass obj1 = new MyClass();
		MyClass obj2 = new MyClass();
		print("obj1.f = " + obj1.f);
		print("obj2.f = " + obj2.f);
		print();
		obj1.f = 5;
		obj2.f = 10;
		print("obj1.f = " + obj1.f);
		print("obj2.f = " + obj2.f);
		print();
		obj1 = obj2;
		print("After obj1 = obj2: ");
		print("obj1.f = " + obj1.f);
		print("obj2.f = " + obj2.f);
		print();
		obj1.f = 15;
		print("obj1.f = " + obj1.f);
		print("obj2.f = " + obj2.f);
		print();
		obj2.f = 20;
		print("obj1.f = " + obj1.f);
		print("obj2.f = " + obj2.f);

	}

}

/* Output:
obj1.f = 0.0
obj2.f = 0.0

obj1.f = 5.0
obj2.f = 10.0

After obj1 = obj2: 
obj1.f = 10.0
obj2.f = 10.0

obj1.f = 15.0
obj2.f = 15.0

obj1.f = 20.0
obj2.f = 20.0
*/