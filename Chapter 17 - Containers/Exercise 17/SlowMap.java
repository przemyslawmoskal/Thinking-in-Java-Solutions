import java.util.*;
import net.mindview.util.*;

public class SlowMap<K,V> extends AbstractMap<K,V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	private EntrySet entries = new EntrySet();
	public Set<Map.Entry<K, V>> entrySet() { return entries; }	
	public V put(K key, V value) {
		V oldValue = get(key); // The old value or null
		if(!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return oldValue;
	}
	public V get(Object key) { // key is type Object, not K
		if(!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}
	public void clear() {
		this.entrySet().clear();
	}
	public boolean containsKey(Object key) {
		if(!keys.contains(key))
				return false;
		return true;
	}
	public boolean containsValue(Object value) {
		if(!values.contains(value))
				return false;
		return true;
	}
	public boolean equals(Object o) {
		if(!(o instanceof SlowMap))
			return false;
		if(this.entrySet().equals(((SlowMap)o).entrySet()))
			return true;
		else return false;
		
	}
	public int hashCode() { return this.entrySet().hashCode(); }
	public boolean isEmpty() { return this.entrySet().isEmpty(); }
	public Set<K> keySet() { return new KeySet<K>(); }
	private class KeySet<K> extends AbstractSet<K> {
		public int size() { return keys.size(); }
		public Iterator<K> iterator() {
			return new Iterator<K>() {
				private int index = -1;
				public boolean hasNext() {
					return index < keys.size() - 1;
				}
				public K next() {
					int nextIndex = ++ index;
					return (K)keys.get(index);
				}
				public void remove() {
					keys.remove(index--);
				}
			};
		}
	}
	public void putAll(Map<? extends K,? extends V> m) {
		for(Map.Entry<? extends K,? extends V> entry : m.entrySet())
			this.put(entry.getKey(), entry.getValue());
	}
	public V remove(Object key) {
		V value = this.get(key);
		int index = keys.indexOf(key);
		keys.remove(index);
		values.remove(index);
		return value;
	}
	public int size() {
		return keys.size();
	}
	public Collection<V> values() {
		return values;
	}
	public String toString() {
		return this.entrySet().toString();
	}
	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		public int size() { return keys.size(); }
		public Iterator<Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				private int index = -1;
				public boolean hasNext() {
					return index < keys.size() - 1;
				}
				public Map.Entry<K, V> next() {
					int nextIndex = ++index;
					return new MapEntry<K,V>(keys.get(nextIndex), values.get(nextIndex));
				}
				public void remove() {
					keys.remove(index);
					values.remove(index--);
				}
			};
		}
	}
  
	public static void main(String[] args) {
		SlowMap<String,String> m = new SlowMap<String,String>();
		System.out.println("m.putAll(Countries.capitals(15)): ");
		m.putAll(Countries.capitals(15));
		System.out.println("m: " + m);
		System.out.println("m.get(\"ALGERIA\"): " + m.get("ALGERIA"));
		System.out.println("m.entrySet(): " + m.entrySet());
		System.out.println("m.clear()");
		m.clear();
		System.out.println("m: " + m);
		System.out.println("m.isEmpty(): " + m.isEmpty());
		System.out.println("m.putAll(Countries.capitals(15)): ");
		m.putAll(Countries.capitals(15));
		System.out.println("m: " + m);
		m.remove("BOTSWANA");
		System.out.println("m: " + m);
		System.out.println("m.containsKey(\"BURUNDI\"): " + m.containsKey("BURUNDI"));
		System.out.println("m.containsValue(\"Porto-Novo\"): " + m.containsValue("Porto-Novo"));
		SlowMap<String,String> m2 = new SlowMap<String,String>();
		m2 = m;
		System.out.println("m2.equals(m): " + m2.equals(m));
		System.out.println("m.hashCode(): " + m.hashCode());
		System.out.println("m.keySet(): " + m.keySet());
		System.out.println("m.size(): " + m.size());
		System.out.println("m.values(): " + m.values());
	}
}

/* Output:
m.putAll(Countries.capitals(15)): 
m: [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo]
m.get("ALGERIA"): Algiers
m.entrySet(): [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo]
m.clear()
m: []
m.isEmpty(): true
m.putAll(Countries.capitals(15)): 
m: [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo]
m: [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo]
m.containsKey("BURUNDI"): true
m.containsValue("Porto-Novo"): true
m2.equals(m): true
m.hashCode(): 2053624824
m.keySet(): [ALGERIA, ANGOLA, BENIN, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA]
m.size(): 14
m.values(): [Algiers, Luanda, Porto-Novo, Ouagadougou, Bujumbura, Yaounde, Praia, Bangui, N'djamena, Moroni, Brazzaville, Dijibouti, Cairo, Malabo]
*/