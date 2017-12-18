import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.regex.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex09 extends JFrame {
	private JTextField inputText = new JTextField(25);
	private JTextArea results = new JTextArea(40, 65);
	private static Pattern p = Pattern.compile("\\w+\\.");

	class NameL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			results.setText("");
			String[] inputs = (inputText.getText().trim()).split(" ");
			if (inputs.length == 0) {
				results.setText("No match");
				return;
			}
			Class<?> kind;
			try {
				kind = Class.forName(inputs[0]);
				Method[] methods = kind.getMethods();
				Constructor[] ctors = kind.getConstructors();
				if (inputs.length == 1) {
					for (Method method : methods)
						results.append(p.matcher(method.toString()).replaceAll("") + "\n");
					for (Constructor ctor : ctors)
						results.append(p.matcher(ctor.toString()).replaceAll("") + "\n");
				} else {
					for (Method method : methods)
						if (method.toString().indexOf(inputs[1]) != -1) {
							results.append(p.matcher(method.toString()).replaceAll("") + "\n");
						}
					for (Constructor ctor : ctors)
						if (ctor.toString().indexOf(inputs[1]) != -1) {
							results.append(p.matcher(ctor.toString()).replaceAll("") + "\n");
						}
				}
			} catch (ClassNotFoundException ex) {
				results.append("No such class\n");
				return;
			}
		}
	}

	public Ch22ex09() {
		NameL nameListener = new NameL();
		inputText.addActionListener(nameListener);
		JPanel top = new JPanel();
		top.add(new JLabel("Class name (and optionally word methods should contain) (press Enter):"));
		top.add(inputText);
		add(BorderLayout.NORTH, top);
		add(new JScrollPane(results));
		// Initial data and test:
		inputText.setText("java.lang.Integer");
		nameListener.actionPerformed(new ActionEvent("", 0, ""));
	}

	public static void main(String[] args) {
		run(new Ch22ex09(), 750, 400);
	}
}

/* Execute to see output */
