package typeinfo.pets;

public class Person extends Individual {
	public static class Factory implements typeinfo.Factory<Person> {
		public Person create() { return new Person(); }
	}
}
