// Creates random sequences of Pets.
package typeinfo.pets;
import java.util.*;

public abstract class PetCreator {
	private Random rand = new Random(47);
	// The List of the different types of Pet to create:
	public abstract List<Class<? extends Pet>> types();
	public Pet randomPet() { // Create one random Pet
		return PetFactory.createRandom();
	}
	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for(int i = 0; i < size; i++)
			result[i] = randomPet();
		return result;
	}
	public ArrayList<Pet> arrayList(int size) {
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}
