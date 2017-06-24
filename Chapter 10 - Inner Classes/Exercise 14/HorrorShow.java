import static ptmoskal.Print.*;

interface Monster {
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace() {}
	public void destroy() {}
}	

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {
	public void menace() {}
	public void destroy() {}
	public void kill() {}
	public void drinkBlood() {}
}	

public class HorrorShow {
	static void u(Monster b) { b.menace(); }
	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}
	static void w(Lethal l) { l.kill(); }
	public DangerousMonster createDangerousMonster() {
		return new DangerousMonster() {
			public void menace() { print("DangerousMonster menace()"); }
			public void destroy() { print("DangerousMonster destroy()"); }
		};
	}
	public Vampire createVampire() {
		return new Vampire() {
			public void menace() { print("Vampire menace()"); }
			public void destroy() { print("Vampire destroy()"); }
			public void kill() { print("Vampire kill()"); }
			public void drinkBlood() { print("Vampire drinkBlood()"); }
		};
	}
	public static void main(String[] args) {
		HorrorShow horrorShow = new HorrorShow();
		horrorShow.u(horrorShow.createDangerousMonster());
		horrorShow.u(horrorShow.createVampire());
		print();
		horrorShow.v(horrorShow.createDangerousMonster());
		horrorShow.v(horrorShow.createVampire());
		print();
		horrorShow.w(horrorShow.createVampire());  
	}
}

/* Output:
 * DangerousMonster menace()
Vampire menace()

DangerousMonster menace()
DangerousMonster destroy()
Vampire menace()
Vampire destroy()

Vampire kill()
*/
