package ch06ex05;
import static ptmoskal.Print.*;

class MyClass {
	public void f() { print("public f()"); }
	public int g = 2;
	protected void h() { print("protected h()"); }
	protected int i = 4;
	private void j() { print("private j()"); }
	private int k = 8;
	void l() {print("l() with package access"); }
	int m = 16;
}

public class Ch06ex05 {

	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.f();
		obj.g = 3;
		print("public int g = " + obj.g);
		obj.h();
		obj.i = 5;
		print("protected int i = " + obj.i);
		// The method j() from the type MyClass is not visible
		// obj.j();
		// The field MyClass.k is not visible
		// obj.k = 9;
		// print(obj.k);
		obj.l();
		obj.m = 17;
		print("int m with package access = " + obj.m);
	}
}

/* Output:
public f()
public int g = 3
protected h()
protected int i = 5
l() with package access
int m with package access = 17
*/
