package ch05ex01;
import static ptmoskal.Print.*;

class MyClass {
	String s;
}

public class Ch05ex01 {

	public static void main(String[] args) {
		MyClass obj = new MyClass();
		print("obj.s = " + obj.s);
	}
}

/* Output:
obj.s = null
*/