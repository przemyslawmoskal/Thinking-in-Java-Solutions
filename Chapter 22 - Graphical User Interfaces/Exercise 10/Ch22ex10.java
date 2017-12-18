import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex10 extends JFrame {
	JLabel label = new JLabel("Hint: Change focus between buttons and text field with Tab button on the keyboard");
	JButton button = new JButton("Button 1 (When focused, copying typed text to textField");
	JButton button2 = new JButton("Button 2 (When focused, no action is performed");
	JTextField textField = new JTextField(15);
	boolean focus = false;
	Ch22ex10() {
		button.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
					textField.setText(textField.getText() + e.getKeyChar());
			}
		});
		setLayout(new FlowLayout());
		add(button);
		add(button2);
		add(label);
		add(textField);
	}

	public static void main(String[] args) {
		run(new Ch22ex10(), 500, 150);
	}

}
