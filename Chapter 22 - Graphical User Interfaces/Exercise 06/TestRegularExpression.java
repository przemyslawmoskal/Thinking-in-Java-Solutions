// Allows you to easily try out regular expressions.

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;
import static net.mindview.util.SwingConsole.*;

class TestRegularExpression extends JFrame {
	private JTextArea
		inputArea = new JTextArea(20,20),
		outputArea = new JTextArea(20,20);
	private JTextField txt = new JTextField(10);
	private JButton searchButton = new JButton("Search");
	private JButton clearButton = new JButton("Clear");
	public TestRegularExpression() {
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputText = inputArea.getText();
				String regexToMatch = txt.getText();
				for (String regex : regexToMatch.split(" ")) {
					outputArea.append("Regular expression: \"" + regex + "\"");
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(inputText);
					while (m.find()) {
						outputArea.append("\nMatch \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1) + "\n");
					}
					outputArea.append("\n*********************\n");
				}
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputArea.setText("");
				outputArea.setText("");
				txt.setText("");
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(inputArea));
		add(new JScrollPane(outputArea));
		add(txt);
		add(searchButton);
		add(clearButton);
	}
	public static void main(String[] args) {
		run(new TestRegularExpression(), 475, 425);
	}
}
