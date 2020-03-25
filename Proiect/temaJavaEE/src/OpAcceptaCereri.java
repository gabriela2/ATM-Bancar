

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpAcceptaCerere
 */
public class OpAcceptaCereri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpAcceptaCereri() {
        super();
        // TODO Auto-generated constructor stub
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
		String idt=null;
		String postname="";
		for (int i=1;i<=ua.getNrCereri();i++)
			if (request.getParameter("submit"+i)!=null){
				postname = request.getParameter("submit"+i);
				idt = request.getParameter("idTranzactie"+i);
				System.out.println(idt);
			}
		int idTranzactie=-1;
		if (idt!=null)
			idTranzactie = Integer.parseInt(idt);
		if (idt!=null && FctMetodeStatice.acceptaCerere(idTranzactie)==1){
			ua.scadeNrCereri();
			response.sendRedirect("raspunsOperatieOK.html");
		}
		else {
			response.sendRedirect("raspunsOperatieNOTOK.html");
		}	
	}
}
