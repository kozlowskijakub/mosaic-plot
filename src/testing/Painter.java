package testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Painter extends JComponent {

	Painter(JPanel panel, Dimension d, Point p,Color c) {
		paint(panel.getGraphics(), d, p,c);
	}

	Painter(JPanel panel) {
		clear(panel.getGraphics(), panel.getSize().width, panel.getSize().height);
	}

	public void paint(Graphics g, Dimension d, Point p, Color c) {
		g.setColor(c);
		
		g.drawRect(p.x, p.y, d.width, d.height);
	}

	public void clear(Graphics g, int width, int height) {
		g.clearRect(0, 0, width, height);
	}

}
