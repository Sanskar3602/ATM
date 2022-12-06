

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
@WebServlet("/withdrawal")
public class withdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public withdrawal() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
			int amount = Integer.parseInt(request.getParameter("amount"));
			String pass = request.getParameter("pass");
			//String pass = request.getParameter("pass");
		
			//java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			//java.sql.Date issueDate = new java.sql.Date(date.getTime()) ;


		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/atm";
 		String username = "atm"; 
 		String password = "Sanskar@2021";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); 
 		System.out.println("connection object "+con);
 		if(amount > 0)
 		{
 			//getting user detail from log
 			PreparedStatement checkUser = con.prepareStatement("select distinct login_id from logged");
 			
 			ResultSet resultSet = checkUser.executeQuery();
 			resultSet.next();
 			int loggedUser = resultSet.getInt(1);
 			
 			PreparedStatement checkPass = con.prepareStatement("select count(*) from newuser where login_id = ? and password = ?");
 			checkPass.setInt(1, loggedUser);
 			checkPass.setString(2, pass);
 			ResultSet passcheck = checkPass.executeQuery();
 			passcheck.next();
 			if(passcheck.getInt("count(*)")>0) {
 				
 			
 			//getting current balance of user
 			PreparedStatement getBalance = con.prepareStatement("SELECT balance from newuser WHERE login_id=?");
 			getBalance.setInt(1, loggedUser);
 			ResultSet resultBalance = getBalance.executeQuery();
 			resultBalance.next();
 			int balance = resultBalance.getInt(1);
 			int totalamount = balance - amount;
 			
 			if(totalamount >0) {
 			PreparedStatement updateUser = con.prepareStatement("UPDATE newuser SET balance=?");
 			updateUser.setInt(1, totalamount);
 			int resultUpdate = updateUser.executeUpdate();
 			
 			PreparedStatement updateTransaction = con.prepareStatement("insert into transactions (login_id, withdrawal) values(?,?)");
 			updateTransaction.setInt(1, loggedUser);
 			updateTransaction.setInt(2, amount);
// 			updateTransaction.setInt(3, null);
 			int transactionUpdate = updateTransaction.executeUpdate();
 			
 			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
// 			resultUpdate.next();
 		}
 			else {
 				System.out.println("You don't have enough balance");
 				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
 				rd.forward(request, response);
 			}
 			}
 			else {
 				System.out.println("Entered Password is wrong!");
 				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
 				rd.forward(request, response);
 			}
 		}
 		else {
 			System.out.println("Please enter amount greater than 0");
 		}
			
 		}
		
		
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
}


}
