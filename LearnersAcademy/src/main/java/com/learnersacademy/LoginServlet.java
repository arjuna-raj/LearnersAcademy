package com.learnersacademy;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
	final String DB_URL = "jdbc:mysql://localhost:3307/learners_academy";
	final String USER = "root";
	final String PASSWORD = "hyperion12";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean userFound = false;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
					System.out.println("Connection established!");
					
					try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM login WHERE username=? AND password=?")) {
						ps.setString(1, username);
						ps.setString(2, password);
						
						ResultSet rs = ps.executeQuery();
						
						userFound = rs.next();
						
					} 		
				} 
			} catch(ClassNotFoundException | SQLException e) {
				System.out.println("DB error");
				response.getWriter().write(
						"<html><body>"
								+"<h2>Login failed!</h2>"
								+ "</body></html>");	
			}	
			
			response.setContentType("text/html");
			
			if(userFound) {
				
					System.out.println("Login Successful!");
					RequestDispatcher rd = request.getRequestDispatcher("dashboard");
					rd.forward(request,  response);
			} else {
				System.out.println("Login Failed!");
				response.getWriter().write(
						"Wrong username or password"
						);
				RequestDispatcher rd = request.getRequestDispatcher("loginPage");
				rd.include(request,  response);
			}
	}
}
