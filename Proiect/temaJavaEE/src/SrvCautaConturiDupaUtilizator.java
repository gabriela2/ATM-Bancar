

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CautaConturiDupaUtilizator
 */
public class SrvCautaConturiDupaUtilizator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvCautaConturiDupaUtilizator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		ClsDepoziteUtilizator duc = (ClsDepoziteUtilizator)context.getAttribute("duc");
		ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua");

		String liniedepozite = "";
		if (duc!=null){
			for (int i=0;i<duc.getNrDepozite();i++){
				String temp = ("<tr><td>Cod depozit: "+duc.getCodDepozit(i)+"</td></tr>");
				liniedepozite += temp;
				
				System.out.println(liniedepozite);

			}
		}
		else{
			String temp = "<tr><td>Nu s-au gasit depozite</td></tr>";
			liniedepozite = temp ;
		}
		
		out.write("<!DOCTYPE html>"
		+"<html>"
		+"<link rel='stylesheet' type='text/css' href='main.css'>"
		+"<head>"
		+"	<title>Aplicatie JSP</title>"
		+"</head>"
		+"<body>"
		+ ClsMenu.getMenu(ua)
		+"	<div class='container'>"
		+"	<h1>Cauta Conturi dupa Utilizator</h1>"
		+"	  <form id='inregistrare' method='post' action='opcautaconturi'>"	
		+"		<label>Nume Utilizator:</label>"
		+"		<input type='text' id='nume' name='nume' placeholder='Introduceti numele utilizatorului cautat..'>"
		+"		<input type='text' id='prenume' name='prenume' placeholder='Introduceti prenumele utilizatorului cautat..'>"
		+"		<input type='submit' value='Cauta'>"
		+"	  </form>"
		+"	</div>"
		+"	<table style='width:40%' border='1'>"
		+"	  <tr>"
		+"		<th>Conturi gasite</th>"
		+"	  </tr>"
		+ liniedepozite
		+"	</table>"
		+"</body>"
		+"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
