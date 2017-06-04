package typeinfo.pets;

public class Dog extends Pet {
	public static class Factory implements typeinfo.Factory<Dog> {
		public Dog create() { return new Dog(); }
	}
}
