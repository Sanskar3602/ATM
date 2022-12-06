/*
  import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;


  Servlet implementation class IssueServlet
 
@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
			int studentId = Integer.parseInt(request.getParameter("s_id"));
			int bookId = Integer.parseInt(request.getParameter("b_id"));
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			java.sql.Date issueDate = new java.sql.Date(date.getTime()) ;
	
		Connection con = null;
 		String url = "jdbc:mysql://localhost:5432/project1"; //MySQL URL and followed by the database name
 		String username = "library"; //MySQL username
 		String password = "Sanskar@2021"; //MySQL password
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);

 		PreparedStatement checkStudent = con.prepareStatement("SELECT count(*) FROM student WHERE student_id = ?");
 		checkStudent.setInt(1, studentId);
		ResultSet resultSet = checkStudent.executeQuery();
		resultSet.next();
		
		//Prepared Statement to add student data
 		if (resultSet.getInt("count") != 0) {
		PreparedStatement st = con.prepareStatement("insert into issue values(?,?,?)");
		st.setInt(1, studentId);
		st.setInt(2, bookId);
		st.setDate(3, issueDate);
		int result = st.executeUpdate();

		//Checks if insert is successful.If yes,then redirects to Result.jsp page 
		if(result>0)
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("IssueResult.jsp");
			rd.forward(request, response);
		}
 		}
 		else {
 			System.out.println("Student does not exist.");
 		}
		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}
	}
}
*/



import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
//			int studentId = Integer.parseInt(request.getParameter("s_id"));
//			int bookId = Integer.parseInt(request.getParameter("b_id"));
//			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
//			java.sql.Date issueDate = new java.sql.Date(date.getTime()) ;

			int loginId = Integer.parseInt(request.getParameter("loginId"));
			String pasd = request.getParameter("pass");
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/atm"; //MySQL URL and followed by the database name
 		String username = "atm"; //MySQL username
 		String password = "Sanskar@2021"; //MySQL password
		
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);

 		PreparedStatement checkStudent = con.prepareStatement("SELECT count(*) FROM newuser WHERE login_id = ? and password = ?");
 		checkStudent.setInt(1, loginId);
 		checkStudent.setString(2, pasd);
		ResultSet resultSet = checkStudent.executeQuery();
		resultSet.next();
		//Prepared Statement to add student data
// 		if (resultSet.getInt("count(*)") != 0) {
// 			PreparedStatement st = con.prepareStatement("insert into issue values(?,?,?,?)");
// 			st.setInt(1, loginId);
// 			st.setString(2, pasd);
// 		PreparedStatement checkStudent = con.prepar
// 		PreparedStatement checkStudent = con.prepar
//// 			st.setDate(3, issueDate);
//// 			st.setDate(4, issueDate);
// 			int result = st.executeUpdate();

		//Checks if insert is successful.If yes,then redirects to Result.jsp page 
		if(resultSet.getInt("count(*)") != 0)
		{
			PreparedStatement addlogin = con.prepareStatement("insert into logged values(?)");
			addlogin.setInt(1, loginId);
			int loggedSet = addlogin.executeUpdate();
			//loggedSet.next();
			
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
		}
 		
 		else {
 			System.out.println("User does not exist.");
 		}
		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
	}


}
