import java.util.*;

class FastTraversalLinkedList<T> {
	LinkedList<T> ll = new LinkedList<T>();
	ArrayList<T> al = new ArrayList<T>();
	private ArrayList<T> toArrayList(LinkedList<T> llist) {
		al.clear();
		al.addAll(llist);
		ll.clear();
		return al;
	}
	private LinkedList<T> toLinkedList(ArrayList<T> alist) {
		ll.clear();
		ll.addAll(alist);
		al.clear();
		return ll;
	}
	public boolean add(T t) {
		if(al.size() < ll.size())
			ll.add(t);
		else
			toLinkedList(al).add(t);
		return true;
	}
	public void add(int index, T t) {
		if(al.size() < ll.size())
			ll.add(index, t);
		else
			toLinkedList(al).add(index, t);
	}
	public boolean addAll(Collection<? extends T> c) {
		if(c.size() > 0) {
			if(al.size() < ll.size())
				ll.addAll(c);
			else
				toLinkedList(al).addAll(c);
			return true;
		}
		return false;
	}
	public boolean addAll(int index, Collection<? extends T> c) {
		if(c.size() > 0) {
			if(al.size() < ll.size())
				ll.addAll(index, c);
			else
				toLinkedList(al).addAll(index, c);
			return true;
		}
		return false;
	}
	public void addFirst(T t) {
		if(al.size() < ll.size())
			ll.addFirst(t);
		else
			toLinkedList(al).addFirst(t);
	}
	public void addLast(T t) {
		if(al.size() < ll.size())
			ll.addLast(t);
		else
			toLinkedList(al).addLast(t);
	}
	public void clear() {
		if(al.size() < ll.size())
			ll.clear();
		else
			toLinkedList(al).clear();
	}
	public T get(int index) {
		if(ll.size() < al.size())
			return al.get(index);
		else
			return toArrayList(ll).get(index);
	}
	public T getFirst() {
		if(ll.size() < al.size())
			return al.get(0);
		else
			return toArrayList(ll).get(0);
	}
	public T getLast() {
		if(ll.size() < al.size())
			return al.get(al.size() - 1);
		else
			return toArrayList(ll).get(al.size() - 1);
	}
	public Iterator<T> iterator() {
		if(ll.size() < al.size())
			return al.iterator();
		else
			return toArrayList(ll).iterator();
	}
	public ListIterator<T> listIterator() {
		if(al.size() < ll.size())
			return ll.listIterator();
		else
			return toLinkedList(al).listIterator();
	}
	public ListIterator<T> listIterator(int index) {
		if(al.size() < ll.size())
			return ll.listIterator(index);
		else
			return toLinkedList(al).listIterator(index);
	}
	public T remove(int index) {
		if(al.size() < ll.size())
			return ll.remove(index);
		else
			return toLinkedList(al).remove(index);
	}
	public T removeFirst() {
		if(al.size() < ll.size())
			return ll.removeFirst();
		else
			return toLinkedList(al).removeFirst();
	}
	public T removeLast() {
		if(al.size() < ll.size())
			return ll.removeLast();
		else
			return toLinkedList(al).removeLast();
	}
	public T set(int index, T t) {
		if(ll.size() < al.size())
			return al.set(index, t);
		else
			return toArrayList(ll).set(index, t);
	}
	public int size() {
		return al.size() < ll.size() ? ll.size() : al.size();
	}
	public String toString() {
		return al.size() > ll.size()
				? al.toString() : (al.size() == ll.size() ? al.toString() : ll.toString());
	}
	
}
