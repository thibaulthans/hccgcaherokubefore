package projet100h.hccgca.services;

import java.util.List;

import projet100h.hccgca.daos.ContactDao;
import projet100h.hccgca.pojos.Contact;

public class ContactService {
	
	private ContactDao contactDao = new ContactDao();
	
	private static class ContactServiceHolder {
		private static ContactService instance = 
									new ContactService();
	}
	
	public static ContactService getInstance() {
		return 	ContactServiceHolder.instance;
	}
	
	private ContactService() {
	}
	
	public Contact saveNewContact(Integer idContact, String nom, String mail, String objet, String message, String dateContact) {
		return contactDao.saveNewContact(idContact, nom, mail, objet, message, dateContact);
	}
	
	public void deleteContact(Integer idContact){
		contactDao.deleteContact(idContact);
	}
	
	public List<Contact> listContact() {
		return contactDao.listContacts();
	}

	public Contact getContactById(Integer id) {
		return contactDao.getContactById(id);
	}

}
