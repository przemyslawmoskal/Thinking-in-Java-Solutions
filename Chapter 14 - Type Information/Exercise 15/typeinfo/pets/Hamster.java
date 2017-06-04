package typeinfo.pets;

public class Hamster extends Rodent {
	public static class Factory implements typeinfo.Factory<Hamster> {
		public Hamster create() { return new Hamster(); }
	}
}
