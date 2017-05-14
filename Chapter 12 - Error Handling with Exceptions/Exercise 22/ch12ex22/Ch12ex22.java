package ch12ex22;
import static ptmoskal.Print.*;

class FailingConstructor{
	FailingConstructor(int i){
		Integer[] arr = new Integer[3];
		arr[i] = 128;
		print("arr[" + i + "] = " + arr[i]);
	}
}

public class Ch12ex22 {

	public static void main(String[] args) {
		try {
			FailingConstructor obj1 = new FailingConstructor(5);
		} catch(Exception e) {
			System.err.println("<< Failed to create FailingConstructor class object >>");
			e.printStackTrace();
		}
	}
}

/* Output:
<< Failed to create FailingConstructor class object >>
java.lang.ArrayIndexOutOfBoundsException: 5
	at ch12ex22.FailingConstructor.<init>(Ch12ex22.java:7)
	at ch12ex22.Ch12ex22.main(Ch12ex22.java:17)
*/