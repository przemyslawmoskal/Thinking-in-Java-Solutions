import java.io.*;
import java.util.*;
import nu.xom.*;
import net.mindview.util.*;

public class Ch18ex32 {
	public static Map<String,Integer> countWords(String fn) {
		System.out.println("Counting occurences of word included in file \"" + fn + "\":");
		String filename = "src//" + fn;
		Map<String,Integer> map = new TreeMap<String,Integer>();
		ArrayList<String> listOfAllWords = new TextFile(filename,"\\W++");
		Iterator<String> it = listOfAllWords.iterator();
		while(it.hasNext()) {
			String word = it.next();
			if(!(map.containsKey(word))) {
				map.put(word, 1);
			}
			else {
				int counter = map.get(word);
				map.put(word, ++counter);
			}
		}
		return map;
	}
	
	public static void format(OutputStream os, Document doc) throws Exception {
		Serializer serializer = new Serializer(os, "Windows-1250");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: Enter name of the file to count occurence of each word.");
			System.exit(1);
		}
		Map<String,Integer> words = countWords(args[0]);
		System.out.println(words);
		System.out.println();
		Element root = new Element("words");
		Iterator it = words.entrySet().iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
			Element word = new Element("word");
			word.appendChild(entry.getKey());
			word.appendChild(": ");
			word.appendChild(entry.getValue().toString());
			root.appendChild(word);
		}
		Document doc = new Document(root);
		try {
			format(System.out, doc);
			format(new BufferedOutputStream(new FileOutputStream(new File("src//words.xml"))), doc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

/* Output:
Counting occurences of word included in file "Ch18ex32.java":
{0=1, 1=3, 1250=1, 4=1, 60=1, ArrayList=1, BufferedOutputStream=1, Ch18ex32=1, Counting=1, Document=3, Element=4, Enter=1, Entry=2, Exception=2, File=1, FileOutputStream=1, Integer=6, Iterator=2, Map=5, OutputStream=1, Serializer=2, String=12, SuppressWarnings=1, System=6, TextFile=1, TreeMap=1, Usage=1, W=1, Windows=1, appendChild=4, args=3, catch=1, class=1, containsKey=1, count=1, countWords=2, counter=2, doc=5, e=2, each=1, else=1, entry=3, entrySet=1, exit=1, file=2, filename=2, flush=1, fn=3, format=3, get=1, getKey=1, getValue=1, hasNext=2, if=2, import=4, in=1, included=1, int=1, io=1, it=6, iterator=2, java=2, length=1, listOfAllWords=2, main=1, map=6, mindview=1, name=1, net=1, new=9, next=2, nu=1, occurence=1, occurences=1, of=3, os=2, out=5, printStackTrace=1, println=4, public=4, put=2, return=1, root=3, serializer=5, setIndent=1, setMaxLength=1, src=2, static=3, the=1, throws=1, to=1, toString=1, try=1, unchecked=1, util=2, void=2, while=2, word=13, words=5, write=1, xml=1, xom=1}

<?xml version="1.0" encoding="Windows-1250"?>
<words>
    <word>0: 1</word>
    <word>1: 3</word>
    <word>1250: 1</word>
    <word>4: 1</word>
    <word>60: 1</word>
    <word>ArrayList: 1</word>
    <word>BufferedOutputStream: 1</word>
    <word>Ch18ex32: 1</word>
    <word>Counting: 1</word>
    <word>Document: 3</word>
    <word>Element: 4</word>
    <word>Enter: 1</word>
    <word>Entry: 2</word>
    <word>Exception: 2</word>
    <word>File: 1</word>
    <word>FileOutputStream: 1</word>
    <word>Integer: 6</word>
    <word>Iterator: 2</word>
    <word>Map: 5</word>
    <word>OutputStream: 1</word>
    <word>Serializer: 2</word>
    <word>String: 12</word>
    <word>SuppressWarnings: 1</word>
    <word>System: 6</word>
    <word>TextFile: 1</word>
    <word>TreeMap: 1</word>
    <word>Usage: 1</word>
    <word>W: 1</word>
    <word>Windows: 1</word>
    <word>appendChild: 4</word>
    <word>args: 3</word>
    <word>catch: 1</word>
    <word>class: 1</word>
    <word>containsKey: 1</word>
    <word>count: 1</word>
    <word>countWords: 2</word>
    <word>counter: 2</word>
    <word>doc: 5</word>
    <word>e: 2</word>
    <word>each: 1</word>
    <word>else: 1</word>
    <word>entry: 3</word>
    <word>entrySet: 1</word>
    <word>exit: 1</word>
    <word>file: 2</word>
    <word>filename: 2</word>
    <word>flush: 1</word>
    <word>fn: 3</word>
    <word>format: 3</word>
    <word>get: 1</word>
    <word>getKey: 1</word>
    <word>getValue: 1</word>
    <word>hasNext: 2</word>
    <word>if: 2</word>
    <word>import: 4</word>
    <word>in: 1</word>
    <word>included: 1</word>
    <word>int: 1</word>
    <word>io: 1</word>
    <word>it: 6</word>
    <word>iterator: 2</word>
    <word>java: 2</word>
    <word>length: 1</word>
    <word>listOfAllWords: 2</word>
    <word>main: 1</word>
    <word>map: 6</word>
    <word>mindview: 1</word>
    <word>name: 1</word>
    <word>net: 1</word>
    <word>new: 9</word>
    <word>next: 2</word>
    <word>nu: 1</word>
    <word>occurence: 1</word>
    <word>occurences: 1</word>
    <word>of: 3</word>
    <word>os: 2</word>
    <word>out: 5</word>
    <word>printStackTrace: 1</word>
    <word>println: 4</word>
    <word>public: 4</word>
    <word>put: 2</word>
    <word>return: 1</word>
    <word>root: 3</word>
    <word>serializer: 5</word>
    <word>setIndent: 1</word>
    <word>setMaxLength: 1</word>
    <word>src: 2</word>
    <word>static: 3</word>
    <word>the: 1</word>
    <word>throws: 1</word>
    <word>to: 1</word>
    <word>toString: 1</word>
    <word>try: 1</word>
    <word>unchecked: 1</word>
    <word>util: 2</word>
    <word>void: 2</word>
    <word>while: 2</word>
    <word>word: 13</word>
    <word>words: 5</word>
    <word>write: 1</word>
    <word>xml: 1</word>
    <word>xom: 1</word>
</words>
*/
