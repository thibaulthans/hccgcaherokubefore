package projet100h.hccgca.daos;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
			stmt.executeUpdate("INSERT INTO `contact`(`idContact`,`nom`,`mail`,`objet`,`message`) VALUES ('1','Desaegher hugo','desaegher.hugo@hotmail.fr', 'Demande info devis', 'Message de Test 1')");
			stmt.executeUpdate("INSERT INTO `contact`(`idContact`,`nom`,`mail`,`objet`,`message`) VALUES ('2','Hans Thibault','th@hotmail.fr', 'Demande info recrutement', 'Message de Test 2')");
		}
	}
	

	@Test
	public void shouldSaveContact() throws Exception {
		// GIVEN
		Contact contactToAdd = new Contact("3","maxime leader de mon cul","ms@gmail.com","Info","Message de Test 3");
		// WHEN
		Contact contactAdded = contactDao.saveContact(contactToAdd);
		// THEN
		Assertions.assertThat(contactAdded).isNotNull();
		Assertions.assertThat(contactAdded.getNom()).isEqualTo("maxime leader de mon cul");
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contact WHERE nom = ?")) {
			stmt.setString(1,contactAdded.getNom());
			try (ResultSet rs = stmt.executeQuery()) {
				//assertThat(rs.next()).isTrue();
				//assertThat(rs.getString("mail")).isEqualTo("desaegher.hugo@hotmail.fr");
			}
		}
	

	}
	
	@Test
	public void shouldDeleteContact() throws Exception {
		// GIVEN
		Contact contact = contactDao.getContactById("1");
		// WHEN
		contactDao.deleteContact(contact);
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
	
	
	

}