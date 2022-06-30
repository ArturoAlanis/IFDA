package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import Control.Controller;

public class PanelAccount extends JPanel {
	private JLabel lblImgApp;
	private JLabel lblNameApp;
	private JLabel lblAccount;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private ButtonGeneral btnStartSection;
	private JLabel lblRegisterUser;
	private ButtonGeneral btnRegister;
	private PanelChoose panelChoose;
	private ButtonGeneral btnSelectOption;
	private GridBagConstraints gbc;

	public PanelAccount(Controller control) {
		lblImgApp = new JLabel();
		Image imgn = new ImageIcon("data/ff.jpg").getImage();
		ImageIcon imgn2 = new ImageIcon(imgn.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		lblImgApp.setIcon(imgn2);
		
		lblNameApp = new JLabel("Software efficiency - Multi-criteria");
		Image img = new ImageIcon("data/login.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		lblAccount = new JLabel("Log in");
		lblAccount.setIcon(img2);
		lblUser = new JLabel("User ");
		txtUser = new JTextField(15);
		lblPassword = new JLabel("Password ");
		txtPassword = new JPasswordField(15);
		btnStartSection = new ButtonGeneral("Log in", 150, 25);
		btnStartSection.setActionCommand(IoManager.START_SESION);
		btnStartSection.addActionListener(control);
		lblRegisterUser = new JLabel("¿Do not have account? ¡Sign up! ");
		btnRegister = new ButtonGeneral("Sign up ", 250, 25);
		btnRegister.setActionCommand(IoManager.REGISTER_USER);
		btnRegister.addActionListener(control);
		btnSelectOption = new ButtonGeneral("Select Option", 150,25);
		btnSelectOption.setActionCommand(IoManager.SELECT_OPTION_APP);
		btnSelectOption.addActionListener(control);
		panelChoose = new PanelChoose("Select method / application", this.listOptions().toArray());
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.init();
	}
	
	private ArrayList<String> listOptions(){
		ArrayList<String> listOptions = new ArrayList<String>();
		listOptions.add("IFDA");
		listOptions.add("IFIS");
		listOptions.add("TOPSIS");
		listOptions.add("Otro");
		return listOptions;
	}
	
	public String getOptionSelected() throws IOException {
		return panelChoose.getOptionSelected();
	}

	private void assignValues(AbstractBorder brd) {
		Image imgAccountUser = new ImageIcon("data/usuario.jpg").getImage();
		ImageIcon imgAccountUser2 = new ImageIcon(imgAccountUser.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		lblUser.setIcon(imgAccountUser2);
		Image imgAccountPasswd = new ImageIcon("data/contra.png").getImage();
		ImageIcon imgAccountPasswd2 = new ImageIcon(imgAccountPasswd.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		lblPassword.setIcon(imgAccountPasswd2);
		Border borderLine = BorderFactory.createMatteBorder(0, 0, 10, 0, Color.BLUE);
		lblNameApp.setBorder(borderLine);
		borderLine = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY);
		lblAccount.setForeground(Color.BLUE);
		txtUser.setBorder(borderLine);
		txtPassword.setBorder(borderLine);
		Font fuente = new Font("Calibri", 3, 50);
		lblNameApp.setFont(fuente);
		fuente = new Font("Calibri", 3, 14);
		txtUser.setFont(fuente);
		fuente = new Font("Arial Black", 3, 14);
		lblAccount.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 14);
		lblUser.setFont(fuente);
		lblPassword.setFont(fuente);
		lblRegisterUser.setFont(fuente);
		txtUser.setText("andres@email.com");
		txtPassword.setText("hr");
	}
	
	

	public void init() {
		removeAll();
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		add(lblImgApp, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(lblNameApp, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.CENTER;
//		add(lblImgAccount, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(120, 0, 20, 0);
		add(lblAccount, gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
//		gbc.anchor = GridBagConstraints.WEST;
		add(lblUser, gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		add(txtUser, gbc);
		add(lblPassword, gbc);
		add(txtPassword, gbc);
		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
//		gbc.gridwidth = GridBagConstraints.RELATIVE;
		add(btnStartSection, gbc);
		add(lblRegisterUser, gbc);
		gbc.insets = new Insets(0, 0, 150, 0);
		add(btnRegister, gbc);
	}

	public String getUser() {
		return txtUser.getText();
	}

	public String getPassword() {
		return txtPassword.getText();
	}

	public void cleanAllsCamps() {
		txtUser.setText("");
		txtPassword.setText("");
	}
	
	public void startSesion() {
		removeAll();
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		add(lblImgApp, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(lblNameApp, gbc);
	}
	
	public void selectApp() {
		removeAll();
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		add(lblImgApp, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(lblNameApp, gbc);
		add(panelChoose, gbc);
		gbc.insets = new Insets(20, 0, 0, 0);
		add(btnSelectOption, gbc);
	}

}
