package ch07ex09;

class Root {
	Root() { System.out.println("Root()"); }
	Component1 component1Root;
	Component2 component2Root;
	Component3 component3Root;
}

class Stem extends Root {
	Stem() { System.out.println("Stem()"); }
	Component1 component1Stem;
	Component2 component2Stem;
	Component3 component3Stem;
}

class Component1 {
	Component1() { System.out.println("Component1()"); }
}

class Component2 {
	Component2() { System.out.println("Component2()"); }
}

class Component3 {
	Component3() { System.out.println("Component3()"); }
}

public class Ch07ex09 {

	public static void main(String[] args) {
		Stem stem = new Stem();
	}

}

/* Output:
Root()
Stem()
*/