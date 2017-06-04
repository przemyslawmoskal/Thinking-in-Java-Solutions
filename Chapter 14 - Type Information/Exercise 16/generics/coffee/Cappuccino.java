package generics.coffee;

public class Cappuccino extends Coffee {
	public static class Factory implements ch14ex16.Factory<Cappuccino> {
		public Cappuccino create() { return new Cappuccino(); }
	}
}
