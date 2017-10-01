import java.util.*;
import net.mindview.util.*;

public class ListPerformance {
	static Random rand = new Random();
	static int reps = 1000;
	static List<Test<FastTraversalLinkedList<Integer>>> tests =
			new ArrayList<Test<FastTraversalLinkedList<Integer>>>();
	static List<Test<FastTraversalLinkedList<Integer>>> qTests =
			new ArrayList<Test<FastTraversalLinkedList<Integer>>>();
	static {
		tests.add(new Test<FastTraversalLinkedList<Integer>>("add") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < listSize; j++)
						list.add(j);
				}
				return loops * listSize;
			}
		});
		tests.add(new Test<FastTraversalLinkedList<Integer>>("get") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for(int i = 0; i < loops; i++)
					list.get(rand.nextInt(listSize));
				return loops;
			}
		});
		tests.add(new Test<FastTraversalLinkedList<Integer>>("set") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for(int i = 0; i < loops; i++)
					list.set(rand.nextInt(listSize), 47);
				return loops;
			}
		});
		tests.add(new Test<FastTraversalLinkedList<Integer>>("iteradd") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				final int LOOPS = 1000000;
				int half = list.size() / 2;
				ListIterator<Integer> it = list.listIterator(half);
				for(int i = 0; i < LOOPS; i++)
					it.add(47);
				return LOOPS;
			}
		});
		tests.add(new Test<FastTraversalLinkedList<Integer>>("insert") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				for(int i = 0; i < loops; i++)
					list.add(5, 47); // Minimize random-access cost
				return loops;
			}
		});
		tests.add(new Test<FastTraversalLinkedList<Integer>>("remove") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size() > 5)
						list.remove(5); // Minimize random-access cost
				}
				return loops * size;
			}
		});
		// Tests for queue behavior:
		qTests.add(new Test<FastTraversalLinkedList<Integer>>("addFirst") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < size; j++)
						list.addFirst(47);
				}
				return loops * size;
			}
		});
		qTests.add(new Test<FastTraversalLinkedList<Integer>>("addLast") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < size; j++)
						list.addLast(47);
				}
				return loops * size;
			}
		});
		qTests.add(
				new Test<FastTraversalLinkedList<Integer>>("rmFirst") {
					int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
						int loops = tp.loops;
						int size = tp.size;
						for(int i = 0; i < loops; i++) {
							list.clear();
							list.addAll(new CountingIntegerList(size));
							while(list.size() > 0)
								list.removeFirst();
						}
						return loops * size;
					}
				});
		qTests.add(new Test<FastTraversalLinkedList<Integer>>("rmLast") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size() > 0)
						list.removeLast();
				}
				return loops * size;
			}
		});
	}
	static class ListTester extends Tester<FastTraversalLinkedList<Integer>> {
		public ListTester(FastTraversalLinkedList<Integer> container,
				List<Test<FastTraversalLinkedList<Integer>>> tests) {
					super(container, tests);
				}
		// Fill to the appropriate size before each test:
		@Override protected FastTraversalLinkedList<Integer> initialize(int size){
			container.clear();
			container.addAll(new CountingIntegerList(size));
			return container;
		}
		// Convenience method:
		public static void run(FastTraversalLinkedList<Integer> list,
				List<Test<FastTraversalLinkedList<Integer>>> tests) {
			new ListTester(list, tests).timedTest();
		}
	}
	public static void main(String[] args) {
		Tester.defaultParams= TestParam.array(
				10, 5000, 100, 5000, 1000, 1000, 10000, 200);
		if(args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		ListTester.run(new FastTraversalLinkedList<Integer>(), tests);
		Tester.fieldWidth = 12;
		Tester<FastTraversalLinkedList<Integer>> qTest =
				new Tester<FastTraversalLinkedList<Integer>>(
						new FastTraversalLinkedList<Integer>(), qTests);
		qTest.setHeadline("Queue tests");
		qTest.timedTest();
	}
}

/* Output: (Sample)
-------------- FastTraversalLinkedList --------------
 size     add     get     set iteradd  insert  remove
   10     397      38      45      53     733     596
  100      78      29      33      31     666     104
 1000      95      26      41      83     120      63
10000      38      24      33      14     153      41
-------------------- Queue tests --------------------
 size    addFirst     addLast     rmFirst      rmLast
   10         172         210         266         223
  100          59          61          71          68
 1000          38          27          68          47
10000          21          19          45          43
*/