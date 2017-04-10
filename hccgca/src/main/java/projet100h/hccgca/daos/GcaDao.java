package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projet100h.hccgca.pojos.Gca;

public class GcaDao {
	
	public Gca addGca(Gca gca) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("INSERT INTO gca(titreGca, texteGca) VALUES(?,?)");
			statement.setString(1, gca.getTitreGca());
			statement.setString(2, gca.getTexteGca());
			return gca;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteGca(Gca gca){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE FROM gca WHERE titreGca=?");
			statement.setString(1, gca.getTitreGca());
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Gca updateGca(Gca gca) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("UPDATE gca SET titreGca=?, texteGca=?)");
			statement.setString(1, gca.getTitreGca());
			statement.setString(2, gca.getTexteGca());
			return gca;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Gca getGcaByTitre(String titreGca) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM gca WHERE titreGca=?");
			statement.setString(1, titreGca);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
