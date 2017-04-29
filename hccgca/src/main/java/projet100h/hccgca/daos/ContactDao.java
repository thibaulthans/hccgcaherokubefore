package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.hccgca.pojos.Contact;


public class ContactDao {
	
public Contact saveNewContact(Integer idContact, String nom, String mail, String objet, String message, String dateContact){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO contact(nom, mail, objet, message, dateContact) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nom);
			stmt.setString(2, mail);
			stmt.setString(3, objet);
			stmt.setString(4, message);
			stmt.setString(5, dateContact);
			stmt.executeUpdate(); 
			
			return new Contact(idContact, nom, mail, objet, message, dateContact);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

public void deleteContact(Integer idContact){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM contact WHERE idContact=?");
		stmt.setInt(1, idContact);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public Contact getContactById(Integer idContact) {
	Contact contact = null;
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contact WHERE idContact = ?")){
			stmt.setInt(1, idContact);
			ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			 contact = new Contact(rs.getInt("idContact"), rs.getString("nom"), rs.getString("mail"), rs.getString("objet"), rs.getString("message"), rs.getString("dateContact"));
		}
		rs.close();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return contact;
}

public List<Contact> listContacts() {
	ArrayList<Contact> lstcontact = new ArrayList<>();
	try (
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contact")){
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			 lstcontact.add(new Contact(rs.getInt("idContact"), rs.getString("nom"), rs.getString("mail"), rs.getString("objet"), rs.getString("message"), rs.getString("dateContact")));
		}
		rs.close();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return lstcontact;
}

}
