import java.awt.*;
import javax.swing.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex08 extends JFrame {
	JTextField textField = new JTextField(10);
	Cursor myCursor1 = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
	Cursor myCursor2 = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	public Ch22ex08() {
		setLayout(new FlowLayout());
		textField.setCursor(myCursor1);
		add(textField);
		setCursor(myCursor2);
	}
	
	public static void main(String[] args) {
		run(new Ch22ex08(), 200, 100);
	}

}

/* Execute to see output */