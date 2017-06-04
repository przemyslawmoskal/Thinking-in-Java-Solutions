package typeinfo.pets;

public class Mouse extends Rodent {
	public static class Factory implements typeinfo.Factory<Mouse> {
		public Mouse create() { return new Mouse(); }
	}
}
