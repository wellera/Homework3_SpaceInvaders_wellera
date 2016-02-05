package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterGUI {

	private JFrame frame;
	JLabel lblFirstName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI window = new RegisterGUI();
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
	public RegisterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(20, 24, 118, 16);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(20, 52, 118, 16);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 108, 118, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 80, 118, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(20, 136, 118, 16);
		frame.getContentPane().add(lblConfirmPassword);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(165, 19, 160, 26);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(165, 47, 160, 26);
		frame.getContentPane().add(txtLastName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(165, 75, 160, 26);
		frame.getContentPane().add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(165, 103, 160, 26);
		frame.getContentPane().add(txtPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(165, 131, 160, 26);
		frame.getContentPane().add(txtConfirmPassword);
		
		JButton btnRegister = new JButton("Register");
		
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					String lastName = txtLastName.getText();
					String firstName = txtFirstName.getText();
					String email = txtEmail.getText();
					String password = txtPassword.getText();
					String confirmPassword = txtConfirmPassword.getText();
					
					
					if (lastName.length() < 1 || firstName.length() < 1 || email.length() < 1 || password.length() < 1 || confirmPassword.length() < 1){
						JOptionPane.showMessageDialog(null, "Please fill in all fields and try again.");
					}
					else if (!password.equals(confirmPassword)){
						JOptionPane.showMessageDialog(null, "Your passwords do not match. Please try again.");
					}
					else if(password.equals(confirmPassword)){
						User user = new User(lastName, firstName, email, password);
						if (user.isLoggedIn() == true){
						JOptionPane.showMessageDialog(null, "Registration successful! Welcome, " + firstName + "!");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
					}
			}
		});
		
		btnRegister.setBounds(162, 170, 93, 29);
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();//close the application
			}
		});
		btnCancel.setBounds(255, 170, 72, 29);
		frame.getContentPane().add(btnCancel);
	}

}
