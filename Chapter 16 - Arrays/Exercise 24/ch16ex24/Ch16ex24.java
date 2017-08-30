package ch16ex24;

import java.util.Arrays;
import static ptmoskal.Print.*;

class A implements Comparable<A> {
	int i;
	A(int i) { this.i = i; }
	public String toString() { return Integer.toString(i); }
	public boolean equals(Object obj) {return obj instanceof A
			&& this.i == ((A)obj).i;
	}
	public int compareTo(A obj) {
		return (this.i < obj.i ? -1 : (this.i == obj.i ? 0 : 1));
	}
}

public class Ch16ex24 {

	public static void main(String[] args) {
		A[] array1 = { new A(0), new A(1), new A(2) };
		print(Arrays.toString(array1));
		A[] array2 = { new A(0), new A(1), new A(2) };
		print(Arrays.toString(array2));
		print("Arrays.equals(array1, array2): " + Arrays.equals(array1, array2));
		int index = Arrays.binarySearch(array1, new A(2));
		if(index >= 0)
			System.out.println("Found " + array1[index] + " at position " + index);
		else
			System.out.println("Nothing found");
	}

}

/* Output:
[0, 1, 2]
[0, 1, 2]
Arrays.equals(array1, array2): true
Found 2 at position 2
*/