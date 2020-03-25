

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerificaSold
 */
public class SrvVerificaSold extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvVerificaSold() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context=getServletContext();  
		Integer suma = (Integer)context.getAttribute("suma");
		String coddepozit = (String)context.getAttribute("depozitul");
		ClsDepoziteUtilizator du = (ClsDepoziteUtilizator)context.getAttribute("du");
		ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua");
		String liniesuma="";
		String linieseldepozit="";
		String linieverificasold;
		if (suma!=null && suma!=-1)
			liniesuma = "<h1>Aveti suma de " + suma + " LEI in Depozitul "+coddepozit+"</h1>";
		else liniesuma="";
		linieseldepozit = ClsSelectareDepozite.depozite(du,0);
		if (du!=null){
			linieverificasold = ""
							+"	<h1>Verifica sold</h1>"
							+"	<form id='inregistrare' method='post' action='opafisaresuma'>"
							+"		<div>Verifica sold depozitele mele</div>"
							+"		<br>"
							+"		<label for='ucont'>Selectati depozit:</label>"
							+ linieseldepozit
							+"		<input type='submit' value='Verifica'>"
							+"	</form>"
							+ liniesuma;
		}
		else {
			linieverificasold = "<h2>Nu sunteti autentificat</h2>";
		}

		out.write(
				"<!DOCTYPE html>"
				+"<html>"
				+"<link rel='stylesheet' type='text/css' href='main.css'>"
				+"<head>"
				+"	<title>Aplicatie JSP</title>"
				+"</head>"
				+"<body>"
				+ ClsMenu.getMenu(ua)
				+"	<div class='container'>"
				+linieverificasold
				+"	</div>"
				+"</body>"
				+"</html>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
