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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import Control.Controller;

public class PanelOptionsTOPIC extends JPanel {
	private JLabel lblNameApp;
	private ButtonOptions btnIfda;
	private ButtonOptions mofifyData;
	private ButtonOptions btnCreateDecisor;
	private ButtonOptions btnOtro;
	private GridBagConstraints gbc;

	public PanelOptionsTOPIC(Controller control) {
		
		lblNameApp = new JLabel("Option menu ");
		mofifyData = new ButtonOptions("Modify data ", WIDTH, 30);
		mofifyData.setActionCommand(IoManager.MODIFY_DATA);
		mofifyData.addActionListener(control);
		btnIfda = new ButtonOptions("IFDA", WIDTH, 30);
		btnIfda.setActionCommand(IoManager.IFDA);
		btnIfda.addActionListener(control);
		btnCreateDecisor = new ButtonOptions("Create Decisor ", WIDTH,30);
		btnCreateDecisor.setActionCommand(IoManager.CREATE_DECISOR);
		btnCreateDecisor.addActionListener(control);
		btnOtro = new ButtonOptions("Other", WIDTH, 30);
		setBackground(new Color(40,43,44));
		setLayout(new GridBagLayout());
		this.assignValues();
		this.init();
	}

	private void assignValues() {
		Border borderLine = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
		lblNameApp.setBorder(borderLine);
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 25);
		lblNameApp.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 20);
		mofifyData.setFont(fuente);
		btnIfda.setFont(fuente);
		btnCreateDecisor.setFont(fuente);
		lblNameApp.setForeground(Color.WHITE);
		mofifyData.setForeground(Color.WHITE);
		btnIfda.setForeground(Color.WHITE);
		btnCreateDecisor.setForeground(Color.WHITE);
	}

	private void init() {
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(lblNameApp, gbc);
		add(new JLabel("   "), gbc);
		add(mofifyData, gbc);
		add(btnIfda, gbc);
		add(btnCreateDecisor, gbc);
		add(btnOtro, gbc);
	}



}
