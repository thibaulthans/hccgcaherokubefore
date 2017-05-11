package projet100h.hccgca.daos;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.hccgca.exceptions.CityExplorerRuntimeException;
import projet100h.hccgca.pojos.Recrutement;


public class RecrutementDao {
	
public void saveNewRecrutement(Integer idRecrutement, String prenom, String nom, String mail, String formation, String posteRecherche, String dateRecrutement, String lettreMotivation, InputStream cv){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO Recrutement(prenom, nom, mail, formation, posteRecherche, dateRecrutement, lettreMotivation, cv) VALUES(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,prenom);
			stmt.setString(2,nom);
			stmt.setString(3,mail);
			stmt.setString(4,formation);
			stmt.setString(5,posteRecherche);
			stmt.setString(6,dateRecrutement);
			stmt.setString(7,lettreMotivation);
			stmt.setBinaryStream(8,cv);

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new CityExplorerRuntimeException("Error when getting recrutement", e);
		}


}

public void deleteRecrutement(Integer idRecrutement){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM recrutement WHERE idRecrutement=?");
		stmt.setInt(1, idRecrutement);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public Recrutement getRecrutementById(Integer idRecrutement) {
	Recrutement recrutement = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM recrutement WHERE idRecrutement = ?")){
			stmt.setInt(1, idRecrutement);
			ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			 recrutement = new Recrutement( rs.getInt("idRecrutement"), rs.getString("prenom"), rs.getString("nom"), rs.getString("mail"), rs.getString("formation"), rs.getString("posteRecherche"), rs.getString("dateRecrutement"),rs.getString("lettreMotivation"));
		}
		rs.close();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return recrutement;
}

public List<Recrutement> listRecrutement() {
	String query = "SELECT * FROM recrutement";
	List<Recrutement> recrutements = new ArrayList<>(); 
	try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
		try (Statement statement = connection.createStatement()) {
			try (ResultSet rs = statement.executeQuery(query)) {
				while(rs.next()) {						
					recrutements.add(new Recrutement( rs.getInt("idRecrutement"), rs.getString("prenom"), rs.getString("nom"), rs.getString("mail"), rs.getString("formation"), rs.getString("posteRecherche"), rs.getString("dateRecrutement"), rs.getString("lettreMotivation")));
				}
			}
		}			
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return recrutements;
}

public InputStream getCv(Integer id) {
	try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT cv FROM recrutement WHERE idRecrutement = ?")) {
		statement.setInt(1, id);
		try (ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getBinaryStream("cv");
			}
		}
	} catch (SQLException e) {
		throw new CityExplorerRuntimeException("Error getting images", e);
	}
	return null;
}



}


