package ch17ex10;

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

class B {}

class SortedSet<T> extends LinkedList<T>{
	int compare(T t1, T t2) {
		// Comparing two objects with their hashCodes:
		int difference = t1.hashCode() - t2.hashCode();
		return difference < 0 ? -1 : (difference == 0 ? 0 : 1);
	}
	public boolean add(T t) {
		if(!this.contains(t)) {
			Iterator<T> iterator = this.iterator();
			int index = 0;
			while(iterator.hasNext()) {
				if(compare(iterator.next(),t) < 1)
					index++;
			}
			add(index,t);
			return true;
		}
		return false;
	}
}

public class Ch17ex10 {

	public static void main(String[] args) {
		Random rand = new Random();
		SortedSet<Integer> integerSS = new SortedSet();
		for(int i = 0; i < 20; i++)
			integerSS.add(rand.nextInt(30));
		print(integerSS);
		SortedSet<String> stringSS = new SortedSet();
		Generator<String> generator = new RandomGenerator.String(5);
		for(int i = 0; i < 20; i++)
			stringSS.add(generator.next());
		System.out.println(stringSS);
		SortedSet<B> bSS = new SortedSet();
		bSS.add(new B());
		bSS.add(new B());
		bSS.add(new B());
		bSS.add(new B());
		bSS.add(new B());
		print(bSS);
	}

}

/* Output:
[5, 6, 7, 8, 10, 11, 13, 15, 17, 20, 21, 24, 25, 26, 29]
[EqUCB, HLGEa, HxxHv, JMRoE, Mesbt, OWZnT, OneOE, RFJQA, WHkjU, YNzbr, bkIna, cQrGs, dLsmw, eGZMm, hKcxr, gwsqP, nyGcF, rUkZP, suEcU, zDyCy]
[ch17ex10.B@25154f, ch17ex10.B@52e922, ch17ex10.B@647e05, ch17ex10.B@10dea4e, ch17ex10.B@1909752]
*/