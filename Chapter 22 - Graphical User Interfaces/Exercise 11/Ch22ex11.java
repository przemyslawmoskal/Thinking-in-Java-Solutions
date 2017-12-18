import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static net.mindview.util.SwingConsole.*;

class MyButton extends JButton {
	Random rand = new Random(128);
	Color color = new Color(0xFFFFFF);
	MyButton(String label) {
		super(label);
		setBackground(color);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(color = new Color(rand.nextInt(0xFFFFFF)));
			}
			
		});
	}
}

public class Ch22ex11 extends JFrame {
	
	Ch22ex11() {
		setLayout(new FlowLayout());
		add(new MyButton("My button"));
	}

	public static void main(String[] args) {
		run(new Ch22ex11(), 200, 100);
	}

}

/* Execute to see output */