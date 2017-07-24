package ch15ex20;

public class MyClassB {
	public static <T extends MyInterface> void i(T x) {
		x.f();
		x.g();
	};
}
