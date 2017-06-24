package ch10ex19a;

public class Outer {
	private class InnerA {
		private class InnerAA {}
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.InnerA oia = outer.new InnerA();
		Outer.InnerA.InnerAA oiaa = oia.new InnerAA();
	}
}

/* Names of the files created by compiler:
Outer$InnerA$InnerAA.class
Outer$InnerA.class
Outer.class
*/