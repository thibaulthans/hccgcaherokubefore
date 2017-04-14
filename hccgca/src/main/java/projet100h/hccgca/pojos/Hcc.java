package projet100h.hccgca.pojos;

public class Hcc {

	private String titreHcc;
	private String texteHcc;
	
	public Hcc() {
		
	}
	
	public Hcc(String titreHcc, String texteHcc) {
		super();
		this.titreHcc = titreHcc;
		this.texteHcc = texteHcc;
	}
	
	public String getTitreHcc() {
		return titreHcc;
	}
	public void setTitreHcc(String titreHcc) {
		this.titreHcc = titreHcc;
	}
	public String getTexteHcc() {
		return texteHcc;
	}
	public void setTexteHcc(String texteHcc) {
		this.texteHcc = texteHcc;
	}
	
	
}
