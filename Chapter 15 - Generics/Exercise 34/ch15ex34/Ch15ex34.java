package ch15ex34;
import static ptmoskal.Print.*;


abstract class SelfBounded<T extends SelfBounded<T>> {
	abstract T f(T arg);
	T g(T arg) {
		print("g(T arg)");
		return f(arg);
	}
}

class Derived extends SelfBounded<Derived>  {
	public Derived f(Derived arg) {
		print("f(Derived arg)");
		return arg;
	}
}

public class Ch15ex34 {

	public static void main(String[] args) {
		Derived der1 = new Derived();
		print("der1.f(der1:");
		der1.f(der1);
		print("\nder1.g(der1):");
		der1.g(der1);
	}

}

/* Output:
der1.f(der1:
f(Derived arg)

der1.g(der1):
g(T arg)
f(Derived arg)
*/