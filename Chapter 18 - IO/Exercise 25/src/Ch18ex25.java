import java.nio.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ch18ex25 {
	
	public static void allocationTimeTest(int i) {
		long startTime = System.nanoTime();
		ByteBuffer bf = ByteBuffer.allocate(1);
		long duration = System.nanoTime() - startTime;
		long startTimeDirect = System.nanoTime();
		ByteBuffer bf2 = ByteBuffer.allocateDirect(1);
		long durationDirect = System.nanoTime() - startTimeDirect;
		System.out.printf("%-23s %5d byte(s): %7d nanoseconds\n", "Time needed to allocate ", i, duration);
		System.out.printf("%-23s %5d byte(s): %7d nanoseconds\n\n", "Time needed to allocate ", i, durationDirect);
	}
	public static long test(String filename) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class c = Class.forName(filename);
		Method m = c.getMethod("main", String[].class);
		String[] arguments = {"src\\ChannelCopy.java","Test.txt"};
		long startTime = System.nanoTime();
		m.invoke(c.newInstance(), (Object)arguments);
		long duration = System.nanoTime() - startTime;
		return duration;
	}
	public static void main(String[] args) {
		
		String [] fileNames = { "BufferToText", "ChannelCopy", "GetChannel", "GetData", "IntBufferDemo", "UsingBuffers" };
		long[] durationTimes = new long[12];
		int index = 0;
		try {
			for(String fn : fileNames) {
				durationTimes[index++] = test(fn);
				System.out.println();
				durationTimes[index++] = test(fn + "Direct");
				System.out.println();
			}
			index = 0;
			System.out.println("*************************");
			for(String fn : fileNames) {
				System.out.printf("%-20s: %10d nanoseconds\n", fn, durationTimes[index++] );
				String fnPlusDirect = fn + "Direct";
				System.out.printf("%-20s: %10d nanoseconds\n\n", fnPlusDirect, durationTimes[index++] );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		allocationTimeTest(1);
		allocationTimeTest(8);
		allocationTimeTest(16);
		allocationTimeTest(128);
		allocationTimeTest(1024);
		allocationTimeTest(16384);
		System.out.println("*************************");
	}

}

/* Output:
????
Decoded using Cp1250: Some text
Some text
Some text

????
Decoded using Cp1250: Some text
Some text
Some text



Some text Some more
Some text Some more
i = 1025
H o w d y ! 
12390
99471142
99471142
9.9471144E7
9.9471142E7

i = 1025
H o w d y ! 
12390
99471142
99471142
9.9471144E7
9.9471142E7

99
11
42
47
1811
143
811
1016

99
11
42
47
1811
143
811
1016

UsingBuffers
sUniBgfuefsr
UsingBuffers

UsingBuffers
sUniBgfuefsr
UsingBuffers

*************************
BufferToText        :    7869848 nanoseconds
BufferToTextDirect  :    2095400 nanoseconds

ChannelCopy         :     436603 nanoseconds
ChannelCopyDirect   :     357787 nanoseconds

GetChannel          :    1650732 nanoseconds
GetChannelDirect    :    1448011 nanoseconds

GetData             :    7219892 nanoseconds
GetDataDirect       :    2833702 nanoseconds

IntBufferDemo       :     998578 nanoseconds
IntBufferDemoDirect :    1393023 nanoseconds

UsingBuffers        :     502222 nanoseconds
UsingBuffersDirect  :     280804 nanoseconds


Time needed to allocate      1 byte(s):   10631 nanoseconds
Time needed to allocate      1 byte(s):   18329 nanoseconds

Time needed to allocate      8 byte(s):    2566 nanoseconds
Time needed to allocate      8 byte(s):   10264 nanoseconds

Time needed to allocate     16 byte(s):    2199 nanoseconds
Time needed to allocate     16 byte(s):    8798 nanoseconds

Time needed to allocate    128 byte(s):    2567 nanoseconds
Time needed to allocate    128 byte(s):    8431 nanoseconds

Time needed to allocate   1024 byte(s):    2933 nanoseconds
Time needed to allocate   1024 byte(s):   20162 nanoseconds

Time needed to allocate  16384 byte(s):    3300 nanoseconds
Time needed to allocate  16384 byte(s):   12464 nanoseconds

*************************
*/