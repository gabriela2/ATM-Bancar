

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SrvTranzactie
 */
public class SrvTranzactie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvTranzactie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		ClsUtilizatorAutentificat ua = 
				(ClsUtilizatorAutentificat)context.getAttribute("ua");
		int idua=-1;
		ClsDepoziteUtilizator du1=null;
		ClsDepoziteUtilizator du2=null;

		if (ua!=null)
			{
			idua = FctMetodeStatice.getIdUtilizator(ua.getNume(), ua.getPrenume());
			du1 = FctMetodeStatice.incarcaDepozite(idua);
		}
		String nume[] = null;
		int utilizatorCautat = -1;
		if (request.getParameter("utilizatorCautat")!=null){
			utilizatorCautat = Integer.parseInt(request.getParameter("utilizatorCautat"));
			nume = FctMetodeStatice.incarcaUtilizator(utilizatorCautat);
			du2 = FctMetodeStatice.incarcaDepozite(utilizatorCautat);
		}
		
		String liniiseldepozit1="";
		String liniiseldepozit2="";
		PrintWriter out = response.getWriter();
		
		if (utilizatorCautat!=-1 && du1!=null && du2!=null && nume!=null) {
			liniiseldepozit1 = ClsSelectareDepozite.depozite(du1,1);
			liniiseldepozit2 = ClsSelectareDepozite.depozite(du2,2);
			out.write(""
				+"<!DOCTYPE html>"
				+"<html>"
				+"<link rel='stylesheet' type='text/css' href='main.css'>"
				+"<head>"
				+"	<title>Aplicatie JSP</title>"
				+"</head>"
				+"<body>"
				+ ClsMenu.getMenu(ua)
				+"	<div class='container'>"
				+"	<h1>Tranzactie</h1>"
				+"	<form id='inregistrare' method='post' action='optranzactie'>"
				+"		<div>Transfer catre: "+nume[0]+" "+nume[1]+"</div>"
				+"		<br>"
				+"		<label>Selectati depozitul dvs:</label>"
				+ liniiseldepozit1
				+"		<label>Selectati depozitul catre care se trimite:</label>"
				+ liniiseldepozit2
				+"		<label for='fname'>Suma:</label>"
				+"		<input type='text' id='ucont' name='suma' placeholder='Introduceti suma'>"
				+"		<input type='hidden' name='idUtilizator1' value='"+idua+"'>"
				+"		<input type='hidden' name='idUtilizator2' value='"+utilizatorCautat+"'>"
				+"		<input type='submit' value='Transfera'>"
				+"	</form>"
				+"	</div>"
				+"</body>"
				+"</html>");
		}else {
			out.write(""
					+"<!DOCTYPE html>"
					+"<html>"
					+"<link rel='stylesheet' type='text/css' href='main.css'>"
					+"<head>"
					+"	<title>Aplicatie JSP</title>"
					+"</head>"
					+"<body>"
					+ ClsMenu.getMenu(ua)
					+"	<div class='container'>"
					+" Eroare la procesare. Ati accesat aceasta pagina direct din "
					+ "browser sau nu sunteti autentificat!"
					+"	</div>"
					+"</body>"
					+"</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
