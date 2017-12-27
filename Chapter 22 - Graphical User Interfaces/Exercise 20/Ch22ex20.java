import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex20 extends JFrame {
	JLabel label = new JLabel("Enter name of the java file: ");
	JTextField txt = new JTextField(30);
	JButton button = new JButton("Search for file and create menus");
	JMenuBar menuBar = new JMenuBar();
	JMenu menuUpper = new JMenu("UpperCaseMenus");
	JMenu menuLower = new JMenu("LowerCaseMenus");
	JMenu menuOther = new JMenu("OtherMenus");
	Set<String> words = new TreeSet<String>();
	Set<String> lowerCaseSet = new TreeSet<String>();
	Set<String> upperCaseSet = new TreeSet<String>();
	Set<String> otherWordsSet = new TreeSet<String>();
	Ch22ex20() {
		setLayout(new FlowLayout());
		add(label);
		add(txt);
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Clear sets and remove all menus from previously searched file:
				words.clear();
				lowerCaseSet.clear();
				upperCaseSet.clear();
				otherWordsSet.clear();
				menuUpper.removeAll();
				menuLower.removeAll();
				menuOther.removeAll();
				File file = new File(txt.getText());
				// If there is no such file in directory:
				if(!(file.isFile())) {
					txt.setText("Enter valid file name (for example \"XYZ.java\")");
				// If file was found - fill sets with Strings from new java file:
				} else {
					words = new TreeSet<String>(new TextFile(txt.getText(), "\\W+"));
					Iterator<String> it = words.iterator();
					while(it.hasNext()) {
						String word = it.next();
						if(Character.isLowerCase(word.charAt(0))) {
							lowerCaseSet.add(word);
						} else if(Character.isUpperCase(word.charAt(0))) {
							upperCaseSet.add(word);
						} else {
							otherWordsSet.add(word);
						}
					}
					for(String word : lowerCaseSet) {
						menuLower.add(new JMenuItem(word));
					}
					for(String word : upperCaseSet) {
						menuUpper.add(new JMenuItem(word));
					}
					for(String word : otherWordsSet) {
						menuOther.add(new JMenuItem(word));
					}
					menuBar.add(menuUpper);
					menuBar.add(menuLower);
					menuBar.add(menuOther);
					add(menuBar);
					// Refreshing frame:
					validate();
				}
			}
		});
	}

	public static void main(String[] args) {
		run(new Ch22ex20(), 500, 200);
	}

}

/* Execute to see output */
