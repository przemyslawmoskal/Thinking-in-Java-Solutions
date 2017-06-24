package ch10ex21;
import static ptmoskal.Print.*;

interface MyInterface {
	String name();
	void showName();
	static class Nested {
		static void invokeShowName(MyInterface m) {
			print("MyInterface.Nested.invokeShowName()");
			m.showName();
		}
	}
}

public class Ch10ex21 implements MyInterface {
	public String name() { return "Ch10ex21"; }
	public void showName() {
		print("showName()");
		print(name()); }
	public static void main(String[] args) {
		Ch10ex21 obj = new Ch10ex21();
		MyInterface.Nested.invokeShowName(obj);
	}
}

/* Output:
MyInterface.Nested.invokeShowName()
showName()
Ch10ex21
*/