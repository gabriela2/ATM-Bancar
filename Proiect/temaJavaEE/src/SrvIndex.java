

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
public class SrvIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context=getServletContext();  
		ClsUtilizatorAutentificat ua = (ClsUtilizatorAutentificat)context.getAttribute("ua");
		out.print("<!DOCTYPE html>"
		+"<!DOCTYPE html>"
		+"<html>"
		+"<link rel='stylesheet' type='text/css' href='main.css'>"
		+"<head>"
		+"	<title>Aplicatie JSP</title>"
		+"</head>"
		+"<body>"
		+ ClsMenu.getMenu(ua)
		+"	<div class='container'>"
		+"		<h1>Optiuni</h1>"
		+"		<a href='autentifica'>Autentifica utilizator</a>"
		+"		<br>"
		+"		<a href='inregistreaza'>Inregistreaza utilizator</a>"
		+"		<br>"
		+"		<a href='modificasuma'>Retrage sau depune suma</a>"
		+"		<br>"
		+"		<a href='cautautilizator'>Cauta nume utilizator dupa cont</a>"
		+"		<br>"
		+"		<a href='cautaconturi'>Cauta conturi dupa nume utilizator</a>"
		+"		<br>"
		+"		<a href='verificasold'>Verifica sold</a>"
		+"		<br>"
		+"		<a href='opadaugadepozit'>Adauga Depozit</a>"
		+"	</div>"
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
