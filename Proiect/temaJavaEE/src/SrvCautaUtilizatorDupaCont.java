

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CautaUtilizatorDupaCont
 */
public class SrvCautaUtilizatorDupaCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvCautaUtilizatorDupaCont() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idUtilizatorCautat;
		ServletContext context = getServletContext();
		ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua");
		idUtilizatorCautat = (Integer)context.getAttribute("utilizatorCautat");
		System.out.println("cautat"+idUtilizatorCautat);
		String tabel;
		if (idUtilizatorCautat!=null && idUtilizatorCautat!=-1){
			String nume[] = FctMetodeStatice.incarcaUtilizator(idUtilizatorCautat);
			tabel = "	  <tr class='active'>"
					+"		<td>"+nume[0]+"</td>"
					+"		<td>"+nume[1]+"</td>"
					+"		<td><a href='tranzactie?utilizatorCautat="+idUtilizatorCautat+"'>Trimite Bani</td>"
					+"		<td><a href='cerefonduri?utilizatorCautat="+idUtilizatorCautat+"'>Cere Bani</td>"
					+"	  </tr>";
		}else {
			tabel="	  <tr class='notactive'>"
			+"		<td colspan='3'>Nu exista contul cautat</td>"	
			+"	  </tr>";
		}
		
		PrintWriter out = response.getWriter();
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
				+"	<h1>Cauta Utilizator dupa cont</h1>"
				+"	  <form id='inregistrare' method='post' action='opcautautilizator'>"	
				+"		<label for='ucont'>Cont Utilizator:</label>"
				+"		<input type='text' id='ucont' name='depozit' placeholder='Introduceti contul utilizatorului..'>"
				+"		<input type='submit' value='Cauta'>"
				+"	  </form>"
				+"	</div>"
				+"	<table style='width:40%;' border='1'>"
				+"	  <tr>"
				+"		<th colspan=4>Conturi gasite</th>"
				+"	  </tr>"
				+ tabel
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
