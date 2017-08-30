package ch16ex22;

import java.util.Arrays;
import net.mindview.util.*;

public class Ch16ex22 {

	public static void main(String[] args) {
		int[] ints = ConvertTo.primitive(Generated.array(new Integer[30], new RandomGenerator.Integer(20)));
		System.out.println(Arrays.toString(ints));
		for(int i = 0; i < 20; i++) {
			int index = Arrays.binarySearch(ints, i);
			if(index >= 0)
				System.out.println("int: " + i + " at position: " + index);
			else
				System.out.println("int: " + i + " not found in array");
		}
		System.out.println();
		Arrays.sort(ints);
		System.out.println(Arrays.toString(ints));
		for(int i = 0; i < 20; i++) {
			int index = Arrays.binarySearch(ints, i);
			if(index >= 0)
				System.out.println("int: " + i + " at position: " + index);
			else
				System.out.println("int: " + i + " not found in array");
		}
	}

}

/* Output:
[18, 15, 13, 1, 1, 9, 8, 0, 2, 7, 8, 8, 11, 9, 9, 18, 18, 1, 0, 18, 16, 0, 11, 2, 4, 3, 6, 15, 10, 2]
int: 0 not found in array
int: 1 not found in array
int: 2 not found in array
int: 3 not found in array
int: 4 not found in array
int: 5 not found in array
int: 6 not found in array
int: 7 not found in array
int: 8 at position: 6
int: 9 at position: 14
int: 10 not found in array
int: 11 at position: 22
int: 12 not found in array
int: 13 not found in array
int: 14 not found in array
int: 15 not found in array
int: 16 not found in array
int: 17 not found in array
int: 18 not found in array
int: 19 not found in array

[0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 4, 6, 7, 8, 8, 8, 9, 9, 9, 10, 11, 11, 13, 15, 15, 16, 18, 18, 18, 18]
int: 0 at position: 2
int: 1 at position: 4
int: 2 at position: 6
int: 3 at position: 9
int: 4 at position: 10
int: 5 not found in array
int: 6 at position: 11
int: 7 at position: 12
int: 8 at position: 14
int: 9 at position: 18
int: 10 at position: 19
int: 11 at position: 20
int: 12 not found in array
int: 13 at position: 22
int: 14 not found in array
int: 15 at position: 24
int: 16 at position: 25
int: 17 not found in array
int: 18 at position: 26
int: 19 not found in array
*/