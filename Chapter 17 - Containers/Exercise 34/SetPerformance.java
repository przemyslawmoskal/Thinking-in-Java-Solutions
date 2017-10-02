import java.util.*;
import net.mindview.util.*;

public class SetPerformance {
	static CountingGenerator.String gen = new CountingGenerator.String(3);
	static CountingGenerator.String gen2 = new CountingGenerator.String(3);
	static List<Test<Set<String>>> tests = new ArrayList<Test<Set<String>>>();
	static {
		tests.add(new Test<Set<String>>("add") {
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					set.clear();
					for (int j = 0; j < size; j++)
						set.add(gen.next());
				}
				return loops * size;
			}
		});
		tests.add(new Test<Set<String>>("contains") {
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for (int i = 0; i < loops; i++)
					for (int j = 0; j < span; j++)
						set.contains(gen2.next());
				return loops * span;
			}
		});
		tests.add(new Test<Set<String>>("iterate") {
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops * 10;
				for (int i = 0; i < loops; i++) {
					Iterator<String> it = set.iterator();
					while (it.hasNext())
						it.next();
				}
				return loops * set.size();
			}
		});
	}

	public static void main(String[] args) {
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		Tester.fieldWidth = 10;
		Tester.run(new TreeSet<String>(), tests);
		Tester.run(new HashSet<String>(), tests);
		Tester.run(new LinkedHashSet<String>(), tests);
	}
}

/* Output (Sample):
------------- TreeSet -------------
 size       add  contains   iterate
   10      1378       391       104
  100       369       223        18
 1000       313       230        11
10000       263       240        12
------------- HashSet -------------
 size       add  contains   iterate
   10       537       780       259
  100       160       187        36
 1000       178       146        21
10000       158       156        21
---------- LinkedHashSet ----------
 size       add  contains   iterate
   10       740       393        70
  100       214       139        17
 1000       155       152        16
10000       171       153        16
*/