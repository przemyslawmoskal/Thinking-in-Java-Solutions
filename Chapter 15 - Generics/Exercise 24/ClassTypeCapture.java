import java.util.*;

interface Factory<T> { T create(); }

class BuildingFactory implements Factory<Building> {
	public Building create() {
		return new Building();
	}
}

class HouseFactory implements Factory<House> {
	public House create() {
		return new House();
	}
}


class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
	Class<T> kind;
	Map<String, Factory> map;
	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}
	public ClassTypeCapture(Class<T> kind, Map<String,Factory> map) {
		this.kind = kind;
		this.map = map;
	}
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	public void addType(String typename, Factory factory) {
		map.put(typename, factory);
	}
	public Object createNew(String typename) throws InstantiationException, IllegalAccessException {
		if(map.containsKey(typename)) 
			return map.get(typename).create();
		System.out.println("Error: Cannot create new instance of type " + typename + "!");
		return null;
	}
	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt3 =
				new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctt3.f(new Building()));
		System.out.println(ctt3.f(new House()));
		ClassTypeCapture<House> ctt4 =
				new ClassTypeCapture<House>(House.class);
		System.out.println(ctt4.f(new Building()));
		System.out.println(ctt4.f(new House()));
		ClassTypeCapture<Building> ctcb = new ClassTypeCapture<Building>(Building.class
				, new HashMap<String,Factory>());
		ctcb.addType("House", new HouseFactory());
		ctcb.addType("Building", new BuildingFactory());
		System.out.println("ctcb.map: " + ctcb.map);
		try {
			House h = (House)ctcb.createNew("House");
			Building b = (Building)ctcb.createNew("Building");
			System.out.println("h.getClass().getName(): " + h.getClass().getName());
			System.out.println("b.getClass().getName(): " + b.getClass().getName());
			System.out.println("h instanceof House: " + (h instanceof House));
			System.out.println("b instanceof House: " + (b instanceof House));
			System.out.println("h instanceof Building: " + (h instanceof Building));
			System.out.println("b instanceof Building: " + (b instanceof Building));
			ctcb.createNew("Integer");
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}


/* Output:
true
true
false
true
ctcb.map: {Building=BuildingFactory@15db9742, House=HouseFactory@6d06d69c}
h.getClass().getName(): House
b.getClass().getName(): Building
h instanceof House: true
b instanceof House: false
h instanceof Building: true
b instanceof Building: true
Error: Cannot create new instance of type Integer!
*/
