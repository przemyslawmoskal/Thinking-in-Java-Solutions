package myPackage;

import static ptmoskal.Print.print;

class HiddenClass implements A{
	public void f() { print("public B.f()"); }
	private void g() { print("private B.g()"); }
	protected void h() { print("protected B.h()"); }
	void i() { print("B.i() with package access"); }
	public void j() { print("public B.j()"); }
}

public class Maker {
	public static A makeHiddenClassObject() {
		return new HiddenClass();
	}
}