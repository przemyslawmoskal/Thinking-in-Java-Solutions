package ch10ex08;
import static ptmoskal.Print.*;


public class Ch10ex08 {
	class Inner {
		private int innerI = 128;
		private void showInnerI() { print("(In class Inner) " + innerI); }
		private void innerMessage() { print("(In class Inner) Sample message"); }
	}
	public int outerI = new Inner().innerI;
	public void showOuterI() { print(outerI); }
	public void showInnerI() { new Inner().showInnerI(); }
	public void OuterMessage() {new Inner().innerMessage();}

	public static void main(String[] args) {
		Ch10ex08 obj = new Ch10ex08();
		obj.showOuterI();
		obj.showInnerI();
		obj.OuterMessage();
	}
}

/* Output:
128
(In class Inner) 128
(In class Inner) Sample message
*/
