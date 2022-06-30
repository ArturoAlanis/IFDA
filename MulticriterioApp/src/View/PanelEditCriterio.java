package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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

import Control.Controller;

public class PanelEditCriterio extends JPanel {
	private JLabel lblNameApp;
	private ButtonGroup buttonGroup;
	private PanelViewCriterios panelViewCriterios;
	private ButtonGeneral btnAddCriterio;
	private ButtonGeneral btnDeleteCriterio;
	private ButtonGeneral btnModifyCriterio;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private GridBagConstraints gbc;

	public PanelEditCriterio(Controller control, String nameApp, String actionCancel, String actionAdd, String actionDelete, String actionModify, String nameAppList) {
		lblNameApp = new JLabel(nameApp);
		buttonGroup = new ButtonGroup();
		btnModifyCriterio = new ButtonGeneral("Edit",150,30);
		btnModifyCriterio.setActionCommand(actionModify);
		btnModifyCriterio.addActionListener(control);
		btnDeleteCriterio = new ButtonGeneral("Delete",150,30);
		btnDeleteCriterio.setActionCommand(actionDelete);
		btnDeleteCriterio.addActionListener(control);
		btnAddCriterio = new ButtonGeneral("Add",150,30);
		btnAddCriterio.setActionCommand(actionAdd);
		btnAddCriterio.addActionListener(control);
		panelViewCriterios = new PanelViewCriterios("Choose the data to modify", null, nameAppList);
		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
//		btnAcceptOption.setActionCommand(IoManager.ACCEPT_OPTION_EDIT);
		btnAcceptOption.addActionListener(control);
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
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.insets = new Insets(0, 0, 20, 0);
		add(btnModifyCriterio, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(btnDeleteCriterio, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(btnAddCriterio, gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.weighty = 0.2;
		add(lblNameApp, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 4;
		gbc.weightx = gbc.weighty = 0.4;
		add(panelViewCriterios, gbc);
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		add(btnCancelOption, gbc);
	}

	public void assignOptions(Object[] list) {
		JRadioButton button;
		for (int i = 0; i < list.length; i++) {
			button = new JRadioButton(list[i].toString());
			add(button, gbc);
			buttonGroup.add(button);
		}
	}
	
	public void setOptionsModify(Object[] listOptions) {
		panelViewCriterios.setOptionsModify(listOptions);
	}
	
	
	public Object[] ccc() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Oppp1");
		a.add("Op22");
		a.add("Op33");
		for (int i = 0; i < 15; i++) {
			a.add("djj");
		}
		return a.toArray();
	}

	
}
