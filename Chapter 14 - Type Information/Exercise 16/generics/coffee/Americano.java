package generics.coffee;

public class Americano extends Coffee {
	public static class Factory implements ch14ex16.Factory<Americano> {
		public Americano create() { return new Americano(); }
	}
}
