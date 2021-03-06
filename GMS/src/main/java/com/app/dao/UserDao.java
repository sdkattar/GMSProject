package com.app.dao;

import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.model.User;

public class UserDao {

	private String jdbcUrl="jdbc:mysql://localhost:3306/gms_project?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="manager";
	
	private static String insertQuery="insert into user (name,email,phone,password) values(?,?,?,?)";
	
	//connection
	protected Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	//insert user
	public void registerUser(User user) throws SQLException {
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(insertQuery)){
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4,user.getPassword());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
