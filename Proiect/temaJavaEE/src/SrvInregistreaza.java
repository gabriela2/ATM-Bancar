

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inregistreaza
 */
public class SrvInregistreaza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvInregistreaza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print(""
			+ "<!DOCTYPE html>"
			+"<html>"
			+"<link rel='stylesheet' type='text/css' href='main.css'>"
			+"<head>"
			+"	<title>Aplicatie JSP</title>"
			+"</head>"
			+"<body>"
			+"	<div class='container'>"
			+"	<h1>Formular inscriere</h1>"
			+"	  <form id='inregistrare' method='post' action='opinregistreaza'>"
			+"		<label for='fname'>Nume</label>"
			+"		<input type='text' id='fname' name='nume' placeholder='Numele dumneavoastra..'>"
			+"		<label for='lname'>Prenume</label>"
			+"		<input type='text' id='lname' name='prenume' placeholder='Prenumele dumneavoastra..'>"
			+"		<label for='parola'>Parola</label>"
			+"		<input type='password' id='lname' name='parola' placeholder='Parola dumneavoastra..'>"
			+"		<input type='submit' value='Inregistreaza'>"
			+"	  </form>"
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
