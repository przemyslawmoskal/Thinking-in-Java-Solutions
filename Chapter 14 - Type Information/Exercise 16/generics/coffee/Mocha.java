//: generics/coffee/Mocha.java
package generics.coffee;
public class Mocha extends Coffee {
	public static class Factory implements ch14ex16.Factory<Mocha> {
		public Mocha create() { return new Mocha(); }
	}
} ///:~
