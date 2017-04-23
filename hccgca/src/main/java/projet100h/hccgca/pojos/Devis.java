package projet100h.hccgca.pojos;

public class Devis {

	private String idDevis;
	private String secteurActivite;
	private String chiffreAffaire;
	private String nbSalarie;
	private String missions;
	private int valeurFacture;
	private String nom;
	private String prenom;
	private String mail;
	private String informationsSupplementaires;



public Devis(String idDevis, String secteurActivite, String chiffreAffaire, String nbSalarie, String missions, int valeurFacture,
		String nom, String prenom, String mail, String informationsSupplementaires) {
	super();
	this.idDevis = idDevis;
	this.secteurActivite = secteurActivite;
	this.chiffreAffaire = chiffreAffaire;
	this.nbSalarie = nbSalarie;
	this.missions = missions;
	this.valeurFacture = valeurFacture;
	this.nom = nom;
	this.prenom = prenom;
	this.mail = mail;
	this.informationsSupplementaires = informationsSupplementaires;
}

public String getIdDevis() {
	return idDevis;
}

public void setIdDevis(String idDevis) {
	this.idDevis = idDevis;
}

public String getSecteurActivite() {
	return secteurActivite;
}



public void setSecteurActivite(String secteurActivite) {
	this.secteurActivite = secteurActivite;
}



public String getChiffreAffaire() {
	return chiffreAffaire;
}



public void setChiffreAffaire(String chiffreAffaire) {
	this.chiffreAffaire = chiffreAffaire;
}



public String getNbSalarie() {
	return nbSalarie;
}



public void setNbSalarie(String nbSalarie) {
	this.nbSalarie = nbSalarie;
}



public String getMissions() {
	return missions;
}



public void setMissions(String missions) {
	this.missions = missions;
}



public int getValeurFacture() {
	return valeurFacture;
}



public void setValeurFacure(int valeurFacture) {
	this.valeurFacture = valeurFacture;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getPrenom() {
	return prenom;
}



public void setPrenom(String prenom) {
	this.prenom = prenom;
}



public String getMail() {
	return mail;
}



public void setMail(String mail) {
	this.mail = mail;
}



public String getInformationsSupplementaires() {
	return informationsSupplementaires;
}



public void setInformationsSupplementaires(String informationsSupplementaires) {
	this.informationsSupplementaires = informationsSupplementaires;
}

}

