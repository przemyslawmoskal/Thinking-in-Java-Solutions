
//: containers/MapPerformance.java
// Demonstrates performance differences in Maps.
// {Args: 100 5000} Small to keep build testing short
import java.util.*;

public class MapPerformance {
	static List<Test<Map<Integer, Integer>>> tests = new ArrayList<Test<Map<Integer, Integer>>>();
	static {
		tests.add(new Test<Map<Integer, Integer>>("put") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					map.clear();
					for (int j = 0; j < size; j++)
						map.put(j, j);
				}
				return loops * size;
			}
		});
		tests.add(new Test<Map<Integer, Integer>>("get") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for (int i = 0; i < loops; i++)
					for (int j = 0; j < span; j++)
						map.get(j);
				return loops * span;
			}
		});
		tests.add(new Test<Map<Integer, Integer>>("iterate") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops * 10;
				for (int i = 0; i < loops; i++) {
					Iterator it = map.entrySet().iterator();
					while (it.hasNext())
						it.next();
				}
				return loops * map.size();
			}
		});
	}

	public static void main(String[] args) {
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		else
			Tester.defaultParams = TestParam.array(10, 1000, 100, 1000, 1000, 100);
		Tester.run(new SimpleHashMap<Integer, Integer>(), tests);
		Tester.run(new SimpleHashMapArr<Integer, Integer>(), tests);
		Tester.run(new HashMap<Integer, Integer>(), tests);
		Tester.run(new TreeMap<Integer, Integer>(), tests);
		Tester.run(new HashMap<Integer, Integer>(), tests);
		Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
		Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
		Tester.run(new WeakHashMap<Integer, Integer>(), tests);
		Tester.run(new Hashtable<Integer, Integer>(), tests);
	}
}

/* Output (Sample):
------- SimpleHashMap -------
size     put     get iterate
  10    2448     148     564
  10     673      90     794
1000   21313      59   19719
------ SimpleHashMapArr ------
size     put     get iterate
  10     753      62     468
  10     458      26     455
1000   20401      47   19495
---------- HashMap ----------
size     put     get iterate
  10      97      63      28
  10      43      20      24
1000      58      28      20
---------- TreeMap ----------
size     put     get iterate
  10     462      74      53
  10      81      49      31
1000     199     145      32
---------- HashMap ----------
size     put     get iterate
  10      43      21      23
  10      43      21      23
1000      58      29      20
------- LinkedHashMap -------
size     put     get iterate
  10     146      35      29
  10      61      21      19
1000      74      25      16
------ IdentityHashMap ------
size     put     get iterate
  10     179      96      79
  10     107      81      41
1000     168     153      34
-------- WeakHashMap --------
size     put     get iterate
  10     338      56      51
  10      75      23      63
1000      90      26      21
--------- Hashtable ---------
size     put     get iterate
  10     307      43      57
  10      43      21      27
1000      54      29      23
*/