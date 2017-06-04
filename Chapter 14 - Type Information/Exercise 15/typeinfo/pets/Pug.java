package typeinfo.pets;

public class Pug extends Dog {
	public static class Factory implements typeinfo.Factory<Pug> {
		public Pug create() { return new Pug(); }
	}
}
