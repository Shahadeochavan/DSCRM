package com.nextech.dscrm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
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

	static int userid;

	public UserRequestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			int rowid = UserRequestServlet
					.saveUserRequest(userRequest, request);
			if (rowid> 0) {
				 out.print("<p>Record saved successfully!</p>"); 
				 request.getRequestDispatcher("userRequest.jsp").forward(request, response);  
			} else {
				 out.println("Sorry! unable to save record");  
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		UserRequestServlet userrequest=new UserRequestServlet();
		userrequest.doPut(request, response);
		

	}

	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			UserRequestServlet.update(userRequest, request);
			
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("i am in put");
	}
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			UserRequestServlet.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// insert method
	public static int saveUserRequest(UserRequest userRequest,
			HttpServletRequest request) throws ClassNotFoundException {
		userRequest = new UserRequest();

		loginName = request.getParameter("name");
		email = request.getParameter("email");
		Requerment = request.getParameter("requirementDescription");
		contact = request.getParameter("mobile");
		ResultSet rs = null;

		String sql = "insert into userrequest(name,email,descrption,mobile_number) values ('"
				+ loginName
				+ "','"
				+ email
				+ "','"
				+ Requerment
				+ "','"
				+ contact + "');";
		Connection conn = null;
		int generatedKey = 0;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dscrm", "root", "root");
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

	// update method
	public static void update(UserRequest userRequest,
			HttpServletRequest request) throws ClassCastException, SQLException {
		System.out.println("i am in update");
		userRequest = new UserRequest();
		loginName = request.getParameter("name");
		email = request.getParameter("email");
		Requerment = request.getParameter("requirementDescription");
		contact = request.getParameter("mobile");
		String sql = "update userrequest set name=?,email=?,descrption=?,mobile_number=? where id=?";
		Connection con = null;
		PreparedStatement prep = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dscrm", "root", "root");
			prep = con.prepareStatement(sql);
			prep.setString(1, "loginName");
			prep.setString(2, "email");
			prep.setString(3, "Requerment");
			prep.setString(4, "contact");
			prep.setString(5, "userid");
			prep.executeUpdate();
			prep.close();
			userRequest.setName(loginName);
			userRequest.setEmail(email);
			userRequest.setMobilenumber(contact);
			userRequest.setRequerment(Requerment);
			userRequest.setUserid(userid);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println("successfully update");
	}

	// delete method
	public static void delete() throws SQLException {

		String sql = "delete form userrequest where name=?";
		Connection con = null;
		PreparedStatement prep = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dscrm", "root", "root");
			prep = con.prepareStatement(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}

