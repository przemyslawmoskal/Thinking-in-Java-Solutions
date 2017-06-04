package typeinfo.pets;

public class Mutt extends Dog {
	public static class Factory implements typeinfo.Factory<Mutt> {
		public Mutt create() { return new Mutt(); }
	}
}
