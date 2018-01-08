import static net.mindview.util.SwingConsole.*;
import java.awt.*;
import javax.swing.*;

public class Ch22ex30 extends JFrame {
	JTabbedPane tabbedPane = new JTabbedPane();
	JMenuItem menuItem = new JMenuItem();
	JToolTip checkBoxToolTip = new JToolTip();
	JToolTip radioButtonToolTip = new JToolTip();
	JRadioButton radioButton1 = new JRadioButton("<html><b><font size=+2>RadioButton#1!");
	JRadioButton radioButton2 = new JRadioButton("<html><b><font size=+2>RadioButton#2!");
	JCheckBox checkBox1 = new JCheckBox("<html><b><font size=+2>CheckBox#1!");
	JCheckBox checkBox2 = new JCheckBox("<html><b><font size=+2>CheckBox#2!");
	JMenu menu1 = new JMenu("JMenu#1");
	JMenu menu2 = new JMenu("JMenu#2");
	JMenuBar menuBar = new JMenuBar();
	Ch22ex30() {
		setJMenuBar(menuBar);
		checkBox1.setToolTipText("<html><i><font size=+5>CheckBox#1 tooltip");
		checkBox2.setToolTipText("<html><i><font size=+5>CheckBox#2 tooltip");
		radioButton1.setToolTipText("<html><i><font size=+5>RadioButton#1 tooltip");
		radioButton2.setToolTipText("<html><i><font size=+5>RadioButton#2 tooltip");
		JPanel panelOfCheckBoxes = new JPanel();
		JPanel panelOfRadioButtons = new JPanel();
		panelOfCheckBoxes.add(checkBox1);
		panelOfCheckBoxes.add(checkBox2);
		panelOfRadioButtons.add(radioButton1);
		panelOfRadioButtons.add(radioButton2);
		tabbedPane.addTab("<html><b><font size=+7>CheckBox Tab",  panelOfCheckBoxes);
		tabbedPane.addTab("<html><b><font size=+7>RadioButton Tab",  panelOfRadioButtons);
		add(tabbedPane);
		menu1.add(new JMenuItem("<html><i><font size=+5>JMenuItem#1"));
		menu1.add(new JMenuItem("<html><b><font size=+2>JMenuItem#2"));
		menu1.add(new JMenuItem("<html><i><font size=+3>JMenuItem#3"));
		menu2.add(new JMenuItem("<html><i><font size=+5>JMenuItem#4"));
		menu2.add(new JMenuItem("<html><b><font size=+2>JMenuItem#5"));
		menuBar.add(menu1);
		menuBar.add(menu2);
	}
	public static void main(String[] args) {
		run(new Ch22ex30(), 600, 300);
	}
}

/* Execute to see output */