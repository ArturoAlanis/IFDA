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

public class ButtonGeneral extends JButton implements MouseListener {
	private AbstractBorder border;

	public ButtonGeneral(String text, int width, int height) {
		border = new TextBubbleBorder(new Color(79,185,192), 3, 10);
		this.setPreferredSize(new Dimension(width, height));
		setBorder(border);
		Font font = new Font("Franklin Gothic Demi", 3, 12);
		setFont(font);
		setText(text);
		setForeground(Color.WHITE);
		addMouseListener(this);
		this.setUI(new MyBottomUI());
		setBackground(new Color(79,185,192));
	}

	public ButtonGeneral(int width, int height, String rutePicture, String text) {
		border = new TextBubbleBorder(new Color(79,185,192), 3, 10);
		this.setPreferredSize(new Dimension(width, height));
		setBorder(border);
		Font font = new Font("Franklin Gothic Demi", 3, 12);
		setFont(font);
		setText(text);
		setForeground(new Color(79,185,192));
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				setBackground(Color.WHITE);
				setForeground(new Color(79,185,192));
//				setBorder(new TextBubbleBorder(new Color(79,185,192), 3, 10));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(new Color(79,185,192));
				setForeground(Color.WHITE);
//				setBorder(new TextBubbleBorder(Color.WHITE, 3, 10));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(Color.WHITE);
				setBorder(new TextBubbleBorder(new Color(79,185,192), 3, 10));
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(new TextBubbleBorder(Color.BLACK, 3, 10));
				setBackground(Color.WHITE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		this.setUI(new MyBottomUI());
		setBackground(Color.WHITE);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setBackground(new Color(79,185,192));
		setForeground(Color.WHITE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setBackground(Color.WHITE);
		setForeground(new Color(79,185,192));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(new Color(79,185,192));
		setBorder(new TextBubbleBorder(new Color(79,185,192), 3, 10));
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBorder(new TextBubbleBorder(Color.BLACK, 3, 10));
		setBackground(new Color(79,185,192));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
}