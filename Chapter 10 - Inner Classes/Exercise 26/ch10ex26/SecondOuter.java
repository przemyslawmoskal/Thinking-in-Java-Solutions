package ch10ex26;
import static ptmoskal.Print.*;

class FirstOuter {
	class FirstInner {
		FirstInner(int i) { print ("FirstOuter.FirstInner(" + i + ")"); }
	}
}

public class SecondOuter {
	public class SecondInner extends FirstOuter.FirstInner {
		SecondInner(FirstOuter o, int i) {
			o.super(i);
			print("SecondOuter.SecondInner(" + i + ")" );
		}
	}
	public static void main(String[] args) {
		FirstOuter fo = new FirstOuter();
		SecondOuter so = new SecondOuter();
		SecondInner si = so.new SecondInner(fo, 128);
	}
}

/* Output:
FirstOuter.FirstInner(128)
SecondOuter.SecondInner(128)
*/