// Testing class Class.
package typeinfo.toys;
import static net.mindview.util.Print.*;
import java.lang.reflect.InvocationTargetException;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*1*)
	Toy(int i) {
		System.out.println("Constructor Toy(" + i +") used.");
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() { super(1); }
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name : " + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			Toy.class.getDeclaredConstructor(int.class).newInstance(1);
		}catch(IllegalAccessException e) {
			throw new RuntimeException(e);
		}catch(InstantiationException e) {
			throw new RuntimeException(e);
		}catch(InvocationTargetException e) {
			throw new RuntimeException(e);
		}catch(NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
}

/* Output:
Constructor Toy(1) used.
*/
