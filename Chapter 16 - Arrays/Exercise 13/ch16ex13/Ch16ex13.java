package ch16ex13;

import java.util.Arrays;

import net.mindview.util.CountingGenerator;

public class Ch16ex13 {
	public static String fillString (int length) {
		CountingGenerator.Character charGen = new CountingGenerator.Character();
		char[] charArr = new char[length];
		for(int i = 0; i < charArr.length; i++) {
			charArr[i] = charGen.next();
		}
		return new String(charArr);
	}

	public static void main(String[] args) {
		System.out.println(fillString(2));
		System.out.println(fillString(5));
		System.out.println(fillString(10));
		System.out.println(fillString(15));
		
	}

}

/* Output:
ab
abcde
abcdefghij
abcdefghijklmno
*/