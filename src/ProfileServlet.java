

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbBullhorn;
import customTools.DbUser;
import model.Bhpost;
import model.Bhuser;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     
        String action = request.getParameter("action");		
		HttpSession session = request.getSession();	
		String nextURL = "/error.jsp";
		
		Bhuser user = (Bhuser) session.getAttribute("user");
		
		if (user==null) {
			System.out.println("ProfileServlet: no user");
			nextURL = "/BHlogin.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
			return;
		}
		
		System.out.println("ProfileServlet action: "+action);
		if (action.equals("edit")) {	
			
			// get current email and password
			String curremail = user.getUseremail();			
			
			String newemail = null;
			String newpassword = null;
	        String newmotto = null;					
	       
	        // get new email, password and mottoString
			newemail = request.getParameter("email");
	        newpassword = request.getParameter("password");
	        newmotto = request.getParameter("motto");      
	        
	        System.out.println("new email: "+newemail);
	        System.out.println("new password: "+newpassword);
	        System.out.println("new motto: "+newmotto);	    
       
	        user = null;	        
	        user = DbUser.updateUser(curremail, newemail, newpassword, newmotto);
	        
	        if (user == null) {	        	
	        	System.out.println("User update succeeded");
	        }
	        else {
	        	System.out.println("User update failed");
	        }
	        
            	
           session.setAttribute("user", user);              
                
           nextURL = "/profile.jsp";            
            
        }
		
        //redirect to next page as indicated by the value of the nextURL variable
        response.sendRedirect(request.getContextPath() + nextURL);   
	}

}
