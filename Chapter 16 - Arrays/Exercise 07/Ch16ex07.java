import java.util.Arrays;

public class Ch16ex07 {
	public static BerylliumSphere[][][] createArr(int rows,int columns,int depth) {
		BerylliumSphere[][][] arr = new BerylliumSphere[rows][columns][depth];
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < arr[row].length; column++) {
				for(int thirdDim = 0; thirdDim < arr[row][column].length; thirdDim++ ) {
					arr[row][column][thirdDim] = new BerylliumSphere();
				}
			}
		}
		return arr;
	}
	
	public static void showArr(Double[][][] array) {
		System.out.println(Arrays.deepToString(array));
	}

	public static void main(String[] args) {
		BerylliumSphere[][][] bsa1 = createArr(2,4,2);
		BerylliumSphere[][][] bsa2 = createArr(2,2,4);
		BerylliumSphere[][][] bsa3 = createArr(2,3,3);
		System.out.println(Arrays.deepToString(bsa1));
		System.out.println(Arrays.deepToString(bsa2));
		System.out.println(Arrays.deepToString(bsa3));
	}

}

/* Output:
[[[Sphere 0, Sphere 1], [Sphere 2, Sphere 3], [Sphere 4, Sphere 5], [Sphere 6, Sphere 7]], [[Sphere 8, Sphere 9], [Sphere 10, Sphere 11], [Sphere 12, Sphere 13], [Sphere 14, Sphere 15]]]
[[[Sphere 16, Sphere 17, Sphere 18, Sphere 19], [Sphere 20, Sphere 21, Sphere 22, Sphere 23]], [[Sphere 24, Sphere 25, Sphere 26, Sphere 27], [Sphere 28, Sphere 29, Sphere 30, Sphere 31]]]
[[[Sphere 32, Sphere 33, Sphere 34], [Sphere 35, Sphere 36, Sphere 37], [Sphere 38, Sphere 39, Sphere 40]], [[Sphere 41, Sphere 42, Sphere 43], [Sphere 44, Sphere 45, Sphere 46], [Sphere 47, Sphere 48, Sphere 49]]]
*/