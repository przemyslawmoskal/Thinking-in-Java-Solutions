package ch13ex20;
import java.util.*;

class MyClass {
	private int i;
	private long l;
	private float f;
	private double d;
	private String s;
	MyClass(String str) {
		Scanner sc = new Scanner(str);
		i = sc.nextInt();
		l = sc.nextLong();
		f = sc.nextFloat();
		d = sc.nextDouble();
		this.s = sc.next();
	}
	public String toString() {
		return i + " " + l + " " + f + " " + d + " " + s;
	}
}

public class Ch13ex20 {
	public static void main(String[] args) {
		MyClass obj = new MyClass("12 3456789 1,23 4,56789 numbers");
		System.out.println(obj);
	}
}

/* Output:
12 3456789 1.23 4.56789 numbers
*/