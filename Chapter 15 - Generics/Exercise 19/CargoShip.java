import java.util.*;
import net.mindview.util.*;

class Package {
	private final int id;
	private String description;
	private double price;
	private String destination;
	public Package(int IDnumber, String descr, String dest, double price){
		id = IDnumber;
		description = descr;
		destination = dest;
		this.price = price;
		System.out.println(toString());
	}
	public String toString() {
		return id + ": " + description + ", shipping to: " + destination + ", price: $" + price;
	}
	public void priceChange(double change) {
		price += change;
	}
	public static Generator<Package> generator =
			new Generator<Package>() {
				private Random rand = new Random(47);
				public Package next() {
					return new Package(rand.nextInt(1000), "TestPackage(.)", "Destination (.)",
							Math.round(rand.nextDouble() * 1000.0) + 0.99);
				}
    		};
}

class Shelf extends ArrayList<Package> {
	public Shelf(int nPackages) {
		Generators.fill(this, Package.generator, nPackages);
	}
}	

class Warehouse extends ArrayList<Shelf> {
	public Warehouse(int nShelves, int nPackages) {
		for(int i = 0; i < nShelves; i++)
			add(new Shelf(nPackages));
	}
}

class Office {}

public class CargoShip extends ArrayList<Warehouse> {
	private Office office = new Office();
	public CargoShip(int nWarehouses, int nShelves, int nPackages) {
		for(int i = 0; i < nWarehouses; i++)
			add(new Warehouse(nShelves, nPackages));
	}
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Warehouse a : this)
			for(Shelf s : a)
				for(Package p : s) {
					result.append(p);
					result.append("\n");
				}
		return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(new CargoShip(14, 5, 10));
	}
}

/* Output:
258: TestPackage(.), shipping to: Destination (.), price: $400.99
861: TestPackage(.), shipping to: Destination (.), price: $160.99
868: TestPackage(.), shipping to: Destination (.), price: $417.99
207: TestPackage(.), shipping to: Destination (.), price: $268.99
551: TestPackage(.), shipping to: Destination (.), price: $114.99
278: TestPackage(.), shipping to: Destination (.), price: $804.99
520: TestPackage(.), shipping to: Destination (.), price: $554.99
140: TestPackage(.), shipping to: Destination (.), price: $530.99
704: TestPackage(.), shipping to: Destination (.), price: $250.99
575: TestPackage(.), shipping to: Destination (.), price: $24.99
674: TestPackage(.), shipping to: Destination (.), price: $440.99
826: TestPackage(.), shipping to: Destination (.), price: $484.99
*/
