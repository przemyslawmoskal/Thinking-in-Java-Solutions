package packagec;
import packageb.BaseB;
import packagea.Interface;
import static ptmoskal.Print.*;

public class DerivedC extends BaseB {
	public Interface createInnerB() {
		return this.new InnerB();
	}
	public static void main(String[] args) {
		DerivedC obj = new DerivedC();
		print(obj.createInnerB().f());
	}
}

/* Output:
BaseB.InnerB()
BaseB.InnerB.f()
*/