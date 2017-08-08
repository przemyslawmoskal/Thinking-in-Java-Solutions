package ch07ex04;
import static ptmoskal.Print.*;

class MyClassA {
	MyClassA() { print("MyClassA()"); }
}

class MyClassAA extends MyClassA {
	MyClassAA() { print("MyClassAA()"); }
	public static MyClassAA createMyClassAA() { return new MyClassAA(); }
	public static void main(String[] args) {
		MyClassAA aa = new MyClassAA();
		MyClassAA aa2 = createMyClassAA();
	}
}

class MyClassAAA extends MyClassAA {
	MyClassAAA() { print("MyClassAAA()"); }
}

public class MyClassAAAA extends MyClassAAA {
	MyClassAAAA() { print("MyClassAAAA()"); }
	public static void main(String[] args) {
		MyClassAAAA aaaa = new MyClassAAAA();
		MyClassAA.main(args);
		
	}

}

/* Output:
MyClassA()
MyClassAA()
MyClassAAA()
MyClassAAAA()
MyClassA()
MyClassAA()
MyClassA()
MyClassAA()
*/
