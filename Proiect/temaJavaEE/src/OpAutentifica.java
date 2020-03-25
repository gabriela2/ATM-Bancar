

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpInregistreaza
 */
public class OpAutentifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpAutentifica() {
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
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String parola = request.getParameter("parola");
		int nrCereri = FctMetodeStatice.getNrCereri(nume,prenume);
		if (FctMetodeStatice.verificaUtilizatorAutentificat(nume, prenume, parola)){
			ServletContext context = getServletContext();  
			ClsUtilizatorAutentificat ua = new ClsUtilizatorAutentificat(nume,prenume,nrCereri);
			ClsDepoziteUtilizator du = FctMetodeStatice.incarcaDepozite(nume,prenume);
			context.setAttribute("du", du);
			context.setAttribute("ua", ua);
			response.sendRedirect("index");
		}
		else {
			response.sendRedirect("raspunsOperatieNOTOK.html");
		}
	}

}
