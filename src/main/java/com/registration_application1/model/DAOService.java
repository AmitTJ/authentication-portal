package com.registration_application1.model;
//Abstraction

import java.sql.ResultSet;

public interface DAOService {
	
	public void connectDB();
	public boolean verifyLogin(String username, String password);
	public void saveRegistration(String name,String city, String email, String mobile);
	public boolean existsByEmail(String email);
	public ResultSet getAllRegistrations();
	public void deleteByEmail(String email);
	public void updateRegistration(String email, String mobile);
	
	
	
}
