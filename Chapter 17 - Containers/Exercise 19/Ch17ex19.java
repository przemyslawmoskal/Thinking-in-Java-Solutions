import java.util.*;
import net.mindview.util.*;

public class Ch17ex19 {
	public static void countWords(String fileName) {
		Set<String> wordsSet =  new TreeSet<String>(new TextFile(fileName,"\\W++"));
		SimpleHashMap<String,Integer> wordCounter = new SimpleHashMap<String,Integer>();
		ArrayList<String> wordsList = new ArrayList<String>(new TextFile(fileName,"\\W++"));
		System.out.println("All words used in " + fileName + ": " + wordsList);
		for(String s : wordsSet) {
			int counter = 0;
			for(String ss : wordsList) {
				if(ss.equals(s))
					counter++;
			}
			wordCounter.put(s, counter);
		}
		System.out.println(wordCounter);
	}

	public static void main(String[] args) {
		countWords("Ch17ex19.java");
		
	}

}

/* Output:
All words used in Ch17ex19.java: [import, java, util, import, net, mindview, util, public, class, Ch17ex19, public, static, void, countWords, String, fileName, Set, String, wordsSet, new, TreeSet, String, new, TextFile, fileName, W, SimpleHashMap, String, Integer, wordCounter, new, SimpleHashMap, String, Integer, ArrayList, String, wordsList, new, ArrayList, String, new, TextFile, fileName, W, System, out, println, All, words, used, in, fileName, wordsList, for, String, s, wordsSet, int, counter, 0, for, String, ss, wordsList, if, ss, equals, s, counter, wordCounter, put, s, counter, System, out, println, wordCounter, public, static, void, main, String, args, countWords, Ch17ex19, java]
{All=1, String=10, countWords=2, Set=1, wordsSet=2, fileName=4, import=2, ArrayList=2, used=1, for=2, main=1, System=2, mindview=1, out=2, Ch17ex19=2, put=1, println=2, java=2, W=2, TreeSet=1, public=3, if=1, class=1, net=1, void=2, static=2, ss=2, new=5, in=1, SimpleHashMap=2, counter=3, words=1, TextFile=2, int=1, s=3, 0=1, wordsList=3, args=1, Integer=2, equals=1, util=2, wordCounter=3}
*/