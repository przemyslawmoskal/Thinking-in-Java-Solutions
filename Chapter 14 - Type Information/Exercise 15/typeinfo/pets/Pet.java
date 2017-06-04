package typeinfo.pets;

public class Pet extends Individual {
	public static class Factory implements typeinfo.Factory<Pet> {
		public Pet create() { return new Pet(); }
	}
}
