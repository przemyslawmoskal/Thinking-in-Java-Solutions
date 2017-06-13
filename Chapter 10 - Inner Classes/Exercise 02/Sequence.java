//: innerclasses/Sequence.java
// Holds a sequence of Objects.

class MyClass {
	MyClass(String s) { this.s = s; }
	String s;
	public String toString() { return s; }
}

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
	public Selector selector() {
		return new SequenceSelector();
	}	
	public static void main(String[] args) {
		Sequence sequence1 = new Sequence(10);
		for(int i = 0; i < 10; i++)
			sequence1.add(Integer.toString(i));
		Selector selector1 = sequence1.selector();
		while(!selector1.end()) {
			System.out.print(selector1.current() + " ");
			selector1.next();
		}
		System.out.println();
		MyClass[] arr = new MyClass[10];
		arr[0] = new MyClass("First");
		arr[1] = new MyClass("Second");
		arr[2] = new MyClass("Third");
		arr[3] = new MyClass("Fourth");
		arr[4] = new MyClass("Fifth");
		arr[5] = new MyClass("Sixth");
		arr[6] = new MyClass("Seventh");
		arr[7] = new MyClass("Eighth");
		arr[8] = new MyClass("Nineth");
		arr[9] = new MyClass("Tenth");
		sequence1.add(arr[0].toString());
		Sequence sequenceMyClass = new Sequence(10);
		for(int i = 0; i < 10; i++)
			sequenceMyClass.add(arr[i].toString());
		Selector selectorMyClass = sequenceMyClass.selector();
		while(!selectorMyClass.end()) {
			System.out.print(selectorMyClass.current() + " ");
			selectorMyClass.next();
		}
	}
}

/* Output:
0 1 2 3 4 5 6 7 8 9 
First Second Third Fourth Fifth Sixth Seventh Eighth Nineth Tenth
*/
