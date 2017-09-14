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
		SlowMap<String,String> m= new SlowMap<String,String>();
		m.putAll(Countries.capitals(15));
		System.out.println(m);
		System.out.println(m.get("BULGARIA"));
		System.out.println(m.entrySet());
	}
}