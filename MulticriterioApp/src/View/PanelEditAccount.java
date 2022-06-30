package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.time.chrono.JapaneseDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Control.Controller;

public class PanelEditAccount extends JPanel {
	private JLabel lblImgApp;
	private JLabel lblNameApp;
	private JLabel lblAccount;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblBirthday;
	private JTextField txtBirthday;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel email;
	private JTextField txtEmail;
	private JTextField txtCredentialPassword; 
	private JLabel lblPswEmail;
	private JPasswordField pswEmail;
	private JLabel lblMssConfirm;
	private JLabel lblPswActual;
	private ButtonGeneral btnConfirmPswActual;
	private JTextField txtNewPassword;
	private JTextField txtConfirmNewPassword;
	private ButtonGeneral btnAcceptChangePassword;
	private ButtonGeneral btnStartSection;
	private ButtonGeneral btnRegister;
	private GridBagConstraints gbc;

	public PanelEditAccount(Controller control) {
		lblImgApp = new JLabel();
		Image imgn = new ImageIcon("data/ff.jpg").getImage();
		ImageIcon imgn2 = new ImageIcon(imgn.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		lblImgApp.setIcon(imgn2);
		
		lblNameApp = new JLabel("Software Efficiency - Multi-criteria");
		Image img = new ImageIcon("data/login.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		lblAccount = new JLabel("___________Edit account____________");
		lblAccount.setIcon(img2);
		
		lblName = new JLabel("First Name");
		txtName = new JTextField(15);
		lblLastName  = new JLabel("Last Name");;
		txtLastName = new JTextField(15);;
		lblBirthday  = new JLabel("Date of Birth");;
		txtBirthday = new JTextField(10);;
		lblPhone = new JLabel("Telephone");;
		txtPhone= new JTextField(15);;
		email = new JLabel("E-mail");;
		txtEmail = new JTextField(15);
		txtCredentialPassword = new JTextField(15); 
		lblPswEmail = new JLabel("Password");
		pswEmail = new JPasswordField(15);
		lblMssConfirm = new JLabel("If you want to change your password, confirm the current password");
		lblPswActual = new JLabel("Current password");
		btnConfirmPswActual = new ButtonGeneral("Confirm ", 150, 30);
		btnConfirmPswActual.setActionCommand(IoManager.CONFIRM_PSW_ACTUAL);
		btnConfirmPswActual.addActionListener(control);
		txtNewPassword = new JPasswordField(15);
		txtConfirmNewPassword = new JPasswordField(15);
		btnAcceptChangePassword = new ButtonGeneral("Change Password", 150, 30);
		btnAcceptChangePassword.setActionCommand(IoManager.ACCEPT_CHANGE_PASSWORD);
		btnAcceptChangePassword.addActionListener(control);
//		lblUser = new JLabel("Usuario ");
//		txtUser = new JTextField(15);
//		lblPassword = new JLabel("Contraseña ");
//		txtPassword = new JPasswordField(15);
		btnStartSection = new ButtonGeneral("Save", 150, 25);
		btnStartSection.setActionCommand(IoManager.SAVE_CHANGES_EDIT);
		btnStartSection.addActionListener(control);
//		lblRegisterUser = new JLabel("¿No tienes una cuenta? ¡Regístrate! ");
		btnRegister = new ButtonGeneral("Cancel ", 150, 25);
		btnRegister.setActionCommand(IoManager.CANCEL_FIRST_PROCESS);
		btnRegister.addActionListener(control);
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.init();
	}

	private void assignValues(AbstractBorder brd) {
		Image imgAccountUser = new ImageIcon("data/usuario.jpg").getImage();
		ImageIcon imgAccountUser2 = new ImageIcon(imgAccountUser.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
//		lblUser.setIcon(imgAccountUser2);
		Image imgAccountPasswd = new ImageIcon("data/contra.png").getImage();
		ImageIcon imgAccountPasswd2 = new ImageIcon(imgAccountPasswd.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
//		lblPassword.setIcon(imgAccountPasswd2);
		Border borderLine = BorderFactory.createMatteBorder(0, 0, 10, 0, Color.BLUE);
		lblNameApp.setBorder(borderLine);
		borderLine = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY);
		lblAccount.setForeground(Color.BLUE);
//		txtUser.setBorder(borderLine);
//		txtPassword.setBorder(borderLine);
		Font fuente = new Font("Calibri", 3, 50);
		lblNameApp.setFont(fuente);
		fuente = new Font("Calibri", 3, 14);
//		txtUser.setFont(fuente);
		fuente = new Font("Arial Black", 3, 14);
		lblAccount.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 14);
//		lblUser.setFont(fuente);
//		lblPassword.setFont(fuente);
//		lblRegisterUser.setFont(fuente);
//		txtUser.setText("andresfw2");
//		txtPassword.setText("hr");
	}
	
	private JPanel panelRegister() {
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(""));
		GridBagConstraints x = new GridBagConstraints();
//		panel.setPreferredSize(getPreferredSize());
		panel.setLayout(new GridBagLayout());
		x.anchor = GridBagConstraints.CENTER;
		panel.add(lblName, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(lblLastName, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(txtName, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtLastName, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblBirthday, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(lblPhone, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(txtBirthday, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtPhone, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(email, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add( lblPswEmail , x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(txtEmail, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(pswEmail ,x);
		panel.add(lblMssConfirm, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblPswActual, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(new JLabel("          "), x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(txtCredentialPassword, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(btnConfirmPswActual, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(new JLabel("Nueva Contraseña"), x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(new JLabel("Confirmar Nueva Contraseña"), x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(txtNewPassword,x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtConfirmNewPassword,x);
		panel.add(btnAcceptChangePassword,x);
//		panel.setPreferredSize(new Dimension(700, 200));
		panel.setBackground(Color.WHITE);
		return panel;
	}
	
	public JPanel buildButtons() {
		JPanel panell = new JPanel();
		panell.setLayout(new GridBagLayout());
		panell.setBackground(Color.WHITE);
		GridBagConstraints y = new GridBagConstraints();
		panell.add(btnStartSection, y);
		y.insets = new Insets(0, 15, 0, 0);
		panell.add(btnRegister, y);
		return panell;
	}
	
	public void setData(String name, String lastName, String birthday, String phone, String email, String password) {
		txtName.setText(name);
		txtLastName.setText(lastName);
		txtBirthday.setText(birthday);
		txtPhone.setText(phone);
		txtEmail.setText(email);
		pswEmail.setText(password);
		txtEmail.setEditable(false);
		pswEmail.setEditable(false);
	}

	private void init() {
		removeAll();
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 80, 0);
		add(lblImgApp, gbc);
		gbc.insets = new Insets(0, 0, 80, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(lblNameApp, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(lblAccount, gbc);
		gbc.insets = new Insets(0, 0, 100, 0);
//		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		add(this.panelRegister(), gbc);
		gbc.insets = new Insets(0, 0, 50, 0);
		add(this.buildButtons(), gbc);
	}
	
	public void cleanAllCamps() {
		txtCredentialPassword.setText("");
		txtNewPassword.setText("");
		txtConfirmNewPassword.setText("");
	}

	

}
