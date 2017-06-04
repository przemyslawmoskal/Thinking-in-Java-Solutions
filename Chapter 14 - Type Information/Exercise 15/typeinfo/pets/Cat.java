package typeinfo.pets;

public class Cat extends Pet {
	public static class Factory implements typeinfo.Factory<Cat> {
		public Cat create() { return new Cat(); }
	}
}
