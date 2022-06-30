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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Control.Controller;

public class PanelAddCriterio extends JPanel {
	private JLabel lblNameApp;
	private JTextField txtNameCriterio;
	private JTextField txtAbreviation;
	private JTextField txtValueCriterioU;
	private JTextField txtValueCriterioV;
	private JTextField txtValueCriterioPi;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private GridBagConstraints gbc;

	public PanelAddCriterio(Controller control,String nameApp, String actionCancel, String nameBorder, String nameOption, String nameAbreviOp, String nameValueU, String nameValueV, String nameValuePi, String actionAdd) {
		lblNameApp = new JLabel(nameApp);
		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(actionAdd);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(actionCancel);
		btnCancelOption.addActionListener(control);
		
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.init(nameBorder, nameOption, nameAbreviOp, nameValueU, nameValueV, nameValuePi);
	}

	private void assignValues(AbstractBorder brd) {
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 14);
		lblNameApp.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 14);
	}
	
	private JPanel panelAddCriterio(String nameBorder, String nameOption, String nameAbrevi, String nameValueU, String nameValueV, String nameValuePi) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder("Create Criteria"));
		panel.setPreferredSize(new Dimension(400,300));
		GridBagConstraints x = new GridBagConstraints();
		JLabel lblNameCriterio = new JLabel(nameOption);
		JLabel lblAbreviation = new JLabel(nameAbrevi);
		JLabel lblValueCriterioU = new JLabel(nameValueU);
		JLabel lblValueCriterioV = new JLabel(nameValueV);
		JLabel lblValueCriterioPi = new JLabel(nameValuePi);
		Border border = new TextBubbleBorder(new Color(79,185,192), 2, 5);
		txtNameCriterio = new JTextField(15);
		txtAbreviation = new JTextField(15);
		txtValueCriterioU = new JTextField(15);
		txtValueCriterioV = new JTextField(15);
		txtValueCriterioPi = new JTextField(15);
		txtNameCriterio.setBorder(border);
		txtAbreviation.setBorder(border);
		txtValueCriterioU.setBorder(border);
		txtValueCriterioV.setBorder(border);
		txtValueCriterioPi.setBorder(border);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblNameCriterio, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtNameCriterio, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblAbreviation, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtAbreviation, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblValueCriterioU, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtValueCriterioU, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblValueCriterioV, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtValueCriterioV, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblValueCriterioPi, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtValueCriterioPi, x);
		
		return panel;
		
	}
	
	public void cleanAllCamps() {
		txtNameCriterio.setText("");
		txtAbreviation.setText("");
		txtValueCriterioU.setText("");
		txtValueCriterioV.setText("");
		txtValueCriterioPi.setText("");
	}

	private void init(String nameBorder, String nameOption, String nameAbrevi, String nameValueU, String nameValueV, String nameValuePi) {
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
		add(this.panelAddCriterio(nameBorder, nameOption, nameAbrevi, nameValueU, nameValueV, nameValuePi), gbc);
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
