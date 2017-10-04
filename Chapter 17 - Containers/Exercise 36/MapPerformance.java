import java.util.*;
import net.mindview.util.Countries;
import static net.mindview.util.Print.*;

//SlowMap with one ArrayList - put() and get() not changed:
class SlowMap<K, V> extends AbstractMap<K, V> {
	protected List<MapEntry<K, V>> entriesList = new ArrayList<MapEntry<K, V>>();

	public V put(K key, V value) {
		V oldValue = get(key); // The old value or null
		Iterator<MapEntry<K, V>> iterator = entriesList.iterator();
		while (iterator.hasNext()) {
			MapEntry<K, V> me = iterator.next();
			if (me.getKey().equals(key))
				me.setValue(value);
		}
		entriesList.add(new MapEntry<K, V>(key, value));
		return oldValue;
	}

	public V get(Object key) { // key is type Object, not K
		Iterator<MapEntry<K, V>> iterator = entriesList.iterator();
		while (iterator.hasNext()) {
			MapEntry<K, V> me = iterator.next();
			if (me.getKey().equals(key))
				return me.getValue();
		}
		return null;
	}

	private EntrySet entries = new EntrySet();

	public Set<Map.Entry<K, V>> entrySet() {
		return entries;
	}

	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		public int size() {
			return entriesList.size();
		}

		public Iterator<Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K, V>>() {
				private int index = -1;

				public boolean hasNext() {
					return index < entriesList.size() - 1;
				}

				public Map.Entry<K, V> next() {
					int i = ++index;
					return entriesList.get(i);
				}

				public void remove() {
					entriesList.remove(index--);
				}
			};
		}

	}
}

// SlowMap with put() and get() changed
class SlowMap2<K, V> extends SlowMap<K, V> {
	private List<MapEntry<Integer, V>> hashEntriesList = new ArrayList<MapEntry<Integer, V>>();

	public List<MapEntry<Integer, V>> hashEntriesList() {
		return hashEntriesList;
	}

	private final MapEntryKeysComparator<K, V> comp1 = new MapEntryKeysComparator<K, V>();
	private final MapEntryKeysComparator<Integer, V> comp2 = new MapEntryKeysComparator<Integer, V>();

	public V put(K key, V value) {
		V oldValue = get(key); // The old value or null
		Iterator<MapEntry<K, V>> iterator = entriesList.iterator();
		while (iterator.hasNext()) {
			MapEntry<K, V> me = iterator.next();
			if (me.getKey().equals(key))
				me.setValue(value);
		}
		entriesList.add(new MapEntry<K, V>(key, value));
		hashEntriesList.add(new MapEntry<Integer, V>(key.hashCode(), value));
		Collections.sort(entriesList, comp1);
		Collections.sort(hashEntriesList, comp2);
		return oldValue;
	}

	public V get(Object key) {
		MapEntry<Integer, V> subME = new MapEntry<Integer, V>(key.hashCode(), null);
		int i = Collections.binarySearch(hashEntriesList, subME, comp2);
		if (i >= 0)
			return hashEntriesList.get(i).getValue();
		return null;
	}

	// Comparator sorting by keys' hashCode():
	class MapEntryKeysComparator<K, V> implements Comparator<MapEntry<K, V>> {
		public int compare(MapEntry<K, V> me1, MapEntry<K, V> me2) {
			return (me1.getKey().hashCode()) < (me2.getKey().hashCode()) ? -1
					: (me1.getKey().hashCode()) == (me2.getKey().hashCode()) ? 0 : 1;
		}

	}
}

public class MapPerformance {
	static List<Test<Map<Integer, Integer>>> tests = new ArrayList<Test<Map<Integer, Integer>>>();
	static {
		tests.add(new Test<Map<Integer, Integer>>("put") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					map.clear();
					for (int j = 0; j < size; j++)
						map.put(j, j);
				}
				return loops * size;
			}
		});
		tests.add(new Test<Map<Integer, Integer>>("get") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for (int i = 0; i < loops; i++)
					for (int j = 0; j < span; j++)
						map.get(j);
				return loops * span;
			}
		});
		tests.add(new Test<Map<Integer, Integer>>("iterate") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops * 10;
				for (int i = 0; i < loops; i++) {
					Iterator it = map.entrySet().iterator();
					while (it.hasNext())
						it.next();
				}
				return loops * map.size();
			}
		});
	}

	public static void main(String[] args) {
		print("Testing if SlowMap is working correctly:");
		print("****************************************");
		SlowMap<String, String> slowMapa = new SlowMap<String, String>();
		slowMapa.putAll(Countries.capitals(20));
		print("slowMapa: " + slowMapa);
		print("slowMapa.get(\"BENIN\"): " + slowMapa.get("BENIN"));
		print("slowMapa.entrySet(): " + slowMapa.entrySet());
		print("slowMapa.keySet(): " + slowMapa.keySet());
		print("slowMapa.values(): " + slowMapa.values());
		SlowMap<String, String> slowMapb = new SlowMap<String, String>();
		slowMapb.putAll(Countries.capitals(20));
		print("slowMapb: " + slowMapb);
		print("slowMapa.equals(slowMapb): " + slowMapa.equals(slowMapb));
		print("slowMapa.clear()");
		slowMapa.clear();
		print("slowMapa: " + slowMapa);
		print("slowMapa.isEmpty(): " + slowMapa.isEmpty());
		print("slowMapb.keySet().clear()");
		slowMapb.keySet().clear();
		print("slowMapb: " + slowMapb);
		print("slowMapb.isEmpty(): " + slowMapb.isEmpty());
		print("\nTesting if SlowMap2 is working correctly:");
		print("****************************************");
		SlowMap2<String, String> slowMap2a = new SlowMap2<String, String>();
		slowMap2a.putAll(Countries.capitals(20));
		print("slowMap2a: " + slowMap2a);
		print("slowMap2a.get(\"BENIN\"): " + slowMap2a.get("BENIN"));
		print("slowMap2a.entrySet(): " + slowMap2a.entrySet());
		print("slowMap2a.hashEntriesList(): " + slowMap2a.hashEntriesList());
		print("slowMap2a.values(): " + slowMap2a.values());
		print("slowMap2a.clear()");
		slowMap2a.clear();
		print("slowMap2a: " + slowMap2a);
		print("slowMap2a.isEmpty(): " + slowMap2a.isEmpty());
		SlowMap2<String, String> slowMap2b = new SlowMap2<String, String>();
		slowMap2b.putAll(Countries.capitals(20));
		print("slowMap2b: " + slowMap2b);
		print("slowMap2b.keySet().clear()");
		slowMap2b.keySet().clear();
		print("slowMap2b: " + slowMap2b);
		print("slowMap2b.isEmpty(): " + slowMap2b.isEmpty());
		print();
		print("Comparing maps with tests: ");
		print("**************************");
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		else
			Tester.defaultParams = TestParam.array(15, 300, 100, 100, 150, 20);
		Tester.run(new UnchangedSlowMap<Integer, Integer>(), tests);
		Tester.run(new SlowMap<Integer, Integer>(), tests);
		Tester.run(new SlowMap2<Integer, Integer>(), tests);
		Tester.run(new TreeMap<Integer, Integer>(), tests);
		Tester.run(new HashMap<Integer, Integer>(), tests);
		Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
		Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
		Tester.run(new WeakHashMap<Integer, Integer>(), tests);
		Tester.run(new Hashtable<Integer, Integer>(), tests);
	}
}

/* Output (Sample):
Testing if SlowMap is working correctly:
****************************************
slowMapa: {ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo, ERITREA=Asmara, ETHIOPIA=Addis Ababa, GABON=Libreville, THE GAMBIA=Banjul, GHANA=Accra}
slowMapa.get("BENIN"): Porto-Novo
slowMapa.entrySet(): [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo, ERITREA=Asmara, ETHIOPIA=Addis Ababa, GABON=Libreville, THE GAMBIA=Banjul, GHANA=Accra]
slowMapa.keySet(): [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA]
slowMapa.values(): [Algiers, Luanda, Porto-Novo, Gaberone, Ouagadougou, Bujumbura, Yaounde, Praia, Bangui, N'djamena, Moroni, Brazzaville, Dijibouti, Cairo, Malabo, Asmara, Addis Ababa, Libreville, Banjul, Accra]
slowMapb: {ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo, ERITREA=Asmara, ETHIOPIA=Addis Ababa, GABON=Libreville, THE GAMBIA=Banjul, GHANA=Accra}
slowMapa.equals(slowMapb): true
slowMapa.clear()
slowMapa: {}
slowMapa.isEmpty(): true
slowMapb.keySet().clear()
slowMapb: {}
slowMapb.isEmpty(): true

Testing if SlowMap2 is working correctly:
****************************************
slowMap2a: {CAPE VERDE=Praia, BOTSWANA=Gaberone, ERITREA=Asmara, ETHIOPIA=Addis Ababa, EQUATORIAL GUINEA=Malabo, ALGERIA=Algiers, THE GAMBIA=Banjul, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, BENIN=Porto-Novo, CONGO=Brazzaville, EGYPT=Cairo, GABON=Libreville, GHANA=Accra, CAMEROON=Yaounde, BURUNDI=Bujumbura, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti, COMOROS=Moroni, ANGOLA=Luanda}
slowMap2a.get("BENIN"): Porto-Novo
slowMap2a.entrySet(): [CAPE VERDE=Praia, BOTSWANA=Gaberone, ERITREA=Asmara, ETHIOPIA=Addis Ababa, EQUATORIAL GUINEA=Malabo, ALGERIA=Algiers, THE GAMBIA=Banjul, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, BENIN=Porto-Novo, CONGO=Brazzaville, EGYPT=Cairo, GABON=Libreville, GHANA=Accra, CAMEROON=Yaounde, BURUNDI=Bujumbura, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti, COMOROS=Moroni, ANGOLA=Luanda]
slowMap2a.hashEntriesList(): [-2005115977=Praia, -1356130423=Gaberone, -769164586=Asmara, -633124695=Addis Ababa, -535406310=Malabo, -198280703=Algiers, -189733898=Banjul, -3715245=Bangui, 2067272=N'djamena, 63085264=Porto-Novo, 64306634=Brazzaville, 65926203=Cairo, 67572359=Libreville, 67779891=Accra, 633061458=Yaounde, 957516733=Bujumbura, 1232689159=Ouagadougou, 1656099706=Dijibouti, 1668453352=Moroni, 1935122954=Luanda]
slowMap2a.values(): [Praia, Gaberone, Asmara, Addis Ababa, Malabo, Algiers, Banjul, Bangui, N'djamena, Porto-Novo, Brazzaville, Cairo, Libreville, Accra, Yaounde, Bujumbura, Ouagadougou, Dijibouti, Moroni, Luanda]
slowMap2a.clear()
slowMap2a: {}
slowMap2a.isEmpty(): true
slowMap2b: {CAPE VERDE=Praia, BOTSWANA=Gaberone, ERITREA=Asmara, ETHIOPIA=Addis Ababa, EQUATORIAL GUINEA=Malabo, ALGERIA=Algiers, THE GAMBIA=Banjul, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, BENIN=Porto-Novo, CONGO=Brazzaville, EGYPT=Cairo, GABON=Libreville, GHANA=Accra, CAMEROON=Yaounde, BURUNDI=Bujumbura, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti, COMOROS=Moroni, ANGOLA=Luanda}
slowMap2b.keySet().clear()
slowMap2b: {}
slowMap2b.isEmpty(): true

Comparing maps with tests: 
**************************
------ UnchangedSlowMap ------
 size     put     get iterate
   15    4056     212    1291
  100    4859     920    3104
  150    6700    1255    5907
---------- SlowMap ----------
 size     put     get iterate
   15    2932     259      28
  100    2623    1674      23
  150    3424    2503      22
---------- SlowMap2 ----------
 size     put     get iterate
   15   89999     284      23
  100  353125     345      22
  150  592610     395      22
---------- TreeMap ----------
 size     put     get iterate
   15     936     101      69
  100     135      89      27
  150     146      95      27
---------- HashMap ----------
 size     put     get iterate
   15      44     110      31
  100      43      20      20
  150      43      22      18
------- LinkedHashMap -------
 size     put     get iterate
   15     302      96     184
  100      57      21      16
  150      55      21      17
------ IdentityHashMap ------
 size     put     get iterate
   15     238     150      82
  100      99     113      32
  150     114     129      29
-------- WeakHashMap --------
 size     put     get iterate
   15     602     102      74
  100     166      21      20
  150      60      26      19
--------- Hashtable ---------
 size     put     get iterate
   15     306      57      75
  100      44      21      23
  150      47      22      22

*/
