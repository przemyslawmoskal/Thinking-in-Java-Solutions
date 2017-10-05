import java.util.*;
import net.mindview.util.*;

class PrimeNumberFinder {
	public static int findNextPrime(int doubledCapacity) {
		for (int i = doubledCapacity + 1; i > doubledCapacity; i++) {
			int counter = 0;
			for (int j = 1; j < ((i + 2) / 2); j++) {
				if ((i % j) == 0)
					counter++;
			}
			if (counter < 2)
				return i;
		}
		return 0;
	}
}

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
	// Choose a prime number for the hash table
	// size, to achieve a uniform distribution:
	static final int SIZE = 997;
	// You can't have a physical array of generics,
	// but you can upcast to one:
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
	private int capacity = SIZE;

	public int capacity() {
		return capacity;
	}

	public void rehash() {
		capacity = PrimeNumberFinder.findNextPrime(capacity * 2);
		LinkedList<MapEntry<K, V>>[] oldBuckets = buckets;
		for (LinkedList<MapEntry<K, V>> bucket : oldBuckets) {
			if (bucket == null)
				continue;
			for (MapEntry<K, V> mPair : bucket)
				this.put(mPair.getKey(), mPair.getValue());
		}
	}

	public V put(K key, V value) {
		if (this.size() > (capacity * 0.75))
			rehash();
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K, V>>();
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		boolean found = false;
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		while (it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair); // Replace old with new
				found = true;
				break;
			}
		}
		if (!found)
			buckets[index].add(pair);
		return oldValue;
	}

	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			return null;
		for (MapEntry<K, V> iPair : buckets[index])
			if (iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null)
				continue;
			for (MapEntry<K, V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}

	public static void main(String[] args) {
		RandomGenerator.String gen = new RandomGenerator.String(3);
		SimpleHashMap<String, String> shm1 = new SimpleHashMap<String, String>();
		System.out.println("size:     " + shm1.size());
		System.out.println("capacity: " + shm1.capacity());
		shm1.putAll(MapData.map(gen, gen, 996));
		System.out.println("\nsize:     " + shm1.size());
		System.out.println("capacity: " + shm1.capacity());
		shm1.putAll(MapData.map(gen, gen, 2034));
		System.out.println("\nsize:     " + shm1.size());
		System.out.println("capacity: " + shm1.capacity());
		System.out.print("\nExact moment when rehash() is needed (+1 pair, over 75% load): ");
		shm1.putAll(MapData.map(gen, gen, 1));
		System.out.println("\nsize:     " + shm1.size());
		System.out.println("capacity: " + shm1.capacity());

	}
}

/* Output:
size:     0
capacity: 997

size:     992
capacity: 1997

size:     3001
capacity: 4001

Exact moment when rehash() is needed (+1 pair, over 75% load): 
size:     3002
capacity: 8009
*/