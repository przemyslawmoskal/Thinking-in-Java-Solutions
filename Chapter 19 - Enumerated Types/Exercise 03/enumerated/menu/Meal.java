package enumerated.menu;

public class Meal {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (Course course : Course.values()) {
				Food food = course.randomSelection();
				System.out.println(food);
			}
			System.out.println("---");
		}
	}
}

/* Output:
SPRING_ROLLS
VINDALOO
FRUIT
DECAF_COFFEE
PINEAPPLE_JUICE
---
SPRING_ROLLS
HUMMOUS
TIRAMISU
TEA
APPLE_JUICE
---
SALAD
LASAGNE
GELATO
DECAF_COFFEE
STRAWBERRY_JUICE
---
SOUP
HUMMOUS
GELATO
BLACK_COFFEE
BLUEBERRY_JUICE
---
SOUP
LASAGNE
GELATO
BLACK_COFFEE
STRAWBERRY_JUICE
---
*/