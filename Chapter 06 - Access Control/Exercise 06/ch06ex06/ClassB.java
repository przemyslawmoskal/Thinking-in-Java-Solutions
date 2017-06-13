package ch06ex06;
import static ptmoskal.Print.*;

class ClassA {
	protected int i = 128;
	protected String s = "hello";
}

public class ClassB {
	public static void changeFields(ClassA object, int i, String s) {
		object.i = i;
		object.s = s;
	}
	public static void main(String[] args) {
		ClassA objA = new ClassA();
		print("objA.i = " + objA.i + ", objA.s = " + objA.s);
		ClassB.changeFields(objA, 256, "goodbye");
		print("objA.i = " + objA.i + ", objA.s = " + objA.s);
	}
}

/* Output:
objA.i = 128, objA.s = hello
objA.i = 256, objA.s = goodbye
*/