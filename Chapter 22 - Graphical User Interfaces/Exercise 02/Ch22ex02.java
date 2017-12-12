import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;
import java.util.concurrent.TimeUnit;

class HelloLabel extends JFrame {
	private static Random rand = new Random();
	JLabel[] labels;
	HelloLabel() {
		super("Hello Swing");
		setLayout(new FlowLayout());
		int size = rand.nextInt(5) + 1;
		labels = new JLabel[size];
		for(int i = 0; i < size; i++) {
			labels[i] = new JLabel("Label#" + i);
			add(labels[i]);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}
}

public class Ch22ex02 {
	public static HelloLabel hl;
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				hl = new HelloLabel();
			}
		});
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for(int i = 0; i < hl.labels.length; i++) {
					hl.labels[i].setText("Changed#" + i);
				}
			}
		});
	}
}

/* Execute to see output */
