import java.util.*;

class ComparableBerylliumSphere implements Comparable<ComparableBerylliumSphere>{
	  private static long counter;
	  protected final long id = counter++;
	  public int compareTo(ComparableBerylliumSphere obj) {
		  return (this.id < obj.id ? -1 : (this.id == obj.id ? 0 : 1));
	  }
	  public String toString() { return "Sphere " + id; }
	}

class ComparableBerylliumSphereComparator implements Comparator<ComparableBerylliumSphere> {
	public int compare(ComparableBerylliumSphere obj1, ComparableBerylliumSphere obj2) {
		return (obj1.id < obj2.id ? 1 : (obj1.id == obj2.id ? 0 : -1));
	}
}

public class Ch16ex21 {

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
		// Cannot sort BerylliumSphere array - ClassCastException thrown:
		// Arrays.sort(bsArray1);
		ComparableBerylliumSphere[] cbsArray1 = new ComparableBerylliumSphere[5];
		for(int i = 0; i < cbsArray1.length; i++)
			cbsArray1[i] = new ComparableBerylliumSphere();
		System.out.println("cbsArray1: " + Arrays.toString(cbsArray1));
		// Now Arrays.sort() can be used with ComparableBerylliumSphere:
		Arrays.sort(cbsArray1);
		System.out.println("cbsArray1: " + Arrays.toString(cbsArray1));
		// Reverse order:
		Arrays.sort(cbsArray1, new ComparableBerylliumSphereComparator());
		System.out.println("cbsArray1: " + Arrays.toString(cbsArray1));
		
	}

}

/* Output:
bsArray1: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
bsArray2: [null, null, null, null, null]
bsArray1: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
bsArray2: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
cbsArray1: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
cbsArray1: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
cbsArray1: [Sphere 4, Sphere 3, Sphere 2, Sphere 1, Sphere 0]
*/