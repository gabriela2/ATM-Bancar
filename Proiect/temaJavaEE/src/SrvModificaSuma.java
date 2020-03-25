

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaSuma
 */
public class SrvModificaSuma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvModificaSuma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String linieseldepozit;
		String liniemodificasuma;
		ServletContext context=getServletContext();  
		ClsDepoziteUtilizator du = (ClsDepoziteUtilizator)context.getAttribute("du");
		ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua");
		linieseldepozit = ClsSelectareDepozite.depozite(du,0);
		
		if (du!=null){
			liniemodificasuma = ""
					+"	<h1>Modifica suma</h1>"
					+"	  <form id='inregistrare' method='post' action='opmodificasuma'>"
					+"		<label for='fcont'>Suma Noua:</label>"
					+ linieseldepozit
					+"		<div>"
					+"			<input type='checkbox' name='retragere' value='bifat'> <em>Bifati pentru retragere Suma</em>"
					+"		</div><br>"
					+"		<label for='fname'>Modificati suma:</label><br>"
					+"		<input type='text' id='fname' name='suma' placeholder='Introduceti suma ..'>"	
					+"		<input type='submit' value='Modifica'>"
					+"	  </form>";
		}
		else {
			liniemodificasuma = "<h2>Nu sunteti autentificat</h2>";
		}
		out.write(""
			+"<!DOCTYPE html>"
			+"<html>"
			+"<link rel='stylesheet' type='text/css' href='main.css'>"
			+"<head>"
			+"	<title>Aplicatie JSP</title>"
			+"</head>"
			+ ClsMenu.getMenu(ua)
			+"<body>"
			+"	<div class='container'>"
			+ liniemodificasuma
			+"	</div>"
			+"</body>"
			+"</html>"
			);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
