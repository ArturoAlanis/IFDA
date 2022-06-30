package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.Controller;

public class PanelInformation extends JDialog {
	private JLabel lblMessage1;
	private JLabel txtMessage2;
	private ButtonGeneral btnAccept;
	private GridBagConstraints gbc;

	public PanelInformation(Controller control, String message1, String message2, boolean isError) {
		lblMessage1 = new JLabel(message1 + " ");
		txtMessage2 = new JLabel(message2);
		btnAccept = new ButtonGeneral("ACCEPT", 100, 25);
		btnAccept.setActionCommand(IoManager.CLOSE_INFORMATION);
		btnAccept.addActionListener(control);
		setLayout(new GridBagLayout());
		if (isError) {
			this.getContentPane().setBackground(new Color(255, 236, 0));
		} else {
			this.getContentPane().setBackground(new Color(94, 249, 63));
		}
		this.setUndecorated(true);
		this.setSize(450, 200);
		Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
		this.setShape(forma);
		this.setModal(true);
		setLocationRelativeTo(null);
		this.assignValues();
		this.initializer();
	}

	private void assignValues() {
		Font font = new Font("Arial Black", 3, 16);
		lblMessage1.setFont(font);
		lblMessage1.setForeground(Color.BLACK);
		font = new Font("Calibri", 3, 12);
		txtMessage2.setFont(font);
		txtMessage2.setForeground(Color.BLACK);
	}

	private void initializer() {
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 0, 10, 0);
		add(lblMessage1, gbc);
		gbc.insets = new Insets(0, 0, 20, 0);
		add(txtMessage2, gbc);
		gbc.anchor = GridBagConstraints.EAST;
		add(btnAccept, gbc);
	}

}
