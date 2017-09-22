import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class SimpleHashSet<T> extends AbstractSet<T>{
	static final int SIZE = 997;
	LinkedList<T>[] buckets = new LinkedList[SIZE];
	public int size() {
		int result = 0;
		for(LinkedList<T> bucket : buckets)
			if(bucket != null)
				result += bucket.size();
		return result;
	}
	public boolean add(T t) {
		if(this.contains(t)) return false;
		int index = Math.abs(t.hashCode()) % SIZE;
		if(buckets[index] == null)
			buckets[index] = new LinkedList<T>();
		buckets[index].add(t);
		return true;
	}
	public boolean addAll(Collection<? extends T> c) {
		int sizeBefore = this.size();
		for(T t : c) this.add(t);
		return(this.size() > sizeBefore);
	}
	public void clear() {
		for(LinkedList<T> bucket : buckets)
			if(bucket != null)
				bucket.clear();
	}
	public boolean contains(Object o) {
		int index = Math.abs(o.hashCode()) % SIZE;
		if(buckets[index] == null) return false;
		for(T t : buckets[index])
			if(t.equals(o))
				return true;
		return false;
	}
	public boolean containsAll(Collection<?> c) {
		int count = 0;
		for(Object o : c)
			if(this.contains(o))
				count++;
		return count == c.size();
	}
	public boolean equals(Object o) {
		if(o instanceof SimpleHashSet) {
			if(this.size() == ((SimpleHashSet)o).size()) {
				int count = 0;
				Iterator it = ((SimpleHashSet)o).iterator();
				while(it.hasNext()) {
					if(this.contains(it.next()))
						count++;
				}
				if(count == this.size()) return true;
			}
		}
		return false;
	}
	public int hashCode() {
		int result = 0;
		for(LinkedList<T> bucket : buckets) {
			if(bucket != null)
				for(T t : bucket)
					if(t != null) result += t.hashCode();
		}
		return result;
	}
	public boolean isEmpty() {
		return(this.size() == 0);
	}
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int bucketIndex = 0;
			private int listIndex = 0;
			private int count = -1;
			public boolean hasNext() {
				return count < SimpleHashSet.this.size() - 1;
			}
			public T next() {
				while(buckets[bucketIndex] == null || 
						buckets[bucketIndex].size() == 0 || listIndex == buckets[bucketIndex].size()) {
					bucketIndex++;
					listIndex = 0;
				}
				T result = buckets[bucketIndex].get(listIndex);
				listIndex++;
				count++;
				return result;
			}
		};
	}
	public boolean remove(Object o) {
		int index = Math.abs(o.hashCode()) % SIZE;
		if(buckets[index] == null) return false;
		for(T t : buckets[index]) {
			if(t.equals(o)) {
				buckets[index].remove(t);
				return true;
			}
		}
		return false;
	}
	public boolean removeAll(Collection<?> c ) {
		int s = this.size();
		for(Object o : c) {
			this.remove(o);
		}
		return (this.size() == s);
	}
	public boolean retainAll(Collection<?> c) {
		int n = this.size();
		for(LinkedList<T> bucket : buckets) {
			if(bucket != null) {
				for(T t : bucket) 
					if(!(c.contains(t))) this.remove(t);
			}
		}
		if(n != this.size()) return true;
		return false;
	}
	public Object[] toArray() {
		Object[] array = new Object[this.size()];
		Iterator<T> iterator = this.iterator();
		int index = 0;
		while(iterator.hasNext()) {
			array[index++] = iterator.next();
		}
		return array;
	}
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] array) {
		Iterator<T> iterator = (Iterator<T>)this.iterator();
		for(int i = 0; i < this.size(); i++) {
			T t = iterator.next();
			array[i] = t;
		}
		return array;
	}
	public String toString() {
		if(this.size() == 0)
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Iterator<T> iterator = this.iterator();
		while(iterator.hasNext()) {
			sb.append(iterator.next() + ", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append("]");
		return sb.toString();
	}
	public static void main(String[] args) {
		SimpleHashSet<String> shs = new SimpleHashSet<String>();
		Generator<String> gen = new RandomGenerator.String(3);
		for(int i = 0; i < 10; i++)
			shs.add(gen.next());
		print("shs: " + shs);
		SimpleHashSet<String> shs2 = new SimpleHashSet<String>();
		for(int i = 0; i < 5; i++)
			shs2.add(gen.next());
		print("shs2: " + shs2);
		print("shs.add(\"XYZ\")");
		shs.add("XYZ");
		print("shs: " + shs);
		print("shs.addAll(shs2)");
		shs.addAll(shs2);
		print("shs: " + shs);
		print("shs.contains(\"cQr\"): " + shs.contains("cQr"));
		print("shs.clear()");
		shs.clear();
		print("shs.isEmpty(): " + shs.isEmpty());
		print("shs: " + shs);
		print("shs.addAll(shs2)");
		shs.addAll(shs2);
		print("shs: " + shs);
		print("shs.equals(shs2): " + shs.equals(shs2));
		print("shs.hashCode(): " + shs.hashCode());
		printnb("Using shs.iterator(): ");
		Iterator<String> it = shs.iterator();
		while(it.hasNext()) {
			printnb(it.next() + ", ");
		}
		shs.remove("neO");
		print("\nshs.remove(\"neO\")");
		print("shs: " + shs);
		print("shs.removeAll(shs2)");
		shs.removeAll(shs2);
		print("shs: " + shs);
		for(int i = 0; i < 4; i++)
			shs.add(gen.next());
		print("shs: " + shs);
		Object[] objArr = shs.toArray();
		print(objArr);
		String[] stringArr = shs.toArray(new String[shs.size()]);
		print(Arrays.toString(stringArr));
		SimpleHashSet<String> shs3 = new SimpleHashSet<String>();
		shs3.add("rEq");
		shs3.add("Eah");
		shs3.add("ABC");
		
		print("shs3: " + shs3);
		print("shs: " + shs);
		print("shs.retainAll(shs3)");
		shs.retainAll(shs3);
		print("shs: " + shs);
		print("shs3: " + shs3);
		print("shs.size(): " + shs.size());
	}

}

/* Output:
shs: [FOW, cQr, Gse, brn, ZnT, GZM, YNz, mJM, RoE, yGc]
shs2: [cUO, neO, smw, suE, EdL]
shs.add("XYZ")
shs: [FOW, cQr, Gse, brn, ZnT, GZM, YNz, mJM, RoE, XYZ, yGc]
shs.addAll(shs2)
shs: [FOW, cQr, Gse, brn, cUO, neO, ZnT, GZM, YNz, smw, mJM, suE, RoE, XYZ, EdL, yGc]
shs.contains("cQr"): true
shs.clear()
shs.isEmpty(): true
shs: []
shs.addAll(shs2)
shs: [cUO, neO, smw, suE, EdL]
shs.equals(shs2): true
shs.hashCode(): 504482
Using shs.iterator(): cUO, neO, smw, suE, EdL, 
shs.remove("neO")
shs: [cUO, smw, suE, EdL]
shs.removeAll(shs2)
shs: []
shs: [rEq, Kcx, Eah, HLG]
[Ljava.lang.Object;@7852e922
[rEq, Kcx, Eah, HLG]
shs3: [rEq, Eah, ABC]
shs: [rEq, Kcx, Eah, HLG]
shs.retainAll(shs3)
shs: [rEq, Eah]
shs3: [rEq, Eah, ABC]
shs.size(): 2
*/