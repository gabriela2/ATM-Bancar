
public class ClsSelectareDepozite {
	public static String depozite(ClsDepoziteUtilizator du, int k){
		String liniiseldepozit = "";
		if (du!=null && du.getNrDepozite()>0){
		if (k!=0)
			liniiseldepozit ="<select name='depozit"+k+"' id='depozite'>";
		else
			liniiseldepozit ="<select name='depozit' id='depozite'>";
		for (int i=0;i<du.getNrDepozite();i++){
			liniiseldepozit+="<option value='"+du.getCodDepozit(i)+"'>Depozitul: "+du.getCodDepozit(i)+"</option>";
		}
		liniiseldepozit+="</select>";
		}
		else {
			liniiseldepozit = "<h2>Nu sunteti autentificat</h2>";
		}
		return liniiseldepozit;
	}
}
