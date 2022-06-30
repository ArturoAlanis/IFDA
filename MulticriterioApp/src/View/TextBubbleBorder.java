package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.sound.sampled.ReverbType;
import javax.swing.RepaintManager;
import javax.swing.border.AbstractBorder;

public class TextBubbleBorder extends AbstractBorder {

	private Color color;
	private int thickness = 4;
	private int radii = 8;
	private int pointerSize = 0;
	private Insets insets = null;
	private BasicStroke stroke = null;
	private int strokePad;
	private int pointerPad = 4;
	private boolean left = true;
	private RenderingHints hints;

	public TextBubbleBorder(Color color, int thickness, int radii) {
		this.thickness = thickness;
		this.radii = radii;
		this.color = color;
		stroke = new BasicStroke(thickness);
		strokePad = thickness / 2;
		hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int pad = radii + strokePad;
		int bottomPad = pad + pointerSize + strokePad;
		insets = new Insets(pad, pad, bottomPad, pad);
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return insets;
	}

	@Override
	public Insets getBorderInsets(Component c, Insets insets) {
		return getBorderInsets(c);
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g;
		int bottomLineY = height - thickness - pointerSize;
		RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(0 + strokePad, 0 + strokePad, width - thickness,
				bottomLineY, radii, radii);
		Polygon pointer = new Polygon();
		if (left) {
			pointer.addPoint(strokePad + radii + pointerPad, bottomLineY);
			pointer.addPoint(strokePad + radii + pointerPad + pointerSize, bottomLineY);
			pointer.addPoint(strokePad + radii + pointerPad + (pointerSize / 2), height - strokePad);
		} else {
			pointer.addPoint(width - (strokePad + radii + pointerPad), bottomLineY);
			pointer.addPoint(width - (strokePad + radii + pointerPad + pointerSize), bottomLineY);
			pointer.addPoint(width - (strokePad + radii + pointerPad + (pointerSize / 2)), height - strokePad);
		}
		Area area = new Area(bubble);
		area.add(new Area(pointer));
		g2.setRenderingHints(hints);
		Component parent = c.getParent();
		if (parent != null) {
			Rectangle rect = new Rectangle(0, 0, width, height);
			Area borderRegion = new Area(rect);
			borderRegion.subtract(area);
			g2.setClip(borderRegion);
			g2.setColor(Color.WHITE);// COLOR.................................................................................
			g2.fillRect(0, 0, width, height);
			g2.setClip(null);
		}
		g2.setColor(color);
		g2.setStroke(stroke);
		g2.draw(area);
	}
}