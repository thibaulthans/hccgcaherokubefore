package projet100h.hccgca.daos;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		Hcc hccToAdd = new Hcc("3","titre 3","texte 3");
		// WHEN
		Hcc hccAdded = hccDao.addHcc(hccToAdd);
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
		hccDao.deleteHcc(hcc);
		// THEN
		try (
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM hcc WHERE idHcc = ?")) {
			statement.setString(1, "titre 4");
			try (ResultSet rs = statement.executeQuery()) {
				assertThat(rs.next()).isFalse();
				
			}
		}
	}


	
	@Test
	public void shoulUpdateHcc() throws Exception {
		// WHEN
		hccDao.updateHcc("1","titre 1", "texte 1");
		// THEN
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM hcc WHERE idHcc = ?")) {
			stmt.setString(1, "1");
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getString("titreHcc")).isEqualTo("titre 1");
				assertThat(rs.getString("texteHcc")).isEqualTo("texte 1");
			}
		}
}
}
