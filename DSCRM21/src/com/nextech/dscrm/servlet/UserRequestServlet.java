package com.nextech.dscrm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nextech.dscrm.pojo.UserRequest;
import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class UserRequestServlet
 */
@WebServlet("/UserRequestServlet")
public class UserRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside goGet login");
//		request.getRequestDispatcher("/userRequest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	 
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String requirement = request.getParameter("requirementDescription");
	        String mobile = request.getParameter("mobile");
	 
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = (Connection) DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/dscrm", "root", "root");
	 
	            PreparedStatement ps = ((java.sql.Connection) con)
	                    .prepareStatement("insert into USERREQUEST values(?,?,?,?)");
	 
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, requirement);
	            ps.setString(4, mobile);
	 
	            int i = ps.executeUpdate();
	            if (i > 0)
	                out.print("You are successfully registered...");
	 
	        } catch (Exception e2) {
	            System.out.println(e2);
	        }
	 
	        out.close();
	        request.getRequestDispatcher("/userRequest.JSP").forward(request, response);
	        System.out.println("Inside post login");
	}
	public int saveUserRequest(UserRequest userRequest)
	{
		return 0;
		
	}

}
