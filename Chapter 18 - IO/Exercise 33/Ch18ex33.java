import java.util.*;
import java.util.prefs.*;

public class Ch18ex33 {

	public static void main(String[] args) {
		Preferences prefs = Preferences.userNodeForPackage(Ch18ex33.class);
		String directory = prefs.get("base directory", "Not defined");
		System.out.println("Base directory value: " + directory);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a new directory value: ");
		directory = sc.nextLine();
		prefs.put("base directory", directory);
		System.out.println("New directory value: " + directory);
	}

}
