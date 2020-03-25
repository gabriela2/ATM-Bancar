import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClsConexiune {
	public static Connection getConexiune() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				return null;
			}
			Connection con;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjsp", "root", "");
				return con;
			} catch (SQLException e) {
				return null;
			}
	}
}
