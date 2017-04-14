package projet100h.hccgca.pojos;

public class Contact {

	private String nom;
	private String mail;
	private String objet;
	private String message;
	
	
	public Contact(String nom, String mail, String objet, String message) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.objet = objet;
		this.message = message;
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
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
