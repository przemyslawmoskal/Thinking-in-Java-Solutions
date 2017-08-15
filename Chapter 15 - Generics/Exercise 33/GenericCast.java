import java.util.*;

class FullStackException extends Exception {};

class Ch15Ex33Stack<T> {
	private int index = 0;
	private final int size;
	private final List<T> storage;
	public Ch15Ex33Stack(int size) {
		storage = new ArrayList<T>(size);
		this.size = size;
	}
	public void push(T item) throws FullStackException {
		if(index < size ) {
			storage.add(item);
			index++;
		}
		else throw new FullStackException();
	}
	public T pop() {
		if(index > 0)
			return storage.get(--index);
		throw new EmptyStackException();
	}
}	

public class GenericCast {
	public static final int SIZE = 10;
	public static void main(String[] args) throws FullStackException {
		Ch15Ex33Stack<String> strings =
				new Ch15Ex33Stack<String>(SIZE);
		for(String s : "A B C D E F G H I J".split(" "))
			strings.push(s);
		try {
			strings.push("K");
		}catch (FullStackException e) {
			System.out.println("\nStack is full");
		}
		for(int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}
		try {
			String ss = strings.pop();
		} catch(EmptyStackException e) {
			System.out.println("\nStack is empty");
		}
	}
}

/* Output:

Stack is full
J I H G F E D C B A 
Stack is empty

*/