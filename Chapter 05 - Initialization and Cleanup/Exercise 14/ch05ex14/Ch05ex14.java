package ch05ex14;
import static ptmoskal.Print.*;

class MyClass {
	private static String s1 = "private static s1";
	private static String s2;
	static {
		s2 = "static { String s2 }";
	}
	public static void showValues() {
		print("s1 = " + s1 + ", s2 = " + s2);
	}
}

public class Ch05ex14 {

	public static void main(String[] args) {
		MyClass.showValues();
	}

}

/* Output:
s1 = private static s1, s2 = static { String s2 }
*/
