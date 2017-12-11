import javax.swing.*;

public class HelloSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Swing");
		frame.setSize(300, 100);
		frame.setVisible(true);
	}
}

// When setDefaultCloseOperation() method is deleted, there is a need to
// manually terminate the program.