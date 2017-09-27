//: containers/ListPerformance.java
// Demonstrates performance differences in Lists.
// {Args: 100 500} Small to keep build testing short
import java.util.*;
import net.mindview.util.*;

public class ListPerformance {
	static Random rand = new Random();
	static RandomGenerator.String gen = new RandomGenerator.String(3);
	static int reps = 1000;
	static List<Test<List<String>>> tests =
			new ArrayList<Test<List<String>>>();
	static List<Test<LinkedList<String>>> qTests =
			new ArrayList<Test<LinkedList<String>>>();
	static {
		tests.add(new Test<List<String>>("add") {
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < listSize; j++)
						list.add(gen.next());
				}
				return loops * listSize;
			}
		});
		tests.add(new Test<List<String>>("get") {
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for(int i = 0; i < loops; i++)
					list.get(rand.nextInt(listSize));
				return loops;
			}
		});
		tests.add(new Test<List<String>>("set") {
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				String s = gen.next();
				for(int i = 0; i < loops; i++)
					list.set(rand.nextInt(listSize), s);
				return loops;
			}
		});
		tests.add(new Test<List<String>>("iteradd") {
			int test(List<String> list, TestParam tp) {
				final int LOOPS = 1000000;
				int half = list.size() / 2;
				String s = gen.next();
				ListIterator<String> it = list.listIterator(half);
				for(int i = 0; i < LOOPS; i++)
					it.add(s);
				return LOOPS;
			}
		});
		tests.add(new Test<List<String>>("insert") {
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				String s = gen.next();
				for(int i = 0; i < loops; i++)
					list.add(5, s); // Minimize random-access cost
				return loops;
			}
		});
		tests.add(new Test<List<String>>("remove") {
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
					while(list.size() > 5)
						list.remove(5); // Minimize random-access cost
				}
				return loops * size;
			}
		});
		// Tests for queue behavior:
		qTests.add(new Test<LinkedList<String>>("addFirst") {
			int test(LinkedList<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				String s = gen.next();
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < size; j++)
						list.addFirst(s);
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<String>>("addLast") {
			int test(LinkedList<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				String s = gen.next();
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < size; j++)
						list.addLast(s);
				}
				return loops * size;
			}
		});
		qTests.add(
			new Test<LinkedList<String>>("rmFirst") {
				int test(LinkedList<String> list, TestParam tp) {
					int loops = tp.loops;
					int size = tp.size;
					for(int i = 0; i < loops; i++) {
						list.clear();
						list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
						while(list.size() > 0)
							list.removeFirst();
					}
					return loops * size;
				}
			});
		qTests.add(new Test<LinkedList<String>>("rmLast") {
			int test(LinkedList<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
					while(list.size() > 0)
						list.removeLast();
				}
				return loops * size;
			}
		});
	}
	static class ListTester extends Tester<List<String>> {
		public ListTester(List<String> container,
				List<Test<List<String>>> tests) {
			super(container, tests);
		}
		// Fill to the appropriate size before each test:
		@Override protected List<String> initialize(int size){
			container.clear();
			container.addAll(Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size)));
			return container;
		}
		// Convenience method:
		public static void run(List<String> list,
				List<Test<List<String>>> tests) {
			new ListTester(list, tests).timedTest();
		}
	}
	public static void main(String[] args) {
		if(args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		// Can only do these two tests on an array:
		Tester<List<String>> arrayTest =
				new Tester<List<String>>(null, tests.subList(1, 3)){
			// This will be called before each test. It
			// produces a non-resizeable array-backed list:
			@Override protected
			List<String> initialize(int size) {
				String[] ia = Generated.array(String.class,
						new CountingGenerator.String(), size);
				return Arrays.asList(ia);
			}
		};
		arrayTest.setHeadline("Array as List");
		arrayTest.timedTest();
		Tester.defaultParams= TestParam.array(
				10, 5000, 100, 5000, 1000, 1000, 10000, 200);
		if(args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		ListTester.run(new ArrayList<String>(), tests);
		ListTester.run(new LinkedList<String>(), tests);
		ListTester.run(new Vector<String>(), tests);
		Tester.fieldWidth = 12;
		Tester<LinkedList<String>> qTest =
				new Tester<LinkedList<String>>(
						new LinkedList<String>(), qTests);
		qTest.setHeadline("Queue tests");
		qTest.timedTest();
	}
}

/* Output: (Sample)
--- Array as List ---
 size     get     set
   10      44      45
  100      43      45
 1000      44      42
10000      42      43
--------------------- ArrayList ---------------------
 size     add     get     set iteradd  insert  remove
   10     564      44      45      91    1490     584
  100     321      43      65      82    2411     358
 1000     178      43      44     325     878     504
10000     183      42      43    2656    6319    3232
--------------------- LinkedList ---------------------
 size     add     get     set iteradd  insert  remove
   10     216      61      60     153     207     473
  100     199      84      83     196      40     222
 1000     207     325     326      62      37     203
10000     210    5159    5230     145      73     210
----------------------- Vector -----------------------
 size     add     get     set iteradd  insert  remove
   10     186      44      46      48    1410     360
  100     183      44      47      73    1465     275
 1000     180      44      47     316     847     494
10000     182      43      46    2663    6360    2969
-------------------- Queue tests --------------------
 size    addFirst     addLast     rmFirst      rmLast
   10          50          47         259         279
  100          21          22         177         174
 1000          18          19         174         172
10000          21          22         185         184
*/