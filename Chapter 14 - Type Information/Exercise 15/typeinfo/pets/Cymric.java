package typeinfo.pets;

public class Cymric extends Manx {
	public static class Factory implements typeinfo.Factory<Cymric> {
		public Cymric create() { return new Cymric(); }
	}
}
