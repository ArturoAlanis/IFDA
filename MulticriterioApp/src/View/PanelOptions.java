package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import Control.Controller;

public class PanelOptions extends JPanel {
	private PanelOptionsTOPIC panelOptionsTopic;
	private PanelInformationAccount panelInformationAccount;
	private GridBagConstraints gbc;

	public PanelOptions(Controller control) {
		panelOptionsTopic = new PanelOptionsTOPIC(control);
		panelInformationAccount = new PanelInformationAccount(control);
		
//		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 10);
//		setBorder(border);
		setBackground(new Color(82,88,90));
//		setPreferredSize(new Dimension(WIDTH, 40));
		setLayout(new GridBagLayout());
//		this.assignValues();
		this.init();
	}

//	private void assignValues() {
//		Border borderLine = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY);
//		Font fuente = new Font("Calibri", 3, 14);
//		fuente = new Font("Arial Black", 3, 25);
//		lblNameApp.setFont(fuente);
//		fuente = new Font("Arial Rounded MT Bold", 3, 20);
//		lblAbout.setFont(fuente);
//		lblHelpme.setFont(fuente);
//		lblExit.setFont(fuente);
//	}
	
	public void setNameAccount(String nameAccount) {
		panelInformationAccount.setNameAccount(nameAccount);
	}

	private void init() {
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = gbc.weighty = 0;
		add(panelInformationAccount, gbc);
//		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 0;
		gbc.gridheight = 0;
		gbc.weightx = gbc.weighty = 6.0;
		add(panelOptionsTopic, gbc);
	}



}
