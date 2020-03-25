import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FctMetodeStatice {
	public static ClsDepoziteUtilizator incarcaDepozite(String nume,String prenume) {
		ClsDepoziteUtilizator du = new ClsDepoziteUtilizator();
		Connection con = ClsConexiune.getConexiune();
		Statement stmt;
		String query = "select * from depozit A inner join utilizator B on A.idUtilizator=B.idUtilizator where B.nume='"
				+ nume + "' and  B.prenume='" + prenume+"'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				ClsDepozit d = new ClsDepozit(rs.getInt(1), rs.getInt(2),
						rs.getInt(3),rs.getString(3));
				du.adaugaDepozit(d);
			}
			return du;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ClsDepoziteUtilizator incarcaDepozite(int idUtilizator) {
		ClsDepoziteUtilizator du = new ClsDepoziteUtilizator();
		Connection con = ClsConexiune.getConexiune();
		Statement stmt;
		String query = "select * from depozit A inner join utilizator B on A.idUtilizator=B.idUtilizator"
				+ " where B.idUtilizator="+idUtilizator;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				ClsDepozit d = new ClsDepozit(rs.getInt(1), rs.getInt(2),
						rs.getInt(3),rs.getString(3));
				du.adaugaDepozit(d);
			}
			return du;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int initiazaTranzactie(int idUtilizator1, int idDepozit1,
			int idUtilizator2, int idDepozit2, int suma) {
		Connection con = ClsConexiune.getConexiune();
		Statement preparedStatement;
		if (verificaMoficareSumaDepozit(idUtilizator1, idDepozit1, -suma)
				&& verificaMoficareSumaDepozit(idUtilizator2, idDepozit2, suma)) {
			String query2 = " insert into tranzactie"
					+ "(idUtilizator1,idDepozit1,idUtilizator2,idDepozit2,suma,acceptata)"
					+ " values (?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement preparedStmt = con.prepareStatement(query2,PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStmt.setInt(1, idUtilizator1);
				preparedStmt.setInt(2, idDepozit1);
				preparedStmt.setInt(3, idUtilizator2);
				preparedStmt.setInt(4, idDepozit2);
				preparedStmt.setInt(5, suma);
				preparedStmt.setInt(6, 0);
				preparedStmt.execute();
				ResultSet rs = preparedStmt.getGeneratedKeys();
				con.close();
				if (rs.next())
					return rs.getInt(1);
			} catch (SQLException e) {
				return -1;
			}

		}
		try {
			con.close();
			return -1;
		} catch (SQLException e) {
			return -1;
		}
	}
	public static void efectueazaTranzactie(int idTranzactie,int idUtilizator1, int idDepozit1,
			int idUtilizator2, int idDepozit2, int suma){
		Connection con = ClsConexiune.getConexiune();
		String query1 = "update depozit set suma=suma-" + (suma)+
				" where idUtilizator = "+idUtilizator1+" and idDepozit="+idDepozit1;
		String query2 = "update depozit set suma=suma+" + (suma)+
				" where idUtilizator = "+idUtilizator2+" and idDepozit="+idDepozit2;
		String query3 = "update tranzactie set acceptata=1"+
				" where idUtilizator1="+idUtilizator1+" and idDepozit1="+idDepozit1
				+" and idUtilizator2="+idUtilizator2+" and suma="+suma+
				" and idTranzactie="+idTranzactie;
		try {
			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.execute();
			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.execute();
			PreparedStatement preparedStmt3 = con.prepareStatement(query3);
			preparedStmt3.execute();
		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static String[] incarcaUtilizator(int idUtilizator) {
		String numeS[] = new String[2];
		String nume = null;
		String prenume = null;
		try {
			Connection con = ClsConexiune.getConexiune();
			if (con != null) {// conexiune activa
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("select * from utilizator where idUtilizator="
								+ idUtilizator);
				while (rs.next()) {
					nume = rs.getString(2);
					prenume = rs.getString(3);
				}
				numeS[0] = nume;
				numeS[1] = prenume;
				con.close();
				return numeS;
			}
		} catch (SQLException e) {
		}
		return null;
	}
	public static int getIdUtilizator(String nume, String prenume){
		int idUtilizator=-1;
		Connection con = ClsConexiune.getConexiune();	
		Statement st;
		if (con != null) {
				try {
					st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from utilizator where nume='"
							+ nume + "' and prenume='" + prenume+"'");
					if (rs.next()){
						idUtilizator = rs.getInt(1);
					}
					con.close();
					return idUtilizator;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return -1;
	}

	public static boolean verificaExistentaUtilizator(String nume,
			String prenume) {
		Connection con = ClsConexiune.getConexiune();
		Statement stmt;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from utilizator");
			while (rs.next())
				if (rs.getString(2).equals(nume)
					&& rs.getString(3).equals(prenume)){
					con.close();	
					return true;
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public static boolean verificaUtilizatorAutentificat(String nume,
			String prenume,String parola) {
		Connection con = ClsConexiune.getConexiune();
		Statement stmt;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from utilizator");
			while (rs.next()){
				if (rs.getString(2).equals(nume)
						&& rs.getString(3).equals(prenume) && rs.getString(4).equals(parola))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public static int getSumaDepozit(String codDepozit){
		Connection con = ClsConexiune.getConexiune();
		String query = "select * from depozit where codDepozit='"
				+ codDepozit+"'";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				int s = rs.getInt(4);
				con.close();
				return s;
			} else {
				con.close();
				return -1;
			}

		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static boolean verificaMoficareSumaDepozit(int idUtilizator,
			int idDepozit, int suma) {
		Connection con = ClsConexiune.getConexiune();

		String query = "select * from depozit where idUtilizator="
				+ idUtilizator + " and idDepozit=" + idDepozit;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				int s = rs.getInt(4);
				if (s + suma < 0) {
					con.close();
					return false;
				}
				 else {
					con.close();
					return true;
				 }
				}
		} catch (SQLException e) {
		}
		return false;
	}

	public static void modificaSumaDepozit(String codDepozit, int suma) {
		Connection con = ClsConexiune.getConexiune();
		String query = "update depozit" + " set suma=suma+" + suma+
				" where codDepozit="+codDepozit;
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int cautaUtilizatorDupaCodDepozit(String codDepozit){
		int idUtilizator;
		try {
			Connection con = ClsConexiune.getConexiune();
			if (con != null) {
				Statement st = con.createStatement();
				String query = "select A.idUtilizator from utilizator A inner join depozit B "
						+ "on A.idUtilizator=B.idUtilizator where B.codDepozit="
						+ codDepozit;
				ResultSet rs = st.executeQuery(query);
				if (rs.next()) {
					idUtilizator = rs.getInt(1);
					con.close();
					return idUtilizator;
				}
			}
		} catch (SQLException e) {
			return -1;
		}
		return -1;
	}
	public static void adaugaUtilizator(String nume, String prenume,
			String parola) {
		Connection con = ClsConexiune.getConexiune();
		Statement preparedStatement;
		String query2 = " insert into utilizator(nume,prenume,parola)"
				+ " values (?, ?, ?)";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query2);
			preparedStmt.setString(1, nume);
			preparedStmt.setString(2, prenume);
			preparedStmt.setString(3, parola);
			// execute the preparedstatement
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int getIdCodDepozit(String codDepozit){
		int idDepozit;
		try {
			Connection con = ClsConexiune.getConexiune();
			if (con != null) {
				Statement st = con.createStatement();
				String query = "select idDepozit from depozit "
						+ "where codDepozit="+codDepozit;
				ResultSet rs = st.executeQuery(query);
				if (rs.next()) {
					idDepozit = rs.getInt(1);
					con.close();
					return idDepozit;
				}
			}
		} catch (SQLException e) {
			return -1;
		}
		return -1;
	}

	public static String genereazaCodDepozit(int idUtilizator,int idDepozit){
		int r = (int)(10+Math.random()*91);
		return ""+(idUtilizator%9)+""+(idDepozit%9) + r;
	}
	public static void adaugaDepozit(int idUtilizator) {
		Connection con = ClsConexiune.getConexiune();
		String query1 = "insert into depozit(idUtilizator,codDepozit,suma)"
				+ " values (?, ?, ?)";
		try {
			PreparedStatement preparedStmt1 = con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
			preparedStmt1.setInt(1, idUtilizator);
			preparedStmt1.setString(2,"0000");
			preparedStmt1.setInt(3, 0);
			preparedStmt1.execute();
			ResultSet rs = preparedStmt1.getGeneratedKeys();
			int idDepozit=0;

			if (rs.next()){
			    idDepozit=rs.getInt(1);
				String codDepozit = genereazaCodDepozit(idUtilizator,idDepozit);
				String query2 = "update depozit set codDepozit=" + codDepozit 
						+ " where idUtilizator="+idUtilizator+" and idDepozit="+idDepozit;
				PreparedStatement preparedStmt2 = con.prepareStatement(query2);
				preparedStmt2.execute();
			}
			con.close();
		} catch (SQLException e) {
		}
	}
	public static int getNrCereri(String nume,String prenume){
		int idUtilizator = getIdUtilizator(nume,prenume);
		Connection con = ClsConexiune.getConexiune();
		String query1 = "select * from tranzactie where idUtilizator1="
		+idUtilizator+" and acceptata=0";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			int count=0;
			while (rs.next()) {
			    ++count;
			    // Get data from the current row and use it
			}
			return count;
		} catch (SQLException e) {
			return 0;
		}
	}
	public static int acceptaCerere(int idTranzactie){
		Connection con = ClsConexiune.getConexiune();
		String query1 = "select * from tranzactie where idTranzactie="+idTranzactie;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			int idUtilizator1;
			int idDepozit1;
			int idUtilizator2;
			int idDepozit2;
			int suma;
			if (rs.next()){
				idTranzactie = rs.getInt(1);
				idUtilizator1 = rs.getInt(2);
				idDepozit1 = rs.getInt(3);
				idUtilizator2 = rs.getInt(4);
				idDepozit2 = rs.getInt(5);
				suma = rs.getInt(6);
				efectueazaTranzactie(idTranzactie,idUtilizator1, idDepozit1,
						idUtilizator2,  idDepozit2, suma);
			}
		} catch (SQLException e) {
			return -1;
		}
		
		String query2 = "update tranzactie set acceptata=1"
				+ " where idTranzactie="+idTranzactie;
		PreparedStatement preparedStmt1;
		try {
			preparedStmt1 = con.prepareStatement(query2);
			preparedStmt1.execute();
			return 1;
		} 
		catch (SQLException e) {
			return -1;
		}
	}
}
