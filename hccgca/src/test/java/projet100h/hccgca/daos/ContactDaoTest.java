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
			stmt.executeUpdate("INSERT INTO `contact`(`nom`,`mail`,`objet`,`message`) VALUES ('Desaegher Hugo','desaegher.hugo@hotmail.fr', 'Demande info devis', 'Message de Test')");
		}
	}
	

	@Test
	public void shouldSaveContact() throws Exception {
		// GIVEN
		Contact contactToAdd = new Contact("Hans Thibault","Hans.Thibault@gmail.com","Info recrutement","Message de Test 2");
		// WHEN
		Contact contactAdded = contactDao.saveContact(contactToAdd);
		// THEN
		Assertions.assertThat(contactAdded).isNotNull();
		Assertions.assertThat(contactAdded.getNom()).isEqualTo("Hans Thibault");
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contact WHERE nom = ?")) {
			stmt.setString(1,contactAdded.getNom());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getString("mail")).isEqualTo("Hans.Thibault@gmail.com");
			}
		}
	

	}
	
	
	

}
