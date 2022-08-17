import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class ServletProgram
 */
@WebServlet("/ServletProgram")
public class ServletProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter out;
    /**
     * Default constructor. 
     */
    public ServletProgram() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try
		 {
				Class.forName("com.mysql.jdbc.Driver");
				Connection co=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");
				  Statement st2=co.createStatement();
				  
				 ResultSet rs=st2.executeQuery("select USERNAME,PASSWORD from logindetails where USERNAME='"+username+"'and PASSWORD='"+password+"';");
				 
				if(rs.next())
				 {
				    response.sendRedirect("https://sysarcinfomatix.com");
				  }
				else
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Invalid Username or Password');");
					out.println(" location='Login.html';");
					out.println(" </script>");
			    }
				
				 
			  }
				catch(Exception e)
				{
					 System.out.println(e);
				}
			 

		 out.println("</body>");
		 out.println("</html>");
		
	}

}
