package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.hccgca.pojos.Gca;

public class GcaDao {

public Gca addGca(Integer idGca, String titreGca, String texteGca) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO gca(titreGca, texteGca) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, titreGca);
		statement.setString(2, texteGca);
		statement.executeUpdate();
		
		return new Gca(idGca, titreGca, texteGca);
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public void deleteGca(Integer idGca){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM gca WHERE idGca=?");
		statement.setInt(1, idGca);
		statement.executeUpdate();	
		statement.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}


public void updateGca(Integer idGca, String titreGca, String texteGca) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE gca SET titreGca=?, texteGca=? WHERE idGca=?");
		statement.setString(1, titreGca);
		statement.setString(2, texteGca);
		statement.executeUpdate();
		statement.close();
connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}

public Gca getGcaById(Integer idGca) {
	Gca gca = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM gca WHERE idGca=?")){
		statement.setInt(1, idGca);
			ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			 gca = new Gca(rs.getInt("idGca"), rs.getString("titreGca"),rs.getString("texteGca"));
		}
		rs.close();
		statement.close();
connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return gca;
}

public List<Gca> listGca() {
	ArrayList<Gca> lstgca = new ArrayList<>(); 
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM gca")){
			ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			 lstgca.add(new Gca(rs.getInt("idGca"), rs.getString("titreGca"),rs.getString("texteGca")));
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
