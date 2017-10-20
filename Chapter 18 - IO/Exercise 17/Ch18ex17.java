import java.util.*;
import net.mindview.util.*;

public class Ch18ex17 {
	public static Map<Character,Integer> countCharacters(String filename) {
		String s = TextFile.read("src\\" + filename);
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(Character.isLetter(c)) {
				if(!(map.keySet().contains(c))) {
					map.put(c, 1);
				}
				else {
					int counter = map.get(c);
					map.put(c, ++counter);
				}
			}
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println(countCharacters(args[0]));
	}

}

/* Output:
{A=1, C=8, F=1, I=3, L=1, M=3, S=5, T=2, a=36, b=3, c=26, d=3, e=38, f=5, g=10, h=10, i=30, j=1, k=1, l=12, m=13, n=24, o=10, p=17, r=35, s=16, t=42, u=13, v=3, w=2, x=2, y=2}
*/