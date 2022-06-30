package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;

public class PanelViewCriteriosCreated extends JPanel{
	private JLabel lblNameApp;
	private GridBagConstraints gbc;
	
	public PanelViewCriteriosCreated(Object[] listOption, String nameApp) {
		gbc = new GridBagConstraints();
		lblNameApp = new JLabel(nameApp);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		this.assignOptions(listOption);
		
	}
	
	public void assignOptions(Object[] list) {
		this.removeAll();
		gbc.anchor = GridBagConstraints.CENTER;
		add(lblNameApp, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.insets = new Insets(10, 0, 10, 10);
		add(new JLabel("Name "), gbc);
		add(new JLabel("  U  "), gbc);
		add(new JLabel("  V  "), gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel("  Pi "), gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
		String nameOption;
		JLabel lblOption;
		JTextField txtValueU;
		JTextField txtValueV;
		JTextField txtValuePi;
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				gbc.gridwidth = GridBagConstraints.RELATIVE;
				nameOption = list[i].toString();
				String[] partsVariable = nameOption.split(",");
				String name = partsVariable[0];
				String u = partsVariable[1];
				String v = partsVariable[2];
				String pi = partsVariable[3];
				lblOption = new JLabel(name);
				txtValueU = new JTextField(u);
				txtValueV = new JTextField(v);
				txtValuePi = new JTextField(pi);
				txtValueU.setEditable(false);
				txtValueV.setEditable(false);
				txtValuePi.setEditable(false);
				Border border = new TextBubbleBorder(new Color(79,185,192), 1, 5);
				txtValueU.setBackground(Color.white);
				txtValueV.setBackground(Color.WHITE);
				txtValuePi.setBackground(Color.WHITE);
				txtValueU.setBorder(border);
				txtValueV.setBorder(border);
				txtValuePi.setBorder(border);
				gbc.insets = new Insets(5, 0, 0, 10);
				add(lblOption, gbc);
				add(txtValueU, gbc);
				add(txtValueV, gbc);
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				add(txtValuePi, gbc);
				
			}
		}
		
	}
	
	
	
}
