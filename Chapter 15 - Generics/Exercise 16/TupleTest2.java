import net.mindview.util.*;
import static net.mindview.util.Tuple.*;

class Vehicle {}
class Amphibian {}

public class TupleTest2 {
	static TwoTuple<String,Integer> f() {
		return tuple("hi", 47);
	}
	static TwoTuple f2() { return tuple("hi", 47); }
	static ThreeTuple<Amphibian,String,Integer> g() {
		return tuple(new Amphibian(), "hi", 47);
	}	
	static
	FourTuple<Vehicle,Amphibian,String,Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}
	static
	FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
		return tuple(new Vehicle(), new Amphibian(),
				"hi", 47, 11.1);
	}
	static
	SixTuple<Vehicle,Amphibian,String,Integer,Double,Integer> l() {
		return tuple(new Vehicle(), new Amphibian(),
				"hi", 47, 11.1, 128);
	}
	public static void main(String[] args) {
		TwoTuple<String,Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
		System.out.println(l());
	}
}

/* Output: 
(hi, 47)
(hi, 47)
(Amphibian@106d69c, hi, 47)
(Vehicle@52e922, Amphibian@25154f, hi, 47)
(Vehicle@10dea4e, Amphibian@647e05, hi, 47, 11.1)
(Vehicle@1909752, Amphibian@1f96302, hi, 47, 11.1, 128)
*/

