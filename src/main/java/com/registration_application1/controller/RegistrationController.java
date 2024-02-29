package com.registration_application1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registration_application1.model.DAOService;
import com.registration_application1.model.DAOServiceImpl;


@WebServlet("/saveReg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
   	 rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session = request.getSession(true);
	 session.setMaxInactiveInterval(10);
	   if(session.getAttribute("email")!=null) {
		   
		   
		   String name = request.getParameter("name");
	     String city = request.getParameter("city");
	     String email = request.getParameter("email");
	     String mobile = request.getParameter("mobile");
	     
	     DAOService service = new DAOServiceImpl();
	     service.connectDB();
	     boolean statusOfEmail = service.existsByEmail(email);
	     if(statusOfEmail) {
	    	 request.setAttribute("msg", "Email ID exists");
	    	 
	     }else {
	    	 service.saveRegistration(name,city,email,mobile);
	    	 request.setAttribute("msg", "Record is saved!!");
	     }
	     
	     
	     
	     RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
    	 rd.forward(request, response);  
	     
		   
		   
	   } else {
		   RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	    	 rd.forward(request, response);
	   }
		 
	}
	

}
