// Demonstrates JOptionPane.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

public class MessageBoxes extends JFrame {
	private JButton b1 = new JButton("Alert");
	private JButton b2 = new JButton("Yes/No");
	private JButton b3 = new JButton("Color");
	private JButton b4 = new JButton("Input");
	private JButton b5 = new JButton("3 Vals");
	private JTextField txt = new JTextField(15);
	public MessageBoxes() {
		setLayout(new FlowLayout());
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "There's a bug on you!", "Hey!", JOptionPane.ERROR_MESSAGE);
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "or no", "choose yes", JOptionPane.YES_NO_OPTION);
			}
		});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Red", "Green" };
				int sel = JOptionPane.showOptionDialog(null, "Choose a Color!", "Warning", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (sel != JOptionPane.CLOSED_OPTION)
					txt.setText("Color Selected: " + options[sel]);
			}
		});
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String val = JOptionPane.showInputDialog("How many fingers do you see?");
				txt.setText(val);
			}
		});
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] selections = { "First", "Second", "Third" };
				Object val = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
						null, selections, selections[0]);
				if (val != null)
					txt.setText(val.toString());
			}
		});
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(txt);
	}
	public static void main(String[] args) {
		run(new MessageBoxes(), 200, 200);
	}
}

/* Execute to see output */
