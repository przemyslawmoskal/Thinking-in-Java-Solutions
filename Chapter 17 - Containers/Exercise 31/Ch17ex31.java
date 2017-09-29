import java.util.*;
import net.mindview.util.*;

class StringContainer {
	private int size = 0;
	private int index = 0;
	private String[] arr = new String[size];
	public StringContainer(int size) {
		this.size = size;
		arr = new String[size];
	}
	public StringContainer() {}
	public void add(String s) {
		if(index < arr.length) {
			arr[index++] = s;
		}else {
			size++;
			String[] newArr = new String[size];
			for(int i = 0; i < arr.length; i++)
				newArr[i] = arr[i];
			newArr[index++] = s;
			arr = newArr;
		}
	}
	public String get(int i) {
		if(i > -1 && i < arr.length)
			return arr[i];
		throw new ArrayIndexOutOfBoundsException(i);
	}
	public String toString() { return Arrays.toString(arr); }
}

class StringContainer2 {
	private int size = 1000;
	private int index = 0;
	private String[] arr = new String[size];
	public void add(String s) {
		if(index < size)
			arr[index++] = s; 
	}
	public String get(int i) {
		if(i > -1 && i < size)
			return arr[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}
	public String toString() {
		return Arrays.toString(arr);
	}
}

public class Ch17ex31 {
	public static RandomGenerator.String gen = new RandomGenerator.String(3);
	public static String s = gen.next();
	public static long addTimeSC(StringContainer sc, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			sc.add(s);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long addTimeSC2(StringContainer2 sc, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			sc.add(s);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long addTimeAL(ArrayList<String> al, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			al.add(s);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long getTimeAL(ArrayList<String> al, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			al.get(i);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long getTimeSC(StringContainer sc, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			sc.get(i);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static long getTimeSC2(StringContainer2 sc, int reps) {
		long befTime = System.nanoTime();
		for(int i = 0; i < reps; i++) {
			sc.get(i);
		}
		return (System.nanoTime() - befTime)/reps;
	}
	public static void main(String[] args) {
		ArrayList<String> al01 = new ArrayList<String>();
		StringContainer sc01 = new StringContainer();
		StringContainer2 sc201 = new StringContainer2();
		System.out.println("AL add time (reps: 5000): " + addTimeAL(al01, 5000));
		System.out.println("SC add  time (reps: 5000): " + addTimeSC(sc01, 5000));
		System.out.println("SC2 add  time (reps: 5000): " + addTimeSC2(sc201, 5000));
		System.out.println("AL get time (reps: 5000): " + getTimeAL(al01, 5000));
		System.out.println("SC get time (reps: 5000): " + getTimeSC(sc01, 5000));
		System.out.println();
		ArrayList<String> al02 = new ArrayList<String>();
		StringContainer sc02 = new StringContainer();
		StringContainer2 sc202 = new StringContainer2();
		System.out.println("AL add time (reps: 1000): " + addTimeAL(al02, 1000));
		System.out.println("SC add  time (reps: 1000): " + addTimeSC(sc02, 1000));
		System.out.println("SC2 add  time (reps: 1000): " + addTimeSC2(sc202, 1000));
		System.out.println("AL get time (reps: 1000): " + getTimeAL(al02, 1000));
		System.out.println("SC get time (reps: 1000): " + getTimeSC(sc02, 1000));
		System.out.println("SC2 get time (reps: 1000): " + getTimeSC2(sc202, 1000));
		System.out.println();
		ArrayList<String> al03 = new ArrayList<String>();
		StringContainer sc03 = new StringContainer();
		StringContainer2 sc203 = new StringContainer2();
		System.out.println("AL add time (reps: 100): " + addTimeAL(al03, 100));
		System.out.println("SC add  time (reps: 100): " + addTimeSC(sc03, 100));
		System.out.println("SC2 add  time (reps: 100): " + addTimeSC2(sc203, 100));
		System.out.println("AL get time (reps: 100): " + getTimeAL(al03, 100));
		System.out.println("SC get time (reps: 100): " + getTimeSC(sc03, 100));
		System.out.println("SC2 get time (reps: 100): " + getTimeSC2(sc203, 100));
	}

}

/* Output:
AL add time (reps: 5000): 199
SC add  time (reps: 5000): 14855
SC2 add  time (reps: 5000): 56
AL get time (reps: 5000): 102
SC get time (reps: 5000): 54

AL add time (reps: 1000): 83
SC add  time (reps: 1000): 2405
SC2 add  time (reps: 1000): 40
AL get time (reps: 1000): 37
SC get time (reps: 1000): 37
SC2 get time (reps: 1000): 58

AL add time (reps: 100): 483
SC add  time (reps: 100): 381
SC2 add  time (reps: 100): 7
AL get time (reps: 100): 43
SC get time (reps: 100): 43
SC2 get time (reps: 100): 87
*/
