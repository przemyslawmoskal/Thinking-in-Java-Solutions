//: enumerated/menu/Meal2.java
package enumerated.menu;

import net.mindview.util.*;

public enum Meal2 {
	APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), DESSERT(Food.Dessert.class), COFFEE(
			Food.Coffee.class), JUICE(Food.Juice.class);
	private Food[] values;

	private Meal2(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}

	public interface Food {
		enum Appetizer implements Food {
			SALAD, SOUP, SPRING_ROLLS;
		}

		enum MainCourse implements Food {
			LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
		}

		enum Dessert implements Food {
			TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
		}

		enum Coffee implements Food {
			BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
		}
		
		enum Juice implements Food {
			ORANGE_JUICE, PINEAPPLE_JUICE, APPLE_JUICE, BLUEBERRY_JUICE, STRAWBERRY_JUICE;
		}
	}

	public Food randomSelection() {
		return Enums.random(values);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (Meal2 meal : Meal2.values()) {
				Food food = meal.randomSelection();
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
