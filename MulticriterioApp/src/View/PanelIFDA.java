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

public class PanelIFDA extends JPanel {
	private JLabel lblNameApp;
	private JLabel lblDescription;
	private JTextField txtNumberDecisors;
	private JTextField txtNumberCriterios;
	private JTextField txtNumberAlternatives;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private GridBagConstraints gbc;

	public PanelIFDA(Controller control) {
		lblNameApp = new JLabel("IFDA ");
		lblDescription = new JLabel("Enter the data to generate the matrix  ");
		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(IoManager.ACCEPT_IFDA);
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
		lblDescription.setFont(fuente);
	}
	
	private JPanel panelCreateDecisor() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder("Generate Matrix"));
		panel.setPreferredSize(new Dimension(400,300));
		GridBagConstraints x = new GridBagConstraints();
		JLabel lblNumberDecisor = new JLabel("Number of decision-makers: ");
		JLabel lblNumberCriterios = new JLabel("Number of criteria: ");
		JLabel lblNumberAlternatives = new JLabel("Number of alternatives: ");
		txtNumberDecisors = new JTextField(15);
		txtNumberCriterios = new JTextField(15);
		txtNumberAlternatives = new JTextField(15);
		Border border = new TextBubbleBorder(new Color(79,185,192), 2, 10);
		txtNumberDecisors.setBorder(border);
		txtNumberCriterios.setBorder(border);
		txtNumberAlternatives.setBorder(border);
		x.insets = new Insets(15, 0, 0, 0);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblNumberDecisor, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtNumberDecisors, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblNumberCriterios, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtNumberCriterios, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblNumberAlternatives, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtNumberAlternatives, x);
		
		return panel;
		
	}
	
	public String getNumberDecisor() {
		return txtNumberDecisors.getText();
	}
	
	public String getNumberCriterios() {
		return txtNumberCriterios.getText();
	}
	
	public String getNumberAlternatives() {
		return txtNumberAlternatives.getText();
	}
	
	public void cleanAllCamps() {
		txtNumberAlternatives.setText("");
		txtNumberCriterios.setText("");
		txtNumberDecisors.setText("");
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
		gbc.weightx = gbc.weighty = 0.2;
		add(lblDescription, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = gbc.weighty = 0.4;
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

}
