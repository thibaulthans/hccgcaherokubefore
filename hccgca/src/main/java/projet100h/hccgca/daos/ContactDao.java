package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projet100h.hccgca.pojos.Contact;


public class ContactDao {
	
public Contact saveContact(Contact contact){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO contact(idContact, nom, mail, objet, message) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,contact.getIdContact());
			stmt.setString(2,contact.getNom());
			stmt.setString(3,contact.getMail());
			stmt.setString(4,contact.getObjet());
			stmt.setString(5,contact.getMessage());
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

public void deleteContact(Contact contact){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM contact WHERE idContact=?");
		stmt.setString(1, contact.getIdContact());
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public Contact getContactById(String idContact) {
	Contact contact = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contact WHERE idContact = ?")){
			stmt.setString(1, idContact);
			ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			 contact = new Contact(rs.getString("idContact"), rs.getString("nom"), rs.getString("mail"), rs.getString("objet"), rs.getString("message"));
		}
		rs.close();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return contact;
}


}
