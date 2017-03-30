package projet100h.hccgca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import projet100h.hccgca.pojos.Contact;

public class ContactDao {
	
public Contact saveContact(Contact contact){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO contact(nom,mail,objet,message) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,contact.getNom());
			stmt.setString(2,contact.getMail());
			stmt.setString(3,contact.getObjet());
			stmt.setString(4,contact.getMessage());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}


}