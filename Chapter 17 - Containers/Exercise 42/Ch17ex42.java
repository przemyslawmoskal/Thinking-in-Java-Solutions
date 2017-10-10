import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

class A implements Comparable<A> {
	String s1;
	String s2;

	A(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public int compareTo(A obj) {
		return s1.compareToIgnoreCase(obj.s1);
	}

	static class AComparator implements Comparator<A> {
		public int compare(A obj1, A obj2) {
			return obj1.s2.compareToIgnoreCase(obj2.s2);
		}
	}
	public static void printArray(A[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.delete(sb.length() - 2,sb.length());
		sb.append(")");
		print(sb);
	}

	public String toString() {
		return "[" + s1 + ", " + s2 + "]";
	}
}

public class Ch17ex42 {

	public static void main(String[] args) {
		RandomGenerator.String gen = new RandomGenerator.String(3);
		ArrayList<A> aList = new ArrayList<A>();
		A.AComparator comp = new A.AComparator();
		A[] array = new A[5];
		for(int i = 0; i < array.length; i++)
			array[i] = new A(gen.next(),gen.next());
		printnb("array: ");
		A.printArray(array);
		Arrays.sort(array);
		printnb("Arrays.sort(array): ");
		A.printArray(array);
		Arrays.sort(array, comp);
		printnb("Arrays.sort(array, comp): ");
		A.printArray(array);
		print("A obj1 = array[2]");
		A obj1 = array[2];
		printnb("Arrays.binarySearch(array, obj1, comp): ");
		print(Arrays.binarySearch(array, obj1, comp));
		for (int i = 0; i < 10; i++)
			aList.add(new A(gen.next(), gen.next()));
		print("aList: " + aList);
		printnb("Collections.sort(aList):");
		Collections.sort(aList);
		print(aList);
		printnb("Collections.sort(aList, comp): ");
		Collections.sort(aList, comp);
		print("aList: " + aList);
		print("A obj2 = aList.get(1)");
		A obj2 = aList.get(1);
		printnb("Collections.binarySearch(aList, obj2, comp): ");
		print(Collections.binarySearch(aList, obj2, comp));
	}

}

/* Output:
array: ([YNz, brn], [yGc, FOW], [ZnT, cQr], [Gse, GZM], [mJM, RoE])
Arrays.sort(array): ([Gse, GZM], [mJM, RoE], [yGc, FOW], [YNz, brn], [ZnT, cQr])
Arrays.sort(array, comp): ([YNz, brn], [ZnT, cQr], [yGc, FOW], [Gse, GZM], [mJM, RoE])
A obj1 = array[2]
Arrays.binarySearch(array, obj1, comp): 2
aList: [[suE, cUO], [neO, EdL], [smw, HLG], [Eah, Kcx], [rEq, UCB], [bkI, naM], [esb, tWH], [kjU, rUk], [ZPg, wsq], [PzD, yCy]]
Collections.sort(aList):[[bkI, naM], [Eah, Kcx], [esb, tWH], [kjU, rUk], [neO, EdL], [PzD, yCy], [rEq, UCB], [smw, HLG], [suE, cUO], [ZPg, wsq]]
Collections.sort(aList, comp): aList: [[suE, cUO], [neO, EdL], [smw, HLG], [Eah, Kcx], [bkI, naM], [kjU, rUk], [esb, tWH], [rEq, UCB], [ZPg, wsq], [PzD, yCy]]
A obj2 = aList.get(1)
Collections.binarySearch(aList, obj2, comp): 1
*/