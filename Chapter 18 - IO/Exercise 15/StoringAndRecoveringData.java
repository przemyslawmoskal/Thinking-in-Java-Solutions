import java.io.*;

public class StoringAndRecoveringData {
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src\\Data.txt")));
		byte[] byteArr = {0,1,2,3,4,5};
		// Only first five bytes from byte[] byteArr:
		out.write(byteArr,0,5);
		// All six bytes from byte[] byteArr:
		out.write(byteArr);
		// Only the lowest 8 bits of int stored:
		out.write((int)255);
		out.writeBoolean(true);
		out.writeByte((int)10101);
		out.writeBytes("abc");
		out.writeChar((int)'a');
		out.writeChars("abc");
		out.writeDouble(1.234D);
		out.writeFloat(1.234F);
		out.writeInt(1234);
		out.writeLong(1234L);
		out.writeShort((short)1234);
		out.writeUTF("Sample UTF String");
		out.close();
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("src\\Data.txt")));
		byte[] byteArrIn = new byte[5];
		System.out.println("Number of bytes read by in.read(byteArrIn,0,5): " + in.read(byteArrIn,0,5));
		System.out.print("byte[] byteArrIn = ");
		for(int i = 0; i < byteArrIn.length; i++)
			System.out.print(byteArrIn[i] + ", ");
		System.out.println();
		// Reading first four bytes of byteArr as int:
		System.out.println(in.readInt());
		// Reading remaining two bytes of byteArr:
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.readByte());
		System.out.println(in.readBoolean());
		System.out.println(in.readByte());
		for(int i = 0; i < 3; i++)
			System.out.print(in.readByte() + " ");
		System.out.println(" (ASCII codes: 'a' = 97,'b' = 98,'c' = 99)");
		System.out.println(in.readChar());
		for(int i = 0; i < 3; i++)
			System.out.print(in.readChar());
		System.out.println();
		System.out.println(in.readDouble());
		System.out.println(in.readFloat());
		System.out.println(in.readInt());
		System.out.println(in.readLong());
		System.out.println(in.readShort());
		System.out.println(in.readUTF());
		in.close();
	}
}

/* Output:
Number of bytes read by in.read(byteArrIn,0,5): 5
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
Sample UTF String
*/