//: generics/Generators.java
// A utility to use with Generators.
import generics.coffee.*;
import java.util.*;
import net.mindview.util.*;

public class Generators {
	public static <T> Collection<T>
	fill(Collection<T> coll, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++)
			coll.add(gen.next());
		return coll;
	}
	public static <T> List<T>
	fill(List<T> list, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++)
			list.add(gen.next());
		return list;
	}
	public static <T> Queue<T>
	fill(Queue<T> queue, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++)
			queue.add(gen.next());
		return queue;
	}
	public static <T> Set<T>
	fill(Set<T> set, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++)
			set.add(gen.next());
		return set;
	}
	public static <T> LinkedList<T>
	fill(LinkedList<T> linkedList, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++)
			linkedList.add(gen.next());
		return linkedList;
	}
	
	public static void main(String[] args) {
 	  Collection<Coffee> coffee = fill(
 			  new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
 	  for(Coffee c : coffee)
 		  System.out.println(c);
 	  Collection<Integer> fnumbers = fill(
 			  new ArrayList<Integer>(), new Fibonacci(), 12);
 	  for(int i : fnumbers)
 		  System.out.print(i + ", ");
 	  System.out.println();
 	  System.out.println();
 	  List<Coffee> listCoffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 5);
 	  System.out.println("Type: " + listCoffee.getClass());
 	  System.out.println("listCoffee: " + listCoffee + "\n");
 	  Queue<Coffee> queueCoffee = fill(new ArrayDeque<Coffee>(), new CoffeeGenerator(), 5);
	  System.out.println("Type: " + queueCoffee.getClass());
	  System.out.println("queueCoffee: " + queueCoffee + "\n");
	  Set<Coffee> setCoffee = fill(new HashSet<Coffee>(), new CoffeeGenerator(), 5);
	  System.out.println("Type: " + setCoffee.getClass());
	  System.out.println("setCoffee: " + setCoffee + "\n");
	  LinkedList<Coffee> linkedListCoffee = fill(new LinkedList<Coffee>(), new CoffeeGenerator(), 5);
	  System.out.println("Type: " + linkedListCoffee.getClass());
	  System.out.println("linkedListCoffee: " + linkedListCoffee + "\n");
	}
}

/* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 

Type: class java.util.ArrayList
listCoffee: [Mocha 4, Breve 5, Americano 6, Latte 7, Cappuccino 8]

Type: class java.util.ArrayDeque
queueCoffee: [Cappuccino 9, Americano 10, Americano 11, Mocha 12, Breve 13]

Type: class java.util.HashSet
setCoffee: [Breve 14, Mocha 17, Latte 18, Americano 16, Americano 15]

Type: class java.util.LinkedList
linkedListCoffee: [Americano 19, Mocha 20, Latte 21, Mocha 22, Cappuccino 23]
*/
