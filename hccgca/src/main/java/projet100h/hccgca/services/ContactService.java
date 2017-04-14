package projet100h.hccgca.services;

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
	
	public Contact saveContact(Contact contact) {
		return contactDao.saveContact(contact);
	}
	
	

}
