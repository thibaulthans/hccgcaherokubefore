package projet100h.hccgca.daos;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


import projet100h.hccgca.pojos.Recrutement;

public class RecrutementDaoTest {
	
	private RecrutementDao recrutementDao = new RecrutementDao();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM recrutement");
			stmt.executeUpdate("INSERT INTO `recrutement`(`prenom`,`nom`,`mail`,`formation`,`posteRecherche`,`cv`,`lettreMotivation`) VALUES ('Hugo','Desaegher','desaegher.hugo@hotmail.fr','ingenieur','audit','cv.pdf', 'lm.pdf')");
		}
	}
	

	@Test
	public void shouldSaveRecrutement() throws Exception {
		// GIVEN
		Recrutement recrutementToAdd = new Recrutement("Thibault", "Hans", "Thibault.Hans@gmail.com", "ingénieur", "Audit", "cv.pdf", "lm.pdf");
		// WHEN
		Recrutement recrutementAdded = recrutementDao.saveRecrutement(recrutementToAdd);
		// THEN
		Assertions.assertThat(recrutementAdded.getPrenom()).isEqualTo("Thibault");
		Assertions.assertThat(recrutementAdded.getNom()).isEqualTo("Hans");
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM recrutement WHERE prenom = 'Hugo'")) {
				assertThat(rs.next()).isTrue();
				
			}
	}
	
}