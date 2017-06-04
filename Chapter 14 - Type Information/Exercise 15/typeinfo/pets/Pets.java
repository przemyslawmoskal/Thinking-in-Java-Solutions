// Facade to produce a default PetCreator.
package typeinfo.pets;
import java.util.*;

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();
	public static PetFactory randomPet() {
		return PetFactory.createRandom();
	}
	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}
	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
}
