package generics.coffee;

import java.util.*;
import ch14ex16.Factory;

public class Coffee {
	private static long counter = 0;
	private final long id = counter++;
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
	static List<Factory<? extends Coffee>> coffeeFactories = 
			new ArrayList<Factory<? extends Coffee>>();
	static {
		coffeeFactories.add(new Americano.Factory());
		coffeeFactories.add(new Breve.Factory());
		coffeeFactories.add(new Cappuccino.Factory());
		coffeeFactories.add(new Latte.Factory());
		coffeeFactories.add(new Mocha.Factory());
	}
	private static Random rand = new Random(128);
	public static Coffee createRandom() {
		int n = rand.nextInt(coffeeFactories.size());
		return coffeeFactories.get(n).create();
	}
}
