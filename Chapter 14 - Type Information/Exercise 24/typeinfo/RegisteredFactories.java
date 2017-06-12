package typeinfo;
// Registering Class Factories in the base class.
import typeinfo.factory.*;
import java.util.*;


class Part {
	public String toString() {
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories =
			new ArrayList<Factory<? extends Part>>();	
	static {
		// Collections.addAll() gives an "unchecked generic
		// array creation ... for varargs parameter" warning.
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinAirFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new NullPart.Factory());
	}
	private static Random rand = new Random(47);
	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}	

class Filter extends Part {}

class NullPart extends Part implements Null {
	private NullPart() { super(); }
	public static final Part NULL = new NullPart();
	public NullPart create() { return new NullPart(); }
	public static class Factory implements typeinfo.factory.Factory<NullPart> {
		public NullPart create() {
			return (NullPart)NULL;
		}
	}
	public String toString() {
		return "NULL";
	}
}

class FuelFilter extends Filter {
	// Create a Class Factory for each specific type:
	public static class Factory
	implements typeinfo.factory.Factory<FuelFilter> {
		public FuelFilter create() { return new FuelFilter(); }
	}
}

class AirFilter extends Filter {
	public static class Factory
	implements typeinfo.factory.Factory<AirFilter> {
		public AirFilter create() { return new AirFilter(); }
	}
}	

class CabinAirFilter extends Filter {
	public static class Factory
	implements typeinfo.factory.Factory<CabinAirFilter> {
		public CabinAirFilter create() {
			return new CabinAirFilter();
    }
  }
}

class OilFilter extends Filter {
	public static class Factory
	implements typeinfo.factory.Factory<OilFilter> {
		public OilFilter create() { return new OilFilter(); }
	}
}	

class Belt extends Part {}

class FanBelt extends Belt {
	public static class Factory
	implements typeinfo.factory.Factory<FanBelt> {
		public FanBelt create() { return new FanBelt(); }
	}
}

class GeneratorBelt extends Belt {
	public static class Factory
	implements typeinfo.factory.Factory<GeneratorBelt> {
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}	

class PowerSteeringBelt extends Belt {
	public static class Factory
	implements typeinfo.factory.Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}	

public class RegisteredFactories {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
			System.out.println(Part.createRandom());
	}
}

/* Output:
 * PowerSteeringBelt
OilFilter
FanBelt
FuelFilter
AirFilter
FanBelt
AirFilter
OilFilter
FanBelt
PowerSteeringBelt
*/
