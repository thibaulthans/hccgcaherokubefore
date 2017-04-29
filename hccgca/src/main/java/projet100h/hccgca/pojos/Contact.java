package projet100h.hccgca.pojos;

public class Contact {

	private Integer idContact;
	private String nom;
	private String mail;
	private String objet;
	private String message;
	private String dateContact;
	
	
	public Contact(Integer idContact, String nom, String mail, String objet, String message, String dateContact) {
		super();
		this.idContact = idContact;
		this.nom = nom;
		this.mail = mail;
		this.objet = objet;
		this.message = message;
		this.dateContact = dateContact;
	}
	
	public Integer getIdContact() {
		return idContact;
	}
	
	public void setIdContact(Integer idContact) {
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

	public String getDateContact() {
		return dateContact;
	}

	public void setDateContact(String dateContact) {
		this.dateContact = dateContact;
	}

	
}
