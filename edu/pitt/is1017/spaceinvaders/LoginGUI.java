package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class LoginGUI {

	private JFrame frame;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblPassword;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // we will cover this piece later in the semester
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(39, 34, 73, 16);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(114, 29, 209, 26);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(39, 72, 73, 16);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(114, 67, 209, 26);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					String email = txtEmail.getText();
					String password = txtPassword.getText();
					User user = new User(email, password);

					if(user.isLoggedIn() == true){
						JOptionPane.showMessageDialog(null, "Login successful! Welcome.");
					}
					else{
						JOptionPane.showMessageDialog(null, "Login failed. Please check your email and password and try again.");
					}
			}
		});
		btnLogin.setBounds(146, 122, 79, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(39, 122, 95, 29);
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();//close the application
			}
		});
		btnCancel.setBounds(237, 122, 86, 29);
		frame.getContentPane().add(btnCancel);
	}
}
