package typeinfo;
import net.mindview.util.*;
import java.util.*;

public class Ch14ex13 {

	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Part.class);
		List<Part> listOfParts = new ArrayList<Part>();
		for(int i = 0; i < 20; i++) {
			listOfParts.add(Part.createRandom());
		}
		for(Part part : listOfParts) {
			System.out.print(part.getClass().getSimpleName() + " ");
			counter.count(part);
		}
		System.out.println();
		System.out.println(counter);
	}

}

/* Output:
GeneratorBelt CabinAirFilter GeneratorBelt AirFilter PowerSteeringBelt CabinAirFilter FuelFilter PowerSteeringBelt PowerSteeringBelt FuelFilter CabinAirFilter PowerSteeringBelt FanBelt AirFilter OilFilter OilFilter AirFilter PowerSteeringBelt FuelFilter CabinAirFilter 
{GeneratorBelt=2, CabinAirFilter=4, Filter=12, Part=20, OilFilter=2, FuelFilter=3, PowerSteeringBelt=5, Belt=8, FanBelt=1, AirFilter=3}
*/