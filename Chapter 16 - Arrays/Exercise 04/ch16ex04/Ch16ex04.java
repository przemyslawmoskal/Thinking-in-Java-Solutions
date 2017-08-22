package ch16ex04;
import java.util.*;

public class Ch16ex04 {
	public static Double[][][] createArr(int rows, int columns, int depth, double begin, double end) {
		int possibilities = rows * columns * depth;
		double range = end - begin;
		double fraction = (double)(range/(possibilities-1));
		int counter = 0;
		Double[][][] arr = new Double[rows][columns][depth];
		for(int row = 0; row < arr.length; row++) {
			for(int column = 0; column < arr[row].length; column++) {
				for(int thirdDim = 0; thirdDim < arr[row][column].length; thirdDim++ )
				arr[row][column][thirdDim] = begin + (fraction*counter++);
				arr[rows-1][columns-1][depth-1] = end;
			}
		}
		return arr;
	}
	
	public static void showArr(Double[][][] array) {
		System.out.println(Arrays.deepToString(array));
	}
	
	public static void main(String[] args) {
		Double[][][] a1 = createArr(2,2,4,5.0,55.0);
		Double[][][] a2 = createArr(3,2,2,2.5,6.6);
		Double[][][] a3 = createArr(2,2,2,3.0,10.0);
		showArr(a1);
		showArr(a2);
		showArr(a3);
	} 	

}

/* Output:
[[[5.0, 8.333333333333334, 11.666666666666668, 15.0], [18.333333333333336, 21.666666666666668, 25.0, 28.333333333333336]], [[31.666666666666668, 35.0, 38.333333333333336, 41.66666666666667], [45.0, 48.333333333333336, 51.66666666666667, 55.0]]]
[[[2.5, 2.8727272727272726], [3.245454545454545, 3.618181818181818]], [[3.9909090909090907, 4.363636363636363], [4.736363636363636, 5.109090909090909]], [[5.4818181818181815, 5.854545454545454], [6.227272727272727, 6.6]]]
[[[3.0, 4.0], [5.0, 6.0]], [[7.0, 8.0], [9.0, 10.0]]]
*/