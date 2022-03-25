package com.sapient.aem.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.EmployeeException;
import com.sapient.aem.model.Employee;
import com.sapient.aem.service.EmployeeService;
import com.sapient.aem.service.EmployeeServiceImpl;


@WebServlet("/post-edit")
public class PostEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(PostEditServlet.class);
	private EmployeeService employeeService= new EmployeeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the form data
			Integer empno= Integer.parseInt(request.getParameter("empno"));
			String ename= request.getParameter("ename");
			String job= request.getParameter("job");
			Integer mgr= Integer.parseInt(request.getParameter("mgr"));
			//yyyy-mm-dd
			String hiredate=request.getParameter("hiredate");
			Double sal= Double.parseDouble(request.getParameter("sal"));
			Double comm= Double.parseDouble(request.getParameter("comm"));
			Integer deptno= Integer.parseInt(request.getParameter("deptno"));
			// Sanitize the form data
			//TODO
			
			// Populate the Employee object
			if(mgr==0) {
				mgr=null;
			}
			
			if(comm==0.0) {
				comm=null;
			}
			Employee employee= 
					new Employee(empno,ename,job,mgr,LocalDate.parse(hiredate),sal,comm,deptno);
			
			String status= employeeService.updateEmployee(employee);
			response.getWriter().println("<html><body><h4>"+status+"</h4></body></html>");
			
			request.getRequestDispatcher("allemp")
						.include(request, response);
		}catch(EmployeeException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
