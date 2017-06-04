package generics.coffee;

public class Latte extends Coffee {
	public static class Factory implements ch14ex16.Factory<Latte> {
		public Latte create() { return new Latte(); }
	}
}
