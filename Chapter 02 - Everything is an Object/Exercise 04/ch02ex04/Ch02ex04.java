
package ch02ex04;

class DataOnly {
	int i;
	double d;
	boolean b;
}

public class Ch02ex04 {
	public static void main(String[] args) {
		DataOnly obj = new DataOnly();
		obj.i = 100;
		obj.d = 100.10;
		obj.b = true;
		System.out.println(obj.i);
		System.out.println(obj.d);
		System.out.println(obj.b);
    }
}

/* Output:
100
100.1
true
*/