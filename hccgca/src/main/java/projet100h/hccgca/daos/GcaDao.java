package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import projet100h.hccgca.pojos.Gca;

public class GcaDao {

public Gca addGca(Gca gca) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("INSERT INTO `gca`(`idGca`, `titreGca`, `texteGca`) VALUES(?,?,?)");
		statement.setString(1, gca.getIdGca());
		statement.setString(2, gca.getTitreGca());
		statement.setString(3, gca.getTexteGca());
		
		return gca;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public void deleteGca(Gca gca){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("DELETE FROM gca WHERE idGca=?");
		statement.setString(1, gca.getIdGca());
		statement.executeUpdate();	
		statement.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}


public void updateGca(String idGca, String titreGca, String texteGca) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("UPDATE gca SET idGca=?, titreGca=?, texteGca=?)");
		statement.setString(1, idGca);
		statement.setString(2, titreGca);
		statement.setString(3, texteGca);
		statement.executeUpdate();
		statement.close();
connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}

public Gca getGcaById(String idGca) {
	Gca gca = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM gca WHERE idGca=?")){
		statement.setString(1, idGca);
			ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			 gca = new Gca(rs.getString("idGca"), rs.getString("titreGca"), rs.getString("texteGca"));
		}
		rs.close();
		statement.close();
connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return gca;
}
	
}
