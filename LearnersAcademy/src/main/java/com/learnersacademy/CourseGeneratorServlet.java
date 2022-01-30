package com.learnersacademy;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CourseGeneratorServlet extends HttpServlet{
	final String DB_URL = "jdbc:mysql://localhost:3307/learners_academy";
	final String USER = "root";
	final String PASSWORD = "hyperion12";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><form action=\"courseSummary\" method\"POST\">");
		try
        {  
			response.getWriter().write(
					"<h2>Create a Course Lecture</h2>");
			
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from class");
            
            out.println("<label>Select a class </label>"
            		+ "<select name=\"class\" id=\"class\">");  
            while (rs.next()) 
            {   
                String cd = rs.getString("Class_Id"); 
                out.println("<option>" + cd + "</option>");   
            }  
            out.println("</select>"); 
            
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
            
            out.println("<label>Select a teacher </label>"
            		+ "<select name=\"teacher\" id=\"teacher\">");  
            while (rs.next()) 
            {   
                String cd = rs.getString("T_Name"); 
                out.println("<option>" + cd + "</option>");   
            }  
            out.println("</select>"); 
            
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
            ResultSet rs = stmt.executeQuery("select * from subject");
            
            out.println("<label>Select a subject </label>"
            		+ "<select name=\"subject\" id=\"subject\">");  
            while (rs.next()) 
            {   
                String cd = rs.getString("Su_Id"); 
                out.println("<option>" + cd + "</option>");   
            }  
            out.println("</select>"); 
            
        }
        catch (Exception e) 
       {  
        out.println("error");  
       }
		out.println("<button type= \"submit\"> Click to go to view summary</button>"
				+ "</form>"
				+ "</body></html>");	
	}
}
