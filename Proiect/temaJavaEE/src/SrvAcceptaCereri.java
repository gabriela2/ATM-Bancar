

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SrvAfiseazaCereri
 */
public class SrvAcceptaCereri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvAcceptaCereri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua"); 
		PrintWriter out = response.getWriter();
		if (ua!=null){
			String liniitranzactii = ClsSelectareTranzactii.
					tranzactii(FctMetodeStatice.getIdUtilizator(ua.getNume(), ua.getPrenume()));
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
			+"	<h1>Afisare cereri</h1>"
			+"</div>"
			+"	<table style='width:40%;' border='1'>"
			+"	  <tr>"
			+"		<th>Nume</th>"
			+"		<th>Prenume</th>"
			+"		<th>Suma</th>"
			+"		<th>Accepta</th>"
			+"	  </tr>"
			+liniitranzactii
			+"	</table>"
			+"</body>"
			+"</html>");
		}
		else {
			out.write(""
			+"<!DOCTYPE html>"
			+"<html>"
			+"<link rel='stylesheet' type='text/css' href='main.css'>"
			+"<head>"
			+"	<title>Aplicatie JSP</title>"
			+"</head>"
			+"<body>"
			+"	<div class='container'>"
			+"  Nu sunteti autentificat"
			+"  </div>"
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
