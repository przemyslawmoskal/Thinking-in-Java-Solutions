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
		int probes = 0;
		while(it.hasNext()) {
			MapEntry<K,V> iPair = it.next();
			probes++;
			if(iPair.getKey().equals(key)) {
				System.out.println("Collision occured (Number of probes: " + probes + "), new pair: " + pair + ", replaces old one: " + iPair);
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
		m.putAll(Countries.capitals(5));
		System.out.println(m);
		m.put("FRANCE", "Tokyo");
		m.put("FRANCE", "Rome");
		m.put("FRANCE", "France");
		m.putAll(Countries.capitals(10));
		System.out.println(m);
	}
}

/* Output:
{ANGOLA=Luanda, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
Collision occured (Number of probes: 1), new pair: FRANCE=Rome, replaces old one: FRANCE=Tokyo
Collision occured (Number of probes: 1), new pair: FRANCE=France, replaces old one: FRANCE=Rome
Collision occured (Number of probes: 1), new pair: ALGERIA=Algiers, replaces old one: ALGERIA=Algiers
Collision occured (Number of probes: 1), new pair: ANGOLA=Luanda, replaces old one: ANGOLA=Luanda
Collision occured (Number of probes: 1), new pair: BENIN=Porto-Novo, replaces old one: BENIN=Porto-Novo
Collision occured (Number of probes: 1), new pair: BOTSWANA=Gaberone, replaces old one: BOTSWANA=Gaberone
Collision occured (Number of probes: 1), new pair: BURKINA FASO=Ouagadougou, replaces old one: BURKINA FASO=Ouagadougou
{CAPE VERDE=Praia, ANGOLA=Luanda, CENTRAL AFRICAN REPUBLIC=Bangui, FRANCE=France, BURKINA FASO=Ouagadougou, CHAD=N'djamena, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, BOTSWANA=Gaberone}
*/
