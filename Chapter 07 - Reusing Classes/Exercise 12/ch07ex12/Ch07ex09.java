package ch07ex12;

class Root {
	Component1 component1Root;
	Component2 component2Root;
	Component3 component3Root;
	Root() {
		System.out.println("Root()");
		component1Root = new Component1();
		component2Root = new Component2();
		component3Root = new Component3();
	}
	void dispose() {
		component3Root.dispose();
		component2Root.dispose();
		component1Root.dispose();
		System.out.println("Root.dispose()");
	}
	
}

class Stem extends Root {
	Component1 component1Stem;
	Component2 component2Stem;
	Component3 component3Stem;
	Stem() {
		super();
		System.out.println("Stem()");
		component1Stem = new Component1();
		component2Stem = new Component2();
		component3Stem = new Component3();
	}
	void dispose() {
		component3Stem.dispose();
		component2Stem.dispose();
		component1Stem.dispose();
		System.out.println("Stem.dispose()");
		super.dispose();
	}
}

class Component1 {
	Component1() { System.out.println("Component1()"); }
	void dispose() { System.out.println("Component1.dispose()"); }
}

class Component2 {
	Component2() { System.out.println("Component2()"); }
	void dispose() { System.out.println("Component2.dispose()"); }
}

class Component3 {
	Component3() { System.out.println("Component3()"); }
	void dispose() { System.out.println("Component3.dispose()"); }
}

public class Ch07ex09 {

	public static void main(String[] args) {
		Stem stem = new Stem();
		System.out.println("****************");
		try {
			// Some code here
		} finally {
			stem.dispose();
		}
	}

}

/* Output:
Root()
Component1()
Component2()
Component3()
Stem()
Component1()
Component2()
Component3()
****************
Component3.dispose()
Component2.dispose()
Component1.dispose()
Stem.dispose()
Component3.dispose()
Component2.dispose()
Component1.dispose()
Root.dispose()
*/