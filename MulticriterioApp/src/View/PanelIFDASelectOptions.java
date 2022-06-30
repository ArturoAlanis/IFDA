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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Control.Controller;

public class PanelIFDASelectOptions extends JPanel {
	private JLabel lblNameApp;
	private JLabel lblDescription;
	private JTextField txtNumberDecisors;
	private JTextField txtNumberCriterios;
	private JTextField txtNumberAlternatives;
	private DefaultListModel<String> defaultListModel;
	private DefaultListModel<String> defaultListModel2;
	private JList<String> list2;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private GridBagConstraints gbc;

	public PanelIFDASelectOptions(Controller control, String actionAccept, String actionBack, Object[] listLeft,String nameApp,  String mssDescription) {
		lblNameApp = new JLabel(nameApp);
		lblDescription = new JLabel(mssDescription);

		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(actionAccept);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(actionBack);
		btnCancelOption.addActionListener(control);
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.init(listLeft);
	}

	private void assignValues(AbstractBorder brd) {
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 14);
		lblNameApp.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 14);
		lblDescription.setFont(fuente);
	}
	
	public void setListOptions(Object[] listLeft) {
        defaultListModel.removeAllElements();
        defaultListModel2.removeAllElements();
		for (int i = 0; i < listLeft.length; i++) {
        	defaultListModel.addElement(listLeft[i].toString());
		}
	}
	
	public ArrayList<String> getListOptionsSelected() {
		ArrayList<String> listOptionsSelected = new ArrayList<String>();
		for (int i = 0; i < list2.getModel().getSize(); i++) {
			listOptionsSelected.add(list2.getModel().getElementAt(i));
		}
		return listOptionsSelected;
	}
	
	private JPanel panelSelectOptions(Object[] listLeft) {
		JPanel panel = new JPanel();
		JPanel panelM = new JPanel();
		panel.setBackground(Color.WHITE);
		panelM.setBackground(Color.WHITE);
		defaultListModel = new DefaultListModel<String>();
		if (listLeft != null) {
			for (int i = 0; i < listLeft.length; i++) {
				defaultListModel.addElement(listLeft[i].toString());
			}
		}
        defaultListModel2 = new DefaultListModel<String>();

        JList<String> list = new JList<String>();
//        list.setPreferredSize(new Dimension(200, 100));
        list.setModel(defaultListModel);
        
        list2 = new JList<String>();
        list2.setPreferredSize(new Dimension(200, 100));
        defaultListModel2.removeAllElements();
        list2.setModel(defaultListModel2);

        ButtonGeneral btnAdd = new ButtonGeneral("Add >>", 150,30);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultListModel<String>)list2.getModel()).addElement(list.getSelectedValue());
                int index = list.getSelectedIndex();
                defaultListModel.remove(index);
//                list.remove(index);
                list.setModel(defaultListModel);
//                list.repaint();
            }
        });
        
        ButtonGeneral btnRemove = new ButtonGeneral("Remove <<", 150,30);
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultListModel<String>)list.getModel()).addElement(list2.getSelectedValue());
                int index = list2.getSelectedIndex();
                defaultListModel2.remove(index);
//                list.remove(index);
                list2.setModel(defaultListModel2);
//                list.repaint();
            }
        });
        
        ButtonGeneral btnAddAll = new ButtonGeneral(">> Add All >>", 150,30);
        btnAddAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for (int i = 0; i < list.getModel().getSize(); i++) {
            		 ((DefaultListModel<String>)list2.getModel()).addElement(list.getModel().getElementAt(i));
				}
            	defaultListModel.removeAllElements();
                list.setModel(defaultListModel);
            }
        });
        
        ButtonGeneral btnRemoveAll = new ButtonGeneral("<< Remove All <<", 150,30);
        btnRemoveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for (int i = 0; i < list2.getModel().getSize(); i++) {
            		 ((DefaultListModel<String>)list.getModel()).addElement(list2.getModel().getElementAt(i));
				}
            	defaultListModel2.removeAllElements();
                list2.setModel(defaultListModel2);
            }
        });
        
        panelM.setLayout(new GridBagLayout());
        GridBagConstraints x = new GridBagConstraints();
        x.gridwidth = GridBagConstraints.REMAINDER;
        x.insets = new Insets(0, 0, 25, 0);
        panelM.add(btnAdd, x);
        panelM.add(btnAddAll, x);
        panelM.add(btnRemove, x);
        panelM.add(btnRemoveAll, x);
        
        panel.setLayout(new BorderLayout(5, 5));
        JScrollPane scrollList = new JScrollPane( list, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollList.setPreferredSize(new Dimension(300, 300));
        scrollList.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));
        panel.add(scrollList, BorderLayout.WEST);
        
        JScrollPane scrollList2 = new JScrollPane( list2, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollList2.setPreferredSize(new Dimension(300, 300));
        scrollList2.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));

        panel.add(scrollList2, BorderLayout.EAST);
        panel.add(panelM, BorderLayout.CENTER);
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

	private void init(Object[] listLeft) {
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
		add(this.panelSelectOptions(listLeft), gbc);
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
