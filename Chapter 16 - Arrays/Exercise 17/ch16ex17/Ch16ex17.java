package ch16ex17;
import net.mindview.util.*;
import java.math.*;
import java.util.Arrays;

class BigDecimalGenerator implements Generator<BigDecimal> {
	private BigDecimal bigDecimal = new BigDecimal(0.0);
	public BigDecimal next() {
		bigDecimal = bigDecimal.add(new BigDecimal(1.0));
		return bigDecimal;
	}
}

public class Ch16ex17 {

	public static void main(String[] args) {
		BigDecimal[] bigDecimalArray1 = new BigDecimal[10];
		BigDecimalGenerator bdgenerator = new BigDecimalGenerator();
		for(int i = 0; i < bigDecimalArray1.length; i++)
			bigDecimalArray1[i] = bdgenerator.next();
		System.out.println("bigDecimalArray1: " + Arrays.toString(bigDecimalArray1));
		System.out.println("bigDecimalArray[0].getClass().getSimpleName(): " + bigDecimalArray1[0].getClass().getSimpleName());
		BigDecimal[] bigDecimalArray2 = Generated.array(BigDecimal.class, new BigDecimalGenerator(), 10);
		System.out.println("bigDecimalArray2: " + Arrays.toString(bigDecimalArray2));
		BigDecimal[] bigDecimalArray3 = new BigDecimal[10];
		Generated.array(bigDecimalArray3, new BigDecimalGenerator());
		System.out.println("bigDecimalArray3: " + Arrays.toString(bigDecimalArray3));
	}

}

/* Output:
bigDecimalArray1: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
bigDecimalArray[0].getClass().getSimpleName(): BigDecimal
bigDecimalArray2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
bigDecimalArray3: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
*/