import java.util.Arrays;

public class Ch16ex01 {
	public static void f(BerylliumSphere[] arr) {
		System.out.println(Arrays.asList(arr));
	}
	public static void main(String[] args) {
		// Aggregate array initialization doesn't work that way:
		// f({ new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
		
		// Ok:
		f(new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
		
		// Ok:
		BerylliumSphere[] bs1 = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
		f(bs1);
		
		// Dynamic aggregate array initialization is redundant:
		BerylliumSphere[] bs2 = new BerylliumSphere[]{ new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
		f(bs2);
	}
}

/* Output:
[Sphere 0, Sphere 1, Sphere 2]
[Sphere 3, Sphere 4, Sphere 5]
[Sphere 6, Sphere 7, Sphere 8]
*/