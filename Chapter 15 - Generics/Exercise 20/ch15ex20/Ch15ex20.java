package ch15ex20;

public class Ch15ex20 {

	public static void main(String[] args) {
		MyClassA mca = new MyClassA();
		MyClassB.i(mca);
	}

}

/* Output:
MyClassA.f()
MyClassA.g()
*/