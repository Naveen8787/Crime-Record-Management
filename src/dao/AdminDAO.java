package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import utility.ConnectionManager;
import services.AdminDaoInterface;

public class AdminDAO implements AdminDaoInterface {
	
	public boolean loginAdmin(Admin admin) {
		boolean status = false;
		try{
			Connection connection = ConnectionManager.getConnection();
		
				//Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement("select * from ADMINlOGIN where USERNAME = ? and PASSWORD = ? ");
		
			preparedStatement.setString(1, admin.getUsername());
			preparedStatement.setString(2, admin.getPassword());

		//	System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status=rs.next();

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return status;
	}


}
	
	