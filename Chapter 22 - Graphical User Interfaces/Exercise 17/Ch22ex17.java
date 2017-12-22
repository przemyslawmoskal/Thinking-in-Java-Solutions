import static net.mindview.util.SwingConsole.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ch22ex17 extends JFrame {
	JLabel label = new JLabel("Enter password:");
	JButton button = new JButton("Check password");
	JPasswordField passwordField = new JPasswordField(20);
	Ch22ex17() {
		setLayout(new FlowLayout());
		add(label);
		add(passwordField);
		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = new String(((JPasswordField)e.getSource()).getPassword());
				if("mypassword".equals(s)) {
					JOptionPane.showMessageDialog(null, "Password is correct !", "Login success", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Password is wrong !", "Login failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = new String(passwordField.getPassword());
				if("mypassword".equals(s)) {
					JOptionPane.showMessageDialog(null, "Password is correct !", "Login success", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Password is wrong !", "Login failed", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		add(button);
	}
	public static void main(String[] args) {
		run(new Ch22ex17(), 300, 300);
	}
}

/* Execute to see output */