package ch16ex19;

import java.util.Arrays;
import static ptmoskal.Print.*;

class A {
	int i;
	A(int i) { this.i = i; }
	public String toString() { return Integer.toString(i); }
	public boolean equals(Object obj) {return obj instanceof A
			&& this.i == ((A)obj).i;
	}
}

public class Ch16ex19 {

	public static void main(String[] args) {
		A[] array1 = { new A(0), new A(1), new A(2) };
		print(Arrays.toString(array1));
		A[] array2 = { new A(0), new A(1), new A(2) };
		print(Arrays.toString(array2));
		print("Arrays.equals(array1, array2): " + Arrays.equals(array1, array2));
		
	}

}

/* Output:
[0, 1, 2]
[0, 1, 2]
Arrays.equals(array1, array2): true
*/