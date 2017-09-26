import java.util.*;
import static net.mindview.util.Print.*;

class TwoTuple<A,B> implements Comparable {
	public final A first;
	public final B second;
	public TwoTuple(A a, B b) { first = a; second = b; }
	public int hashCode() {
		int result = 17;
		result = result * 37 + first.hashCode();
		result = result * 37 + second.hashCode();
		return result;
	}
	public boolean equals(Object o) {
		return (o instanceof TwoTuple) &&
				this.first.equals(((TwoTuple)o).first) &&
				this.second.equals(((TwoTuple)o).second);
	}
	public int compareTo(Object o) {
		if(!(o instanceof TwoTuple))
			throw new ClassCastException();
		TwoTuple t = (TwoTuple)o;
		return this.hashCode() < t.hashCode() ? -1 : (this.hashCode() == t.hashCode() ? 0 : 1);
	}
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}

class ThreeTuple<A,B,C> extends TwoTuple<A,B> implements Comparable {
	public final C third;
	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		third = c;
	}
	public int hashCode() {
		int result = 17;
		result = result * 37 + first.hashCode();
		result = result * 37 + second.hashCode();
		result = result * 37 + third.hashCode();
		return result;
	}
	public boolean equals(Object o) {
		return (o instanceof ThreeTuple) &&
				this.first.equals(((ThreeTuple)o).first) &&
				this.second.equals(((ThreeTuple)o).second) &&
				this.third.equals(((ThreeTuple)o).third);
	}
	public int compareTo(Object o) {
		if(!(o instanceof ThreeTuple))
			throw new ClassCastException();
		ThreeTuple t = (ThreeTuple)o;
		return this.hashCode() < t.hashCode() ? -1 : (this.hashCode() == t.hashCode() ? 0 : 1);
	}
	public String toString() {
		return "(" + first + ", " + second + ", " + third +")";
	}
}

class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> implements Comparable {
	public final D fourth;
	public FourTuple(A a, B b, C c, D d) {
		super(a, b, c);
		fourth = d;
	}
	public int hashCode() {
		int result = 17;
		result = result * 37 + first.hashCode();
		result = result * 37 + second.hashCode();
		result = result * 37 + third.hashCode();
		result = result * 37 + fourth.hashCode();
		return result;
	}
	public boolean equals(Object o) {
		return (o instanceof FourTuple) &&
				this.first.equals(((FourTuple)o).first) &&
				this.second.equals(((FourTuple)o).second) &&
				this.third.equals(((FourTuple)o).third) &&
				this.fourth.equals(((FourTuple)o).fourth);
	}
	public int compareTo(Object o) {
		if(!(o instanceof FourTuple))
			throw new ClassCastException();
		FourTuple t = (FourTuple)o;
		return this.hashCode() < t.hashCode() ? -1 : (this.hashCode() == t.hashCode() ? 0 : 1);
	}
	public String toString() {
		return "(" + first + ", " + second + ", " +
				third + ", " + fourth + ")";
	}
}

class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> implements Comparable {
	public final E fifth;
	public FiveTuple(A a, B b, C c, D d, E e) {
		super(a, b, c, d);
		fifth = e;
	}
	public int hashCode() {
		int result = 17;
		result = result * 37 + first.hashCode();
		result = result * 37 + second.hashCode();
		result = result * 37 + third.hashCode();
		result = result * 37 + fourth.hashCode();
		result = result * 37 + fifth.hashCode();
		return result;
	}
	public boolean equals(Object o) {
		return (o instanceof FiveTuple) &&
				this.first.equals(((FiveTuple)o).first) &&
				this.second.equals(((FiveTuple)o).second) &&
				this.third.equals(((FiveTuple)o).third) &&
				this.fourth.equals(((FiveTuple)o).fourth) &&
				this.fifth.equals(((FiveTuple)o).fifth);
	}
	public int compareTo(Object o) {
		if(!(o instanceof FiveTuple))
			throw new ClassCastException();
		FiveTuple t = (FiveTuple)o;
		return this.hashCode() < t.hashCode() ? -1 : (this.hashCode() == t.hashCode() ? 0 : 1);
	}
	public String toString() {
		return "(" + first + ", " + second + ", " +
				third + ", " + fourth + ", " + fifth + ")";
	}
}

class Tuple {
	public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
		return new TwoTuple<A,B>(a, b);
	}
	public static <A,B,C> ThreeTuple<A,B,C>
	tuple(A a, B b, C c) {
		return new ThreeTuple<A,B,C>(a, b, c);
	}
	public static <A,B,C,D> FourTuple<A,B,C,D>
	tuple(A a, B b, C c, D d) {
		return new FourTuple<A,B,C,D>(a, b, c, d);
	}
	public static <A,B,C,D,E>
	FiveTuple<A,B,C,D,E> tuple(A a, B b, C c, D d, E e) {
		return new FiveTuple<A,B,C,D,E>(a, b, c, d, e);
	}
}

public class Ch17ex28 {
	public static void main(String[] args) {
		FiveTuple fiveT1 = Tuple.tuple(0, 1, 2, 3, 4);
		FiveTuple fiveT2 = Tuple.tuple(0, 1, 2, 3, 5);
		FiveTuple fiveT3 = Tuple.tuple(0, 0, 2, 3, 4);
		FiveTuple fiveT4 = Tuple.tuple(0, 1, 2, 3, 4);
		FiveTuple fiveT5 = Tuple.tuple(0, 0, 2, 3, 4);
		print("fiveT1: " + fiveT1);
		print("fiveT2: " + fiveT2);
		print("fiveT3: " + fiveT3);
		print("fiveT4: " + fiveT4);
		print("fiveT5: " + fiveT5);
		print("fiveT1.compareTo(fiveT2): " + fiveT1.compareTo(fiveT2));
		print("fiveT1.compareTo(fiveT3): " + fiveT1.compareTo(fiveT3));
		print("fiveT1.compareTo(fiveT4): " + fiveT1.compareTo(fiveT4));
		print("fiveT1.compareTo(fiveT5): " + fiveT1.compareTo(fiveT5));
		print("fiveT1.equals(fiveT2): " + fiveT1.equals(fiveT2));
		print("fiveT1.equals(fiveT3): " + fiveT1.equals(fiveT3));
		print("fiveT1.equals(fiveT4): " + fiveT1.equals(fiveT4));
		print("fiveT1.equals(fiveT5): " + fiveT1.equals(fiveT5));
		Set<FiveTuple> ftset = new TreeSet<FiveTuple>();
		ftset.add(fiveT1);
		ftset.add(fiveT2);
		ftset.add(fiveT3);
		ftset.add(fiveT4);
		ftset.add(fiveT5);
		print(ftset);
		List<FiveTuple> ftlist = new ArrayList<FiveTuple>();
		ftlist.add(fiveT1);
		ftlist.add(fiveT2);
		ftlist.add(fiveT3);
		ftlist.add(fiveT4);
		ftlist.add(fiveT5);
		print(ftlist);
		print("Collections.sort(ftlist):");
		Collections.sort(ftlist);
		print(ftlist);
		
	}
}

/* Output:
fiveT1: (0, 1, 2, 3, 4)
fiveT2: (0, 1, 2, 3, 5)
fiveT3: (0, 0, 2, 3, 4)
fiveT4: (0, 1, 2, 3, 4)
fiveT5: (0, 0, 2, 3, 4)
fiveT1.compareTo(fiveT2): -1
fiveT1.compareTo(fiveT3): 1
fiveT1.compareTo(fiveT4): 0
fiveT1.compareTo(fiveT5): 1
fiveT1.equals(fiveT2): false
fiveT1.equals(fiveT3): false
fiveT1.equals(fiveT4): true
fiveT1.equals(fiveT5): false
[(0, 0, 2, 3, 4), (0, 1, 2, 3, 4), (0, 1, 2, 3, 5)]
[(0, 1, 2, 3, 4), (0, 1, 2, 3, 5), (0, 0, 2, 3, 4), (0, 1, 2, 3, 4), (0, 0, 2, 3, 4)]
Collections.sort(ftlist):
[(0, 0, 2, 3, 4), (0, 0, 2, 3, 4), (0, 1, 2, 3, 4), (0, 1, 2, 3, 4), (0, 1, 2, 3, 5)]
*/