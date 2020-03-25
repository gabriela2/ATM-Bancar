

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inregistreaza
 */
public class SrvAutentifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvAutentifica() {
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
		if (ua==null){
		out.write("<!DOCTYPE html>"
				+"<html>"
				+"<link rel='stylesheet' type='text/css' href='main.css'>"
				+"<head>"
				+"	<title>Aplicatie JSP</title>"
				+"</head>"
				+"<body>"
				+ ClsMenu.getMenu(ua)
				+"	<div class='container'>"
				+"	<h1>Autentifica</h1>"
				+"	  <form id='inregistrare' method='post' action='opautentifica'>"
				+"		<label for='fname'>Nume</label>"
				+"		<input type='text' id='fname' name='nume' placeholder='Numele dumneavoastra..'>"
				+"		<label for='lname'>Prenume</label>"
				+"		<input type='text' id='lname' name='prenume' placeholder='Prenumele dumneavoastra..'>"
				+"		<label for='lname'>Parola</label>"
				+"		<input type='password' id='lname' name='parola' placeholder='Parola dumneavoastra..'>"	  
				+"		<input type='submit' value='Autentifica'>"
				+"	  </form>"
				+"	</div>"
				+"</body>"
				+"</html>");
	} else {
		out.write("<!DOCTYPE html>"
				+"<html>"
				+"<link rel='stylesheet' type='text/css' href='main.css'>"
				+"<head>"
				+"	<title>Aplicatie JSP</title>"
				+"</head>"
				+"<body>"
				+ ClsMenu.getMenu(ua)
				+"	<div class='container'>"
				+"  Sunteti deja autentificat!"
				+"  </div>"
				+"</body>"
				+"</html>");	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
