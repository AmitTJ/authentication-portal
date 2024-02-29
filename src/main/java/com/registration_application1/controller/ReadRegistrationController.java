package com.registration_application1.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registration_application1.model.DAOService;
import com.registration_application1.model.DAOServiceImpl;


@WebServlet("/allReg")
public class ReadRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadRegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(10);
		   if(session.getAttribute("email")!=null) {
		DAOService service= new DAOServiceImpl();
	    service.connectDB();
	    ResultSet result = service.getAllRegistrations();
	    request.setAttribute("res", result);
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/show_registrations.jsp");
	   	 rd.forward(request, response);
	   }else {
		   RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	    	 rd.forward(request, response);		   
	   }
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
