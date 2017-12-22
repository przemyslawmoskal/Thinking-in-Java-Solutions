import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import static net.mindview.util.SwingConsole.*;

public class List extends JFrame {
	private String[] flavors = { "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge",
			"Rum Raisin", "Praline Cream", "Mud Pie" };
	private JList<String> lst = new JList<>(flavors);
	private JTextArea t = new JTextArea(flavors.length, 20);
	private ListSelectionListener ll = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting())
				return;
			t.setText("");
			for (Object item : lst.getSelectedValuesList())
				t.append(item + "\n");
		}
	};
	public List() {
		t.setEditable(false);
		setLayout(new FlowLayout());
		// Create Borders for components:
		Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
		lst.setBorder(brd);
		t.setBorder(brd);
		add(t);
		add(lst);
		// Register event listeners
		lst.addListSelectionListener(ll);
	}

	public static void main(String[] args) {
		run(new List(), 250, 375);
	}
}

/* Execute to see output */