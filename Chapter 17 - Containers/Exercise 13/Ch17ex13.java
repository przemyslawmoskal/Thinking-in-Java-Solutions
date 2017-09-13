import java.util.*;
import net.mindview.util.*;

public class Ch17ex13 {
	public static void countWords(String fileName) {
		Set<String> wordsSet =  new TreeSet<String>(new TextFile(fileName,"\\W++"));
		AssociativeArray<String,Integer> wordCounter = new AssociativeArray<String,Integer>(wordsSet.size());
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
		countWords("Ch17ex13.java");
		
	}

}

/* Output:
All words used in Ch17ex13.java: [import, java, util, import, net, mindview, util, public, class, Ch17ex13, public, static, void, countWords, String, fileName, Set, String, wordsSet, new, TreeSet, String, new, TextFile, fileName, W, AssociativeArray, String, Integer, wordCounter, new, AssociativeArray, String, Integer, wordsSet, size, ArrayList, String, wordsList, new, ArrayList, String, new, TextFile, fileName, W, System, out, println, All, words, used, in, fileName, wordsList, for, String, s, wordsSet, int, counter, 0, for, String, ss, wordsList, if, ss, equals, s, counter, wordCounter, put, s, counter, System, out, println, wordCounter, public, static, void, main, String, args, countWords, Ch17ex13, java]
0 : 1
All : 1
ArrayList : 2
AssociativeArray : 2
Ch17ex13 : 2
Integer : 2
Set : 1
String : 10
System : 2
TextFile : 2
TreeSet : 1
W : 2
args : 1
class : 1
countWords : 2
counter : 3
equals : 1
fileName : 4
for : 2
if : 1
import : 2
in : 1
int : 1
java : 2
main : 1
mindview : 1
net : 1
new : 5
out : 2
println : 2
public : 3
put : 1
s : 3
size : 1
ss : 2
static : 2
used : 1
util : 2
void : 2
wordCounter : 3
words : 1
wordsList : 3
wordsSet : 3
*/