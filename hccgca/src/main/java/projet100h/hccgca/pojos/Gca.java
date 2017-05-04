package projet100h.hccgca.pojos;

public class Gca {

	private Integer idGca;
	private String titreGca;
	private String texteGca;
	
	public Gca() {
		
	}
	
	public Gca(Integer idGca, String titreGca, String texteGca) {
		super();
		this.idGca = idGca;
		this.titreGca = titreGca;
		this.texteGca = texteGca;
	}
	
	
	public Integer getIdGca() {
		return idGca;
	}

	public void setIdGca(Integer idGca) {
		this.idGca = idGca;
	}

	public String getTitreGca() {
		return titreGca;
	}
	public void setTitreGca(String titreGca) {
		this.titreGca = titreGca;
	}
	public String getTexteGca() {
		return texteGca;
	}
	public void setTexteGca(String texteGca) {
		this.texteGca = texteGca;
	}
	
	
}
