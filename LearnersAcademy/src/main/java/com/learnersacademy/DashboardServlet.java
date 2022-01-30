package com.learnersacademy;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DashboardServlet extends HttpServlet {
	final String DB_URL = "jdbc:mysql://localhost:3307/learners_academy";
	final String USER = "root";
	final String PASSWORD = "hyperion12";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		try
        {  
			response.getWriter().write(
					"<html><body>"
							+"<h2>Welcome to the Learner's Academy Admin page</h2>"
							+ "</body></html>");
			
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from subject");
            out.println("<h3>Subjects</h3>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Subject ID</th><th>Subject</th><tr>");  
            while (rs.next()) 
            {   
                String nm = rs.getString("Su_Id");  
                String s = rs.getString("Su_Name");   
                out.println("<tr><td>" + nm + "</td><td>" + s + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }
		
		try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from student");
            out.println("<h3>Students</h3>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Student ID</th><th>Student Name</th><th>Class</th><tr>");  
            while (rs.next()) 
            {  
                int n = rs.getInt("stu_Id");  
                String nm = rs.getString("stu_alias");  
                String s = rs.getString("class_Id");   
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }
		
		try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from teacher");
            out.println("<h3>Teachers</h3>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Teacher ID</th><th>Teacher</th><tr>");  
            while (rs.next()) 
            {  
  
                String nm = rs.getString("T_Id");  
                String s = rs.getString("T_Name");   
                out.println("<tr><td>" + nm + "</td><td>" + s + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }
		
		try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from class");
            out.println("<h3>Classes</h3>");
            out.println("<table border=1 width=25% height=50%>");  
            out.println("<tr><th>Class</th><tr>");  
            while (rs.next()) 
            {  
 
                String s = rs.getString("Class_Id");   
                out.println("<tr>><td>" + s + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error 1");  
        }
		
		try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from lecture");
            out.println("<h3>Lectures</h3>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Class</th><th>subject</th><th>Teacher</th><tr>");  
            while (rs.next()) 
            {  
                String n = rs.getString("CC_id");  
                String nm = rs.getString("SU_id");  
                String s = rs.getString("T_id");   
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error 2");  
        }
		out.println("<form action=\"course\" method=\"POST\"><div>"
				+ "	 <button type= \"submit\"> Click to go to course page</button>");
		out.println("</div></form>");

		System.out.println("Welcome Message displayed.");
	}
}
