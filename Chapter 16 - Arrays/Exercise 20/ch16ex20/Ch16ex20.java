package ch16ex20;

import java.util.Arrays;

public class Ch16ex20 {

	public static void main(String[] args) {
		int[][] arr21 = {{0,1,2},{3,4,5}};
		int[][] arr22 = {{0,1,2},{3,4,5}};
		System.out.println(Arrays.deepEquals(arr21, arr22));
		String[][][] arr31 = {
				{ {"ab","cd"},{"ef","gh","ij"},{"kl"} },
				{ {"mn","op"},{"qr","st","uv","wx"},{"yz"} }
				};
		String[][][] arr32 = {
				{ {"ab","cd"},{"ef","gh","ij"},{"kl"} },
				{ {"mn","op"},{"qr","st","uv","wx"},{"yz"} }
				};
		String[][][] arr33 = {
				{ {"aa","cd"},{"ef","gh","ij"},{"kl"} },
				{ {"mn","op"},{"qr","st","uv","wx"},{"yz"} }
				};
		System.out.println(Arrays.deepEquals(arr31, arr32));
		System.out.println(Arrays.deepEquals(arr31, arr33));
	}

}

/* Output:
true
true
false
*/