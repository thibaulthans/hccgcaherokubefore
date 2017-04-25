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

import projet100h.hccgca.pojos.Hcc;

public class HccDaoTest {

	private HccDao hccDao = new HccDao();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM hcc");
			stmt.executeUpdate("INSERT INTO `hcc`(`idHcc`,`titreHcc`,`texteHcc`) VALUES ('1','titre 1','texte 1')");
			stmt.executeUpdate("INSERT INTO `hcc`(`idHcc`,`titreHcc`,`texteHcc`) VALUES ('2','titre 2','texte 2')");
		}
	}
	
	@Test
	public void shouldAddHcc() throws Exception {
		// GIVEN
		Hcc hccToAdd = new Hcc("titre 3","texte 3");
		// WHEN
		Hcc hccAdded = hccDao.addHcc(hccToAdd.getTitreHcc(), hccToAdd.getTexteHcc());
		// THEN
		Assertions.assertThat(hccAdded).isNotNull();
		Assertions.assertThat(hccAdded.getTitreHcc()).isEqualTo("titre 3");
		
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM hcc WHERE texteHcc='texte 1'")) {
					assertThat(rs.next()).isTrue();
			
	}
}
	
	@Test
	public void shouldDeleteHcc() throws Exception {
		// GIVEN
		Hcc hcc = hccDao.getHccById("1");
		// WHEN
		hccDao.deleteHcc(hcc.getIdHcc());
		// THEN
		try (
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM hcc WHERE idHcc = ?")) {
			statement.setString(1, "1");
			try (ResultSet rs = statement.executeQuery()) {
				assertThat(rs.next()).isFalse();
				
			}
		}
	}


	
	@Test
	public void shoulUpdateHcc() throws Exception {
		// WHEN
		hccDao.updateHcc("1", "titre 1 modif", "texte 1 modif");
		// THEN
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM hcc WHERE idHcc = ?")) {
			stmt.setString(1, "1");
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getString("titreHcc")).isEqualTo("titre 1 modif");
				assertThat(rs.getString("texteHcc")).isEqualTo("texte 1 modif");
			}
		}
}
	
	@Test
	public void shouldListHcc() throws Exception {
		// WHEN
		List<Hcc> listhcc = hccDao.listHcc(); 
		// THEN
		Assertions.assertThat(listhcc).isNotNull();
		Assertions.assertThat(listhcc.get(0).getTitreHcc()).isEqualTo("titre 1");
		Assertions.assertThat(listhcc.get(1).getTexteHcc()).isEqualTo("texte 2");
		
	}
	
	@Test
	public void shouldGetHcc() throws Exception {
		// WHEN
		Hcc hcc = hccDao.getHccById("1"); 
		// THEN
		Assertions.assertThat(hcc).isNotNull();
		Assertions.assertThat(hcc.getTitreHcc()).isEqualTo("titre 1");
		Assertions.assertThat(hcc.getTexteHcc()).isEqualTo("texte 1");
		
	}
}
