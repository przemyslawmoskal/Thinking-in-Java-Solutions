package ch16ex14;
import net.mindview.util.*;
import java.util.*;

public class Ch16ex14 {

	public static void main(String[] args) {
		boolean[] booleanArray = new boolean[10];
		char[] charArray = new char[10];
		byte[] byteArray = new byte[10];
		short[] shortArray = new short[10];
		int[] intArray = new int[10];
		long[] longArray = new long[10];
		float[] floatArray = new float[10];
		double[] doubleArray = new double[10];
		CountingGenerator.Boolean booleanGen = new CountingGenerator.Boolean();
		for(int i = 0; i < booleanArray.length; i++)
			booleanArray[i] = booleanGen.next();
		System.out.println("boolean: " + Arrays.toString(booleanArray));
		CountingGenerator.Character charGen = new CountingGenerator.Character();
		for(int i = 0; i < charArray.length; i++)
			charArray[i] = charGen.next();
		System.out.println("char: " + Arrays.toString(charArray));
		CountingGenerator.Byte byteGen = new CountingGenerator.Byte();
		for(int i = 0; i < byteArray.length; i++)
			byteArray[i] = byteGen.next();
		System.out.println("byte: " + Arrays.toString(byteArray));
		CountingGenerator.Short shortGen = new CountingGenerator.Short();
		for(int i = 0; i < shortArray.length; i++)
			shortArray[i] = shortGen.next();
		System.out.println("short: " + Arrays.toString(shortArray));
		CountingGenerator.Integer intGen = new CountingGenerator.Integer();
		for(int i = 0; i < intArray.length; i++)
			intArray[i] = intGen.next();
		System.out.println("int: " + Arrays.toString(intArray));
		CountingGenerator.Long longGen = new CountingGenerator.Long();
		for(int i = 0; i < longArray.length; i++)
			longArray[i] = longGen.next();
		System.out.println("long: " + Arrays.toString(longArray));
		CountingGenerator.Float floatGen = new CountingGenerator.Float();
		for(int i = 0; i < floatArray.length; i++)
			floatArray[i] = floatGen.next();
		System.out.println("float: " + Arrays.toString(floatArray));
		CountingGenerator.Double doubleGen = new CountingGenerator.Double();
		for(int i = 0; i < doubleArray.length; i++)
			doubleArray[i] = doubleGen.next();
		System.out.println("double: " + Arrays.toString(doubleArray));
	}

}

/* Output:
 * boolean: [true, false, true, false, true, false, true, false, true, false]
char: [a, b, c, d, e, f, g, h, i, j]
byte: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
short: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
int: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
long: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
float: [0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
double: [0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
*/
