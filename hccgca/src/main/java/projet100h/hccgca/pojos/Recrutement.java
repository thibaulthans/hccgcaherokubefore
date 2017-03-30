package projet100h.hccgca.pojos;

public class Recrutement {

	private String prenom;
	private String nom;
	private String mail;
	private String formation;
	private String posteRecherche;
	private String cv;
	private String lettreMotivation;
	
	
	public Recrutement(String prenom, String nom, String mail, String formation, String posteRecherche, String cv,
			String lettreMotivation) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
		this.formation = formation;
		this.posteRecherche = posteRecherche;
		this.cv = cv;
		this.lettreMotivation = lettreMotivation;
	}
	
	
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	public String getPosteRecherche() {
		return posteRecherche;
	}
	public void setPosteRecherche(String posteRecherche) {
		this.posteRecherche = posteRecherche;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getLettreMotivation() {
		return lettreMotivation;
	}
	public void setLettreMotivation(String lettreMotivation) {
		this.lettreMotivation = lettreMotivation;
	}
	
	
	
}

