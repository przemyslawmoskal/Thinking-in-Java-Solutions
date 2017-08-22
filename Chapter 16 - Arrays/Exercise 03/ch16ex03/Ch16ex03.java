package ch16ex03;
import java.util.*;

public class Ch16ex03 {
	public static Double[][] createArr(int rows, int columns, double begin, double end) {
		int possibilities = rows * columns;
		double range = end - begin;
		double fraction = (double)(range/(possibilities-1));
		int counter = 0;
		Double[][] arr = new Double[rows][columns];
		for(int row = 0; row < arr.length; row++) {
			for(int column = 0; column < arr[row].length; column++) {
				arr[row][column] = begin + (fraction*counter++);
				arr[rows-1][columns-1] = end;
			}
		}
		return arr;
	}
	
	public static void showArr(Double[][] array) {
		System.out.println(Arrays.deepToString(array));
	}
	
	public static void main(String[] args) {
		Double[][] a1 = createArr(2,4,1.6,2.6);
		Double[][] a2 = createArr(5,2,5.5,6.6);
		Double[][] a3 = createArr(3,2,5.0,10.0);
		showArr(a1);
		showArr(a2);
		showArr(a3);
	} 	

}

/* Output:
[[1.6, 1.7428571428571429, 1.8857142857142857, 2.0285714285714285], [2.1714285714285717, 2.314285714285714, 2.4571428571428573, 2.6]]
[[5.5, 5.622222222222222], [5.7444444444444445, 5.866666666666666], [5.988888888888889, 6.111111111111111], [6.233333333333333, 6.355555555555555], [6.477777777777778, 6.6]]
[[5.0, 6.0], [7.0, 8.0], [9.0, 10.0]]
*/