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
		return s1.compareTo(obj.s1);
	}

	static class AComparator implements Comparator<A> {
		public int compare(A obj1, A obj2) {
			return obj1.s2.compareTo(obj2.s2);
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
	
	public boolean equals(Object obj) {
		return ((obj instanceof A) && (s1.equals(((A)obj).s1)) && (s2.equals(((A)obj).s2)));
	}
	
	public int hashCode() {
		int result = 17;
		result = 37 * result + s1.hashCode();
		result = 37 * result + s2.hashCode();
		return result;
	}

	public String toString() {
		return "[" + s1 + ", " + s2 + "]";
	}
}

public class Ch17ex41 {

	public static void main(String[] args) {
		RandomGenerator.String genS = new RandomGenerator.String(3);
		RandomGenerator.Integer genI = new RandomGenerator.Integer(100);
		Set<A> set = new HashSet<A>();
		Map<A, Integer> map = new HashMap<A, Integer>();
		for(int i = 0; i < 5; i++) {
			String s1 = genS.next();
			String s2 = genS.next();
			set.add(new A(s1,s2));
			map.put(new A(s1,s2), genI.next());
		}
		String s3 = "aaa";
		String s4 = "bbb";
		for(int i = 0; i < 10; i++) {
			set.add(new A(s3,s4));
			map.put(new A(s3,s4), genI.next());
		}
		print("hashSet: " + set);
		print("hashMap: " + map);
	}

}

/* Output:
hashSet: [[TcQ, rGs], [GZM, mJM], [oEs, uEc], [YNz, brn], [GcF, OWZ], [aaa, bbb]]
hashMap: {[TcQ, rGs]=16, [GZM, mJM]=75, [oEs, uEc]=22, [YNz, brn]=68, [GcF, OWZ]=89, [aaa, bbb]=66}
*/