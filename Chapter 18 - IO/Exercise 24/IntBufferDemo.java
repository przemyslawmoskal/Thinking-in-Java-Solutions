import java.nio.*;

public class IntBufferDemo {
	
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		DoubleBuffer ib = bb.asDoubleBuffer();
		// Store an array of double:
		ib.put(new double[] { 11.0d, 42.1d, 47.2d, 99.3d, 143.4d, 811.5d, 1016.6d });
		// Absolute location read and write:
		System.out.println(ib.get(3));
		ib.put(3, 1811.7d);
		// Setting a new limit before rewinding the buffer.
		ib.flip();
		while (ib.hasRemaining()) {
			double i = ib.get();
			System.out.println(i);
		}
	}
}


/* Output:
99.3
11.0
42.1
47.2
1811.7
143.4
811.5
1016.6
*/