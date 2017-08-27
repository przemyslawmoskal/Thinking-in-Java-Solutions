package ch16ex12;

import java.util.Arrays;
import net.mindview.util.*;

public class Ch16ex12 {
	
	public static void main(String[] args) {
		double[] d = new double[5];
		CountingGenerator.Double generator = new CountingGenerator.Double();
		for(int i = 0; i < d.length; i++)
			d[i] = generator.next();
		System.out.println(Arrays.toString(d));
	}
	
}

/* Output:
[0.0, 1.0, 2.0, 3.0, 4.0]
*/
