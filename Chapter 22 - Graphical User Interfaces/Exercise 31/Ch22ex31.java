import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex31 extends JFrame {
	private static Random rand = new Random();
	private JProgressBar pb = new JProgressBar();
	int delay = 100;
	javax.swing.Timer timer = new Timer(500, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int r = rand.nextInt(6);
			if (r == 0) {
				pb.setValue(pb.getValue() + rand.nextInt(10));
			} else {
				delay *= 1.2;
			}
			timer.setDelay(delay);
			pb.setValue(pb.getValue() + 3);
		}
	});
	Ch22ex31() {
		pb.setValue((int)(pb.getMaximum() * 0.05));
		timer.start();
		add(pb);
	}
	public static void main(String[] args) {
		run(new Ch22ex31(), 300, 100);
	}
}

/* Execute to see output */