package ch14ex12;
import net.mindview.util.*;
import generics.coffee.*;

public class Ch14ex12 {
	
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Coffee.class);
		for(Coffee coffee : new CoffeeGenerator(20)) {
			System.out.print(coffee.getClass().getSimpleName() + " ");
			counter.count(coffee);
		}
		System.out.println();
		System.out.println(counter);
	}

}

/* Output:
Americano Latte Americano Mocha Mocha Breve Americano Latte Cappuccino Cappuccino Americano Americano Mocha Breve Breve Americano Americano Mocha Latte Americano 
{Americano=8, Mocha=4, Breve=3, Latte=3, Coffee=20, Cappuccino=2}
*/