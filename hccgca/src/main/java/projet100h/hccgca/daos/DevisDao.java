package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.hccgca.pojos.Devis;


public class DevisDao {
	
public Devis saveNewDevis(String idDevis, String secteurActivite, String chiffreAffaire, String nbSalarie, String missions, int valeurFacture, String nom, String prenom, String mail, String informationsSupplementaires, String dateDevis){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO devis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis) VALUES(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, idDevis);
			stmt.setString(2, secteurActivite);
			stmt.setString(3, chiffreAffaire);
			stmt.setString(4, nbSalarie);
			stmt.setString(5, missions);
			stmt.setInt(6, valeurFacture);
			stmt.setString(7, nom);
			stmt.setString(8, prenom);
			stmt.setString(9, mail);
			stmt.setString(10, informationsSupplementaires);
			stmt.setString(11, dateDevis);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			
			return new Devis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

public void deleteDevis(String idDevis){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM devis WHERE idDevis=?");
		stmt.setString(1, idDevis);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public Devis getDevisById(String idDevis) {
	Devis devis = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM devis WHERE idDevis = ?")){
			stmt.setString(1, idDevis);
			ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			 devis = new Devis(rs.getString("idDevis"), rs.getString("secteurActivite"), rs.getString("chiffreAffaire"), rs.getString("nbSalarie"), rs.getString("missions"),
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
	ArrayList<Devis> lstdevis = new ArrayList<>();
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM devis")){
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			 lstdevis.add(new Devis(rs.getString("idDevis"), rs.getString("secteurActivite"), rs.getString("chiffreAffaire"), rs.getString("nbSalarie"), rs.getString("missions"),
					 rs.getInt("valeurFacture"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("informationsSupplementaires"), rs.getString("dateDevis")));
		}
		rs.close();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return lstdevis;
}


}
