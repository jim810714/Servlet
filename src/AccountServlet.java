import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * This servlet simply prints out HTTP method name and query string in it's service method.
 * 
 * 
 * Servlet implementation class AccountServlet
 */

public class AccountServlet extends HttpServlet 
{
	Hashtable data = new Hashtable();
	
	//If somebody types up the URL for this servlet 
	//in the address field of the browser.
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{
		//get the userid set by LoginServlet
		String userid = (String) req.getAttribute("userid");

		if(userid != null )
		{
			// userid available. retrieve the data and generate the page.
			String[] records = (String[]) data.get(userid);

			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Account Status for "+userid+" at the start of previous three months...</h3><p>");				
			for(int i=0; i<records.length; i++)
			{
				out.println(records[i]+"<br>");
			}

			out.println("</body>");
			out.println("</html>");						
		}
		else
		{

			//No userid. Send login.html to the user.
			//observe the use of relative path.
			
			req.getRequestDispatcher("/login.html").forward(req, res);
		}			
	}
  
	public void init()
	{
		data.put("jim", new String[]{ "09/20/2020 : 10000.00", "21/09/2020 : 10000.00", "24/09/2020 : 90000.00"} );				
		data.put("kevin", new String[]{ "09/20/2020 : 450000.00", "23/09/2020 : 20000.00", "25/09/2020 : 220000.00"} );
		data.put("marry", new String[]{ "09/20/2020 : 42600.00", "22/09/2020 : 2000.00", "26/09/2020 : 100.00"} );
	}
}



