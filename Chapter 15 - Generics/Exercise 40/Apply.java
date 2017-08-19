// {main: ApplyTest}
import java.lang.reflect.*;
import java.util.*;
import typeinfo.pets.*;
import static net.mindview.util.Print.*;

public class Apply {
	public static <T, S extends Iterable<? extends T>>
	void apply(S seq, Method f, Object... args) {
		try {
			for(T t: seq)
				f.invoke(t, args);
		} catch(Exception e) {
			// Failures are programmer errors
			throw new RuntimeException(e);
		}
	}
}	

class Shape {
	public void rotate() { print(this + " rotate"); }
	public void resize(int newSize) {
		print(this + " resize " + newSize);
	}
}

class Square extends Shape {}

class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			for(int i = 0; i < size; i++)
				// Assumes default constructor:
				add(type.newInstance());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}	

class ApplyTest {
	public static void main(String[] args) throws Exception {
		print("Using ArrayList:");
		List<Pet> pets = Pets.arrayList(15);
		print("pets: " + pets);
		Apply.apply(pets, Pet.class.getMethod("speak"));
		print("\nUsing Filledlist (only one type):");
		Apply.apply((new FilledList<Cat>(Cat.class, 10)), Cat.class.getMethod("speak"));
	}
}

/* Output:
Using ArrayList:
pets: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau, Mutt, Mutt]
Little rat says something!
Little manx says something!
Little cymric says something!
Little mutt says something!
Little pug says something!
Little cymric says something!
Little pug says something!
Little manx says something!
Little cymric says something!
Little rat says something!
Little egyptian mau says something!
Little hamster says something!
Little egyptian mau says something!
Little mutt says something!
Little mutt says something!

Using Filledlist (only one type):
Little cat says something!
Little cat says something!
Little cat says something!
Little cat says something!
Little cat says something!
Little cat says something!
Little cat says something!
Little cat says something!
Little cat says something!
Little cat says something!
*/
