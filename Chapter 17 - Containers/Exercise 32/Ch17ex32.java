import java.util.*;

class IntContainer {
	private int size = 0;
	private int index = 0;
	private int[] arr = new int[size];
	public IntContainer(int size) {
		this.size = size;
		arr = new int[size];
	}
	public IntContainer() {}
	public int size() { return this.size; }
	public void add(int i) {
		if(index < arr.length) {
			arr[index++] = i;
		}else {
			size++;
			int[] newArr = new int[size];
			for(int j = 0; j < arr.length; j++)
				newArr[j] = arr[j];
			newArr[index++] = i;
			arr = newArr;
		}
	}
	public int get(int i) {
		if(i > -1 && i < arr.length)
			return arr[i];
		throw new ArrayIndexOutOfBoundsException(i);
	}
	public void increment() {
		for(int i = 0; i < size; i++)
			arr[i]++;
	}
	public String toString() { return Arrays.toString(arr); }
}

class IntContainer2 {
	private int size = 1000;
	private int index = 0;
	private int[] arr = new int[size];
	public int size() { return this.size; }
	public void add(int i) {
		if(index < size)
			arr[index++] = i; 
	}
	public int get(int i) {
		if(i > -1 && i < size)
			return arr[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}
	public void increment() {
		for(int i = 0; i < size; i++)
			arr[i]++;
	}
	public String toString() {
		return Arrays.toString(arr);
	}
}

public class Ch17ex32 {
	public static int s = 0;
	public static long addTimeIC(IntContainer ic, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			ic.add(s);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long addTimeIC2(IntContainer2 sc, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			sc.add(s);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long addTimeAL(ArrayList<Integer> al, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			al.add(s);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long getTimeAL(ArrayList<Integer> al, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			al.get(i);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long getTimeIC(IntContainer ic, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			ic.get(i);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long getTimeIC2(IntContainer2 ic, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			ic.get(i);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long incrTimeAL(ArrayList<Integer> al) {
		long befTime = System.nanoTime();
		for(Integer i : al)
			i++;
		return (System.nanoTime() - befTime)/al.size();
	}
	public static long incrTimeIC(IntContainer ic) {
		long befTime = System.nanoTime();
		ic.increment();
		return (System.nanoTime() - befTime)/ic.size();
	}
	public static long incrTimeIC2(IntContainer2 ic) {
		long befTime = System.nanoTime();
		ic.increment();
		return (System.nanoTime() - befTime)/ic.size();
	}
	public static void main(String[] args) {
		ArrayList<Integer> al01 = new ArrayList<Integer>();
		IntContainer ic01 = new IntContainer();
		IntContainer2 ic201 = new IntContainer2();
		System.out.println("AL add time (reps: 5000): " + addTimeAL(al01, 5000));
		System.out.println("IC add  time (reps: 5000): " + addTimeIC(ic01, 5000));
		System.out.println("IC2 add  time (reps: 5000): " + addTimeIC2(ic201, 5000));
		System.out.println("AL get time (reps: 5000): " + getTimeAL(al01, 5000));
		System.out.println("IC get time (reps: 5000): " + getTimeIC(ic01, 5000));
		System.out.println("AL incrementing time (reps: 5000): " + incrTimeAL(al01));
		System.out.println("IC incrementing time (reps: 5000): " + incrTimeIC(ic01));
		System.out.println("IC2 incrementing time (reps: 5000): " + incrTimeIC2(ic201));
		System.out.println();
		ArrayList<Integer> al02 = new ArrayList<Integer>();
		IntContainer ic02 = new IntContainer();
		IntContainer2 ic202 = new IntContainer2();
		System.out.println("AL add time (reps: 1000): " + addTimeAL(al02, 1000));
		System.out.println("IC add  time (reps: 1000): " + addTimeIC(ic02, 1000));
		System.out.println("IC2 add  time (reps: 1000): " + addTimeIC2(ic202, 1000));
		System.out.println("AL get time (reps: 1000): " + getTimeAL(al02, 1000));
		System.out.println("IC get time (reps: 1000): " + getTimeIC(ic02, 1000));
		System.out.println("IC2 get time (reps: 1000): " + getTimeIC2(ic202, 1000));
		System.out.println("AL incrementing time (reps: 1000): " + incrTimeAL(al02));
		System.out.println("IC incrementing time (reps: 1000): " + incrTimeIC(ic02));
		System.out.println("IC2 incrementing time (reps: 1000): " + incrTimeIC2(ic202));
		System.out.println();
		ArrayList<Integer> al03 = new ArrayList<Integer>();
		IntContainer ic03 = new IntContainer();
		IntContainer2 ic203 = new IntContainer2();
		System.out.println("AL add time (reps: 100): " + addTimeAL(al03, 100));
		System.out.println("IC add  time (reps: 100): " + addTimeIC(ic03, 100));
		System.out.println("IC2 add  time (reps: 100): " + addTimeIC2(ic203, 100));
		System.out.println("AL get time (reps: 100): " + getTimeAL(al03, 100));
		System.out.println("IC get time (reps: 100): " + getTimeIC(ic03, 100));
		System.out.println("IC2 get time (reps: 100): " + getTimeIC2(ic203, 100));
		System.out.println("AL incrementing time (reps: 100): " + incrTimeAL(al02));
		System.out.println("IC incrementing time (reps: 100): " + incrTimeIC(ic02));
		System.out.println("IC2 incrementing time (reps: 100): " + incrTimeIC2(ic202));
	}

}

/* Output:
AL add time (reps: 5000): 355
IC add  time (reps: 5000): 9688
IC2 add  time (reps: 5000): 190
AL get time (reps: 5000): 255
IC get time (reps: 5000): 189
AL incrementing time (reps: 5000): 688
IC incrementing time (reps: 5000): 52
IC2 incrementing time (reps: 5000): 73

AL add time (reps: 1000): 291
IC add  time (reps: 1000): 671
IC2 add  time (reps: 1000): 123
AL get time (reps: 1000): 106
IC get time (reps: 1000): 82
IC2 get time (reps: 1000): 510
AL incrementing time (reps: 1000): 322
IC incrementing time (reps: 1000): 53
IC2 incrementing time (reps: 1000): 55

AL add time (reps: 100): 388
IC add  time (reps: 100): 180
IC2 add  time (reps: 100): 88
AL get time (reps: 100): 96
IC get time (reps: 100): 88
IC2 get time (reps: 100): 134
AL incrementing time (reps: 100): 342
IC incrementing time (reps: 100): 53
IC2 incrementing time (reps: 100): 52
*/
