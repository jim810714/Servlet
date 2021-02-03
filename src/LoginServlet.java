import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * This servlet simply prints out HTTP method name and query string in it's service method.
 * 
 *
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet 
{
	Hashtable<String, String> users = new Hashtable();
	
	//If somebody types up the URL for this servlet 
	//in the address field of the browser.
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");	
		//取得init參數

//		String userid = config.getInitParameter("userid");
//		String password = config.getInitParameter("password");
		
//		PrintWriter out = res.getWriter();
//		out.println(userid);
//		out.println(password);
		ServletConfig config = getServletConfig();
		Enumeration user = config.getInitParameterNames();
		
	    while(user.hasMoreElements()) {	    	
	      String initUserid = (String)user.nextElement();
	      
	      String initPassword = config.getInitParameter(userid);
	      
			PrintWriter out = res.getWriter();
			
			out.println(initUserid);
			out.println(initPassword);
	      
	      users.put(userid,password);
	      
	    }
		
		if(userid != null && password != null && password.equals((String)config.getInitParameter(userid)) )
		{
//			res.sendRedirect("./loginSuccess.html");
			//登入成功
			req.setAttribute("userid", userid);
			req.getRequestDispatcher("/loginSuccess.html").forward(req, res);
			return;
		}
		else
		{	
			//密碼錯誤轉跳回原頁面
			req.getRequestDispatcher("/login.html").forward(req, res);
			
			
			return;			
		}

	}

}


