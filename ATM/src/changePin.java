

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
@WebServlet("/changePin")
public class changePin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public changePin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
			String previousPass = request.getParameter("previous");
			String newPass = request.getParameter("newPass");
		
			//java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			//java.sql.Date issueDate = new java.sql.Date(date.getTime()) ;


		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/atm";
 		String username = "atm"; 
 		String password = "Sanskar@2021";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); 
 		System.out.println("connection object "+con);
// 		if(amount > 0)
// 		{
 			//getting user detail from log
 			PreparedStatement checkUser = con.prepareStatement("select distinct login_id from logged");
 			
 			ResultSet resultSet = checkUser.executeQuery();
 			resultSet.next();
 			int loggedUser = resultSet.getInt(1);
 			
 			//getting current balance of user
 			PreparedStatement getBalance = con.prepareStatement("SELECT count(*) from newuser WHERE login_id=? and password = ?");
 			getBalance.setInt(1, loggedUser);
 			getBalance.setString(2,  previousPass);
 			ResultSet resultBalance = getBalance.executeQuery();
 			resultBalance.next();
// 			int balance = resultBalance.getInt(1);
// 			int totalamount = balance + amount;
 			if(resultBalance.getInt("count(*)")> 0) {
 				PreparedStatement updateUser = con.prepareStatement("UPDATE newuser SET password=? where login_id=?");
 	 			updateUser.setString(1, newPass);
 	 			updateUser.setInt(2, loggedUser);
 	 			int resultUpdate = updateUser.executeUpdate();
 	 			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
 				rd.forward(request, response);
 			}
 			else {
 				System.out.println("Password didn't match ");
 				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
 				rd.forward(request, response);
 			}
// 			PreparedStatement updateUser = con.prepareStatement("UPDATE newuser SET balance=?");
// 			updateUser.setInt(1, totalamount);
// 			int resultUpdate = updateUser.executeUpdate();
// 			
// 			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
//			rd.forward(request, response);
// 			resultUpdate.next();
 		

 		
			
 		}
		
		
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
}


}
