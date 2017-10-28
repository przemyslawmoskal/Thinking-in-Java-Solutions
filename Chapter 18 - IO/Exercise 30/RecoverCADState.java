// {RunFirst: StoreCADState}
import java.io.*;
import java.util.*;

public class RecoverCADState {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
		// Read in the same order they were written:
		Line.deserializeStaticState(in);
		Circle.deserializeStaticState(in);
		Square.deserializeStaticState(in);
		List<Shape> shapes = (List<Shape>) in.readObject();
		System.out.println(shapes);
	}
}

/* Output:
[class Circlecolor[3] xPos[58] yPos[55] dim[93]
, class Squarecolor[3] xPos[61] yPos[61] dim[29]
, class Linecolor[3] xPos[68] yPos[0] dim[22]
, class Circlecolor[3] xPos[7] yPos[88] dim[28]
, class Squarecolor[3] xPos[51] yPos[89] dim[9]
, class Linecolor[3] xPos[78] yPos[98] dim[61]
, class Circlecolor[3] xPos[20] yPos[58] dim[16]
, class Squarecolor[3] xPos[40] yPos[11] dim[22]
, class Linecolor[3] xPos[4] yPos[83] dim[6]
, class Circlecolor[3] xPos[75] yPos[10] dim[42]
]
*/
