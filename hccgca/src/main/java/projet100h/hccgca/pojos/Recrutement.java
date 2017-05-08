package projet100h.hccgca.pojos;

import javax.servlet.http.Part;

public class Recrutement {

	private Integer idRecrutement;
	private String prenom;
	private String nom;
	private String mail;
	private String formation;
	private String posteRecherche;
	private String lettreMotivation;
	private String dateRecrutement;
	
	
	public Recrutement(Integer idRecrutement, String prenom, String nom, String mail, String formation, String posteRecherche, String dateRecrutement, String lettreMotivation) {
		super();
		this.lettreMotivation=lettreMotivation;
		this.dateRecrutement=dateRecrutement;
		this.idRecrutement=idRecrutement;
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
		this.formation = formation;
		this.posteRecherche = posteRecherche;
	}



	public String getLettreMotivation() {
		return lettreMotivation;
	}



	public void setLettreMotivation(String lettreMotivation) {
		this.lettreMotivation = lettreMotivation;
	}



	public Integer getIdRecrutement(){
		return idRecrutement;
	}
	
	public void setIdRecrutement(Integer idRecrutement){
		this.idRecrutement=idRecrutement;
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

	public String getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(String dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	
}

