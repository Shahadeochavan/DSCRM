package com.nextech.dscrm.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.nextech.dscrm.pojo.UserRequest;

/**
 * Servlet implementation class UserRequestServlet
 */
@WebServlet("/UserRequestServlet")
public class UserRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRequest userRequest;
	static String loginName;
	       static String email;
	       static String Requerment;
	       static String contact;
	       static String userid;

	public UserRequestServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*try {
			int rowid=UserRequestServlet.saveUserRequest(userRequest,request);
			if(rowid==0) {
				request.getRequestDispatcher("/userRequestFailure.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/update.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} */
		//this is  upadte method
		try
		{
			int id=UserRequestServlet.update(userRequest,request);
			 if(id ==0)
			 {
					request.getRequestDispatcher("/updateFailure.jsp").forward(request, response);
				 
			 }
			 else
			 {
				 request.getRequestDispatcher("/updateSuccess.jsp").forward(request, response);
			 }
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("i am in post method");
	}
	public static int saveUserRequest(UserRequest userRequest, HttpServletRequest request) throws ClassNotFoundException {
		userRequest = new UserRequest();

		  request.getParameter("name");
		  request.getParameter("email");
		request.getParameter("requirementDescription");
		request.getParameter("mobile");
		ResultSet rs=null;

		String sql = "insert into userrequest(name,email,descrption,mobile_number) values ('"+loginName+"','"+email+"','"+contact+"','"+Requerment+"');";
		Connection conn=null;
		int generatedKey = 0;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dscrm","root","root");
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}
			userRequest.setName(loginName);
			userRequest.setEmail(email);
			userRequest.setMobilenumber(contact);
			userRequest.setRequerment(Requerment);

			System.out.println("Inserted record's ID: " + generatedKey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedKey;
	}
	 public static int update(UserRequest userRequest,HttpServletRequest request) throws ClassCastException, SQLException
     {
		 System.out.println("i am in update");
		 userRequest = new UserRequest();

		  request.getParameter("name");
		  request.getParameter("email");
		request.getParameter("requirementDescription");
		request.getParameter("mobile");
		request.getParameter("userid");
		ResultSet rs=null;
         String sql = "update userrequest set (name,email,descrption,mobile_number)VALUES('"+loginName+"','"+email+"','"+contact+"','"+Requerment+"',where id=?);";
         Connection con = null;
         PreparedStatement prep = null;
         int id=0;

         try
         {
             Class.forName("com.mysql.jdbc.Driver");
             con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dscrm", "root", "root");
             prep = con.prepareStatement(sql);
             prep.execute();
           
			rs.getInt(id);
             userRequest.setName(loginName);
 			userRequest.setEmail(email);
 			userRequest.setMobilenumber(contact);
 			userRequest.setRequerment(Requerment);


         } 
         catch (ClassNotFoundException e)
         {
             // TODO Auto-generated catch block
             e.printStackTrace();

         }
         return id;
     }

	
}
