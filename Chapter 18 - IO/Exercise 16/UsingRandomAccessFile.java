
//: io/UsingRandomAccessFile.java
import java.io.*;

public class UsingRandomAccessFile {
	static String file = "src\\rtest.dat";

	static void display() throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		byte[] byteArrIn = new byte[5];
		System.out.println("Number of bytes read by rf.read(byteArrIn,0,5): " + rf.read(byteArrIn,0,5));
		System.out.print("byte[] byteArrIn = ");
		for(int i = 0; i < byteArrIn.length; i++)
			System.out.print(byteArrIn[i] + ", ");
		System.out.println();
		// Reading first four bytes of byteArr as int:
		System.out.println(rf.readInt());
		// Reading remaining two bytes of byteArr:
		System.out.println(rf.read());
		System.out.println(rf.read());
		System.out.println(rf.readByte());
		System.out.println(rf.readBoolean());
		System.out.println(rf.readByte());
		for(int i = 0; i < 3; i++)
			System.out.print(rf.readByte() + " ");
		System.out.println(" (ASCII codes: 'a' = 97,'b' = 98,'c' = 99)");
		System.out.println(rf.readChar());
		for(int i = 0; i < 3; i++)
			System.out.print(rf.readChar());
		System.out.println();
		System.out.println(rf.readDouble());
		System.out.println(rf.readFloat());
		System.out.println(rf.readInt());
		System.out.println(rf.readLong());
		System.out.println(rf.readShort());
		System.out.println(rf.readUTF());
		rf.close();
	}

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		byte[] byteArr = {0,1,2,3,4,5};
		// Only first five bytes from byte[] byteArr:
		rf.write(byteArr,0,5);
		// All six bytes from byte[] byteArr:
		rf.write(byteArr);
		// Only the lowest 8 bits of int stored:
		rf.write((int)255);
		rf.writeBoolean(true);
		rf.writeByte((int)10101);
		rf.writeBytes("abc");
		rf.writeChar((int)'a');
		rf.writeChars("abc");
		rf.writeDouble(1.234D);
		rf.writeFloat(1.234F);
		rf.writeInt(1234);
		rf.writeLong(1234L);
		rf.writeShort((short)1234);
		rf.writeUTF("End of file");
		rf.close();
		display();
	}
} 

/* Output:
Number of bytes read by rf.read(byteArrIn,0,5): 5
byte[] byteArrIn = 0, 1, 2, 3, 4, 
66051
4
5
-1
true
117
97 98 99  (ASCII codes: 'a' = 97,'b' = 98,'c' = 99)
a
abc
1.234
1.234
1234
1234
1234
End of file
*/