package ch10ex19b;

public class Outer {
	static class NestedA {
		static class NestedAA {}
	}
	public static void main(String[] args) {
		NestedA.NestedAA nestedA = new NestedA.NestedAA();
	}
}

/* Names of the files created by compiler:
Outer$NestedA$NestedAA.class
Outer$NestedA.class
Outer.class
 */