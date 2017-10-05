import java.util.*;
import net.mindview.util.*;

public class Ch17ex38 {
	static CountingGenerator.String gen = new CountingGenerator.String(3);
	static String s = gen.next();
	static List<Test<Map<Integer, String>>> tests = new ArrayList<Test<Map<Integer, String>>>();
	static {
		tests.add(new Test<Map<Integer, String>>("put") {
			int test(Map<Integer, String> map, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					map.clear();
					for (int j = 0; j < size; j++)
						map.put(j, s);
				}
				return loops * size;
			}
		});
		tests.add(new Test<Map<Integer, String>>("get") {
			int test(Map<Integer, String> map, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for (int i = 0; i < loops; i++)
					for (int j = 0; j < span; j++)
						map.get(j);
				return loops * span;
			}
		});
		tests.add(new Test<Map<Integer, String>>("iterate") {
			int test(Map<Integer, String> map, TestParam tp) {
				int loops = tp.loops * 10;
				for (int i = 0; i < loops; i++) {
					Iterator it = map.entrySet().iterator();
					while (it.hasNext())
						it.next();
				}
				return loops * map.size();
			}
		});
	}

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.putAll(new CountingMapData(32));
		System.out.println("hm: " + hm);
		HashMap<Integer, String> hm2 = new HashMap<Integer, String>(64);
		hm2.putAll(hm);
		System.out.println("hm2: " + hm2);
		HashMap<Integer, String> hm3 = new HashMap<Integer, String>(128);
		hm3.putAll(hm);
		System.out.println("hm3: " + hm2);
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		else
			Tester.defaultParams = TestParam.array(10, 1000, 100, 1000, 1000, 1000);
		System.out.println("\nhm test:");
		Tester.run(hm, tests);
		System.out.println("\nhm2 test:");
		Tester.run(hm2, tests);
		System.out.println("\nhm3 test:");
		Tester.run(hm2, tests);
	}

}

/* Output (Sample):
 * hm: {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0, 25=Z0, 26=A1, 27=B1, 28=C1, 29=D1, 30=E1, 31=F1}
hm2: {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0, 25=Z0, 26=A1, 27=B1, 28=C1, 29=D1, 30=E1, 31=F1}
hm3: {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0, 25=Z0, 26=A1, 27=B1, 28=C1, 29=D1, 30=E1, 31=F1}

hm test:
---------- HashMap ----------
 size     put     get iterate
   10     287      98      59
  100      75      33      22
 1000      56      26      18

hm2 test:
---------- HashMap ----------
 size     put     get iterate
   10      45      19      34
  100      41      78      20
 1000      60      49      18

hm3 test:
---------- HashMap ----------
 size     put     get iterate
   10     238      19     556
  100      64      19      67
 1000      51      26      18
*/
