// Drawing with Swing, using a JSlider.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;

class SineDraw extends JPanel {
	private static final int SCALEFACTOR = 200;
	private int cycles;
	private int points;
	private double[] sines;
	private int[] pts;
	java.util.Timer myTimer = new java.util.Timer();
	private double offset;
	private JSlider adjustSpeed = new JSlider(5, 55, 45);
	
	private class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			offset += 0.15;
			synchronized(SineDraw.this) {
				for(int i = 0; i < points; i++) {
					double radians = (Math.PI/SCALEFACTOR) * i + offset;
					sines[i] = Math.sin(radians);
				}
			}
			repaint();
		}
	}
	
	public SineDraw() {
		super(new BorderLayout());
		add(BorderLayout.SOUTH, adjustSpeed);
		adjustSpeed.setInverted(true);
		adjustSpeed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				myTimer.cancel();
				myTimer = new java.util.Timer();
				myTimer.scheduleAtFixedRate(new MyTimerTask(), 0, adjustSpeed.getValue());
			}
		});
		setCycles(5);
		myTimer.scheduleAtFixedRate(new MyTimerTask(), 300, 50);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int maxWidth = getWidth();
		double hstep = (double) maxWidth / (double) points;
		int maxHeight = getHeight();
		pts = new int[points];
		for (int i = 0; i < points; i++)
			pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
		g.setColor(Color.RED);
		for (int i = 1; i < points; i++) {
			int x1 = (int) ((i - 1) * hstep);
			int x2 = (int) (i * hstep);
			int y1 = pts[i - 1];
			int y2 = pts[i];
			g.drawLine(x1, y1, x2, y2);
		}
	}

	public synchronized void setCycles(int newCycles) {
		cycles = newCycles;
		points = SCALEFACTOR * cycles * 2;
		sines = new double[points];
		for (int i = 0; i < points; i++) {
			double radians = (Math.PI / SCALEFACTOR) * i;
			sines[i] = Math.sin(radians);
		}
		repaint();
	}
}

public class SineWave extends JFrame {
	private SineDraw sines = new SineDraw();
	private JSlider adjustCycles = new JSlider(1, 30, 5);
	
	public SineWave() {
		add(sines);
		adjustCycles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sines.setCycles(((JSlider) e.getSource()).getValue());
			}
		});
		add(BorderLayout.SOUTH, adjustCycles);
	}

	public static void main(String[] args) {
		run(new SineWave(), 700, 400);
	}
}

/* Execute to see output */