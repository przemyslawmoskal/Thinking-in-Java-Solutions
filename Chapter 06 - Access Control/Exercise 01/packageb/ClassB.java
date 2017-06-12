package packageb;
import static ptmoskal.Print.*;

public class ClassB {

	public static void main(String[] args) {
		print("In package B:");
		packagea.ClassA obj = new packagea.ClassA();
	}

}

/* Output:
In package B:
I'm from Package A
*/
