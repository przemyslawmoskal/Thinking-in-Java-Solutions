package packageb;
import packagea.Interface;
import static ptmoskal.Print.*;

public class BaseB {
	protected class InnerB implements Interface {
		public InnerB() { print("BaseB.InnerB()"); }
		public String f() {return "BaseB.InnerB.f()"; }
	}
}
