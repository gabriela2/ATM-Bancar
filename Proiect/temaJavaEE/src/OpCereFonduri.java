

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpTranzactie
 */
public class OpCereFonduri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpCereFonduri() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua");
		
		String idu1 = request.getParameter("idUtilizator1");
		String idu2 = request.getParameter("idUtilizator2");;
		int idUtilizator1 = Integer.parseInt(idu1);
		int idUtilizator2 = Integer.parseInt(idu2);
		String cod1 = request.getParameter("depozit1");
		String cod2 = request.getParameter("depozit2");
		int idDepozit1 = FctMetodeStatice.getIdCodDepozit(cod1);
		int idDepozit2 = FctMetodeStatice.getIdCodDepozit(cod2);

		String s = request.getParameter("suma");
		int suma = Integer.parseInt(s);

		int codStatus = FctMetodeStatice.initiazaTranzactie(idUtilizator2, idDepozit2, 
				idUtilizator1, idDepozit1, suma);
				
		if (codStatus!=-1){
				response.sendRedirect("raspunsOperatieOK.html");
		} else {
			response.sendRedirect("raspunsOperatieNOTOK.html");
		}
			
		
		
	}

}
