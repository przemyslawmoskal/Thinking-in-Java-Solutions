//: containers/SimpleHashMap.java
// A demonstration hashed Map.
import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
	class MapEntry<K,V> implements Map.Entry<K,V> {
		private K key;
		private V value;
		private MapEntry<K,V> nextEntry = null;
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() { return key; }
		public V getValue() { return value; }
		public V setValue(V v) {
			V result = value;
			value = v;
			return result;
		}
		public MapEntry<K,V> getNextEntry() {
			return this.nextEntry;
		}
		public void SetNextEntry(MapEntry<K,V> ne) {
			this.nextEntry = ne;
		}
		public boolean equals(Object o) {
			if(!(o instanceof MapEntry))
				return false;
			MapEntry me = (MapEntry)o;
			return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
					(value == null ? me.getValue() == null : value.equals(me.getValue()));
		}
		public int hashCode() {
			return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
		}
		public String toString() {
			return key + "=" + value;
		}
		
	}
	// Choose a prime number for the hash table
	// size, to achieve a uniform distribution:
	static final int SIZE = 997;
	// You can't have a physical array of generics,
	// but you can upcast to one:
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
		if(buckets[index] == null) {
			buckets[index] = new LinkedList<MapEntry<K,V>>();
			LinkedList<MapEntry<K,V>> bucket = buckets[index];
			bucket.add(pair);
		}
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		if(buckets[index].size() > 0) {
			for(MapEntry<K,V> entry = bucket.get(0); entry != null; entry = entry.getNextEntry()) {
				if(entry.getKey().equals(key)) {
					oldValue = entry.getValue();
					entry.setValue(value);
					return oldValue;
				}
			}
			bucket.add(pair);
			int i = bucket.indexOf(pair);
			if(i > 0)
				bucket.get(i - 1).SetNextEntry(pair);
			return pair.getValue();
		}
		return oldValue;
	}
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) return null;
		for(MapEntry<K,V> iPair : buckets[index])
			if(iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}
	public Set<Map.Entry<K,V>> entrySet() {
		Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket == null) continue;
			for(MapEntry<K,V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}
	public static void main(String[] args) {
		SimpleHashMap<String,String> m =
				new SimpleHashMap<String,String>();
		m.putAll(Countries.capitals(25));
		System.out.println(m);
		System.out.println(m.put("FRANCE", "Tokyo"));
		System.out.println(m.put("FRANCE", "Paris"));
		System.out.println(m.get("FRANCE"));
		System.out.println(m.entrySet());
	}
}

/* Output:
{CAPE VERDE=Praia, ANGOLA=Luanda, ETHIOPIA=Addis Ababa, BENIN=Porto-Novo, CONGO=Brazzaville, LESOTHO=Maseru, CENTRAL AFRICAN REPUBLIC=Bangui, EQUATORIAL GUINEA=Malabo, ERITREA=Asmara, COMOROS=Moroni, BURKINA FASO=Ouagadougou, GABON=Libreville, THE GAMBIA=Banjul, GUINEA=Conakry, EGYPT=Cairo, BURUNDI=Bujumbura, ALGERIA=Algiers, CAMEROON=Yaounde, GHANA=Accra, KENYA=Nairobi, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, BISSAU=Bissau, DJIBOUTI=Dijibouti, CHAD=N'djamena, BOTSWANA=Gaberone}
Tokyo
Tokyo
Paris
[CAPE VERDE=Praia, ANGOLA=Luanda, ETHIOPIA=Addis Ababa, BENIN=Porto-Novo, CONGO=Brazzaville, LESOTHO=Maseru, CENTRAL AFRICAN REPUBLIC=Bangui, EQUATORIAL GUINEA=Malabo, ERITREA=Asmara, COMOROS=Moroni, BURKINA FASO=Ouagadougou, GABON=Libreville, THE GAMBIA=Banjul, GUINEA=Conakry, EGYPT=Cairo, BURUNDI=Bujumbura, ALGERIA=Algiers, CAMEROON=Yaounde, GHANA=Accra, KENYA=Nairobi, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, FRANCE=Paris, BISSAU=Bissau, DJIBOUTI=Dijibouti, CHAD=N'djamena, BOTSWANA=Gaberone]
*/
