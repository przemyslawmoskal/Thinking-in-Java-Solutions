import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import static net.mindview.util.SwingConsole.*;

public class Ch22ex22 extends JFrame{
	
	private JSlider sliderR = new JSlider(0, 255, 0);
	private JSlider sliderG = new JSlider(0, 255, 0);
	private JSlider sliderB = new JSlider(0, 255, 0);
	private JTextField rField= new JTextField(3);
	private JTextField gField= new JTextField(3);
	private JTextField bField= new JTextField(3);
	private int rValue = 0;
	private int gValue = 0;
	private int bValue = 0;
	private JPanel panelR = new JPanel();
	private JPanel panelG = new JPanel();
	private JPanel panelB = new JPanel();
	private JPanel panelColor = new JPanel();
	
	Ch22ex22() {
		setLayout(new GridLayout(4, 1));
		panelR.add(new JLabel("R"));
		panelR.add(sliderR);
		panelR.add(rField);
		panelG.add(new JLabel("G"));
		panelG.add(sliderG);
		panelG.add(gField);
		panelB.add(new JLabel("B"));
		panelB.add(sliderB);
		panelB.add(bField);
		rField.setEditable(false);
		gField.setEditable(false);
		bField.setEditable(false);
		
		sliderR.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				rValue = ((JSlider)(e.getSource())).getValue();
				rField.setText("" + rValue);
				panelColor.setBackground(new Color(rValue, gValue, bValue));
			}
		});
		sliderG.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				gValue = ((JSlider)(e.getSource())).getValue();
				gField.setText("" + gValue);
				panelColor.setBackground(new Color(rValue, gValue, bValue));
			}
		});
		sliderB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				bValue = ((JSlider)(e.getSource())).getValue();
				bField.setText("" + bValue);
				panelColor.setBackground(new Color(rValue, gValue, bValue));
			}
		});
		
		add(panelR);
		add(panelG);
		add(panelB);
		panelColor.setBackground(new Color(255,0,0));
		add(panelColor);
	}
	
	public static void main(String[] args) {
		run(new Ch22ex22(), 400, 150);
	}
}

/* Execute to see output */