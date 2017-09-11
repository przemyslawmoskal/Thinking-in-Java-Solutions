package ch17ex07;

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class Ch17ex07 {

	public static void main(String[] args) {
		List<String> al = new ArrayList<String>(Countries.names(10));
		List<String> ll = new LinkedList<String>(Countries.names(10));
		Iterator<String> alit = al.iterator();
		printnb("al: ");
		while(alit.hasNext())
			printnb(alit.next() + ", ");
		printnb("\nll: ");
		Iterator<String> llit = ll.iterator();
		while(llit.hasNext())
			printnb(llit.next() + ", ");
		ListIterator<String> allit = al.listIterator();
		ListIterator<String> lllit = ll.listIterator();
		while(allit.hasNext()) {
			lllit.add(allit.next());
			lllit.next();
		}
		print("\nal: " + al);
		print("ll: " + ll);
		print("--------------");
		List<String> ll2 = new LinkedList<String>(Countries.names(10));
		ListIterator<String> ll2lit = ll2.listIterator();
		print("al: " + al);
		print("ll2: " + ll2);
		while(allit.hasPrevious())
			allit.previous();
		while(ll2lit.hasNext())
			ll2lit.next();
		while(ll2lit.hasPrevious()) {
			ll2lit.add(allit.next());
			ll2lit.previous();
			ll2lit.previous();
		}
		print("al: " + al);
		print("ll2: " + ll2);
	}

}

/* Output:
al: ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, 
ll: ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, 
al: [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
ll: [ALGERIA, ALGERIA, ANGOLA, ANGOLA, BENIN, BENIN, BOTSWANA, BOTSWANA, BURKINA FASO, BURKINA FASO, BURUNDI, BURUNDI, CAMEROON, CAMEROON, CAPE VERDE, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CENTRAL AFRICAN REPUBLIC, CHAD, CHAD]
--------------
al: [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
ll2: [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
al: [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
ll2: [ALGERIA, CHAD, ANGOLA, CENTRAL AFRICAN REPUBLIC, BENIN, CAPE VERDE, BOTSWANA, CAMEROON, BURKINA FASO, BURUNDI, BURUNDI, BURKINA FASO, CAMEROON, BOTSWANA, CAPE VERDE, BENIN, CENTRAL AFRICAN REPUBLIC, ANGOLA, CHAD, ALGERIA]
*/