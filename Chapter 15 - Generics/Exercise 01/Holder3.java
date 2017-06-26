import typeinfo.pets.*;
import static ptmoskal.Print.*;

public class Holder3<T> {
	private T a;
	public Holder3(T a) { this.a = a; }
	public void set(T a) { this.a = a; }
	public T get() { return a; }
	public static void main(String[] args) {
		Holder3<Pet> h3 = new Holder3<Pet>(new Pet());
		Pet a = h3.get(); // No cast needed
		print(a);
		h3.set(new Cymric());
		print(h3.get());
	}
}

/* Output:
Pet
Cymric
*/