package ch10ex11;
import static ptmoskal.Print.*;

class Outer {
	private class Inner implements MyInterface {
		public void testMessage(String s) { print("testMessage from Inner class: " + s); }
	}
	MyInterface createInner() {
		return new Inner();
	}
}



public class Ch10ex11 {
	
	public static void main(String[] args) {
		Outer obj = new Outer();
		obj.createInner().testMessage("Hello !");
		// Error: Multiple markers at this line, Inner cannot be resolved to a type
		// ((Inner)obj.createInner()).testMessage("Good bye!");
	}

}

/* Output:
testMessage from Inner class: Hello !
*/