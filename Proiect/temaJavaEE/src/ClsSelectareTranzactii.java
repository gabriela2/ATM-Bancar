import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClsSelectareTranzactii {
	public static String tranzactii(int idUtilizator1){
		String liniitranzactii = "";
		Connection con = ClsConexiune.getConexiune();
		String query = "select * from tranzactie where idUtilizator1="+idUtilizator1+
				" and acceptata=0";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			int count = 0;
			while (rs.next()){
				int idTranzactie = rs.getInt(1);
				int idUtilizator2 = rs.getInt(4);
				int suma = rs.getInt(6);
				String nume[] = FctMetodeStatice.incarcaUtilizator(idUtilizator2);
				liniitranzactii+=
						 " 	 <tr>"
						+"		<form action='opacceptacereri' method='post'>"
						+"		<td>"+nume[0]+"</td>"
						+"		<td>"+nume[1]+"</td>"
						+"		<td>Suma ceruta:"+suma+"</td>"
						+"		<td>"
						+"         <input type='hidden' name='idTranzactie"+(++count)+"' value='"+idTranzactie+"'>"
						+"         <input type='submit' name='submit"+(count)+"' value='Accepta'>"
						+"      </td>"
						+"		</form>"		
						+"	  </tr>";
			}
			return liniitranzactii;
		} catch (SQLException e) {
			return null;
		}
	}
}
