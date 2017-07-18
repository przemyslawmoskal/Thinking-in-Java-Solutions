package net.mindview.util;
import java.util.*;
import generics.watercolors.*;
import static generics.watercolors.Watercolors.*;

public class Sets {
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		try {
			if(a instanceof EnumSet) {
				Set<T> result = ((EnumSet)a).clone();
				result.addAll(b);
				return result;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	public static <T>
	Set<T> intersection(Set<T> a, Set<T> b) {
		try {
			if(a instanceof EnumSet) {
				Set<T> result = ((EnumSet)a).clone();
				result.retainAll(b);
				return result;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}	
	// Subtract subset from superset:
	public static <T> Set<T>
	difference(Set<T> superset, Set<T> subset) {
		try {
			if(superset instanceof EnumSet) {
				Set<T> result = ((EnumSet)superset).clone();
				result.removeAll(subset);
				return result;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}
	// Reflexive--everything not in the intersection:
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
	public static void main(String[] args) {
		 Set<Watercolors> w1 = EnumSet.range(CRIMSON, SAP_GREEN);
		 Set<Watercolors> w2 = EnumSet.range(ULTRAMARINE, YELLOW_OCHRE);
		 System.out.println("w1: " + w1);
		 System.out.println("w2: " + w2);
		 System.out.println("union(w1,w2): " + union(w1,w2));
		 System.out.println("intersection(w1,w2): " + intersection(w1,w2));
		 System.out.println("difference(w1,w2): " + difference(w1,w2));
		 System.out.println("complement(w1,w2): " + complement(w1,w2));
	}
}

/* Output:
w1: [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN]
w2: [ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE]
union(w1,w2): [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE]
intersection(w1,w2): [ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN]
difference(w1,w2): [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE]
complement(w1,w2): [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, YELLOW_OCHRE]
*/