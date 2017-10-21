import java.util.*;
import java.io.*;
import net.mindview.util.*;

public class Ch18ex19 {
	public static Map<Byte, Integer> countBytes(String filename) throws IOException {
		byte[] bytes = BinaryFile.read("src\\" + filename);
		Map<Byte, Integer> map = new TreeMap<Byte, Integer>();
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			if (!(map.keySet().contains(b))) {
				map.put(b, 1);
			} else {
				int counter = map.get(b);
				map.put(b, ++counter);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: Enter file name to count occurence of each of bytes");
			System.exit(1);
		}
		try {
			System.out.println(countBytes(args[0]));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}

/* Output:
{9=62, 10=34, 13=34, 32=69, 33=2, 34=4, 40=19, 41=19, 42=3, 43=5, 44=5, 46=21, 48=2, 49=5, 56=1, 57=1, 58=1, 59=16, 60=4, 61=6, 62=3, 66=6, 67=1, 69=3, 70=1, 73=5, 77=3, 79=2, 83=7, 84=2, 85=1, 91=4, 92=2, 93=4, 97=31, 98=14, 99=23, 100=3, 101=55, 102=8, 103=12, 104=6, 105=37, 106=2, 107=2, 108=15, 109=17, 110=34, 111=21, 112=22, 114=28, 115=21, 116=58, 117=16, 118=4, 119=3, 120=4, 121=17, 123=9, 125=9}
*/
