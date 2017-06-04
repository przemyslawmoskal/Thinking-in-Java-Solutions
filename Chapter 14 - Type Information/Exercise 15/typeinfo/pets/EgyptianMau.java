package typeinfo.pets;

public class EgyptianMau extends Cat {
	public static class Factory implements typeinfo.Factory<EgyptianMau> {
		public EgyptianMau create() { return new EgyptianMau(); }
	}
}
