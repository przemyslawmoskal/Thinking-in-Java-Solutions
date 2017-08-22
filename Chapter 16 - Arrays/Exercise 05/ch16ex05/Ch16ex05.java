package ch16ex05;

import java.util.Arrays;

class A {}

public class Ch16ex05 {
	public static void main(String[] args) {
		A[][][] arr = new A[2][2][2];
		System.out.println(Arrays.deepToString(arr));
	}
}

/* Output:
[[[null, null], [null, null]], [[null, null], [null, null]]]
*/