package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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
			stmt.executeUpdate("INSERT INTO `devis`(`idDevis`,`secteurActivite`,`chiffreAffaire`,`nbSalarie`,`missions`,`valeurFacture`,`nom`,`prenom`,`mail`,`informationsSupplementaires`,`dateDevis`) VALUES ('1','Droit','inférieur 200k','20 à 50', 'Comptable', 100,'Desaegher','Hugo', 'desaegher.hugo@hotmail.fr', 'Message de Test', '26-04-2017')");
			stmt.executeUpdate("INSERT INTO `devis`(`idDevis`,`secteurActivite`,`chiffreAffaire`,`nbSalarie`,`missions`,`valeurFacture`,`nom`,`prenom`,`mail`,`informationsSupplementaires`,`dateDevis`) VALUES ('2','Immobilier','supérieur à 2M','supérieur à 50', 'social', 200,'Hans','Thibault', 'Hans.Thibault@gmail.com', 'Message de Test2', '26-04-2017')");
		}
	}
	
	@Test
	public void shouldSaveDevis() throws Exception {
		// GIVEN
		Devis devisToAdd = new Devis("3","Communication","entre 500k et 1M","10 à 20", "Comptable", 150,"Dupont","Richard","RichardDupont@hotmail.fr","Message de Test 3","26-04-2017");
		// WHEN
		Devis devisAdded = devisDao.saveNewDevis(devisToAdd.getIdDevis(), devisToAdd.getSecteurActivite(), devisToAdd.getChiffreAffaire(), devisToAdd.getNbSalarie(), devisToAdd.getMissions(), devisToAdd.getValeurFacture(), devisToAdd.getNom(), devisToAdd.getPrenom(), devisToAdd.getMail(), devisToAdd.getInformationsSupplementaires(), devisToAdd.getDateDevis());
		// THEN
		Assertions.assertThat(devisAdded).isNotNull();
		Assertions.assertThat(devisAdded.getSecteurActivite()).isEqualTo("Communication");
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM devis WHERE nom='Dupont'")) {
				assertThat(rs.next()).isTrue();
				
			}
		}
	

	
	@Test
	public void shouldDeleteDevis() throws Exception {
		// GIVEN
		Devis devis = devisDao.getDevisById("1");
		// WHEN
		devisDao.deleteDevis(devis.getIdDevis());
		// THEN
		try (
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM devis WHERE idDevis = ?")) {
			stmt.setString(1, "1");
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isFalse();
				
			}
		}
		
	}
	
	@Test
	public void shouldListDevis() throws Exception {
		// WHEN
		List<Devis> listDevis = devisDao.listDevis(); 
		// THEN1
		Assertions.assertThat(listDevis).isNotNull();
		Assertions.assertThat(listDevis.get(0).getNom()).isEqualTo("Desaegher");
		Assertions.assertThat(listDevis.get(1).getNbSalarie()).isEqualTo("supérieur à 50");
		
	}
	
	@Test
	public void shouldGetDevis() throws Exception {
		// WHEN
		Devis devis = devisDao.getDevisById("1"); 
		// THEN
		Assertions.assertThat(devis).isNotNull();
		Assertions.assertThat(devis.getIdDevis()).isEqualTo("1");
		Assertions.assertThat(devis.getChiffreAffaire()).isEqualTo("inférieur 200k");
		
	}
	
}