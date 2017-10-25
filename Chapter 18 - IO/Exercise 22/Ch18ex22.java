import net.mindview.util.*;
public class Ch18ex22 {

	public static void main(String[] args) {
		for(String s : OSExecute.command("javap Ch18ex22"))
			System.out.println(s);
	}

}

/* Output:
Compiled from "Ch18ex22.java"
public class Ch18ex22 {
	public Ch18ex22();
	public static void main(java.lang.String[]);
}
*/