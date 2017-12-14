import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex07 extends JFrame {
	// Array of Strings to use in JComboBox:
	String[] strings = "A B C D E F G".split(" ");
	private JButton button = new JButton("Button");
	private JTextArea textArea = new JTextArea(20,15);
	private JTextField textField = new JTextField(15);
	private JComboBox<String> comboBox = new JComboBox<String>(strings);
	private JMenuItem menuItem = new JMenuItem("MenuItem");
	private JFileChooser fileChooser = new JFileChooser(".");
	public Ch22ex07() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Button" + '\n');
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("ComboBox" + '\n');
			}
		});
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("MenuItem" + '\n');
			}
		});
		// Action performed when pressed "Enter" button:
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("TextField" + '\n');
			}
		});
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("FileChooser" + '\n');
			}
		});
		new Timer(3000, new ActionListener() {
			int i = 0;
			public void actionPerformed(ActionEvent e) {
				textArea.append("Timer " + i++ + '\n');
			}
		}).start();
		setLayout(new FlowLayout());
		add(button);
		add(comboBox);
		add(menuItem);
		add(textField);
		add(fileChooser);
		add(new JScrollPane(textArea));
		
	}

	public static void main(String[] args) {
		run(new Ch22ex07(), 500, 800);
	}

}

/* Execute to see output */