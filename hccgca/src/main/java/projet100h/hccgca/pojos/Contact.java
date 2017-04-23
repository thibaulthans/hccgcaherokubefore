package projet100h.hccgca.pojos;

public class Contact {

	private String idContact;
	private String nom;
	private String mail;
	private String objet;
	private String message;
	
	
	public Contact(String idContact, String nom, String mail, String objet, String message) {
		super();
		this.idContact = idContact;
		this.nom = nom;
		this.mail = mail;
		this.objet = objet;
		this.message = message;
	}
	
	public String getIdContact() {
		return idContact;
	}
	
	public void setIdContact(String idContact) {
		this.idContact = idContact;
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
