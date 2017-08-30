package ch16ex23;

import java.util.*;
import net.mindview.util.*;

public class Ch16ex23 {
	
	public static void main(String[] args) {
		Integer[] integers = Generated.array(new Integer[15], new RandomGenerator.Integer(100));
		System.out.println(Arrays.toString(integers));
		Arrays.sort(integers,Collections.reverseOrder());
		System.out.println(Arrays.toString(integers));
	}

}

/* Output:
[58, 55, 93, 61, 61, 29, 68, 0, 22, 7, 88, 28, 51, 89, 9]
[93, 89, 88, 68, 61, 61, 58, 55, 51, 29, 28, 22, 9, 7, 0]
*/