import java.util.Arrays;

public class Ch16ex06 {
	public static BerylliumSphere[][] createArr(int rows,int columns) {
		BerylliumSphere[][] arr = new BerylliumSphere[rows][columns];
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < arr[row].length; column++) {
				arr[row][column] = new BerylliumSphere();
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		BerylliumSphere[][] bsa = createArr(2,4);
		System.out.println(Arrays.deepToString(bsa));
	}

}

/* Output:
[[Sphere 0, Sphere 1, Sphere 2, Sphere 3], [Sphere 4, Sphere 5, Sphere 6, Sphere 7]]
*/