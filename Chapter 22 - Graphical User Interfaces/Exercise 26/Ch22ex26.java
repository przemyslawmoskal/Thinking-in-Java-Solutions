import static net.mindview.util.SwingConsole.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ch22ex26 extends JFrame {
	SineDraw[] sines;
	JSlider cycles = new JSlider(1, 30, 5);
	public Ch22ex26(int numOfPanels) {
		int side = Math.round((float)Math.sqrt((double)numOfPanels));
		JPanel jp = new JPanel(new GridLayout(side, side));
		sines = new SineDraw[numOfPanels];
		for(int i = 0; i < sines.length; i++) {
			sines[i] = new SineDraw();
			jp.add(sines[i]);
		}
		add(jp);
		add(BorderLayout.SOUTH, cycles);
		cycles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				for(int i = 0; i < sines.length; i++)
					sines[i].setCycles(((JSlider)e.getSource()).getValue());
			}});
		}
	public static void main(String[] args) {
		int numberOfPanels = 6;
		if(args.length > 0) {
			numberOfPanels = Integer.parseInt(args[0]);
		}
		run(new Ch22ex26(numberOfPanels), 600, 600);
	}

}

/* Execute to see output */
