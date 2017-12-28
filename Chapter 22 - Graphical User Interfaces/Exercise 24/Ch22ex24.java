import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;

class SketchPanel extends JPanel {
	java.util.List<SimplePoint> listOfPoints = new ArrayList<>();
	SimplePoint startingPoint;
	
	class SimplePoint {
		int x;
		int y;
		SimplePoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void clearPanel() {
		repaint();
	}
	
	public boolean horizontalOrVerticalMoved = false;
	
	public void drawPoint(Graphics g, SimplePoint p) {
		if (startingPoint == null) {
			startingPoint = p;
			return;
		}
		g.drawLine(startingPoint.x, startingPoint.y, p.x, p.y);
		startingPoint = p;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(horizontalOrVerticalMoved) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.RED);
		}
		startingPoint = null;
		for(SimplePoint p : listOfPoints) {
			drawPoint(g, p);
		}
	}
	
	public void addSimplePoint(int x, int y) {
		listOfPoints.add(new SimplePoint(x, y));
		repaint();
	}
}


public class Ch22ex24 extends JFrame {
	JButton button = new JButton("Erase");
	JSlider verticalSlider = new JSlider(JSlider.VERTICAL);
	JSlider horizontalSlider = new JSlider();
	SketchPanel panel = new SketchPanel();
	
	Ch22ex24() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.listOfPoints.clear();
				panel.clearPanel();
			}
		});
		verticalSlider.setInverted(true);
		verticalSlider.setValue(0);
		verticalSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int x = horizontalSlider.getValue();
				int y = verticalSlider.getValue();
				panel.horizontalOrVerticalMoved = true;
				panel.addSimplePoint(x, y);
			}
		});
		horizontalSlider.setValue(0);
		horizontalSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int x = horizontalSlider.getValue();
				int y = verticalSlider.getValue();
				panel.horizontalOrVerticalMoved = false;
				panel.addSimplePoint(x, y);
			}
		});
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				horizontalSlider.setMaximum(panel.getWidth());
				verticalSlider.setMaximum(panel.getHeight());
			}
		});
		add(BorderLayout.NORTH, button);
		add(BorderLayout.WEST, verticalSlider);
		add(BorderLayout.SOUTH, horizontalSlider);
		panel.setBackground(new Color(0xFFFFFF));
		add(panel);
		
	}

	public static void main(String[] args) {
		run(new Ch22ex24(), 500, 500);
	}

}

/* Execute to see output */