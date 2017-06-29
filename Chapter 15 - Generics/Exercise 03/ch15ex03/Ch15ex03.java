package ch15ex03;
import net.mindview.util.*;

class Rat{}
class Elephant{}
class Bird{}

class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E> {
	public final F sixth;
	public SixTuple(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		this.sixth = f;
	}
	public String toString() {
		return "(" + first + ", " + second + ", " + third + "," +
				"," + fourth + ", " + fifth + ", " + sixth + ")";
	}

	
}


public class Ch15ex03 {
	static SixTuple<String,Integer,Double,Rat,Elephant,Bird> f() {
		return new
				SixTuple<String,Integer,Double,Rat,Elephant,Bird>(
						"String for test", 128, 123.3, new Rat(), new Elephant(), new Bird());
	}
	public static void main(String[] args) {
		SixTuple<String,Integer,Double,Rat,Elephant,Bird> mySixTuple = f();
		System.out.println(mySixTuple);
	}

}

/* Output:
(String for test, 128, 123.3,,ch15ex03.Rat@106d69c, ch15ex03.Elephant@52e922, ch15ex03.Bird@25154f)
*/
