package typeinfo.pets;

public class Rat extends Rodent {
	public static class Factory implements typeinfo.Factory<Rat> {
		public Rat create() { return new Rat(); }
	}
}
