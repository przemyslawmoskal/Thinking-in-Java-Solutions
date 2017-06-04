package typeinfo.pets;

public class Manx extends Cat {
	public static class Factory implements typeinfo.Factory<Manx> {
		public Manx create() { return new Manx(); }
	}
}
