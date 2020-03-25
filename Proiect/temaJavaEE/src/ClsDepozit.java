import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClsDepozit {
	private int idUtilizator;
	private int suma;
	private int idDepozit;
	private String codDepozit;
	public ClsDepozit(int idUtilizator,int idDepozit, int suma, String codDepozit) {
		this.idUtilizator = idUtilizator;
		this.suma = suma;
		this.codDepozit =  codDepozit;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public int getSuma() {
		return suma;
	}
	public String getCodDepozit(){
		return codDepozit;
	}
}
