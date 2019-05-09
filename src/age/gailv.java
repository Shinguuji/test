package age;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class gailv
 */
@WebServlet("/gailv")
public class gailv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gailv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session=request.getSession();
		
		int Count =0;
		int SSRCount =0;
		int SRCount =0;
		int RCount=0;
		int CK=0;
		

		if(session.getAttribute("CNT")!=null) {			         
	    	 Count=(Integer)session.getAttribute("CNT");	    	
	   }		
		if(request.getParameter("get")!=null) {
  	            Count++;
  	     session.setAttribute("CNT", Count);
    }
		
		
		int gl =(int)(Math.random()*1000);
		
		if(session.getAttribute("SSR")!=null) {
			SSRCount=(Integer)session.getAttribute("SSR");
		}
		if(session.getAttribute("SR")!=null) {
			SRCount=(Integer)session.getAttribute("SR");
		}
		if(session.getAttribute("R")!=null) {
			RCount=(Integer)session.getAttribute("R");
		}
		
		
		if(gl>=0&&gl<3) {
			SSRCount++;
			CK=1;
			session.setAttribute("SSR",SSRCount);					
		}
		else if(gl>=4&&gl<666) {
			SRCount++;
			CK=2;
			session.setAttribute("SR",SRCount);
		}				
		
		else if(gl>=666&&gl<=1000) {
			RCount++;
			CK=3;
			session.setAttribute("R",RCount);
		}
		 if(request.getParameter("clear")!=null) {
			session.removeAttribute("CNT");
			session.removeAttribute("SSR");
			session.removeAttribute("SR");
			session.removeAttribute("R");
			CK=4;
			
		}
		
		request.setAttribute("wow",CK);						
          RequestDispatcher dis = request.getRequestDispatcher("jieguo.jsp");
          dis.forward(request, response);
			}

}
