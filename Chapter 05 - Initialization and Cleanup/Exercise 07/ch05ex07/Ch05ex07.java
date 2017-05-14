package ch05ex07;
import static ptmoskal.Print.*;

class MyClass {
	void show() {
		print("MyClass show()");
	}
}

public class Ch05ex07 {

	public static void main(String[] args) {
		MyClass obj1 = new MyClass();
		obj1.show();
	}

}

/* Output:
MyClass show()
*/