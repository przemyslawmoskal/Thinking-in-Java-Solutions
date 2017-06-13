interface Selector {
	boolean end();
	Object current();
	void next();
}	

public class Sequence {
	private Object[] items;
	private int next = 0;
	public Sequence(int size) { items = new Object[size]; }
	public void add(Object x) {
		if(next < items.length)
			items[next++] = x;
	}
	public void f() { System.out.println("Sequence.f()");  }
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; }
		// This method allows to produce outer class reference
		public Sequence getOuterRef() {
			return Sequence.this;
		}
	}
	public Selector selector() {
		return new SequenceSelector();
	}	
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		System.out.println();
		// Testing if casting and getting outer class reference is working correctly
		((SequenceSelector)selector).getOuterRef().f();
	}
}

/* Output:
0 1 2 3 4 5 6 7 8 9 
Sequence.f()
*/
