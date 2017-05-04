package projet100h.hccgca.pojos;

public class Hcc {

	private Integer idHcc;
	private String titreHcc;
	private String texteHcc;
	
	public Hcc() {
		
	}
	

	public Hcc(Integer idHcc, String titreHcc, String texteHcc) {
		super();
		this.idHcc = idHcc;
		this.titreHcc = titreHcc;
		this.texteHcc = texteHcc;
	}


	public Integer getIdHcc() {
		return idHcc;
	}


	public void setIdHcc(Integer idHcc) {
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