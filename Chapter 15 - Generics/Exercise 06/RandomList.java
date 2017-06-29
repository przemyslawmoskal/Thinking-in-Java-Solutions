import java.util.*;
import typeinfo.pets.*;

public class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random(47);
	public void add(T item) { storage.add(item); }
	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}
	public static void main(String[] args) {
		RandomList<String> rs = new RandomList<String>();
		for(String s: ("The quick brown fox jumped over " +
				"the lazy brown dog").split(" "))
			rs.add(s);
		for(int i = 0; i < 11; i++)
			System.out.print(rs.select() + " ");
		System.out.println();
		RandomList<Integer> ri = new RandomList<Integer>();
		for(int i = 0; i < 10; i++)
			ri.add(i);
		for(int i = 0; i < 10; i++)
			System.out.print(ri.select() + " ");
		System.out.println();
		RandomList<Pet> rp = new RandomList<Pet>();
		for(Pet pet : Pets.arrayList(10))
			rp.add(pet);
		for(int i = 0; i < 10; i++)
			System.out.print(rp.select() + " ");
  }
}

/* Output:
brown over fox quick quick dog brown The brown lazy brown 
8 5 3 1 1 9 8 0 2 7 
Cymric Cymric Mutt Manx Manx Rat Cymric Rat Cymric Manx 
*/