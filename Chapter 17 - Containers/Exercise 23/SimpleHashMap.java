import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
	// Choose a prime number for the hash table
	// size, to achieve a uniform distribution:
	static final int SIZE = 997;
	// You can't have a physical array of generics,
	// but you can upcast to one:
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K,V>>[] buckets =
		new LinkedList[SIZE];
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K,V>>();
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
		boolean found = false;
		ListIterator<MapEntry<K,V>> it = bucket.listIterator();
		while(it.hasNext()) {
			MapEntry<K,V> iPair = it.next();
			if(iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair); // Replace old with new
				found = true;
				break;
			}	
		}
		if(!found)
			buckets[index].add(pair);
		return oldValue;
	}
	public void putAll(Map<? extends K,? extends V> m) {
		for(Map.Entry<? extends K, ? extends V> me : m.entrySet()) {
			put(me.getKey(),me.getValue());
		}
	}
	public int size() {
		int result = 0;
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket != null)
				result += bucket.size();
		}
		return result;
	}
	public boolean containsKey(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null)
			return false;
		for(MapEntry<K,V> iPair : buckets[index]) {
			if(iPair.getKey().equals(key))
				return true;
		}
		return false;
	}
	public boolean containsValue(Object value) {
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket != null) {
				for(MapEntry<K,V> iPair : bucket) {
					if(iPair.getValue().equals(value))
						return true;
				}
			}
			
		}
		return false;
	}
	public boolean equals(Object o) {
		if(o instanceof SimpleHashMap) {
			if(this.entrySet().equals(((SimpleHashMap)o).entrySet()))
				return true;
		}
		return false;
	}
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) return null;
		for(MapEntry<K,V> iPair : buckets[index])
			if(iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}
	public int hashCode() {
		return this.entrySet().hashCode();
	}
	public boolean isEmpty() {
		return this.entrySet().isEmpty();
	}
	private Set<Map.Entry<K, V>> entrySet = new EntrySet();
	public Set<Map.Entry<K,V>> entrySet() {
		return entrySet;
	}
	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		public int size() { return SimpleHashMap.this.size(); }
		public Iterator<Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				private int bucketIndex = 0;
				private int listIndex = 0;
				private int count = -1;
				public boolean hasNext() {
					return count < SimpleHashMap.this.size() - 1;
				}
				public Map.Entry<K, V> next() {
					while(buckets[bucketIndex] == null || buckets[bucketIndex].size() == 0 || listIndex == buckets[bucketIndex].size()) {
						bucketIndex++;
						listIndex = 0;
					}
					Map.Entry<K, V> result = buckets[bucketIndex].get(listIndex);
					listIndex++;
					count++;
					return result;
				}
			};
		}
	}
	private KeySet keys = new KeySet();
	public Set<K> keySet() { return keys; }
	private class KeySet extends AbstractSet<K> {
		public int size() { return SimpleHashMap.this.size(); }
		public Iterator<K> iterator() {
			return new Iterator<K>() {
				private int bucketIndex = 0;
				private int listIndex = 0;
				private int count = -1;
				public boolean hasNext() {
					return count < SimpleHashMap.this.size() - 1;
				}
				public K next() {
					while(buckets[bucketIndex] == null || buckets[bucketIndex].size() == 0 || listIndex == buckets[bucketIndex].size()) {
						bucketIndex++;
						listIndex = 0;
					}
					K result = buckets[bucketIndex].get(listIndex).getKey();
					listIndex++;
					count++;
					return result;
				}
			};
		}
	} 
	public V remove(Object key) {
		V oldValue = null;
		if(!(this.get(key) == null)) {
			int index = Math.abs(key.hashCode()) % SIZE;
			for(MapEntry<K,V> iPair : buckets[index]) {
				if(iPair.getKey().equals(key)) {
					oldValue = iPair.getValue();
					int i = buckets[index].indexOf(iPair);
					buckets[index].remove(i);
					break;
				}
			}
		}
		return oldValue;
	}
	public void clear() {
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket != null)
				bucket.clear();
		}
	}
	public Collection<V> values() {
		HashSet<V> v = new HashSet<V>();
		for(LinkedList<MapEntry<K, V>> bucket : buckets) {
			if(bucket != null) {
				for(MapEntry<K, V> iPair : bucket)
					v.add(iPair.getValue());
			}
		}
		return v;
	}
	public static void main(String[] args) {
		SimpleHashMap<String,String> m =
				new SimpleHashMap<String,String>();
		System.out.println("m.putAll(Countries.capitals(25))");
		m.putAll(Countries.capitals(25));
		System.out.println("m.put(\"X\",\"Y\")");
		m.put("X","Y");
		System.out.println("m: " + m);
		System.out.println("m.get(\"ERITREA\"): " + m.get("ERITREA"));
		System.out.println("m.entrySet(): " + m.entrySet());
		System.out.println("m.keySet(): " + m.keySet());
		System.out.println("m.values(): " + m.values());
		System.out.println("m.containsKey(\"BENIN\"): " + m.containsKey("BENIN"));
		System.out.println("m.containsValue(\"Gaberone\"): " + m.containsValue("Gaberone"));
		System.out.println("m.hashCode(): " + m.hashCode());
		System.out.println("m.remove(\"BENIN\"): " + m.remove("BENIN"));
		System.out.println("m: " + m);
		System.out.println("m.size(): " + m.size());
		System.out.println("m.clear()");
		m.clear();
		System.out.println("m: " + m);
		System.out.println("m.isEmpty(): " + m.isEmpty());
		SimpleHashMap<String,String> m2 =
				new SimpleHashMap<String,String>();
		SimpleHashMap<String,String> m3 =
				new SimpleHashMap<String,String>();
		m2.putAll(Countries.capitals(3));
		m3.putAll(Countries.capitals(3));
		System.out.println("m2: " + m2);
		System.out.println("m3: " + m3);
		System.out.println("m2.equals(m3): " + m2.equals(m3));
	}
}

/* Output:
m.putAll(Countries.capitals(25))
m.put("X","Y")
m: {ERITREA=Asmara, BOTSWANA=Gaberone, X=Y, BENIN=Porto-Novo, CONGO=Brazzaville, LESOTHO=Maseru, GUINEA=Conakry, KENYA=Nairobi, ALGERIA=Algiers, BURKINA FASO=Ouagadougou, CAMEROON=Yaounde, EQUATORIAL GUINEA=Malabo, CENTRAL AFRICAN REPUBLIC=Bangui, CAPE VERDE=Praia, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, CHAD=N'djamena, EGYPT=Cairo, GABON=Libreville, BISSAU=Bissau, COMOROS=Moroni, ETHIOPIA=Addis Ababa, ANGOLA=Luanda, THE GAMBIA=Banjul, GHANA=Accra, BURUNDI=Bujumbura, DJIBOUTI=Dijibouti}
m.get("ERITREA"): Asmara
m.entrySet(): [ERITREA=Asmara, BOTSWANA=Gaberone, X=Y, BENIN=Porto-Novo, CONGO=Brazzaville, LESOTHO=Maseru, GUINEA=Conakry, KENYA=Nairobi, ALGERIA=Algiers, BURKINA FASO=Ouagadougou, CAMEROON=Yaounde, EQUATORIAL GUINEA=Malabo, CENTRAL AFRICAN REPUBLIC=Bangui, CAPE VERDE=Praia, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, CHAD=N'djamena, EGYPT=Cairo, GABON=Libreville, BISSAU=Bissau, COMOROS=Moroni, ETHIOPIA=Addis Ababa, ANGOLA=Luanda, THE GAMBIA=Banjul, GHANA=Accra, BURUNDI=Bujumbura, DJIBOUTI=Dijibouti]
m.keySet(): [ERITREA, BOTSWANA, X, BENIN, CONGO, LESOTHO, GUINEA, KENYA, ALGERIA, BURKINA FASO, CAMEROON, EQUATORIAL GUINEA, CENTRAL AFRICAN REPUBLIC, CAPE VERDE, COTE D'IVOIR (IVORY COAST), CHAD, EGYPT, GABON, BISSAU, COMOROS, ETHIOPIA, ANGOLA, THE GAMBIA, GHANA, BURUNDI, DJIBOUTI]
m.values(): [Yaounde, Algiers, Bangui, Bujumbura, Praia, Moroni, Accra, Nairobi, Brazzaville, Yamoussoukro, Porto-Novo, Malabo, Libreville, Banjul, Y, Luanda, Gaberone, Ouagadougou, Bissau, Asmara, Addis Ababa, N'djamena, Conakry, Cairo, Maseru, Dijibouti]
m.containsKey("BENIN"): true
m.containsValue("Gaberone"): true
m.hashCode(): -1447464436
m.remove("BENIN"): Porto-Novo
m: {ERITREA=Asmara, BOTSWANA=Gaberone, X=Y, CONGO=Brazzaville, LESOTHO=Maseru, GUINEA=Conakry, KENYA=Nairobi, ALGERIA=Algiers, BURKINA FASO=Ouagadougou, CAMEROON=Yaounde, EQUATORIAL GUINEA=Malabo, CENTRAL AFRICAN REPUBLIC=Bangui, CAPE VERDE=Praia, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, CHAD=N'djamena, EGYPT=Cairo, GABON=Libreville, BISSAU=Bissau, COMOROS=Moroni, ETHIOPIA=Addis Ababa, ANGOLA=Luanda, THE GAMBIA=Banjul, GHANA=Accra, BURUNDI=Bujumbura, DJIBOUTI=Dijibouti}
m.size(): 25
m.clear()
m: {}
m.isEmpty(): true
m2: {BENIN=Porto-Novo, ALGERIA=Algiers, ANGOLA=Luanda}
m3: {BENIN=Porto-Novo, ALGERIA=Algiers, ANGOLA=Luanda}
m2.equals(m3): true
*/