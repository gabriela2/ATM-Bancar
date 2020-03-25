
public class ClsUtilizatorAutentificat {
	private String nume;
	private String prenume;
	private int nrCereri;
	public ClsUtilizatorAutentificat(String nume,String prenume,int nrCereri){
		this.nume = nume;
		this.prenume = prenume;
		this.nrCereri = nrCereri;
	}
	public String getNume(){
		return this.nume;
	}
	public void scadeNrCereri(){
		this.nrCereri--;
	}
	public int getNrCereri(){
		return this.nrCereri;
	}
	public String getPrenume(){
		return this.prenume;
	}
}
