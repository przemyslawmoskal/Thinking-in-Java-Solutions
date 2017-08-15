import java.util.*;

class Ch15Ex33Stack<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	public void push(T item) { storage.add(item); }
	public T pop() { return (T)storage.remove((storage.size()-1)); }
	public int showSize() { return storage.size(); }
}	

public class GenericCast {
	public static void main(String[] args) {
		Ch15Ex33Stack<String> strings =
				new Ch15Ex33Stack<String>();
		for(String s : "A B C D E F G H I J".split(" "))
			strings.push(s);
		int counter = strings.showSize();
		for(int i = 0; i < counter; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}
	}
}

/* Output:
J I H G F E D C B A
*/