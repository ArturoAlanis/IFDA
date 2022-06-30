package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Control.Controller;

public class PanelCreateDecisor extends JPanel {
	private JLabel lblNameApp;
	private JComboBox<Object> cbxCharge;
	private JTextField txtNameDecisor;
	private JTextField txtLastNameDecisor;
	private JTextField txtEmail;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private GridBagConstraints gbc;

	public PanelCreateDecisor(Controller control) {
		lblNameApp = new JLabel("Create Decision Maker");
		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(IoManager.SAVE_AND_CREATE_DECISOR);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(IoManager.CANCEL_FIRST_PROCESS);
		btnCancelOption.addActionListener(control);
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.init();
	}

	private void assignValues(AbstractBorder brd) {
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 14);
		lblNameApp.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 14);
	}
	
	private JPanel panelCreateDecisor() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder("Create Decision Maker"));
		panel.setPreferredSize(new Dimension(400,300));
		GridBagConstraints x = new GridBagConstraints();
		JLabel lblNameDecisor = new JLabel("First Name");
		JLabel lblLastNameDecisor = new JLabel("Last Name");
		JLabel lblEmail = new JLabel("E-mail: ");
		JLabel lblCharge = new JLabel("Position: ");
		txtNameDecisor = new JTextField(15);
		txtLastNameDecisor = new JTextField(15);
		txtEmail = new JTextField(15);
		Border border = new TextBubbleBorder(new Color(79,185,192), 2, 10);
		txtNameDecisor.setBorder(border);
		txtLastNameDecisor.setBorder(border);
		txtEmail.setBorder(border);
		cbxCharge = new JComboBox<Object>();
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblNameDecisor, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtNameDecisor, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblLastNameDecisor, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtLastNameDecisor, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblEmail, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtEmail, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblCharge, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(cbxCharge, x);
		
		return panel;
		
	}
	
	public void cleanAllCamps() {
		txtNameDecisor.setText("");
		txtLastNameDecisor.setText("");
		txtEmail.setText("");
	}
	
	public String getCharge() {
		return cbxCharge.getSelectedItem().toString();
	}
	
	public String getNameDecisor() {
		return txtNameDecisor.getText();
	}
	
	public String getLastNameDecisor() {
		return txtLastNameDecisor.getText();
	}
	
	public String getEmail() {
		return txtEmail.getText();
	}

	private void init() {
		gbc = new GridBagConstraints();
//		gbc.anchor = GridBagConstraints.CENTER;
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		gbc.insets = new Insets(0, 0, 30, 0);
//		add(lblNameApp, gbc);
//		gbc.insets = new Insets(0, 0, 120, 0);
//		add(lblDescription, gbc);
//		gbc.insets = new Insets(0, 0, 0, 0);
//		add(panelChoose, gbc);
//		gbc.gridwidth = GridBagConstraints.RELATIVE;
//		add(btnAcceptOption, gbc);
//		add(btnCancelOption, gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weighty = 0.2;
		add(lblNameApp, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weighty = 0.2;
		add(this.panelCreateDecisor(), gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.insets = new Insets(0, 0, 0, 10);
		add(btnAcceptOption, gbc);
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		add(btnCancelOption, gbc);
	}
	
	public void setCharges(Object[] listObj) {
		cbxCharge.setModel(new DefaultComboBoxModel<>(listObj));
	}

	
	
}
