import java.util.*;
import static net.mindview.util.Print.*;

class CarPart {
	String name;
	CarPart(String name) { this.name = name; }
	CarPart() { this.name = null; }
	public void set(String n) { this.name = n; }
	public String get() { return name; }
	public String toString() { return "Car part: <<" + name + ">>"; }
}

class Audio {
	String name;
	Audio(String name) { this.name = name; }
	Audio() { this.name = null; }
	public void set(String n) { this.name = n; }
	public String get() { return name; }
	public String toString() { return "Audio: <<" + name + ">>"; }
}

interface Combiner<T> { T combine(T x, T y); }
interface UnaryFunction<R,T> { R function(T x); }
interface Collector<T> extends UnaryFunction<T,T> {
	T result(); // Extract result of collecting parameter
}
interface UnaryPredicate<T> { boolean test(T x); }
	
public class Functional {
	public static <T> T
	reduce(Iterable<T> seq, Combiner<T> combiner) {
		Iterator<T> it = seq.iterator();
		if(it.hasNext()) {
			T result = it.next();
			while(it.hasNext())
				result = combiner.combine(result, it.next());
			return result;
		}
		return null;
	}
	public static <T> Collector<T>
	forEach(Iterable<T> seq, Collector<T> func) {
		for(T t : seq)
			func.function(t);
		return func;
	}
	static class CarMaker implements Combiner<CarPart> {
		public CarPart combine(CarPart x, CarPart y) {
			return new CarPart(x.get() + ", " + y.get());
		}
	}
	
	static class AudioMaker implements Combiner<Audio> {
		public Audio combine(Audio x, Audio y) {
			return new Audio(x.get() + ", " + y.get());
		}
	}
	static class CarPartFixer
	implements Collector<CarPart> {
		private CarPart part = new CarPart("");
		public CarPart function(CarPart x) {
			part = new CarPart(part.get() + " " + x.get()) ;
			return part;
		}
		public CarPart result() { return new CarPart(part.get() + " is fixed."); }
	}
	public static void main(String[] args) {
		List<CarPart> lcp = Arrays.asList(new CarPart("Cooler"), new CarPart("Drivetrain"), new CarPart("Wheels"), new CarPart("Body"),
				new CarPart("Chassis"), new CarPart("Engine"));
		CarPart res = reduce(lcp, new CarMaker());
		print(res);
		print("***************");
		List<Audio> la = Arrays.asList(new Audio("Speakers"), new Audio("Subwoofer"), new Audio("DVD Player"), new Audio("Cables"), new Audio("Some CDs"));
		Audio res2 = reduce(la, new AudioMaker());
		print(res2);
		print("***************");
		List<CarPart> toFix = Arrays.asList(new CarPart("Cooler"), new CarPart("Drivetrain"), new CarPart("Wheels"));
		print(forEach(toFix, new CarPartFixer()).result());
	}
}

/* Output:
Car part: <<Cooler, Drivetrain, Wheels, Body, Chassis, Engine>>
***************
Audio: <<Speakers, Subwoofer, DVD Player, Cables, Some CDs>>
***************
Car part: << Cooler Drivetrain Wheels is fixed.>>
*/
