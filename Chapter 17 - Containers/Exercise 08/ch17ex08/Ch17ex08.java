package ch17ex08;
import java.util.*;
import static ptmoskal.Print.*;

class SList<T> {
	Link<T> firstLink = new Link<T>(null);
	public SListIterator<T> iterator() {
		return new SListIterator<T>(firstLink);
	}
	public String toString() {
		if(firstLink == null)
			return "[]";
		System.out.print("[");
		SListIterator<T> slit = this.iterator();
		StringBuilder sb = new StringBuilder();
		while(slit.hasNext()) {
			sb.append(slit.next() + (slit.hasNext() ? ", " : ""));
		}
		return sb + "]";
	}
}

class Link<T> {
	T t;
	Link<T> next;
	Link(T t) {
		this(t,null);
	}
	Link(T t,Link<T> next) {
		this.t = t;
		this.next = next;
	}
	public String toString() {
		if(t == null) return "null";
		return t.toString();
	}
}

class SListIterator<T> {
	Link<T> current;
	SListIterator(Link<T> link) {
		current = link;
	}
	public Link<T> next() {
		current = current.next;
		return current;
	}
	public boolean hasNext() {
		return (current.next != null);
	}
	public void add(T t) {
		current.next = new Link<T>(t, current.next);
	}
	public void remove() {
		if(current.next != null)
			current.next = current.next.next;
	}
}

public class Ch17ex08 {
	
	public static void main(String[] args) {
		SList<String> slist = new SList<String>();
		SListIterator<String> iterator = slist.iterator();
		iterator.add("One");
		print(slist);
		iterator.next();
		iterator.add("Two");
		print(slist);
		print(iterator.hasNext());
		print(iterator.next());
		print(iterator.hasNext());
		print(iterator.next());
		SList<Integer> slist2 = new SList<Integer>();
		SListIterator<Integer> iterator2 = slist2.iterator();
		for(int i = 0; i < 5; i++) {
			iterator2.add(i);
			iterator2.next();
		}
		print(slist2);
		SListIterator<Integer> iterator3 = slist2.iterator();
		iterator3.remove();
		print(slist2);
		while(iterator3.hasNext())
			iterator3.remove();
		print(slist2);
	}

}

/* Output:
 * [One]
[One, Two]
true
Two
false
null
[0, 1, 2, 3, 4]
[1, 2, 3, 4]
[]
*/
