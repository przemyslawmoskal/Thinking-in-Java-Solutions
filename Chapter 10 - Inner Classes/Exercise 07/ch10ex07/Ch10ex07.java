package ch10ex07;
import static ptmoskal.Print.*;

public class Ch10ex07 {
	private int i = 128;
	private void showI() {
		print("i = " + i);
	}
	class Inner {
		public void modifyOuterI(int j) {
			i = j;
			showI();
		}
	}
	public void createInner(int k) {
		Inner o = new Inner();
		o.modifyOuterI(k);
	}
	public static void main(String[] args) {
		Ch10ex07 outerobj = new Ch10ex07();
		outerobj.showI();
		outerobj.createInner(256);
	}
}

/* Output:
i = 128
i = 256
*/