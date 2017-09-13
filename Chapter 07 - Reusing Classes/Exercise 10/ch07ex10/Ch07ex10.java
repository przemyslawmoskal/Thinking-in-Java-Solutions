package ch07ex10;

class Root {
	Component1 component1Root;
	Component2 component2Root;
	Component3 component3Root;
	Root(int i) {
		System.out.println("Root(" + i + ")");
		component1Root = new Component1(i+10);
		component2Root = new Component2(i+20);
		component3Root = new Component3(i+30);
	}
	
}

class Stem extends Root {
	Component1 component1Stem;
	Component2 component2Stem;
	Component3 component3Stem;
	Stem(int i) {
		super(i);
		System.out.println("Stem(" + i*10 + ")");
		component1Stem = new Component1(i*100+10);
		component2Stem = new Component2(i*100+20);
		component3Stem = new Component3(i*100+30);}
}

class Component1 {
	Component1(int i) { System.out.println("Component1(" + i + ")"); }
}

class Component2 {
	Component2(int i) { System.out.println("Component2(" + i + ")"); }
}

class Component3 {
	Component3(int i) { System.out.println("Component3(" + i + ")"); }
}

public class Ch07ex10 {

	public static void main(String[] args) {
		Stem stem = new Stem(3);
	}

}

/* Output:
Root(3)
Component1(13)
Component2(23)
Component3(33)
Stem(30)
Component1(310)
Component2(320)
Component3(330)
*/