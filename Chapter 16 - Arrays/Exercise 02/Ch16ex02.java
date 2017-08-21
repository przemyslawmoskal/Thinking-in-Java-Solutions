import java.util.Arrays;

public class Ch16ex02 {
	public static BerylliumSphere[] f(int length) {
		BerylliumSphere[] arr = new BerylliumSphere[length];
		for(int i = 0; i < length; i++)
			arr[i] = new BerylliumSphere();
		return arr;
	}
	public static void test(BerylliumSphere[] a) {
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		test(f(4));
	}

}

/* Output:
[Sphere 0, Sphere 1, Sphere 2, Sphere 3]
*/