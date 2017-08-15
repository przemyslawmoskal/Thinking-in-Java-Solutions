import java.util.*;
import static ptmoskal.Print.*;

public class Ch15ex29 {
	public static void f1(Holder<List<?>> holder) {
		print("f1() - Holder methods:");
		print("**************");
		print("holder: " + holder);
		print("holder.get(): " + holder.get());
		printnb("holder.set(Arrays.asList(2,4,8,16))...");
		holder.set(Arrays.asList(2,4,8,16));
		print("\nholder.get(): " + holder.get());
		print("int[] arr = {2,4,8,16}...");
		int[] arr = {2,4,8,16};
		print("List integerList = Arrays.asList(arr)...");
		List integerList = Arrays.asList(arr);
		printnb("holder.equals(integerList): ");
		print(holder.equals(integerList));
		print("List<Integer> exactIntegerList = new ArrayList<Integer>()");
		print("exactIntegerList.add(2)");
		print("exactIntegerList.add(4)");
		print("exactIntegerList.add(8)");
		print("exactIntegerList.add(16)");
		List<Integer> exactIntegerList = new ArrayList<Integer>();
		exactIntegerList.add(2);
		exactIntegerList.add(4);
		exactIntegerList.add(8);
		exactIntegerList.add(16);
		print("exactIntegerList: " + exactIntegerList);
		print("holder.equals(integerList): " + holder.equals(integerList));
		print();
		print("f1() - List methods:");
		print("*************");
		print("holder.get(): " + holder.get());
		print("holder.get().getClass(): " + holder.get().getClass());
		// Type mismatch:
		// List<? extends Integer> list = holder.get();
		print("List<?> unboundedList = holder.get()");
		List<?> unboundedList = holder.get();
		print("unboundedList: " + unboundedList);
		// unboundedList.add(new Object());
		print("List rawList = holder.get()");
		List rawList = holder.get();
		// Unchecked call to add(E), UnsupportedOperationException
		// rawList.add(new Object());
		print("unboundedList.equals(rawList): " + unboundedList.equals(rawList));
		// UnsupportedOperationException:
		// unboundedList.clear();
		print("unboundedList.contains(16): " + unboundedList.contains(16));
		print("Collection<Integer> coll = new HashSet<Integer>();");
		print("Add 2, 4, 8, 16 to coll...");
		Collection<Integer> coll = new HashSet<Integer>();
		coll.add(2);
		coll.add(4);
		coll.add(8);
		coll.add(16);
		print("unboundedList.containsAll(coll): " + unboundedList.containsAll(coll));
		print("unboundedList.equals(coll): " + unboundedList.equals(coll));
		print("unboundedList: " + unboundedList);
		print("coll: " + coll);
		print("coll.getClass(): " + coll.getClass());
		print("unboundedList.get(0): " + unboundedList.get(0));
		print("unboundedList.hashCode(): " + unboundedList.hashCode());
		print("unboundedList.indexOf(8): " + unboundedList.indexOf(8));
		print("ListIterator listIterator = unboundedList.listIterator()");
		ListIterator listIterator = unboundedList.listIterator();
		print("listIterator.next(): " + listIterator.next());
		// UnsupportedOperationException:
		// print("unboundedList.remove(0)" + unboundedList.remove(0));
		// print("unboundedList.removeAll(coll)" + unboundedList.removeAll(coll));
		// print("unboundedList.retainAll(coll)" + unboundedList.retainAll(coll));
		// The method set(int, capture#19-of ?) in the type List<capture#19-of ?> is not applicable
		// for the arguments (int, int)
		// unboundedList.set(1,64);
		print("unboundedList.size(): " + unboundedList.size());
		print("unboundedList.subList(1,2): " + unboundedList.subList(1,2));
		print("Object[] objectArray = unboundedList.toArray()");
		Object[] objectArray = unboundedList.toArray();
		print("objectArray: " + objectArray);
		printnb("objectArray includes: ");
		for(Object o : objectArray)
			printnb(o + " ");
		// ArrayStoreException:
		// Double[] doubleArray = unboundedList.toArray(new Double[4]);
		print("Number[] numberArray = unboundedList.toArray(new Number[4])");
		Number[] numberArray = unboundedList.toArray(new Number[4]);
		print("numberArray: " + numberArray);
		printnb("numberArray includes: ");
		for(Number n : numberArray)
			printnb(n + " ");
		print();
	}
	public static void f2(List<Holder<?>> list) {
		print("f2() - List methods:");
		print("*************");
		print("Add Holder<Integer>, Holder<String> and Holder<Double> to list...");
		list.add(new Holder<Integer>(128));
		list.add(new Holder<String>("Hello"));
		list.add(new Holder<Double>(2.0));
		print("list: " + list);
		print("What holders contain: ");
		for(Holder h : list)
			printnb(h.get() + ", ");
		print("\nlist.add(3, new Holder<Float>(16.0F))...");
		print("list(size): " + list.size());
		list.add(3, new Holder<Float>(16.0F));
		print("list: " + list);
		print("What holders contain: ");
		for(Holder h : list)
			printnb(h.get() + ", ");
		print("\nlist.clear()");
		list.clear();
		print("list: " + list);
		print("Collection<Holder<?>> coll = new ArrayList<Holder<?>>()");
		Collection<Holder<?>> coll = new ArrayList<Holder<?>>();
		print("Adding Holder<String>, Holder<Float>, Holder<Double> to coll");
		coll.add(new Holder<String>("Hi"));
		coll.add(new Holder<Integer>(512));
		coll.add(new Holder<Double>(4.0));
		print("list.addAll(coll)...");
		list.addAll(coll);
		print("list: " + list);
		print("What holders contain: ");
		for(Holder h : list)
			printnb(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
		print("\nObject clonedList = ((ArrayList)list).clone()");
		Object clonedList = ((ArrayList)list).clone();
		print("clonedList: " + clonedList);
		print("((ArrayList)list).clone().getClass(): " + ((ArrayList)list).clone().getClass());
		// Type mismatch: cannot convert from Object to ArrayList
		// ArrayList arrList = ((ArrayList)list).clone();
		print("Holder<Float> floatHolder = new Holder<Float>(8.0F);");
		Holder<Float> floatHolder = new Holder<Float>(8.0F);
		print("list.set(0, floatHolder)...");
		list.set(0, floatHolder);
		print("list: " + list);
		print("What holders contain: ");
		for(Holder h : list)
			printnb(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
		print("\nlist.contains(list.set(0, floatHolder): " + list.contains(list.set(0, floatHolder)));
		print("list.contains(8.0F): " + list.contains(8.0F));
		print("list.contains(floatHolder): " + list.contains(floatHolder));
		print("list.add(null)...");
		list.add(null);
		print("list.isEmpty(): " + list.isEmpty());
		print("list.contains(null): " + list.contains(null));
		print("list.indexOf(floatHolder): " + list.indexOf(floatHolder));
		print("list.get(0).get(): " + list.get(0).get());
		print("list.indexOf(null): " + list.indexOf(null));
		print("list.lastIndexOf(null): " + list.lastIndexOf(null));
		print("list.remove(0)...");
		list.remove(0);
		print("list: " + list);
		print("What holders contain: ");
		for(Holder h : list)
			if(h == null)
				print("Null, ");
			else
			printnb(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
		list.remove(2);
		print("list: " + list);
		print("What holders contain: ");
		for(Holder h : list)
			if(h == null)
				print("Null, ");
			else
			printnb(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
		// The method removeRange(int, int) from the type ArrayList is not visible
		// ((ArrayList)list).removeRange(0,2);
		print("list.add(null)...");
		list.add(null);
		print("\nObject[] objectArray = list.toArray()");
		Object[] objectArray = list.toArray();
		print("What objectArray contains: ");
		for(int i = 0; i < objectArray.length; i++) {
			printnb(objectArray[i] + ", ");
		}
		print("\nHolder[] holderArray = ((ArrayList<Holder<?>>)list).toArray(new Holder[4])");
		Holder[] holderArray = ((ArrayList<Holder<?>>)list).toArray(new Holder[3]);
		print("What holderArray contains: ");
		for(int i = 0; i < holderArray.length; i++)
			printnb(holderArray[i] + ", ");
		print();
		print();
		print("f2() - Holder methods:");
		print("***************");
		print("list: " + list);
		print("What's in list: ");
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == null)
				print("null");
			else
				printnb(list.get(i).getClass().getSimpleName() + ", ");
		}
		print("list.remove(2)...");
		list.remove(2);
		print("What holders contain: ");
		for(Holder h : list)
			printnb(h.get() + ", ");
		print("\nHolder<?> holder1 = list.get(0)...");
		print("Holder<?> holder2 = list.get(1)...");
		Holder<?> holder1 = list.get(0);
		Holder<?> holder2 = list.get(1);
		print(list.get(0).getClass() + " - " + list.get(0).get().getClass().getSimpleName() + ";\n"
				+ list.get(1).getClass() + " - " + list.get(1).get().getClass().getSimpleName() + ";");
		// The methods are not applicable for the arguments:
		// holder1.set(1024);
		// holder2.set(4.0);
		// holder1.set(new Object());
		// holder2.set(new Object());
	}
	public static void main(String[] args) {
		f1(new Holder<List<?>>());
		print();
		List<Holder<?>> list = new ArrayList<Holder<?>>();
		f2(list);
	}

}

/* Output:
f1() - Holder methods:
**************
holder: Holder@106d69c
holder.get(): null
holder.set(Arrays.asList(2,4,8,16))...
holder.get(): [2, 4, 8, 16]
int[] arr = {2,4,8,16}...
List integerList = Arrays.asList(arr)...
holder.equals(integerList): false
List<Integer> exactIntegerList = new ArrayList<Integer>()
exactIntegerList.add(2)
exactIntegerList.add(4)
exactIntegerList.add(8)
exactIntegerList.add(16)
exactIntegerList: [2, 4, 8, 16]
holder.equals(integerList): false

f1() - List methods:
*************
holder.get(): [2, 4, 8, 16]
holder.get().getClass(): class java.util.Arrays$ArrayList
List<?> unboundedList = holder.get()
unboundedList: [2, 4, 8, 16]
List rawList = holder.get()
unboundedList.equals(rawList): true
unboundedList.contains(16): true
Collection<Integer> coll = new HashSet<Integer>();
Add 2, 4, 8, 16 to coll...
unboundedList.containsAll(coll): true
unboundedList.equals(coll): false
unboundedList: [2, 4, 8, 16]
coll: [16, 2, 4, 8]
coll.getClass(): class java.util.HashSet
unboundedList.get(0): 2
unboundedList.hashCode(): 987211
unboundedList.indexOf(8): 2
ListIterator listIterator = unboundedList.listIterator()
listIterator.next(): 2
unboundedList.size(): 4
unboundedList.subList(1,2): [4]
Object[] objectArray = unboundedList.toArray()
objectArray: [Ljava.lang.Integer;@52e922
objectArray includes: 2 4 8 16 Number[] numberArray = unboundedList.toArray(new Number[4])
numberArray: [Ljava.lang.Number;@25154f
numberArray includes: 2 4 8 16 

f2() - List methods:
*************
Add Holder<Integer>, Holder<String> and Holder<Double> to list...
list: [Holder@10dea4e, Holder@647e05, Holder@1909752]
What holders contain: 
128, Hello, 2.0, 
list.add(3, new Holder<Float>(16.0F))...
list(size): 3
list: [Holder@10dea4e, Holder@647e05, Holder@1909752, Holder@1f96302]
What holders contain: 
128, Hello, 2.0, 16.0, 
list.clear()
list: []
Collection<Holder<?>> coll = new ArrayList<Holder<?>>()
Adding Holder<String>, Holder<Float>, Holder<Double> to coll
list.addAll(coll)...
list: [Holder@14eac69, Holder@a57993, Holder@1b84c92]
What holders contain: 
String: Hi, Integer: 512, Double: 4.0, 
Object clonedList = ((ArrayList)list).clone()
clonedList: [Holder@14eac69, Holder@a57993, Holder@1b84c92]
((ArrayList)list).clone().getClass(): class java.util.ArrayList
Holder<Float> floatHolder = new Holder<Float>(8.0F);
list.set(0, floatHolder)...
list: [Holder@1c7c054, Holder@a57993, Holder@1b84c92]
What holders contain: 
Float: 8.0, Integer: 512, Double: 4.0, 
list.contains(list.set(0, floatHolder): false
list.contains(8.0F): false
list.contains(floatHolder): false
list.add(null)...
list.isEmpty(): false
list.contains(null): true
list.indexOf(floatHolder): -1
list.get(0).get(): 8.0
list.indexOf(null): 3
list.lastIndexOf(null): 3
list.remove(0)...
list: [Holder@a57993, Holder@1b84c92, null]
What holders contain: 
Integer: 512, Double: 4.0, Null, 
list: [Holder@a57993, Holder@1b84c92]
What holders contain: 
Integer: 512, Double: 4.0, list.add(null)...

Object[] objectArray = list.toArray()
What objectArray contains: 
Holder@a57993, Holder@1b84c92, null, 
Holder[] holderArray = ((ArrayList<Holder<?>>)list).toArray(new Holder[4])
What holderArray contains: 
Holder@a57993, Holder@1b84c92, null, 

f2() - Holder methods:
***************
list: [Holder@a57993, Holder@1b84c92, null]
What's in list: 
Holder, Holder, null
list.remove(2)...
What holders contain: 
512, 4.0, 
Holder<?> holder1 = list.get(0)...
Holder<?> holder2 = list.get(1)...
class Holder - Integer;
class Holder - Double;
*/
