import java.util.*;

interface Selector {
	boolean end();
	Object current();
	void next();
}	

public class GenericSequence<T> {
	private List<T> items = new ArrayList<T>();
	private int next = 0;
	public GenericSequence(List<T> items) { this.items = items; }
	public void add(T t) {
		items.add(t);
	}
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.size(); }
		public Object current() { return items.get(i); }
		public void next() { if(i < items.size()) i++; }
	}
	public Selector selector() {
		return new SequenceSelector();
	}	
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		GenericSequence<Integer> intgenseq = new GenericSequence<Integer>(myList);
		for(int i = 0; i < 10; i++)
			intgenseq.add(i);;
		Selector selector = intgenseq.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}

/* Output:
0 1 2 3 4 5 6 7 8 9
*/
