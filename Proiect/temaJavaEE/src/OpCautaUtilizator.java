

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpCauta
 */
public class OpCautaUtilizator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpCautaUtilizator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String coddepozit = request.getParameter("depozit");
		System.out.println("Cod Depozit="+coddepozit);
		Integer idUtilizatorCautat = FctMetodeStatice.cautaUtilizatorDupaCodDepozit(coddepozit);	
		context.setAttribute("utilizatorCautat", idUtilizatorCautat);
		response.sendRedirect("cautautilizator");
	}

}
