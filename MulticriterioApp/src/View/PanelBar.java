package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import Control.Controller;

public class PanelBar extends JPanel {
	private JLabel lblImgApp;
	private JLabel lblNameApp;
	private JLabel lblHelpme;
	private JLabel lblAbout;
	private JButton btnExit;
	private GridBagConstraints gbc;

	public PanelBar(Controller control) {
		lblImgApp = new JLabel();
//		Image img = new ImageIcon("data/IconApp.png").getImage();
		Image img = new ImageIcon("data/ff.jpg").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		lblImgApp.setIcon(img2);
		
		lblNameApp = new JLabel("Multi-criteria - IFDA & IFIS ");
		lblHelpme = new JLabel("Help ");
		lblAbout = new JLabel("About ");
		btnExit = new JButton("Leave ");
		AbstractBorder border = new TextBubbleBorder(new Color(35,168,176), 0, 0);
//		btnExit.setPreferredSize(new Dimension(WIDTH,25));
		btnExit.setBorder(border);
		btnExit.setUI(new MyBottomUI());
		btnExit.setBackground(new Color(35,168,176));
		btnExit.addActionListener(control);
		btnExit.setActionCommand(IoManager.LOG_OUT);
		btnExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				btnExit.setBackground(new Color(35,168,176));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btnExit.setBackground(new Color(28,138,219));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(35,168,176));
				btnExit.setBorder(null);
				btnExit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(new Color(35,168,176));
				btnExit.setBorder(new TextBubbleBorder(Color.blue, 1, 0));
				btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
//		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 10);
//		setBorder(border);
		setBackground(new Color(35,168,176));
		setPreferredSize(new Dimension(WIDTH, 40));
		setLayout(new GridBagLayout());
		this.assignValues();
		this.init();
	}

	private void assignValues() {
		Border borderLine = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY);
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 25);
		lblNameApp.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 20);
		lblAbout.setFont(fuente);
		lblHelpme.setFont(fuente);
		btnExit.setFont(fuente);
	}

	private void init() {
		gbc = new GridBagConstraints();
//		gbc.anchor = GridBagConstraints.WEST;
//		gbc.gridwidth = GridBagConstraints.HORIZONTAL;
//		add(lblImgApp, gbc);
//		add(lblNameApp, gbc);
//		gbc.insets = new Insets(0, 700, 0, 0);
//		gbc.anchor = GridBagConstraints.EAST;
//		add(lblAbout, gbc);
//		gbc.insets = new Insets(0, 10, 0, 0);
//		add(lblHelpme, gbc);
//		add(lblExit, gbc);
		
		
		
		//........................................
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 10, 0, 0);
		add(lblImgApp, gbc);
		
		gbc.weightx = gbc.weighty = 1.0;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridy = 0;
		add(lblNameApp, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.weightx = gbc.weighty = 0.0;
		gbc.gridx = 5;
		gbc.gridwidth = 1;
		gbc.gridy = 0;
		add(lblAbout, gbc);
		
		
		gbc.gridx = 6;
		gbc.gridwidth = 1;
		gbc.gridy = 0;
		add(lblHelpme, gbc);
		
		
		gbc.insets = new Insets(0, 0, 0, 10);
		gbc.gridx = 7;
		gbc.gridwidth = 1;
//		gbc.gridheight = 0;
		gbc.gridy = 0;
		add(btnExit, gbc);
	}



}
