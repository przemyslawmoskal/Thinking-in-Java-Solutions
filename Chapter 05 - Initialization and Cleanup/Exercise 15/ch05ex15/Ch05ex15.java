package ch05ex15;
import static ptmoskal.Print.*;

class MyClass {
	private String s1;
	{
		s1 = "XYZ";
		print("s1 initialization successful, s1 = " + s1);
	}
	MyClass() {
		print("MyClass()");
	}
}

public class Ch05ex15 {

	public static void main(String[] args) {
		MyClass obj = new MyClass();
	}

}

/* Output:
s1 initialization successful, s1 = XYZ
MyClass()
*/