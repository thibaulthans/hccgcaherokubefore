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

import projet100h.hccgca.pojos.Gca;

public class GcaDaoTest {

	private GcaDao gcaDao = new GcaDao();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM gca");
			stmt.executeUpdate("INSERT INTO `gca`(`idGca`,`titreGca`,`texteGca`) VALUES ('1','titre 1','texte 1')");
			stmt.executeUpdate("INSERT INTO `gca`(`idGca`,`titreGca`,`texteGca`) VALUES ('2','titre 2','texte 2')");
		}
	}
	
	@Test
	public void shouldAddGca() throws Exception {
		// GIVEN
		Gca gcaToAdd = new Gca("titre 3","texte 3");
		// WHEN
		Gca gcaAdded = gcaDao.addGca(gcaToAdd.getTitreGca(), gcaToAdd.getTexteGca());
		// THEN
		Assertions.assertThat(gcaAdded).isNotNull();
		Assertions.assertThat(gcaAdded.getTitreGca()).isEqualTo("titre 3");
		
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM gca WHERE texteGca='texte 1'")) {
					assertThat(rs.next()).isTrue();
			
	}
}
	
	@Test
	public void shouldDeleteGca() throws Exception {
		// GIVEN
		Gca gca = gcaDao.getGcaById("1");
		// WHEN
		gcaDao.deleteGca(gca.getIdGca());
		// THEN
		try (
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM gca WHERE idGca = ?")) {
			statement.setString(1, "1");
			try (ResultSet rs = statement.executeQuery()) {
				assertThat(rs.next()).isFalse();
				
			}
		}
	}


	
	@Test
	public void shoulUpdateGca() throws Exception {
		// WHEN
		gcaDao.updateGca("1", "titre 1 modif", "texte 1 modif");
		// THEN
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM gca WHERE idGca = ?")) {
			stmt.setString(1, "1");
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getString("titreGca")).isEqualTo("titre 1 modif");
				assertThat(rs.getString("texteGca")).isEqualTo("texte 1 modif");
			}
		}
}
	
	@Test
	public void shouldListGca() throws Exception {
		// WHEN
		List<Gca> listgca = gcaDao.getGca(); 
		// THEN
		Assertions.assertThat(listgca).isNotNull();
		Assertions.assertThat(listgca.get(0).getTitreGca()).isEqualTo("titre 1");
		Assertions.assertThat(listgca.get(1).getTexteGca()).isEqualTo("texte 2");
		
	}
	
	@Test
	public void shouldGetGca() throws Exception {
		// WHEN
		Gca gca = gcaDao.getGcaById("1"); 
		// THEN
		Assertions.assertThat(gca).isNotNull();
		Assertions.assertThat(gca.getTitreGca()).isEqualTo("titre 1");
		Assertions.assertThat(gca.getTexteGca()).isEqualTo("texte 1");
		
	}
}
