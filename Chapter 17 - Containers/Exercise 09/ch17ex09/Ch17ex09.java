package ch17ex09;

import java.util.*;
import net.mindview.util.*;

public class Ch17ex09 {

	public static void main(String[] args) {
		Set<String> strings = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		Generator<String> generator = new RandomGenerator.String(3);
		for(int i = 0; i < 15; i++)
			strings.add(generator.next());
		System.out.println(strings);
	}

}

/* Output:
[brn, cQr, cUO, EdL, FOW, Gse, GZM, mJM, neO, RoE, smw, suE, yGc, YNz, ZnT]
*/