package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import projet100h.hccgca.pojos.Devis;


public class DevisDao {
	
public Devis saveDevis(Devis devis){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO devis(secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires) VALUES(?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,devis.getSecteurActivite());
			stmt.setString(2,devis.getChiffreAffaire());
			stmt.setString(3,devis.getNbSalarie());
			stmt.setString(4,devis.getMissions());
			stmt.setInt(5,devis.getValeurFacture());
			stmt.setString(6,devis.getNom());
			stmt.setString(7,devis.getPrenom());
			stmt.setString(8,devis.getMail());
			stmt.setString(9,devis.getInformationsSupplementaires());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devis;
	}

}
