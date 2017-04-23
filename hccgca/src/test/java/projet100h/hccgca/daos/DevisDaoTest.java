package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

import projet100h.hccgca.pojos.Devis;

public class DevisDaoTest {
	
	private DevisDao devisDao = new DevisDao();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM devis");
			stmt.executeUpdate("INSERT INTO `devis`(`idDevis`,`secteurActivite`,`chiffreAffaire`,`nbSalarie`,`missions`,`valeurFacture`,`nom`,`prenom`,`mail`,`informationsSupplementaires`) VALUES ('1','Droit','inférieur 200k','20 à 50', 'Comptable', 100,'Desaegher','Hugo', 'desaegher.hugo@hotmail.fr', 'Message de Test')");
			stmt.executeUpdate("INSERT INTO `devis`(`idDevis`,`secteurActivite`,`chiffreAffaire`,`nbSalarie`,`missions`,`valeurFacture`,`nom`,`prenom`,`mail`,`informationsSupplementaires`) VALUES ('2','Immobilier','supérieur à 2M','supérieur à 50', 'social', 200,'Hans','Thibault', 'Hans.Thibault@gmail.com', 'Message de Test2')");
		}
	}
	
	@Test
	public void shouldSaveDevis() throws Exception {
		// GIVEN
		Devis devisToAdd = new Devis("3","Communication","entre 500k et 1M","10 à 20", "Comptable", 150,"Dupont","Richard","RichardDupont@hotmail.fr","Message de Test 3");
		// WHEN
		Devis devisAdded = devisDao.saveDevis(devisToAdd);
		// THEN
		Assertions.assertThat(devisAdded).isNotNull();
		Assertions.assertThat(devisAdded.getMissions()).isEqualTo("Comptable");
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM devis WHERE missions = ?")) {
			stmt.setString(1,devisAdded.getMissions());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getString("prenom")).isEqualTo("Hugo");
			}
		}
	

	}
	
	@Test
	public void shouldDeleteDevis() throws Exception {
		// GIVEN
		Devis devis = devisDao.getDevisById("2");
		// WHEN
		devisDao.deleteDevis(devis);
		// THEN
		try (
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM devis WHERE idDevis = ?")) {
			stmt.setString(1, "2");
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isFalse();
				
			}
		}
		
}
}