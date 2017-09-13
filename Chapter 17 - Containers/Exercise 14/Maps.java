//: containers/Maps.java
// Things you can do with Maps.
import java.util.concurrent.*;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class Maps {
	public static void printKeys(Map<Integer,String> map) {
		printnb("Size = " + map.size() + ", ");
		printnb("Keys: ");
		print(map.keySet()); // Produce a Set of the keys
	}
	public static void printKeysObj(Map<Object,Object> map) {
		printnb("Size = " + map.size() + ", ");
		printnb("Keys: ");
		print(map.keySet()); // Produce a Set of the keys
	}
	public static void test(Map<Integer,String> map) {
		print(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(25));
		// Map has 'Set' behavior for keys:
		map.putAll(new CountingMapData(25));
		printKeys(map);
		// Producing a Collection of the values:
		printnb("Values: ");
		print(map.values());
		print(map);
		print("map.containsKey(11): " + map.containsKey(11));
		print("map.get(11): " + map.get(11));
		print("map.containsValue(\"F0\"): "
				+ map.containsValue("F0"));
		Integer key = map.keySet().iterator().next();
		print("First key in map: " + key);
		map.remove(key);
		printKeys(map);
		map.clear();
		print("map.isEmpty(): " + map.isEmpty());
		map.putAll(new CountingMapData(25));
		// Operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		print("map.isEmpty(): " + map.isEmpty());
	}
	public static void testObj(Map<Object,Object> map) {
		print(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(25));
		// Map has 'Set' behavior for keys:
		map.putAll(new CountingMapData(25));
		printKeysObj(map);
		// Producing a Collection of the values:
		printnb("Values: ");
		print(map.values());
		print(map);
		print("map.containsKey(11): " + map.containsKey(11));
		print("map.get(11): " + map.get(11));
		print("map.containsValue(\"F0\"): "
				+ map.containsValue("F0"));
		Object key = map.keySet().iterator().next();
		print("First key in map: " + key);
		map.remove(key);
		printKeysObj(map);
		map.clear();
		print("map.isEmpty(): " + map.isEmpty());
		map.putAll(new CountingMapData(25));
		// Operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		print("map.isEmpty(): " + map.isEmpty());
	}
	public static void main(String[] args) {
		testObj(System.getProperties());
	}
}

/* Output:
Properties
Size = 79, Keys: [java.vendor, sun.java.launcher, sun.management.compiler, os.name, sun.boot.class.path, sun.desktop, java.vm.specification.vendor, java.runtime.version, user.name, user.language, sun.boot.library.path, java.version, user.timezone, sun.arch.data.model, java.endorsed.dirs, sun.cpu.isalist, sun.jnu.encoding, file.encoding.pkg, file.separator, java.specification.name, java.class.version, user.country, java.home, java.vm.info, os.version, path.separator, java.vm.version, user.variant, java.awt.printerjob, sun.io.unicode.encoding, awt.toolkit, user.script, user.home, java.specification.vendor, java.library.path, java.vendor.url, java.vm.vendor, java.runtime.name, sun.java.command, java.class.path, java.vm.specification.name, java.vm.specification.version, sun.cpu.endian, sun.os.patch.level, java.io.tmpdir, java.vendor.url.bug, os.arch, java.awt.graphicsenv, java.ext.dirs, user.dir, line.separator, java.vm.name, 24, 23, 22, 21, 20, 19, 18, 17, 16, file.encoding, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, java.specification.version, 5, 4, 3, 2, 1, 0]
Values: [Oracle Corporation, SUN_STANDARD, HotSpot 64-Bit Tiered Compilers, Windows 7, C:\Program Files\Java\jre1.8.0_141\lib\resources.jar;C:\Program Files\Java\jre1.8.0_141\lib\rt.jar;C:\Program Files\Java\jre1.8.0_141\lib\sunrsasign.jar;C:\Program Files\Java\jre1.8.0_141\lib\jsse.jar;C:\Program Files\Java\jre1.8.0_141\lib\jce.jar;C:\Program Files\Java\jre1.8.0_141\lib\charsets.jar;C:\Program Files\Java\jre1.8.0_141\lib\jfr.jar;C:\Program Files\Java\jre1.8.0_141\classes, windows, Oracle Corporation, 1.8.0_141-b15, Przemek, pl, C:\Program Files\Java\jre1.8.0_141\bin, 1.8.0_141, , 64, C:\Program Files\Java\jre1.8.0_141\lib\endorsed, amd64, Cp1250, sun.io, \, Java Platform API Specification, 52.0, PL, C:\Program Files\Java\jre1.8.0_141, mixed mode, 6.1, ;, 25.141-b15, , sun.awt.windows.WPrinterJob, UnicodeLittle, sun.awt.windows.WToolkit, , C:\Users\Przemek, Oracle Corporation, C:\Program Files\Java\jre1.8.0_141\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:/Program Files/Java/jre1.8.0_141/bin/server;C:/Program Files/Java/jre1.8.0_141/bin;C:/Program Files/Java/jre1.8.0_141/lib/amd64;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\AMD APP\bin\x86_64;C:\Program Files (x86)\AMD APP\bin\x86;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\ATI Technologies\ATI.ACE\Core-Static;C:\Program Files\Java\jdk1.8.0_121\bin;C:\Program Files\Git\cmd;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\Java\jdk1.8.0_121\bin;C:\Users\Przemek\Downloads\eclipse-java-neon-3-win32-x86_64\eclipse;;., http://java.oracle.com/, Oracle Corporation, Java(TM) SE Runtime Environment, Maps, C:\Users\Przemek\workspace\Ch17Ex14\bin;C:\Users\Przemek\Documents\GitHub\Thinking-in-Java-Solutions\bruceeckel\bin, Java Virtual Machine Specification, 1.8, little, Service Pack 1, C:\Users\Przemek\AppData\Local\Temp\, http://bugreport.sun.com/bugreport/, amd64, sun.awt.Win32GraphicsEnvironment, C:\Program Files\Java\jre1.8.0_141\lib\ext;C:\Windows\Sun\Java\lib\ext, C:\Users\Przemek\workspace\Ch17Ex14, 
, Java HotSpot(TM) 64-Bit Server VM, Y0, X0, W0, V0, U0, T0, S0, R0, Q0, Cp1250, P0, O0, N0, M0, L0, K0, J0, I0, H0, G0, 1.8, F0, E0, D0, C0, B0, A0]
{java.vendor=Oracle Corporation, sun.java.launcher=SUN_STANDARD, sun.management.compiler=HotSpot 64-Bit Tiered Compilers, os.name=Windows 7, sun.boot.class.path=C:\Program Files\Java\jre1.8.0_141\lib\resources.jar;C:\Program Files\Java\jre1.8.0_141\lib\rt.jar;C:\Program Files\Java\jre1.8.0_141\lib\sunrsasign.jar;C:\Program Files\Java\jre1.8.0_141\lib\jsse.jar;C:\Program Files\Java\jre1.8.0_141\lib\jce.jar;C:\Program Files\Java\jre1.8.0_141\lib\charsets.jar;C:\Program Files\Java\jre1.8.0_141\lib\jfr.jar;C:\Program Files\Java\jre1.8.0_141\classes, sun.desktop=windows, java.vm.specification.vendor=Oracle Corporation, java.runtime.version=1.8.0_141-b15, user.name=Przemek, user.language=pl, sun.boot.library.path=C:\Program Files\Java\jre1.8.0_141\bin, java.version=1.8.0_141, user.timezone=, sun.arch.data.model=64, java.endorsed.dirs=C:\Program Files\Java\jre1.8.0_141\lib\endorsed, sun.cpu.isalist=amd64, sun.jnu.encoding=Cp1250, file.encoding.pkg=sun.io, file.separator=\, java.specification.name=Java Platform API Specification, java.class.version=52.0, user.country=PL, java.home=C:\Program Files\Java\jre1.8.0_141, java.vm.info=mixed mode, os.version=6.1, path.separator=;, java.vm.version=25.141-b15, user.variant=, java.awt.printerjob=sun.awt.windows.WPrinterJob, sun.io.unicode.encoding=UnicodeLittle, awt.toolkit=sun.awt.windows.WToolkit, user.script=, user.home=C:\Users\Przemek, java.specification.vendor=Oracle Corporation, java.library.path=C:\Program Files\Java\jre1.8.0_141\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:/Program Files/Java/jre1.8.0_141/bin/server;C:/Program Files/Java/jre1.8.0_141/bin;C:/Program Files/Java/jre1.8.0_141/lib/amd64;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\AMD APP\bin\x86_64;C:\Program Files (x86)\AMD APP\bin\x86;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\ATI Technologies\ATI.ACE\Core-Static;C:\Program Files\Java\jdk1.8.0_121\bin;C:\Program Files\Git\cmd;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\Java\jdk1.8.0_121\bin;C:\Users\Przemek\Downloads\eclipse-java-neon-3-win32-x86_64\eclipse;;., java.vendor.url=http://java.oracle.com/, java.vm.vendor=Oracle Corporation, java.runtime.name=Java(TM) SE Runtime Environment, sun.java.command=Maps, java.class.path=C:\Users\Przemek\workspace\Ch17Ex14\bin;C:\Users\Przemek\Documents\GitHub\Thinking-in-Java-Solutions\bruceeckel\bin, java.vm.specification.name=Java Virtual Machine Specification, java.vm.specification.version=1.8, sun.cpu.endian=little, sun.os.patch.level=Service Pack 1, java.io.tmpdir=C:\Users\Przemek\AppData\Local\Temp\, java.vendor.url.bug=http://bugreport.sun.com/bugreport/, os.arch=amd64, java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment, java.ext.dirs=C:\Program Files\Java\jre1.8.0_141\lib\ext;C:\Windows\Sun\Java\lib\ext, user.dir=C:\Users\Przemek\workspace\Ch17Ex14, line.separator=
, java.vm.name=Java HotSpot(TM) 64-Bit Server VM, 24=Y0, 23=X0, 22=W0, 21=V0, 20=U0, 19=T0, 18=S0, 17=R0, 16=Q0, file.encoding=Cp1250, 15=P0, 14=O0, 13=N0, 12=M0, 11=L0, 10=K0, 9=J0, 8=I0, 7=H0, 6=G0, java.specification.version=1.8, 5=F0, 4=E0, 3=D0, 2=C0, 1=B0, 0=A0}
map.containsKey(11): true
map.get(11): L0
map.containsValue("F0"): true
First key in map: java.vendor
Size = 78, Keys: [sun.java.launcher, sun.management.compiler, os.name, sun.boot.class.path, sun.desktop, java.vm.specification.vendor, java.runtime.version, user.name, user.language, sun.boot.library.path, java.version, user.timezone, sun.arch.data.model, java.endorsed.dirs, sun.cpu.isalist, sun.jnu.encoding, file.encoding.pkg, file.separator, java.specification.name, java.class.version, user.country, java.home, java.vm.info, os.version, path.separator, java.vm.version, user.variant, java.awt.printerjob, sun.io.unicode.encoding, awt.toolkit, user.script, user.home, java.specification.vendor, java.library.path, java.vendor.url, java.vm.vendor, java.runtime.name, sun.java.command, java.class.path, java.vm.specification.name, java.vm.specification.version, sun.cpu.endian, sun.os.patch.level, java.io.tmpdir, java.vendor.url.bug, os.arch, java.awt.graphicsenv, java.ext.dirs, user.dir, line.separator, java.vm.name, 24, 23, 22, 21, 20, 19, 18, 17, 16, file.encoding, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, java.specification.version, 5, 4, 3, 2, 1, 0]
map.isEmpty(): true
map.isEmpty(): true
*/