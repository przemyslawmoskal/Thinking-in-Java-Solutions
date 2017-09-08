import java.util.*;

class MyList<T> extends ArrayList<T> {
	List<T> myList = new ArrayList<T>();
	MyList(List<T> list) { myList = list; }
	public MyList<T> getReversed() {
		ListIterator<T> iterator = myList.listIterator(myList.size());
		List<T> reverseList = new ArrayList<T>();
		while(iterator.hasPrevious())
			reverseList.add(iterator.previous());
		return new MyList<T>(reverseList);
	}
}

public class PythonListsToJava {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(aList.getClass().getSimpleName());
		System.out.println(aList);
		System.out.println(aList.get(4));
		aList.add(6);
		aList.addAll(new ArrayList<Integer>(Arrays.asList(7,8)));
		List<Integer> aSlice = aList.subList(2,4);
		System.out.println(aSlice);
		MyList<Integer> list2 = new MyList<Integer>(aList);
		System.out.println(list2.getReversed().myList);
	}

}

/* Output:
 * ArrayList
[1, 2, 3, 4, 5]
5
[3, 4]
[8, 7, 6, 5, 4, 3, 2, 1]
*/
