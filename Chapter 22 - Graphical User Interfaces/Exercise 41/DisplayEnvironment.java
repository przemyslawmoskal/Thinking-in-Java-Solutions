import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import java.util.*;

public class DisplayEnvironment {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("DisplayEnvironment");
		shell.setLayout(new FillLayout());
		Text text = new Text(shell, SWT.WRAP | SWT.V_SCROLL);
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			text.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}

/* Execute to see output */