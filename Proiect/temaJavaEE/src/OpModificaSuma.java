

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfisareSuma
 */
public class OpModificaSuma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpModificaSuma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ServletContext context=getServletContext();  
			String s = request.getParameter("suma");
			int suma = Integer.parseInt(s) ;
			String coddepozit = request.getParameter("depozit");
			String retragere = request.getParameter("retragere");
			ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua");
				int idua = FctMetodeStatice.getIdUtilizator(ua.getNume(), ua.getPrenume());
				int idDepozit = FctMetodeStatice.getIdCodDepozit(coddepozit);
				if (retragere!=null && retragere.equals("bifat")){
					System.out.println("bifat");
					suma = -suma;
				}
				System.out.println(FctMetodeStatice.verificaMoficareSumaDepozit(idua,idDepozit,suma));
				
				if (FctMetodeStatice.verificaMoficareSumaDepozit(idua,idDepozit,suma)){
					FctMetodeStatice.modificaSumaDepozit(coddepozit, suma);
					response.sendRedirect("raspunsOperatieOK.html");
				}
				else {
					response.sendRedirect("raspunsOperatieNOTOK.html");
				}
		}
		catch(Exception e) {
			response.sendRedirect("raspunsOperatieNOTOK.html");
		}
	}
}
