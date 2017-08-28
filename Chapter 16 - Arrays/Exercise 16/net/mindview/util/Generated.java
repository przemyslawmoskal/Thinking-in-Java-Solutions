package net.mindview.util;
import java.util.*;
import ch16ex16.*;

class CollectionData<T> extends ArrayList<T> {
	public CollectionData(SkipGenerator<T> gen, int skip, int quantity) {
		for(int i = 0; i < quantity; i++)
			add(gen.next(skip));
	}
}

public class Generated {
	public static <T> T[] array(T[] a, SkipGenerator<T> gen, int skip) {
		return new CollectionData<T>(gen, skip, a.length).toArray(a);
	}
}
