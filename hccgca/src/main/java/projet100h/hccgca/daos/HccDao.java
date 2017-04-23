package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import projet100h.hccgca.pojos.Hcc;

public class HccDao {

public Hcc addHcc(Hcc hcc) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("INSERT INTO `hcc`(`idHcc`, `titreHcc`, `texteHcc`) VALUES(?,?,?)");
		statement.setString(1, hcc.getIdHcc());
		statement.setString(2, hcc.getTitreHcc());
		statement.setString(3, hcc.getTexteHcc());
		
		return hcc;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public void deleteHcc(Hcc hcc){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("DELETE FROM hcc WHERE idHcc=?");
		statement.setString(1, hcc.getIdHcc());
		statement.executeUpdate();	
		statement.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}


public void updateHcc(String idHcc, String titreHcc, String texteHcc) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("UPDATE hcc SET idHcc=?, titreHcc=?, texteHcc=?)");
		statement.setString(1, idHcc);
		statement.setString(2, titreHcc);
		statement.setString(3, texteHcc);
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
			 hcc = new Hcc(rs.getString("idHcc"), rs.getString("titreHcc"), rs.getString("texteHcc"));
		}
		rs.close();
		statement.close();
connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return hcc;
}
	
}
