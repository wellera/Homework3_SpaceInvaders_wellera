package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Tester {

	public static void main(String[] args) {
		//DbUtilities db = new DbUtilities();
		
		 int userID = 88;
		 String lastName = "Weller";
		 String firstName = "Ali";
		 String email = "wellera@edc.pitt.edu";
		 String password = "test123";
		
		
		//db.executeQuery(sql);
		
		 
	
			try{
				DbUtilities db = new DbUtilities();
				String sql = "UPDATE users SET lastName='" + lastName + "', firstName='" + firstName + "',  "
						+ "email='" + email + "', password=MD5('" + password + "') "
								+ "WHERE userID = '" + userID + "' ";
				
				db.executeQuery(sql);
				
				//ResultSet rs = db.getResultSet(sql);
				//db.executeQuery(sql);
			db.closeDbConnection(); // Close connection
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "There was an error connecting to the database. Please try again.");
			}
		
		
		
		/*
		String sql = "INSERT INTO users (lastName,firstName,email,password) ";
		sql = sql + "VALUES('Test', 'Alison', 'alison.test@pitt.edu', MD5('test456'));";
		String lastName ="Weller", firstName="Alison", email="wellera@pitt.edu", password="test987";
		sql = sql + "VALUES('" + lastName + "', '" + firstName + "', '" + email + "', MD5('" + password + "'));";
		 */
		
		//db.executeQuery(sql);
		
		//sql = "SELECT * FROM users;";
		
		/*
		String email = "dmb72@pitt.edu";
		String password = "test123";
		
		
		String sql = "SELECT * FROM users WHERE email = '" + email + "' AND password = MD5('" + password + "');";
		
		System.out.println(sql);
		
		try{
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()){
				System.out.println("TRUE");
			}
			else{
				System.out.println("FALSE");
			}
			
			while(rs.next()){
				System.out.print(rs.getInt("userID") + "\t");
				System.out.print(rs.getString("lastName") + "\t");
				System.out.print(rs.getString("firstName") + "\t");
				System.out.print(rs.getString("email"));
				System.out.println()
			}
			
			db.closeDbConnection(); // Close connection
		}
		catch(Exception ex){
			// Handle here
		}*/
	}

}
