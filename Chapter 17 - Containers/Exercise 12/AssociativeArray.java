import java.util.*;
import static net.mindview.util.Print.*;

public class AssociativeArray<K,V> {
	private Object[][] pairs;
	private int index;
	public AssociativeArray(int length) {
		pairs = new Object[length][2];
	}	
	public void put(K key, V value) {
		if(index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++] = new Object[]{ key, value };
	}
	@SuppressWarnings("unchecked")
	public V get(K key) {
		for(int i = 0; i < index; i++)
			if(key.equals(pairs[i][0]))
				return (V)pairs[i][1];
		return null; // Did not find key
	}
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < index; i++) {
			result.append(pairs[i][0].toString());
			result.append(" : ");
			result.append(pairs[i][1].toString());
			if(i < index - 1)
				result.append("\n");
		}
		return result.toString();
	}
	 public static void main(String[] args) {
		 AssociativeArray<String,String> map =
				 new AssociativeArray<String,String>(6);
		 map.put("sky", "blue");
		 map.put("grass", "green");
		 map.put("ocean", "dancing");
		 map.put("tree", "tall");
		 map.put("earth", "brown");
		 map.put("sun", "warm");
		 try {
			 map.put("extra", "object"); // Past the end
		 } catch(ArrayIndexOutOfBoundsException e) {
			 print("Too many objects!");
		 }
		 print(map);
		 print(map.get("ocean"));
		 HashMap<String,String> hashMap =
				 new HashMap<String,String>(6);
		 hashMap.put("sky", "blue");
		 hashMap.put("grass", "green");
		 hashMap.put("ocean", "dancing");
		 hashMap.put("tree", "tall");
		 hashMap.put("earth", "brown");
		 hashMap.put("sun", "warm");
		 try {
			 hashMap.put("extra", "object");
		 } catch(ArrayIndexOutOfBoundsException e) {
			 print("Too many objects!");
		 }
		 print("hashMap: " + hashMap);
		 print(hashMap.get("ocean"));
		 TreeMap<String,String> treeMap =
				 new TreeMap<String,String>();
		 treeMap.put("sky", "blue");
		 treeMap.put("grass", "green");
		 treeMap.put("ocean", "dancing");
		 treeMap.put("tree", "tall");
		 treeMap.put("earth", "brown");
		 treeMap.put("sun", "warm");
		 try {
			 treeMap.put("extra", "object");
		 } catch(ArrayIndexOutOfBoundsException e) {
			 print("Too many objects!");
		 }
		 print("treeMap: " + treeMap);
		 print(treeMap.get("ocean"));
		 LinkedHashMap<String,String> linkedHashMap =
				 new LinkedHashMap<String,String>(6);
		 linkedHashMap.put("sky", "blue");
		 linkedHashMap.put("grass", "green");
		 linkedHashMap.put("ocean", "dancing");
		 linkedHashMap.put("tree", "tall");
		 linkedHashMap.put("earth", "brown");
		 linkedHashMap.put("sun", "warm");
		 try {
			 linkedHashMap.put("extra", "object");
		 } catch(ArrayIndexOutOfBoundsException e) {
			 print("Too many objects!");
		 }
		 print("linkedHashMap: " + linkedHashMap);
		 print(linkedHashMap.get("ocean"));
	 }
}

/* Output:
Too many objects!
sky : blue
grass : green
ocean : dancing
tree : tall
earth : brown
sun : warm
dancing
hashMap: {sky=blue, ocean=dancing, grass=green, earth=brown, extra=object, tree=tall, sun=warm}
dancing
treeMap: {earth=brown, extra=object, grass=green, ocean=dancing, sky=blue, sun=warm, tree=tall}
dancing
linkedHashMap: {sky=blue, grass=green, ocean=dancing, tree=tall, earth=brown, sun=warm, extra=object}
dancing
*/
