package ch14ex16;

import generics.coffee.Coffee;

public class Ch14ex16 {

	public static void main(String[] args) {
		for(int i = 0; i < 15; i++) {
			System.out.println(Coffee.createRandom());
		}
	}

}

/* Output:
Mocha 0
Latte 1
Cappuccino 2
Americano 3
Cappuccino 4
Latte 5
Latte 6
Cappuccino 7
Americano 8
Americano 9
Americano 10
Cappuccino 11
Breve 12
Mocha 13
Cappuccino 14
*/