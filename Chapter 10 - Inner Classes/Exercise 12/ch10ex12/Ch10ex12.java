package ch10ex12;
import static ptmoskal.Print.*;

interface Inner {
	void modifyOuterI(int j);
}

public class Ch10ex12 {
	private int i = 128;
	private void showI() {
		print("i = " + i);
	}
	public Inner inner() {
		return new Inner() {
			@Override
			public void modifyOuterI(int j) {
				i = j;
				showI();
			}
		};
	}
	public static void main(String[] args) {
		Ch10ex12 outerobj = new Ch10ex12();
		outerobj.showI();
		outerobj.inner().modifyOuterI(256);
	}
}

/* Output:
i = 128
i = 256
*/