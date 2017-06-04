package typeinfo.pets;

public class Rodent extends Pet {
	public static class Factory implements typeinfo.Factory<Rodent> {
		public Rodent create() { return new Rodent(); }
	}
}
