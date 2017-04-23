package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import projet100h.hccgca.pojos.Recrutement;


public class RecrutementDao {
	
public Recrutement saveRecrutement(Recrutement recrutement){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO Recrutement(prenom, nom, mail, formation, posteRecherche, cv, lettreMotivation) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,recrutement.getPrenom());
			stmt.setString(2,recrutement.getNom());
			stmt.setString(3,recrutement.getMail());
			stmt.setString(4,recrutement.getFormation());
			stmt.setString(5,recrutement.getPosteRecherche());
			stmt.setString(6,recrutement.getCv());
			stmt.setString(7,recrutement.getLettreMotivation());

			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recrutement;
	}

}
