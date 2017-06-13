// Using protected methods in other packages is not allowed

package packageb;
import packagea.ClassA;

public class ClassC {

	public static void main(String[] args) {
		ClassA obj = new ClassA();
		// The method f() from the type ClassA is not visible
		// obj.f();
	}
}

/* Output:
ClassA()
*/