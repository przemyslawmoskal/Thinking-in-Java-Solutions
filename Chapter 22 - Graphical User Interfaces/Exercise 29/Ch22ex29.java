import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex29 extends JFrame {
	JButton button = new JButton("Choose color");
	JTextField textField = new JTextField(7);
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	Color defaultColor = new Color(0xFFFFFF);
	Ch22ex29() {
		panel1.setLayout(new FlowLayout());
		panel1.add(button);
		panel1.add(textField);
		setLayout(new GridLayout(2, 1));
		panel2.setBackground(defaultColor);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(Ch22ex29.this, "Choose color", new Color(0xFFFFFF));
				if (chosenColor != null) {
					panel2.setBackground(chosenColor); 
					textField.setText("#" + Integer.toHexString(Integer.valueOf(chosenColor.getRGB())).toUpperCase().substring(2));
					validate();
				}
			}
		});
		add(panel1);
		add(panel2);
	}
	public static void main(String[] args) {
		run(new Ch22ex29(), 300, 100);
	}
}

/* Execute to see output */
