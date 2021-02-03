

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Homework1
 */
@WebServlet("/Homework1")
public class Homework1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("UTF8");可分成兩行寫
//		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String title = "personal information";
		
		 String param1 = request.getParameter("param1");
		  String param2 = request.getParameter("param2");
//		  String param3 = request.getParameter("param3");		  
		  
		  out.println(			  
				       "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				       "Transitional//EN\n" +
		               "<HTML>\n" +
		               "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
			           "<BODY BGCOLOR=\"green\">\n" +
			           "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
			           "<UL>\n" +
			           "  <LI><B>姓名</B>: "
			           + param1 + "\n" +
			           "  <LI><B>地址</B>: "
			           + param2 + "\n" +
			           "  <LI><B>興趣</B>: "
			           + "\n" );
		  
		  String[] exist= request.getParameterValues("param3");
	          if(exist == null || exist.equals("")) { 
	        	  out.println("沒勾選喔!");
	          }else {	        	  
	        	  for (String p3 : request.getParameterValues("param3")) { //For Each	  
	        		  out.println(p3);
	        	  }
	        	 
	          }
		      
	  
//		  Enumeration h1 = request.getParameterNames();          
//          while(h1.hasMoreElements()) {
//            String h2 = (String)h1.nextElement();
//            out.println( h2);            
//          }
			 

		  out.println("</UL>\n</BODY></HTML>");	
		  
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
