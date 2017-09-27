import java.util.*;

public class Ch17ex30 {
	static Random rand = new Random();
	public static ArrayList<Integer> createFilledAL(int size) {
		ArrayList<Integer> alist = new ArrayList<Integer>();
		for(int i = 0; i < size; i++) {
			alist.add(rand.nextInt(size));
		}
		return alist;
	}
	public static LinkedList<Integer> createFilledLL(int size) {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for(int i = 0; i < size; i++) {
			llist.add(rand.nextInt(size));
		}
		return llist;
	}
	public static long sortSingleALTime(ArrayList<Integer> al) {
		long befTime = System.nanoTime();
		Collections.sort(al);
		long aftTime = System.nanoTime() - befTime;
		return aftTime;
	}
	public static long sortSingleLLTime(LinkedList<Integer> ll) {
		long befTime = System.nanoTime();
		Collections.sort(ll);
		long aftTime = System.nanoTime() - befTime;
		return aftTime;
	}
	public static void compareSortingSpeed(int size, int loops) {
		System.out.println("Average sorting speed comparison, size of each list: " + size + ", loops: " + loops);
		long result = 0;
		for(int i = 0; i < loops; i++) {
			ArrayList<Integer> al = createFilledAL(size);
			 long time = sortSingleALTime(al);
			 result += time;
		}
		System.out.println("AL: " + result/loops);
		result = 0;
		for(int i = 0; i < loops; i++) {
			LinkedList<Integer> ll = createFilledLL(size);
			 long time = sortSingleLLTime(ll);
			 result += time;
		}
		System.out.println("LL: " + result/loops);
	}
	public static void main(String[] args) {
		compareSortingSpeed(10,10000);
		compareSortingSpeed(100,10000);
		compareSortingSpeed(1000,1000);
		compareSortingSpeed(10000,100);
	}
}

/* Output: (Sample)
Average sorting speed comparison, size of each list: 10, loops: 10000
AL: 998
LL: 1052
Average sorting speed comparison, size of each list: 100, loops: 10000
AL: 12558
LL: 14331
Average sorting speed comparison, size of each list: 1000, loops: 1000
AL: 201307
LL: 209337
Average sorting speed comparison, size of each list: 10000, loops: 100
AL: 2604180
LL: 2870241
*/
