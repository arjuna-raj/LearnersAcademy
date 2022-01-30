package com.learnersacademy;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CourseSummaryServlet extends HttpServlet{
	final String DB_URL = "jdbc:mysql://localhost:3307/learners_academy";
	final String USER = "root";
	final String PASSWORD = "hyperion12";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String teacher = request.getParameter("teacher");
		String chosenC = request.getParameter("class");
		
		System.out.println("Arrived to summary page");
		
		
		
		try {
			System.out.println("flag 1");
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
				System.out.println("Connection established!");
				
				try(PreparedStatement ps = connection.prepareStatement("INSERT INTO lecture VALUES(?, ?, ?)")) {

					ps.setString(1, chosenC);
					ps.setString(2, subject);
					ps.setString(3, teacher);
					

					int rowsAfftected = ps.executeUpdate();
					
					if(rowsAfftected > 0) {
						System.out.println("A new course Has been created!");
						response.getWriter().write(
								"<html><body>"
										+"<h2>creation succesful!</h2>"
										+  "Course:" + subject + " will be taught in CLASS:" + chosenC + ", by " + teacher
										+"<form action=\"dashboard\" method=\"POST\"><div>"
										+ "	 <button type= \"submit\"> Click to go back to dashboard</button>"
										+ "</body></html>"
								);	
					} else if(rowsAfftected == 0) {
						System.out.println("No new record inserted!");
						response.getWriter().write(
								"<html><body>"
										+"<h2>creation failed!</h2>"
										+"<form action=\"course\" method=\"POST\">"
										+ "<button type= \"submit\"> Click to go back to dashboard</button>"
										+ "</body></html>"
								);
						throw new SQLException();		
					}
				} 		
			}
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("Flag 1 error");
			response.getWriter().write(
					"<html><body>"
							+"<h2>creation failed!</h2>"
							+"<form action=\"course\" method=\"POST\">"
							+ "<button type= \"submit\"> Click to go back to dashboard</button>"
							+ "</body></html>"
					);	
		}
		

		
	}
}
