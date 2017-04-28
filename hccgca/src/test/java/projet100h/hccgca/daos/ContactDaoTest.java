package projet100h.hccgca.daos;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import projet100h.hccgca.pojos.Contact;

public class ContactDaoTest {
	
	private ContactDao contactDao = new ContactDao();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM contact");
			stmt.executeUpdate("INSERT INTO `contact`(`idContact`,`nom`,`mail`,`objet`,`message`,`dateContact`) VALUES ('1','Desaegher hugo','desaegher.hugo@hotmail.fr', 'Demande info devis', 'Message de Test 1', '26-04-2017')");
			stmt.executeUpdate("INSERT INTO `contact`(`idContact`,`nom`,`mail`,`objet`,`message`,`dateContact`) VALUES ('2','Hans Thibault','th@hotmail.fr', 'Demande info recrutement', 'Message de Test 2', '26-04-2017')");
		}
	}
	

	@Test
	public void shouldSaveContact() throws Exception {
		// GIVEN
		Contact contactToAdd = new Contact("3","maxime leader de mon cul","ms@gmail.com","Info","Message de Test 3", "26-04-2017");
		// WHEN
		Contact contactAdded = contactDao.saveNewContact(contactToAdd.getIdContact(), contactToAdd.getNom(), contactToAdd.getMail(), contactToAdd.getObjet(), contactToAdd.getMessage(), contactToAdd.getDateContact());
		// THEN
		Assertions.assertThat(contactAdded).isNotNull();
		Assertions.assertThat(contactAdded.getNom()).isEqualTo("maxime leader de mon cul");
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM contact WHERE nom='Desaegher hugo'")) {
					assertThat(rs.next()).isTrue();
			}
		}

	
	@Test
	public void shouldDeleteContact() throws Exception {
		// GIVEN
		Contact contact = contactDao.getContactById("1");
		// WHEN
		contactDao.deleteContact(contact.getIdContact());
		// THEN
		try (
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contact WHERE idContact = ?")) {
			stmt.setString(1, "1");
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isFalse();
				
			}
		}
		
}
	
	@Test
	public void shouldListContact() throws Exception {
		// WHEN
		List<Contact> listContacts = contactDao.listContacts(); 
		// THEN1
		Assertions.assertThat(listContacts).isNotNull();
		Assertions.assertThat(listContacts.get(0).getNom()).isEqualTo("Desaegher hugo");
		Assertions.assertThat(listContacts.get(1).getObjet()).isEqualTo("Demande info recrutement");
		
	}
	
	@Test
	public void shouldGetContact() throws Exception {
		// WHEN
		Contact contact = contactDao.getContactById("1"); 
		// THEN
		Assertions.assertThat(contact).isNotNull();
		Assertions.assertThat(contact.getIdContact()).isEqualTo("1");
		Assertions.assertThat(contact.getMessage()).isEqualTo("Message de Test 1");
		
	}

}