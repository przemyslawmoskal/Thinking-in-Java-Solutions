import java.util.*;
import static net.mindview.util.Print.*;

public class CountedString {
	private static List<String> created =
			new ArrayList<String>();
	private String s;
	private int id = 0;
	private char c;
	public CountedString(String str, char ch) {
		s = str;
		c = ch;
		created.add(s);
		// id is the total number of instances
		// of this string in use by CountedString:
		for(String s2 : created)
			if(s2.equals(s))
				id++;
	}
	public String toString() {
		return "String: " + s + ", char: " + c + ", id: " + id +
				" hashCode(): " + hashCode();
	}
	public int hashCode() {
		// The very simple approach:
		// return s.hashCode() * id;
		// Using Joshua Bloch's recipe:
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + c;
		result = 37 * result + id;
		return result;
	}
	public boolean equals(Object o) {
		return o instanceof CountedString &&
				s.equals(((CountedString)o).s) &&
				id == ((CountedString)o).id &&
				c == ((CountedString)o).c;
	}
	public static void main(String[] args) {
		Map<CountedString,Integer> map =
				new HashMap<CountedString,Integer>();
		CountedString[] cs = new CountedString[5];
		for(int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString("hi", 'h');
			map.put(cs[i], i); // Autobox int -> Integer
		}
		print(map);
		for(CountedString cstring : cs) {
			print("Looking up " + cstring);
			print(map.get(cstring));
		}
	}
}

/* Output: (Sample)
{String: hi, char: h, id: 4 hashCode(): 5422354=3, String: hi, char: h, id: 5 hashCode(): 5422355=4, String: hi, char: h, id: 2 hashCode(): 5422352=1, String: hi, char: h, id: 3 hashCode(): 5422353=2, String: hi, char: h, id: 1 hashCode(): 5422351=0}
Looking up String: hi, char: h, id: 1 hashCode(): 5422351
0
Looking up String: hi, char: h, id: 2 hashCode(): 5422352
1
Looking up String: hi, char: h, id: 3 hashCode(): 5422353
2
Looking up String: hi, char: h, id: 4 hashCode(): 5422354
3
Looking up String: hi, char: h, id: 5 hashCode(): 5422355
4
*/
