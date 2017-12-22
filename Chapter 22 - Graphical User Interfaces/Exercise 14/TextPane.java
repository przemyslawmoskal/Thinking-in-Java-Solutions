import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.mindview.util.*;
import static net.mindview.util.SwingConsole.*;

public class TextPane extends JFrame {
	private JButton b = new JButton("Add Text");
	private JTextArea tp = new JTextArea();
	private static Generator sg = new RandomGenerator.String(7);

	public TextPane() {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 10; i++)
					tp.setText(tp.getText() + sg.next() + "\n");
			}
		});
		add(new JScrollPane(tp));
		add(BorderLayout.SOUTH, b);
	}

	public static void main(String[] args) {
		run(new TextPane(), 475, 425);
	}
}

/* Execute to see output */