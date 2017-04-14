package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import projet100h.hccgca.pojos.Hcc;

public class HccDao {

public Hcc addHcc(Hcc hcc) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("INSERT INTO hcc(titreHcc, texteHcc) VALUES(?,?)");
		statement.setString(1, hcc.getTitreHcc());
		statement.setString(2, hcc.getTexteHcc());
		return hcc;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public void deleteHcc(Hcc hcc){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("DELETE FROM hcc WHERE titreHcc=?");
		statement.setString(1, hcc.getTitreHcc());
		statement.executeUpdate();	
		statement.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}

/*public void deleteEmploye(Employe employe){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM employes WHERE idEmploye=?");
		stmt.setString(1,employe.getIdEmploye());
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}*/


public void updateHcc(String titreHcc, String texteHcc) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("UPDATE hcc SET titreHcc=?, texteHcc=?)");
		statement.setString(1, titreHcc);
		statement.setString(2, texteHcc);
		statement.executeUpdate();
		statement.close();
connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}

public Hcc getHccByTitre(String titreHcc) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM hcc WHERE titreHcc=?");
		statement.setString(1, titreHcc);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
	
}
