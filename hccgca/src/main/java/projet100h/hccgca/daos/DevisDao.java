package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projet100h.hccgca.pojos.Devis;


public class DevisDao {
	
public Devis saveDevis(Devis devis){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO devis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires) VALUES(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,devis.getIdDevis());
			stmt.setString(2,devis.getSecteurActivite());
			stmt.setString(3,devis.getChiffreAffaire());
			stmt.setString(4,devis.getNbSalarie());
			stmt.setString(5,devis.getMissions());
			stmt.setInt(6,devis.getValeurFacture());
			stmt.setString(7,devis.getNom());
			stmt.setString(8,devis.getPrenom());
			stmt.setString(9,devis.getMail());
			stmt.setString(10,devis.getInformationsSupplementaires());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devis;
	}

public void deleteDevis(Devis devis){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM devis WHERE idDevis=?");
		stmt.setString(1, devis.getIdDevis());
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
						rs.getInt("valeurFacture"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("informationsSupplementaires"));
		}
		rs.close();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return devis;
}


}
