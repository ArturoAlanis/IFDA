package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.ButtonUI;

public class PanelChooseOptions extends JPanel{
	private ButtonGroup buttonGroup;
	private GridBagConstraints gbc;
	
	public PanelChooseOptions(Object[] listOption) {
		buttonGroup = new ButtonGroup();
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		this.assignOptions(listOption);
		
	}
	
	public void assignOptions(Object[] list) {
		this.removeAll();
		JRadioButton button;
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				button = new JRadioButton(list[i].toString());
				button.setActionCommand(list[i].toString());
				button.setBackground(Color.WHITE);
				gbc.anchor = GridBagConstraints.NORTHWEST;
				buttonGroup.add(button);
				add(button, gbc);
			}
		}
	}
	
	public String getOptionSelected() throws IOException {
		if (buttonGroup.getSelection().getActionCommand() != null) {
			return buttonGroup.getSelection().getActionCommand();
		}
		return " ";
	}
	
	
}
