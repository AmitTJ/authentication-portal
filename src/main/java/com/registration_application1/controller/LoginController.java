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


@WebServlet("/verifylogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String email = request.getParameter("email");
	     String password = request.getParameter("password");
	     
	     DAOService service= new DAOServiceImpl();
	     service.connectDB();
	     boolean status = service.verifyLogin(email,password);
	     if(status) {
	    	 HttpSession session = request.getSession(true);
	    	 session.setAttribute("email", email);
	    	 session.setMaxInactiveInterval(10);
	    	 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
	    	 rd.forward(request, response);
	     }else {
	    	 request.setAttribute("error", "Invalid username/password");
	    	 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	    	 rd.forward(request, response);
	    	 
	     }
	     
	     
	}

}
