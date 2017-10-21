import java.io.*;
import net.mindview.util.*;

public class Ch18ex20 {
	public static void checkIfClassFilesStartWithCAFEBABE() throws IOException {
		byte[] signature = {(byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE};
		boolean allFilesStartWithCAFEBABE = true;
		for(File file : Directory.walk(".", ".*\\.class")) {
			byte[] bytes = BinaryFile.read(file);
			for(int i = 0; i < 4; i++)
				if(signature[i] != bytes[i]) {
					System.out.println("File \"" + file.getName() + "\" doesn't start with CAFEBABE!");
					allFilesStartWithCAFEBABE = false;
					break;
				}
		}
		if(allFilesStartWithCAFEBABE)
			System.out.println("All .class files in the directory start with CAFEBABE");
	}

	public static void main(String[] args) {
		try {
			checkIfClassFilesStartWithCAFEBABE();	
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}

/* Output:
All .class files in the directory start with CAFEBABE
*/
