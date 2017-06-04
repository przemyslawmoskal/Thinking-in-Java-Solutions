package generics.coffee;

public class Breve extends Coffee {
	public static class Factory implements ch14ex16.Factory<Breve> {
		public Breve create() { return new Breve(); }
	}
}
