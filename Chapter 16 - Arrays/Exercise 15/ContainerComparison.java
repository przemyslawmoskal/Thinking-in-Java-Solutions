import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

class BerylliumSphere {
	private static long counter;
	private final long id = counter++;
	public String toString() { return "Sphere " + id; }
}

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
	public BerylliumSphere next() { return new BerylliumSphere(); }
}

public class ContainerComparison {
	
	public static void main(String[] args) {
		BerylliumSphere[] berylliumSpheres1 = Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator(), 5);
		print("berylliumSpheres1: " + Arrays.toString(berylliumSpheres1));
		BerylliumSphere[] berylliumSpheres2 = Generated.array(berylliumSpheres1, new BerylliumSphereGenerator());
		print("berylliumSpheres2: " + Arrays.toString(berylliumSpheres2));
	}
	
}

/* Output:
berylliumSpheres1: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
berylliumSpheres2: [Sphere 5, Sphere 6, Sphere 7, Sphere 8, Sphere 9]
*/
