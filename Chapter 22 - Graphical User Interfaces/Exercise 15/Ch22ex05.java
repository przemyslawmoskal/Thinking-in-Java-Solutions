import static net.mindview.util.SwingConsole.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class MyClass extends JFrame {
	private JButton button1 = new JButton("Button #1"), button2 = new JButton("Button #2"),
			button3 = new JButton("Button #3");
	private JTextField txt = new JTextField(25);
	private JCheckBox checkBox = new JCheckBox("CheckBox #1");
	private ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton) e.getSource()).getText();
			// Showing button label + additional text:
			txt.setText(name + " clicked!");
		}
	};
	private ActionListener al2 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBox cb = (JCheckBox) e.getSource();
			// Showing button label + additional text:
			if(cb.isSelected()) {
				txt.setText(cb.getText() + " set!");
			} else {
				txt.setText(cb.getText() + " cleared!");
			}
			
		}
	};
	
	MyClass() {
		setLayout(new FlowLayout());
		button1.addActionListener(al);
		button2.addActionListener(al);
		button3.addActionListener(al);
		checkBox.addActionListener(al2);
		add(button1);
		add(button2);
		add(button3);
		add(checkBox);
		add(txt);
	}
}

public class Ch22ex05 {

	public static void main(String[] args) {
		run(new MyClass(), 300, 150);
	}

}

/* Execute to see output */