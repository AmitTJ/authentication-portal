package com.registration_application1.model;

import java.sql.*;
// Inheritance
public class DAOServiceImpl implements DAOService {
	  private Connection con;
	  private Statement stmnt;
	  
	  //polymorphism
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_app_100", "root", "Amit19821289");
		     stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public boolean verifyLogin(String username, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+username+"' and password='"+password+"'");
		     return result.next();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
		 stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		     
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


@Override
	public boolean existsByEmail(String email) {
	try {
		ResultSet result = stmnt.executeQuery("select * from registration where email='"+email+"'");
	     return result.next();
	
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}


	@Override
	public ResultSet getAllRegistrations() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration ");
		     return result;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public void deleteByEmail(String email) {
		try {
			 stmnt.executeUpdate("delete from registration where email='"+email+"'");
			     
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}



	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			 stmnt.executeUpdate("update registration SET mobile='"+mobile+"' WHERE email='"+email+"'");
			     
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}



	


	//stmnt.executeUpdate("update registration SET mobile='"+mobile+"' WHERE email='"+email+"'");
	
	
}
