package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projet100h.hccgca.pojos.Hcc;

public class HccDao {

public Hcc addHcc(String titreHcc, String texteHcc) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("INSERT INTO `hcc`(`titreHcc`, `texteHcc`) VALUES(?,?)");
		statement.setString(1, titreHcc);
		statement.setString(2, texteHcc);
		
		return new Hcc(titreHcc, texteHcc);
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public void deleteHcc(String idHcc){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("DELETE FROM hcc WHERE idHcc=?");
		statement.setString(1, idHcc);
		statement.executeUpdate();	
		statement.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}


public void updateHcc(String idHcc, String titreHcc, String texteHcc) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("UPDATE hcc SET titreHcc=?, texteHcc=? WHERE idHcc=?");
		statement.setString(1, titreHcc);
		statement.setString(2, texteHcc);
		statement.setString(3, idHcc);
		statement.executeUpdate();
		statement.close();
connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}

public Hcc getHccById(String idHcc) {
	Hcc hcc = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM hcc WHERE idHcc=?")){
		statement.setString(1, idHcc);
			ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			 hcc = new Hcc(rs.getString("idHcc"), rs.getString("titreHcc"),rs.getString("texteHcc"));
		}
		rs.close();
		statement.close();
connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return hcc;
}

public List<Hcc> listHcc() {
	ArrayList<Hcc> lsthcc = new ArrayList<>(); 
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM hcc")){
			ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			 lsthcc.add(new Hcc(rs.getString("idHcc"), rs.getString("titreHcc"),rs.getString("texteHcc")));
		}
		rs.close();
		statement.close();
connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return lsthcc;
}
	
}
