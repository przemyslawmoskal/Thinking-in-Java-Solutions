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
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; }
	}
	private class RSelector implements Selector {
		private int i = items.length-1;
		public boolean end() { return i == -1; }
	    public Object current() { return items[i]; }
	    public void next() { if(i > -1) i--; }
	}
	public Selector selector() {
		return new SequenceSelector();
	}	
	public Selector reverseSelector() {
		return new RSelector();
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
		Selector rselector = sequence.reverseSelector();
		while(!rselector.end()) {
			System.out.print(rselector.current() + " ");
			rselector.next();
		}
	}
}

/* Output:
0 1 2 3 4 5 6 7 8 9 
9 8 7 6 5 4 3 2 1 0
*/
