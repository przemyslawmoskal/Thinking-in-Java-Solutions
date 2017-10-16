import java.util.*;
import java.io.*;

// args: { Ch18ex09.java }

public class Ch18ex09 {

	public static String readReverseAndUpperCaseLines(String filename) throws IOException {
		LinkedList<String> ll = new LinkedList<String>();
		BufferedReader in = new BufferedReader(new FileReader(new File("src\\" + filename)));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			ll.add(s.toUpperCase());
		ListIterator<String> it = ll.listIterator(ll.size());
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
			
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			System.out.println("Usage: Enter file name.");
			System.exit(0);
		}
		readReverseAndUpperCaseLines(args[0]);
	}

}

/* Output:
}

}
	READREVERSEANDUPPERCASELINES(ARGS[0]);
	}
		SYSTEM.EXIT(0);
		SYSTEM.OUT.PRINTLN("USAGE: ENTER FILE NAME.");
	IF(ARGS.LENGTH != 1) {
PUBLIC STATIC VOID MAIN(STRING[] ARGS) THROWS IOEXCEPTION {
}
	RETURN SB.TOSTRING();
	IN.CLOSE();
		
	}
		SYSTEM.OUT.PRINTLN(IT.PREVIOUS());
	WHILE(IT.HASPREVIOUS()) {
	LISTITERATOR<STRING> IT = LL.LISTITERATOR(LL.SIZE());
		LL.ADD(S.TOUPPERCASE());
	WHILE((S = IN.READLINE()) != NULL)
	STRINGBUILDER SB = NEW STRINGBUILDER();
	STRING S;
	BUFFEREDREADER IN = NEW BUFFEREDREADER(NEW FILEREADER(NEW FILE("SRC\\" + FILENAME)));
	LINKEDLIST<STRING> LL = NEW LINKEDLIST<STRING>();
PUBLIC STATIC STRING READREVERSEANDUPPERCASELINES(STRING FILENAME) THROWS IOEXCEPTION {

PUBLIC CLASS CH18EX09 {

//ARGS: { CH18EX09.JAVA }

IMPORT JAVA.IO.*;
IMPORT JAVA.UTIL.*;
*/