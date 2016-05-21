package com.nextech.dscrm.dbconnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nextech.dscrm.pojo.UserRequest;

public class EmpDao {
	  public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dscrm", "root", "root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(UserRequest userRequest){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
	                         "insert into userrequest(name,email,requerment,mobile_number) values (?,?,?,?)");  
	            ps.setString(1,userRequest.getName());  
	            ps.setString(2,userRequest.getEmail());
	            ps.setString(3,userRequest.getRequerment());  
	            ps.setString(4,userRequest.getMobilenumber());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(UserRequest userRequest){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
	                         "update userrequest set name=?,email=?,requerment=?,mobile_number=? where id=?");  
	            ps.setString(1,userRequest.getName());  
	            ps.setString(2,userRequest.getEmail());  
	            ps.setString(3,userRequest.getRequerment());  
	            ps.setString(4,userRequest.getMobilenumber());  
	            ps.setInt(5,userRequest.getUserid());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from userrequest where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static UserRequest getEmployeeById(int id){  
	        UserRequest userRequest=new UserRequest();  
	          
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from userrequest where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                userRequest.setUserid(rs.getInt(1));  
	                userRequest.setName(rs.getString(2));  
	                userRequest.setEmail(rs.getString(3));  
	                userRequest.setRequerment(rs.getString(4)); 
	                userRequest.setMobilenumber(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return userRequest;  
	    }  
	    public static List<UserRequest> getAllEmployees(){  
	        List<UserRequest> list=new ArrayList<UserRequest>();  
	          
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from userrequest");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	UserRequest userRequest=new UserRequest();  
	            	userRequest.setUserid(rs.getInt(1));  
	                userRequest.setName(rs.getString(2));  
	                userRequest.setEmail(rs.getString(3));  
	                userRequest.setRequerment(rs.getString(4)); 
	                userRequest.setMobilenumber(rs.getString(5));   
	                list.add(userRequest);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  

}
