import java.util.*;

class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
	Class<T> kind;
	Map<String, Class<?>> map;
	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}
	public ClassTypeCapture(Class<T> kind, Map<String,Class<?>> map) {
		this.kind = kind;
		this.map = map;
	}
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	public void addType(String typename, Class<?> kind) {
		map.put(typename, kind);
	}
	public Object createNew(String typename) throws InstantiationException, IllegalAccessException {
		if(map.containsKey(typename)) 
			return map.get(typename).newInstance();
		System.out.println("Error: Cannot create new instance of type " + typename + "!");
		return null;
	}
	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt3 =
				new ClassTypeCapture<Building>(Building.class, new HashMap<String, Class<?>>());
		ctt3.addType("House", House.class);
		ctt3.addType("Building", Building.class);
		System.out.println("ctt3.map: " + ctt3.map);
		try {
			House h = (House)ctt3.createNew("House");
			Building b = (Building)ctt3.createNew("Building");
			System.out.println("h.getClass().getName(): " + h.getClass().getName());
			System.out.println("b.getClass().getName(): " + b.getClass().getName());
			System.out.println("h instanceof House: " + (h instanceof House));
			System.out.println("b instanceof House: " + (b instanceof House));
			System.out.println("h instanceof Building: " + (h instanceof Building));
			System.out.println("b instanceof Building: " + (b instanceof Building));
			ctt3.createNew("Integer");
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}


/* Output:
ctt3.map: {Building=class Building, House=class House}
h.getClass().getName(): House
b.getClass().getName(): Building
h instanceof House: true
b instanceof House: false
h instanceof Building: true
b instanceof Building: true
Error: Cannot create new instance of type Integer!
*/
