package ch12ex26;
import java.io.*;

public class MainException {
	
	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream("MainException123.java");
		file.close();
	}
}  

/* Output:
Exception in thread "main" java.io.FileNotFoundException: MainException123.java (Nie mo¿na odnaleŸæ okreœlonego pliku)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(Unknown Source)
	at java.io.FileInputStream.<init>(Unknown Source)
	at java.io.FileInputStream.<init>(Unknown Source)
	at ch12ex26.MainException.main(MainException.java:7)
*/