package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.AbstractBorder;

public class ButtonOptions extends JButton implements MouseListener {
	private AbstractBorder border;

	public ButtonOptions(String text, int width, int height) {
		border = new TextBubbleBorder(new Color(40,43,44), 0, 0);
		this.setPreferredSize(new Dimension(width, height));
		setBorder(border);
		Font font = new Font("Arial Rounded MT Bold", 3, 20);
		setFont(font);
		setText(text);
		setForeground(Color.WHITE);
		addMouseListener(this);
		this.setUI(new MyBottomUI());
		setBackground(new Color(40,43,44));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setBackground(new Color(49,48,48));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setBackground(new Color(0, 0, 0));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(new Color(40,43,44));
		setBorder(new TextBubbleBorder(new Color(40,43,44), 0, 0));
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBackground(new Color(49,48,48));
		setBorder(new TextBubbleBorder(Color.BLACK, 1, 0));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
}