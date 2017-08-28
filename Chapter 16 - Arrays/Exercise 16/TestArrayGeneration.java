import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
import ch16ex16.SkipGen;

public class TestArrayGeneration {
	public static void main(String[] args) {
		int size = 10;
		int skip = 4;
		boolean[] a1 = ConvertTo.primitive(Generated.array(
				new Boolean[size], new SkipGen.Boolean(skip), skip));
		print("a1 = " + Arrays.toString(a1));
		byte[] a2 = ConvertTo.primitive(Generated.array(
				new Byte[size], new SkipGen.Byte(skip), skip));
		print("a2 = " + Arrays.toString(a2));
		char[] a3 = ConvertTo.primitive(Generated.array(
				new Character[size],new SkipGen.Character(skip), skip));
		print("a3 = " + Arrays.toString(a3));
		short[] a4 = ConvertTo.primitive(Generated.array(
				new Short[size],new SkipGen.Short(skip), skip));
		print("a4 = " + Arrays.toString(a4));
		int[] a5 = ConvertTo.primitive(Generated.array(
				new Integer[size],new SkipGen.Integer(skip), skip));
		print("a5 = " + Arrays.toString(a5));
		long[] a6 = ConvertTo.primitive(Generated.array(
				new Long[size],new SkipGen.Long(skip), skip));
		print("a6 = " + Arrays.toString(a6));
		float[] a7 = ConvertTo.primitive(Generated.array(
				new Float[size],new SkipGen.Float(skip), skip));
		print("a7 = " + Arrays.toString(a7));
		double[] a8 = ConvertTo.primitive(Generated.array(
				new Double[size],new SkipGen.Double(skip), skip));
		print("a8 = " + Arrays.toString(a8));
	}
}

/* Output:
a1 = [true, true, true, true, true, true, true, true, true, true]
a2 = [4, 8, 12, 16, 20, 24, 28, 32, 36, 40]
a3 = [e, j, o, t, y, D, I, N, S, X]
a4 = [4, 8, 12, 16, 20, 24, 28, 32, 36, 40]
a5 = [4, 8, 12, 16, 20, 24, 28, 32, 36, 40]
a6 = [4, 8, 12, 16, 20, 24, 28, 32, 36, 40]
a7 = [0.0, 4.0, 8.0, 12.0, 16.0, 20.0, 24.0, 28.0, 32.0, 36.0]
a8 = [0.0, 4.0, 8.0, 12.0, 16.0, 20.0, 24.0, 28.0, 32.0, 36.0]
*/