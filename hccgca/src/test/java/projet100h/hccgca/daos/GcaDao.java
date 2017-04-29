package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projet100h.hccgca.pojos.Gca;

public class GcaDao {

public Gca addGca(String titreGca, String texteGca) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("INSERT INTO `gca`(`titreGca`, `texteGca`) VALUES(?,?)");
		statement.setString(1, titreGca);
		statement.setString(2, texteGca);
		
		return new Gca(titreGca, texteGca);
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public void deleteGca(String idGca){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("DELETE FROM gca WHERE idGca=?");
		statement.setString(1, idGca);
		statement.executeUpdate();	
		statement.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}


public void updateGca(String idGca, String titreGca, String texteGca) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("UPDATE gca SET titreGca=?, texteGca=? WHERE idGca=?");
		statement.setString(1, titreGca);
		statement.setString(2, texteGca);
		statement.setString(3, idGca);
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
			 gca = new Gca(rs.getString("idGca"), rs.getString("titreGca"),rs.getString("texteGca"));
		}
		rs.close();
		statement.close();
connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return gca;
}

public List<Gca> getGca() {
	ArrayList<Gca> lstgca = new ArrayList<>(); 
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM gca")){
			ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			 lstgca.add(new Gca(rs.getString("idGca"), rs.getString("titreGca"),rs.getString("texteGca")));
		}
		rs.close();
		statement.close();
connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return lstgca;
}
	
}
