import java.util.*;

public class ArrayOfGenerics {
	
	public static void main(String[] args) {
		List<List<String>> listsOfStrings = new ArrayList<List<String>>();
		listsOfStrings.add(new ArrayList<String>());
		List<Object> listOfObjects = new ArrayList<Object>();
		// Type mismatch: cannot convert from List<List<String>> to List<Object>:
		// listOfObjects = listsOfStrings;
		List<List> listOfLists = new ArrayList<List>();
		// Type mismatch: cannot convert from List<List<String>> to List<List>
		// listOfLists = listsOfStrings;
		List<List<BerylliumSphere>> listsOfBS = new ArrayList<List<BerylliumSphere>>();
		for(int i = 0; i < 2; i++) {
			listsOfBS.add(new ArrayList<BerylliumSphere>());
			for(int j = 0; j < 3; j++)
				listsOfBS.get(i).add(new BerylliumSphere());
		}
		System.out.println(listsOfBS);
	}
} 

/* Output:
[[Sphere 0, Sphere 1, Sphere 2], [Sphere 3, Sphere 4, Sphere 5]]
*/