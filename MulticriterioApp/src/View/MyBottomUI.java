package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class MyBottomUI extends BasicButtonUI {

	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.BLACK);
		super.paint(g2d, c);
	}
}
