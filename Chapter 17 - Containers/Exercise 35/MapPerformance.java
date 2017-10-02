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
			Tester.defaultParams = TestParam.array(10, 500, 100, 500, 500, 100);
		Tester.run(new SlowMap<Integer, Integer>(), tests);
		Tester.run(new TreeMap<Integer, Integer>(), tests);
		Tester.run(new HashMap<Integer, Integer>(), tests);
		Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
		Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
		Tester.run(new WeakHashMap<Integer, Integer>(), tests);
		Tester.run(new Hashtable<Integer, Integer>(), tests);
	}
}

/* Output (Sample):
---------- SlowMap ----------
 size     put     get iterate
   10    6457     930    1282
  100    6958     622    2362
  500   13224    1230   10621
---------- TreeMap ----------
 size     put     get iterate
   10    2454    1354     942
  100     608      98     223
  500     160     158      24
---------- HashMap ----------
 size     put     get iterate
   10     357     326     201
  100      91      62      44
  500      85      89      22
------- LinkedHashMap -------
 size     put     get iterate
   10     603     482      93
  100     129      68      24
  500     124      37      17
------ IdentityHashMap ------
 size     put     get iterate
   10     734     397     241
  100     277     115      62
  500     213     226      53
-------- WeakHashMap --------
 size     put     get iterate
   10    1232     416     242
  100     184      21      34
  500     136      84      26
--------- Hashtable ---------
 size     put     get iterate
   10     571     208     265
  100     107     236      34
  500     103      45      28
*/