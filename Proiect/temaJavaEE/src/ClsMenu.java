
public class ClsMenu {
	static String getMenu(ClsUtilizatorAutentificat ua){
		String header = "<header><h3>";
		if (ua!=null){
			header+="[Autentificat ca "+ua.getNume()+" "+ua.getPrenume()+"]"
					+ "[<a href='opdelogare'>Delogare</a>]";
		}
		else{
			header+="[Nu sunteti autentificat]";
		}
		if (ua!=null && ua.getNrCereri()>0){
			header+="[<a href='acceptacereri'>"+ ua.getNrCereri() + " cereri de la alti utilizatori</a>]";
		}
		if (ua!=null && ua.getNrCereri()==0) {
			header+= "<br>[Nu aveti cereri de la alti utilizatori]";
		}
		header+="</h3></header>";
		return header;
	}
}
