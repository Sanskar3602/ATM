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

@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
// Fetching input values from jsp page
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String category = request.getParameter("cat");
		String author = request.getParameter("author");

		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/atm"; //MySQL URL and followed by the database name
 		String username = "atm"; //MySQL username
 		String password = "Sanskar@2021"; //MySQL password
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);

// Prepared Statement to verify if the book already exists.
		PreparedStatement checkBook = con.prepareStatement("SELECT count(*) FROM book WHERE book_id = ?"); // Query to check if the book exists
 		checkBook.setInt(1, id);
		ResultSet resultSet = checkBook.executeQuery();
		resultSet.next();
 		
// Prepared Statement to add data of the book
		if (resultSet.getInt("count(*)") == 0) {
			PreparedStatement addBook = con.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?)"); //Insert values of new book
	 		addBook.setInt(1, id);
			addBook.setString(2, title);
			addBook.setString(3, category);
			addBook.setString(4, author);
			int result = addBook.executeUpdate();

// If INSERT QUERY is successful, then load Result.jsp page
			if(result>0){
				RequestDispatcher rd = request.getRequestDispatcher("AddResult.jsp");
				rd.forward(request, response);
			}
		
		}
		
		else {
			System.out.println("Book Already Exists.");
		}

	}
		 catch (Exception e) {
 			e.printStackTrace();
 		}
	}
}