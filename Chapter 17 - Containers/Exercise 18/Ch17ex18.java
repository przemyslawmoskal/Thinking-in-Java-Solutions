import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

class SlowSet<T> extends AbstractSet<T> {
	private List<T> list = new ArrayList<T>();
	public int size() { return list.size(); }
	public boolean add(T t) {
		if(list.contains(t))
			return false;
		list.add(t);
		return true;
	}
	public boolean addAll(Collection<? extends T> coll) {
		return list.addAll(coll);
	}
	public void clear() { list.clear(); }
	public boolean contains(Object o) {
		return list.contains(o);
	}
	public boolean containsAll(Collection<?> coll) {
		return list.containsAll(coll);
	}
	public boolean equals(Object o) {
		if(o instanceof SlowSet) {
			if(list.size() == ((SlowSet)o).size()) {
				int equalsCounter = 0;
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).equals(((SlowSet)o).get(i)))
						equalsCounter++;
					if(equalsCounter == list.size()) return true;
				}
					
			}
				
					
		}
		return false;	
	}
	public T get(int index) { return list.get(index); }
	public int hashCode() {
		int hC = 0;
		for(int i = 0; i < list.size(); i++)
			hC += list.get(i).hashCode();
		return hC;
	}
	public boolean isEmpty() { return list.isEmpty(); }
	public Iterator<T> iterator() { return list.iterator(); }
	public boolean remove(Object o) { return list.remove(o); }
	public boolean removeAll(Collection<?> coll) { return list.removeAll(coll); }
	public boolean retainAll(Collection<?> coll) { return list.retainAll(coll); }
	public Object[] toArray() { return list.toArray(); }
	public <T> T[] toArray(T[] t) { return list.toArray(t); }
	public String toString() {
		if(list.size() == 0)
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + ", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append("]");
		return sb.toString();
	}
}

public class Ch17ex18 {

	public static void main(String[] args) {
		SlowSet<String> slowSet = new SlowSet<String>();
		Generator<String> generator = new RandomGenerator.String(3);
		for(int i = 0; i < 10; i++)
			slowSet.add(generator.next());
		print("slowSet: " + slowSet);
		print("slowSet.size(): " + slowSet.size());
		slowSet.add("ABC");
		print("slowSet.add(\"ABC\")");
		print("slowSet: " + slowSet);
		SlowSet<String> slowSet2 = new SlowSet<String>();
		for(int i = 0; i < 5; i++)
			slowSet2.add(generator.next());
		print("slowSet2: " + slowSet2);
		print("slowSet.addAll(slowSet2)");
		slowSet.addAll(slowSet2);
		print("slowSet: " + slowSet);
		slowSet.clear();
		print("slowSet.clear()");
		print("slowSet.isEmpty(): " + slowSet.isEmpty());
		print("slowSet: " + slowSet);
		for(int i = 0; i < 4; i++)
			slowSet.add(generator.next());
		print("slowSet: " + slowSet);
		print("slowSet.contains(\"Eah\"): " + slowSet.contains("Eah"));
		slowSet2.clear();
		print("slowSet2.clear()");
		print("slowSet2: " + slowSet2);
		slowSet2.add("HLG");
		slowSet2.add("Eah");
		slowSet2.add("Kcx");
		print("slowSet2: " + slowSet2);
		print("slowSet.containsAll(slowSet2): " + slowSet.containsAll(slowSet2));
		slowSet2.add("rEq");
		print("slowSet2.add(\"rEq\")");
		print("slowSet.equals(slowSet2): " + slowSet.equals(slowSet2));
		print("slowSet.get(2): " + slowSet.get(2));
		print("slowSet.hashCode(): " + slowSet.hashCode());
		printnb("Using iterator: ");
		Iterator<String> it = slowSet.iterator();
		while(it.hasNext())
			printnb(it.next() + ", ");
		print("\nslowSet.remove(\"HLG\")");
		slowSet.remove("HLG");
		print("slowSet: " + slowSet);
		for(int i = 0; i < 5; i++)
			slowSet.add(generator.next());
		print("slowSet: " + slowSet);
		print("slowSet2: " + slowSet2);
		print("slowSet.retainAll(slowSet2)");
		slowSet.retainAll(slowSet2);
		print("slowSet: " + slowSet);
		print("slowSet.removeAll(slowSet2)");
		slowSet.removeAll(slowSet2);
		print("slowSet: " + slowSet);
		for(int i = 0; i < 5; i++)
			slowSet.add(generator.next());
		print("slowSet: " + slowSet);
		String[] array = new String[5];
		print("slowSet.toArray(array): " + slowSet.toArray(array));
		for(int i = 0; i < array.length; i++)
			printnb(array[i] + ", ");
		
	}

}

/* Output:
 * slowSet: [YNz, brn, yGc, FOW, ZnT, cQr, Gse, GZM, mJM, RoE]
slowSet.size(): 10
slowSet.add("ABC")
slowSet: [YNz, brn, yGc, FOW, ZnT, cQr, Gse, GZM, mJM, RoE, ABC]
slowSet2: [suE, cUO, neO, EdL, smw]
slowSet.addAll(slowSet2)
slowSet: [YNz, brn, yGc, FOW, ZnT, cQr, Gse, GZM, mJM, RoE, ABC, suE, cUO, neO, EdL, smw]
slowSet.clear()
slowSet.isEmpty(): true
slowSet: []
slowSet: [HLG, Eah, Kcx, rEq]
slowSet.contains("Eah"): true
slowSet2.clear()
slowSet2: []
slowSet2: [HLG, Eah, Kcx]
slowSet.containsAll(slowSet2): true
slowSet2.add("rEq")
slowSet.equals(slowSet2): true
slowSet.get(2): Kcx
slowSet.hashCode(): 328109
Using iterator: HLG, Eah, Kcx, rEq, 
slowSet.remove("HLG")
slowSet: [Eah, Kcx, rEq]
slowSet: [Eah, Kcx, rEq, UCB, bkI, naM, esb, tWH]
slowSet2: [HLG, Eah, Kcx, rEq]
slowSet.retainAll(slowSet2)
slowSet: [Eah, Kcx, rEq]
slowSet.removeAll(slowSet2)
slowSet: []
slowSet: [kjU, rUk, ZPg, wsq, PzD]
[Ljava.lang.String;@52e922
kjU, rUk, ZPg, wsq, PzD, 
*/
