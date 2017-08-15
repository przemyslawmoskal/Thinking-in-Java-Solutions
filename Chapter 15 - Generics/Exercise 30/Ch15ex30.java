import static ptmoskal.Print.*;

public class Ch15ex30 {
	public static void main(String[] args) {
		Holder<Character> charH = new Holder<Character>();
		Holder<Byte> byteH = new Holder<Byte>();
		Holder<Short> shortH = new Holder<Short>();
		Holder<Integer> intH = new Holder<Integer>();
		Holder<Long> longH = new Holder<Long>();
		Holder<Float> floatH = new Holder<Float>();
		Holder<Double> doubleH = new Holder<Double>();
		charH.set('a');
		byte b = 1;
		byteH.set(b);
		short s = 2;
		shortH.set(s);
		intH.set(3);
		long l = 4L;
		longH.set(l);
		float f = 5.0F;
		floatH.set(f);
		double d = 6.0;
		doubleH.set(d);
		Holder[] holders = new Holder[] {charH,byteH,shortH,intH,longH,floatH,doubleH};
		print("Holders contain: ");
		for(Holder h : holders)
		printnb(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
		print();
		print();
		char cc = charH.get();
		byte bb = byteH.get();
		short ss = shortH.get();
		int ii = intH.get();
		long ll = longH.get();
		float ff = floatH.get();
		double dd = doubleH.get();
		print("char cc = charH.get(), cc = " + cc);
		print("byte bb = byteH.get(), bb = " + bb);
		print("short ss = shortH.get(), ss = " + ss);
		print("int ii = intH.get(), ii = " + ii);
		print("long ll = longH.get(), ll = " + ll);
		print("float ff = floatH.get(), ff = " + ff);
		print("double dd = doubleH.get(), dd = " + dd);
	}
}

/* Output:
Holders contain: 
Character: a, Byte: 1, Short: 2, Integer: 3, Long: 4, Float: 5.0, Double: 6.0, 

char cc = charH.get(), cc = a
byte bb = byteH.get(), bb = 1
short ss = shortH.get(), ss = 2
int ii = intH.get(), ii = 3
long ll = longH.get(), ll = 4
float ff = floatH.get(), ff = 5.0
double dd = doubleH.get(), dd = 6.0
*/
