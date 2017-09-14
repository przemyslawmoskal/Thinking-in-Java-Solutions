import java.util.*;
import net.mindview.util.*;

public class Ch17ex15 {
	public static void countWords(String fileName) {
		ArrayList<String> wordsList = new ArrayList<String>(new TextFile(fileName,"\\W++"));
		SlowMap<String,Integer> wordCounter = new SlowMap<String,Integer>();
		System.out.println("All words used in " + fileName + ": " + wordsList);
		Iterator<String> iterator = wordsList.iterator();
		while(iterator.hasNext()) {
			String word = iterator.next();
			if(!(wordCounter.containsKey(word)))
				wordCounter.put(word, 1);
			else {
				int counter = wordCounter.get(word);
				wordCounter.put(word, ++counter);
			}
				
		}
		System.out.println(wordCounter);
	}

	public static void main(String[] args) {
		countWords("Ch17ex15.java");
		
	}

}

/* Output:
All words used in Ch17ex15.java: [import, java, util, import, net, mindview, util, public, class, Ch17ex15, public, static, void, countWords, String, fileName, ArrayList, String, wordsList, new, ArrayList, String, new, TextFile, fileName, W, SlowMap, String, Integer, wordCounter, new, SlowMap, String, Integer, System, out, println, All, words, used, in, fileName, wordsList, Iterator, String, iterator, wordsList, iterator, while, iterator, hasNext, String, word, iterator, next, if, wordCounter, containsKey, word, wordCounter, put, word, 1, else, int, counter, wordCounter, get, word, wordCounter, put, word, counter, System, out, println, wordCounter, public, static, void, main, String, args, countWords, Ch17ex15, java]
{fileName=3, All=1, next=1, countWords=2, String=8, import=2, ArrayList=2, used=1, Ch17ex15=2, main=1, System=2, put=2, mindview=1, out=2, while=1, println=2, java=2, W=1, iterator=4, get=1, public=3, else=1, Iterator=1, class=1, if=1, net=1, static=2, void=2, new=3, in=1, containsKey=1, TextFile=1, words=1, counter=2, hasNext=1, int=1, 1=1, wordsList=3, args=1, Integer=2, wordCounter=6, util=2, word=5, SlowMap=2}
*/