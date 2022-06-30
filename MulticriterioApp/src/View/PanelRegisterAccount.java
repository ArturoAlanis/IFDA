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

import Control.Controller;

public class PanelRegisterAccount extends JPanel {
	private JLabel lblImgApp;
	private JLabel lblNameApp;
	private JLabel lblAccount;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblBirthday;
	private JTextField txtBirthday;
	private JLabel lblGender;
	private JComboBox<Object> cbxGender;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel email;
	private JLabel confirmationEmail;
	private JTextField txtEmail;
	private JTextField txtConfEmail; 
	private JLabel lblPswEmail;
	private JLabel lblconfirmationPswEmail;
	private JPasswordField pswEmail;
	private JPasswordField confirmationPswEmail;
	private ButtonGeneral btnStartSection;
	private ButtonGeneral btnRegister;
	private GridBagConstraints gbc;

	public PanelRegisterAccount(Controller control) {
		lblImgApp = new JLabel();
		Image imgn = new ImageIcon("data/ff.jpg").getImage();
		ImageIcon imgn2 = new ImageIcon(imgn.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		lblImgApp.setIcon(imgn2);
		
		lblNameApp = new JLabel("Software Efficiency - Multi-criteria");
		Image img = new ImageIcon("data/login.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		lblAccount = new JLabel("¡Sign up!");
		lblAccount.setIcon(img2);
		
		lblName = new JLabel("First Name");
		txtName = new JTextField(15);
		lblLastName  = new JLabel("Last Name");;
		txtLastName = new JTextField(15);;
		lblBirthday  = new JLabel("Date of birth");;
		txtBirthday = new JTextField(10);;
		lblGender  = new JLabel("Gender ");;
		cbxGender = new JComboBox<Object>();
		lblPhone = new JLabel("Telephone");;
		txtPhone= new JTextField(15);;
		email = new JLabel("E-mail");;
		txtEmail = new JTextField(15);
		confirmationEmail = new JLabel("E-mail Confirmation");;
		txtConfEmail = new JTextField(15); 
		lblPswEmail = new JLabel("Password");
		pswEmail = new JPasswordField(15);
		lblconfirmationPswEmail = new JLabel("Password Confirmation ");
		confirmationPswEmail = new JPasswordField(15);
		
		
//		
//		lblUser = new JLabel("Usuario ");
//		txtUser = new JTextField(15);
//		lblPassword = new JLabel("Contraseña ");
//		txtPassword = new JPasswordField(15);
		btnStartSection = new ButtonGeneral("Sign up", 150, 25);
		btnStartSection.setActionCommand(IoManager.REGISTER_USER_SAVE);
		btnStartSection.addActionListener(control);
		btnRegister = new ButtonGeneral(150, 25, null, "Cancel ");
		btnRegister.setActionCommand(IoManager.CANCEL_REGISTER_USER);
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
		GridBagConstraints x = new GridBagConstraints();
		panel.setPreferredSize(getPreferredSize());
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
		panel.add(confirmationEmail, x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(txtEmail, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(txtConfEmail,x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(lblPswEmail, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(lblconfirmationPswEmail,x);
		x.gridwidth = GridBagConstraints.RELATIVE;
		panel.add(pswEmail, x);
		x.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(confirmationPswEmail, x);
		panel.setPreferredSize(new Dimension(700, 200));
		panel.setBackground(Color.WHITE);
		return panel;
	}
	
	public JPanel buildButtons() {
		JPanel panell = new JPanel();
		panell.setLayout(new GridBagLayout());
		panell.setBackground(Color.RED);
		GridBagConstraints y = new GridBagConstraints();
		panell.add(btnStartSection, y);
		panell.add(btnRegister, y);
		return panell;
	}
	
	public void cleanAllCamps() {
		txtName.setText("");
		txtLastName.setText("");
		txtBirthday.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtConfEmail.setText("");
		pswEmail.setText("");
		confirmationPswEmail.setText("");
	}

	private void init() {
		removeAll();
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		add(lblImgApp, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(lblNameApp, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(130, 0, 20, 0);
		add(lblAccount, gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
//		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		add(this.panelRegister(), gbc);
		gbc.insets = new Insets(0, 0, 60, 0);
		add(this.buildButtons(), gbc);
	}

	

}
