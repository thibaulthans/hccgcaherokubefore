package projet100h.hccgca.pojos;

public class Hcc {

	private String idHcc;
	private String titreHcc;
	private String texteHcc;
	
	public Hcc() {
		
	}
	

	public Hcc(String titreHcc, String texteHcc) {
		this.titreHcc = titreHcc;
		this.texteHcc = texteHcc;
	}
	
	public Hcc(String idHcc, String titreHcc, String texteHcc) {
		this.idHcc = idHcc;
		this.titreHcc = titreHcc;
		this.texteHcc = texteHcc;
	}
	

	public String getIdHcc() {
		return idHcc;
	}


	public void setIdHcc(String idHcc) {
		this.idHcc = idHcc;
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