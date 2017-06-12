import net.mindview.simple.*;
import java.util.*;

public class Ch06ex02 {

	public static void main(String[] args) {
		/*Multiple markers at this line
		- The type Vector is ambiguous
		- The type Vector is ambiguous
		Vector v = new Vector();
		*/
		net.mindview.simple.Vector vector1 = new net.mindview.simple.Vector();
		java.util.Vector vector2 = new java.util.Vector();
	}

}

/* Output:
net.mindview.simple.Vector
*/