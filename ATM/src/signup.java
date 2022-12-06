

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
import java.sql.ResultSet;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
			int user = Integer.parseInt(request.getParameter("u_id"));
			String pass = request.getParameter("pass");
			int bal = Integer.parseInt(request.getParameter("bal"));
			int age = Integer.parseInt(request.getParameter("age"));
			String addr = request.getParameter("addr");
			//java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			//java.sql.Date issueDate = new java.sql.Date(date.getTime()) ;


		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/atm";
 		String username = "atm"; 
 		String password = "Sanskar@2021";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); 
 		System.out.println("connection object "+con);

 		PreparedStatement checkUser = con.prepareStatement("SELECT count(*) FROM newuser WHERE login_id = ? and password = ?");
 		checkUser.setInt(1, user);
 		checkUser.setString(2,pass);
		ResultSet resultSet = checkUser.executeQuery();
		resultSet.next();
		
 		if (resultSet.getInt("count(*)") == 0) {
 		PreparedStatement insertuser = con.prepareStatement("INSERT into newuser values(? ,? ,?, ?, ?)");
 		insertuser.setInt(1, user);
 		insertuser.setString(2,pass);
 		insertuser.setInt(3, bal);
 		insertuser.setInt(4,age);
 		insertuser.setString(5,addr);
 		int result = insertuser.executeUpdate();
//		ResultSet inserted = insertuser.executeQuery();
//		inserted.next();
		
// 		if (resultSet.getInt("count(*)") != 0) {
// 			PreparedStatement st = con.prepareStatement("insert into issue values(?,?,?,?)");
// 			st.setInt(1, studentId);
// 			st.setInt(2, bookId);
// 			st.setDate(3, issueDate);
// 			st.setDate(4, issueDate);
// 			int result = st.executeUpdate();
 		if(result > 0)
 		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
 		}
		}
 		
 		else {
 			System.out.println("User already exist.");
// 			RequestDispatcher rd1 = request.getRequestDispatcher("SignUp.jsp");
//			rd1.forward(request, response);
 		}
		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
}


}
