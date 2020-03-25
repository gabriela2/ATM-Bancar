public class ClsDepoziteUtilizator {
	private ClsDepozit[] depozite = new ClsDepozit[100];
	private int nrDepozite =0;
	public void adaugaDepozit(ClsDepozit d){
		depozite[nrDepozite++] = d;
	}
	public int getNrDepozite(){
		return nrDepozite;
	}
	public String getCodDepozit(int i){
		return (depozite[i].getCodDepozit());
	}
}
