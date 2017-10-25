import java.io.*;

// Args: { Ch18ex21.java }

public class Ch18ex21 {

	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			System.out.println("Usage: Enter file name");
			System.exit(1);
		}
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("src\\" + args[0]));
		System.setIn(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null) {
			System.out.println(s.toUpperCase());
		}
		
	}

}

/* Output:
IMPORT JAVA.IO.*;

//ARGS: { CH18EX21.JAVA }

PUBLIC CLASS CH18EX21 {

	PUBLIC STATIC VOID MAIN(STRING[] ARGS) THROWS IOEXCEPTION {
		IF(ARGS.LENGTH != 1) {
			SYSTEM.OUT.PRINTLN("USAGE: ENTER FILE NAME");
			SYSTEM.EXIT(1);
		}
		BUFFEREDINPUTSTREAM IN = NEW BUFFEREDINPUTSTREAM(NEW FILEINPUTSTREAM("SRC\\" + ARGS[0]));
		SYSTEM.SETIN(IN);
		BUFFEREDREADER BR = NEW BUFFEREDREADER(NEW INPUTSTREAMREADER(SYSTEM.IN));
		STRING S;
		WHILE((S = BR.READLINE()) != NULL) {
			SYSTEM.OUT.PRINTLN(S.TOUPPERCASE());
		}
		
	}

}
*/