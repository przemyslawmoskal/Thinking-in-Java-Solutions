package ch15ex38;
import java.util.*;

class BasicCoffee {
	private String value;
	public void set(String value) { this.value = value; }
	public String get() { return value; }
	public String toString() { return this.getClass().getSimpleName(); }
}

class Decorator extends BasicCoffee {
	protected BasicCoffee bc;
	public Decorator(BasicCoffee bc) { this.bc = bc; }
	public void set(String value) { bc.set(value); }
	public String get() { return bc.get(); }
}

class SteamedMilk extends Decorator {
	private final String steamedMilk = "SteamedMilk";
	public SteamedMilk(BasicCoffee bc) {
		super(bc);
	}
	public String getSteamedMilk() { return steamedMilk; }
}

class Foam extends Decorator {
	private final String foam = "Foam";
	public Foam(BasicCoffee bc) {
		super(bc);
	}
	public String getFoam() { return foam; }
}

class Chocolate extends Decorator {
	private final String chocolate = "Chocolate";
	public Chocolate(BasicCoffee bc) {
		super(bc);
	}
	public String getChocolate() { return chocolate; }
}

class Caramel extends Decorator {
	private final String caramel = "Caramel";
	public Caramel(BasicCoffee bc) {
		super(bc);
	}
	public String getCaramel() { return caramel; }
}

class WhippedCream extends Decorator {
	private final String whippedCream = "Whipped cream";
	public WhippedCream(BasicCoffee bc) {
		super(bc);
	}
	public String getWhippedCream() { return whippedCream; }
}

public class Ch15ex38 {

	public static void main(String[] args) {
		Foam foam = new Foam(new BasicCoffee());
		System.out.println(foam.getFoam());
		SteamedMilk steamedMilk = new SteamedMilk(new Caramel(new Chocolate(new BasicCoffee())));
		System.out.println("\n" + steamedMilk.getSteamedMilk());
		// Not available:
		// System.out.println(steamedMilk.getCaramel());
	}

}

/* Output:
Foam

SteamedMilk

*/