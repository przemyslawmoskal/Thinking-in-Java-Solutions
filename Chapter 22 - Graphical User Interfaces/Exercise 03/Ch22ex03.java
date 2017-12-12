import javax.swing.*;
import java.util.concurrent.*;
import static net.mindview.util.SwingConsole.*;

class SubmitSwingProgram extends JFrame {
	JLabel label;
	public SubmitSwingProgram() {
		label = new JLabel("A Label");
		add(label);
	}
}

public class Ch22ex03 {
	static SubmitSwingProgram ssp;
	public static void main(String[] args) throws Exception {
		run(ssp = new SubmitSwingProgram(), 300, 100);
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ssp.label.setText("Hey! This is Different!");
			}
		});
	}
}

/* Execute to see output */