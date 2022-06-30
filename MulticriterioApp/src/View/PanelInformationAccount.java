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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import Control.Controller;

public class PanelInformationAccount extends JPanel {
	private JLabel lblImgAccount;
	private JLabel lblNameUser;
	private JButton jbtEditAccount;
	private GridBagConstraints gbc;

	public PanelInformationAccount(Controller control) {
		lblImgAccount = new JLabel();
		Image img = new ImageIcon("data/IconApp.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		lblImgAccount.setIcon(img2);
		
		lblNameUser = new JLabel("José Vargas ");
		jbtEditAccount = new JButton("Edit Account ");
		AbstractBorder border = new TextBubbleBorder(new Color(79,185,192), 0, 0);
		jbtEditAccount.setPreferredSize(new Dimension(WIDTH,25));
		jbtEditAccount.setActionCommand(IoManager.EDIT_ACCOUNT);
		jbtEditAccount.addActionListener(control);
		jbtEditAccount.setBorder(border);
		jbtEditAccount.setUI(new MyBottomUI());
		jbtEditAccount.setBackground(new Color(79,185,192));
		jbtEditAccount.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				jbtEditAccount.setBackground(new Color(35,168,176));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				jbtEditAccount.setBackground(new Color(28,138,219));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jbtEditAccount.setBackground(new Color(79,185,192));
				jbtEditAccount.setBorder(null);
				jbtEditAccount.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jbtEditAccount.setBackground(new Color(35,168,176));
				jbtEditAccount.setBorder(new TextBubbleBorder(Color.blue, 1, 0));
				jbtEditAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setBackground(new Color(79,185,192));
		setLayout(new GridBagLayout());
		this.assignValues();
		this.init();
	}

	private void assignValues() {
		Border borderLine = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY);
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 25);
		lblNameUser.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 20);
		jbtEditAccount.setFont(fuente);
		jbtEditAccount.setForeground(Color.WHITE);
	}
	
	public void setNameAccount(String nameAccount) {
		lblNameUser.setText(nameAccount);
	}

	private void init() {
		gbc = new GridBagConstraints();
//		gbc.anchor = GridBagConstraints.WEST;
//		gbc.gridwidth = GridBagConstraints.BOTH;
//		gbc.insets = new Insets(20, 0, 0, 10);
//		add(lblImgAccount, gbc);
//		gbc.insets = new Insets(0, 0, 0, 0);
//		gbc.anchor = GridBagConstraints.EAST;
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		add(lblNameUser, gbc);
//		gbc.insets = new Insets(0, 0, 20, 0);
//		add(lblEditAccount, gbc);
		
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.gridy = 1;
//		gbc.insets = new Insets(0, 20, 0, 10);
		gbc.fill = GridBagConstraints.VERTICAL;
		add(lblImgAccount, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 0, 0);
		gbc.gridx = 1;
		gbc.gridwidth = 1;
//		gbc.gridheight = 1;
		gbc.gridy = 0;
		add(lblNameUser, gbc);
		gbc.insets = new Insets(20, 10, 0, 0);
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		add(jbtEditAccount, gbc);
	}



}
