import java.util.*;

public class Ch16ex18 {

	public static void main(String[] args) {
		BerylliumSphere[] bsArray1 = new BerylliumSphere[5];
		for(int i = 0; i < bsArray1.length; i++)
			bsArray1[i] = new BerylliumSphere();
		System.out.println("bsArray1: " + Arrays.toString(bsArray1));
		BerylliumSphere[] bsArray2 = new BerylliumSphere[5];
		System.out.println("bsArray2: " + Arrays.toString(bsArray2));
		System.arraycopy(bsArray1, 0, bsArray2, 0, bsArray1.length);
		// No new BerylliumSpheres in bsArray2, just the new references
		// to BerylliumSpheres in bsArray1: 
		System.out.println("bsArray1: " + Arrays.toString(bsArray1));
		System.out.println("bsArray2: " + Arrays.toString(bsArray2));
	}

}

/* Output:
bsArray1: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
bsArray2: [null, null, null, null, null]
bsArray1: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
bsArray2: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
*/