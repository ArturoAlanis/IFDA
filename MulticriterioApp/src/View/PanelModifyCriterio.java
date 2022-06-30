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

public class PanelModifyCriterio extends JPanel {
	private JLabel lblNameApp;
	private PanelChoose panelChooseForModify;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private GridBagConstraints gbc;

	public PanelModifyCriterio(Controller control, String nameApp, String actionCancel, String mssPanelChoose, String actionModify) {
		lblNameApp = new JLabel(nameApp);

		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(actionModify);
		btnAcceptOption.addActionListener(control);
		panelChooseForModify = new PanelChoose(mssPanelChoose, null);
		panelChooseForModify.setPreferredSize(new Dimension(300,300));
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(actionCancel);
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
		add(panelChooseForModify, gbc);
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
	
	public void setListCriterios(Object[] list) {
		panelChooseForModify.setOptionsModify(list);
	}
	
	
}
