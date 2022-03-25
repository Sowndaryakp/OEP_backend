package com.sapient.aem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.service.EmployeeService;
import com.sapient.aem.service.EmployeeServiceImpl;


@WebServlet("/delete-emp")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(DeleteEmployeeServlet.class);
	private EmployeeService employeeService= new EmployeeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer empno= Integer.parseInt(request.getParameter("id"));
			String status=employeeService.deleteEmployee(empno);
			response.getWriter().println("<html><body><h4>"+status+"</h4></body></html>");
			
			request.getRequestDispatcher("allemp")
						.include(request, response);
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
