
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
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
			
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/atm"; //MySQL URL and followed by the database name
 		String username = "atm"; //MySQL username
 		String password = "Sanskar@2021"; //MySQL password
		
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);

 
	
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

		PreparedStatement checkStudent = con.prepareStatement("delete from logged");
 		
		int resultSet = checkStudent.executeUpdate();
		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
	}


}