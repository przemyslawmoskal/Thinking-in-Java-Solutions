import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.Charset;

public class Ch18ex23 {
	public static boolean isPrintableCharacter(char c) {
		if((c >= '!') && (c <= '~')) {
			return true;
		}
		return false;
	}
	
	public static void showCharacters(CharBuffer cb) {
		cb.clear();
		System.out.print("Printable characters in CharBuffer: >");
		while(cb.hasRemaining()) {
			char c = cb.get();
			if(isPrintableCharacter(c))
				System.out.print(c);
		}
		System.out.println("<");
		
	}

	public static void main(String[] args) throws Exception {
		// char[] containing only printable characters:
		char[] chars1 = new char[10];
		for(int i = 0; i < 10; i++) {
			chars1[i] = (char)(i+97);
		}
		System.out.print("char1[] chars: >>");
		for(int i = 0; i < chars1.length; i++) {
			System.out.print(chars1[i]);
		}
		System.out.println("<<");
		CharBuffer cb1 = CharBuffer.wrap(chars1);
		showCharacters(cb1);
		// char[] containing printable and non-printable characters:
		char[] chars2 = new char[5];
		chars2[0] = (char)32;
		chars2[1] = 'k';
		chars2[2] = (char)13;
		chars2[3] = (char)12;
		chars2[4] = 'l';
		System.out.print("char2[] chars: >>");
		for(int i = 0; i < chars2.length; i++) {
			System.out.print(chars2[i]);
		}
		System.out.println("<<");
		CharBuffer cb2 = CharBuffer.wrap(chars2);
		showCharacters(cb2);
	}

}

/* Output:
char1[] chars: >>abcdefghij<<
Printable characters in CharBuffer: >abcdefghij<
char2[] chars: >> k
l<<
Printable characters in CharBuffer: >kl<
*/
