package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.hccgca.pojos.Contact;
import projet100h.hccgca.pojos.Devis;


public class DevisDao {
	
public Devis saveNewDevis(Integer idDevis, String secteurActivite, String chiffreAffaire, String nbSalarie, String missions, int valeurFacture, String nom, String prenom, String mail, String informationsSupplementaires, String dateDevis){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO devis(secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis) VALUES(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, secteurActivite);
			stmt.setString(2, chiffreAffaire);
			stmt.setString(3, nbSalarie);
			stmt.setString(4, missions);
			stmt.setInt(5, valeurFacture);
			stmt.setString(6, nom);
			stmt.setString(7, prenom);
			stmt.setString(8, mail);
			stmt.setString(9, informationsSupplementaires);
			stmt.setString(10, dateDevis);
			stmt.executeUpdate();
			
			return new Devis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

public void deleteDevis(Integer idDevis){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM devis WHERE idDevis=?");
		stmt.setInt(1, idDevis);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public Devis getDevisById(Integer idDevis) {
	Devis devis = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM devis WHERE idDevis = ?")){
			stmt.setInt(1, idDevis);
			ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			 devis = new Devis(rs.getInt("idDevis"), rs.getString("secteurActivite"), rs.getString("chiffreAffaire"), rs.getString("nbSalarie"), rs.getString("missions"),
						rs.getInt("valeurFacture"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("informationsSupplementaires"), rs.getString("dateDevis"));
		}
		rs.close();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return devis;
}

public List<Devis> listDevis() {
	String query = "SELECT * FROM devis";
	List<Devis> devis = new ArrayList<>(); 
	try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
		try (Statement statement = connection.createStatement()) {
			try (ResultSet rs = statement.executeQuery(query)) {
				while(rs.next()) {						
					devis.add(new Devis(rs.getInt("idDevis"), rs.getString("secteurActivite"), rs.getString("chiffreAffaire"), rs.getString("nbSalarie"), rs.getString("missions"),
							 rs.getInt("valeurFacture"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("informationsSupplementaires"), rs.getString("dateDevis")));
				}
			}
		}			
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return devis;
}



}
