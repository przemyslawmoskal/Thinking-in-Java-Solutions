package ch13ex06;

class MyClass {
	MyClass(int i, long l, float f, double d) {
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
	}
	private int i;
	private long l;
	private float f;
	private double d;
	public String toString() {
		return String.format("%03d, %-10d, %+15f, %010.2f", i, l, f, d);
	}
}

public class Ch13ex06 {
	public static void main(String[] args) {
		MyClass obj1 = new MyClass(1, 23456789l, -345.6789f, -45.789d);
		MyClass obj2 = new MyClass(2, 34567l, 24.2345f, -3000.11d);
		MyClass obj3 = new MyClass(3, 1234l, 34563.3f, -234.423d);
		MyClass[] arr = {obj1, obj2, obj3};
		for(MyClass m : arr) {
			System.out.println(m);
		}
	}
}

/* Output:
001, 23456789  ,     -345,678894, -000045,79
002, 34567     ,      +24,234501, -003000,11
003, 1234      ,   +34563,300781, -000234,42
*/
