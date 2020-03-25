

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpCauta
 */
public class OpCautaConturi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpCautaConturi() {
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
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		if (nume!=null && prenume!=null){
			int idUtilizator = FctMetodeStatice.getIdUtilizator(nume, prenume);
			ClsDepoziteUtilizator duc = FctMetodeStatice.incarcaDepozite(idUtilizator);
			context.setAttribute("duc", (ClsDepoziteUtilizator)duc);
		}
		response.sendRedirect("cautaconturi");
	}

}
