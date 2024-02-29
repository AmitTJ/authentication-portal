package com.registration_application1.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration_application1.model.DAOService;
import com.registration_application1.model.DAOServiceImpl;


@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String email = request.getParameter("email");
	  System.out.println(email);
	  DAOService service= new DAOServiceImpl();
	  service.connectDB();
	  service.deleteByEmail(email);
	  ResultSet result = service.getAllRegistrations();
	  request.setAttribute("res", result);
	  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/show_registrations.jsp");
	  rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
