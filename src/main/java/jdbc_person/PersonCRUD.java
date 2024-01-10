package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCRUD {
	
	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb","root","root");
		
		return connection;
	}
	
//	1. Insert data into the table
	public void savePerson(int id, String name, int age, long phone, String address) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?)");
		
		preparedStatement.setInt(1,id);
		preparedStatement.setString(2,name);
		preparedStatement.setInt(3,age);
		preparedStatement.setLong(4,phone);
		preparedStatement.setString(5,address);
		
		int result = preparedStatement.executeUpdate();
		
		if (result!=0) 
		{
			System.out.println("Data Inserted");
		} 
		else 
		{
			System.out.println("Data Not Inserted");
		}
		
		connection.close();
		
	}
	
//	2. Fetch data from the table
	public void readPerson(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
		
		preparedStatement.setInt(1,id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) 
		{
			System.out.println(resultSet.getInt("id"));
			
			System.out.println(resultSet.getString("name"));
			
			System.out.println(resultSet.getInt("age"));
			
			System.out.println(resultSet.getLong("phone"));
			
			System.out.println(resultSet.getString("address"));
			
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
	}
	
//	3. Update data in the table
	public void updatePerson(int id, String name, int age, long phone, String address) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PERSON SET NAME=?,AGE=?,PHONE=?,ADDRESS=? WHERE ID=?");
		
		preparedStatement.setString(1,name);
		preparedStatement.setInt(2,age);
		preparedStatement.setLong(3,phone);
		preparedStatement.setString(4,address);
		preparedStatement.setInt(5,id);
		
		int result = preparedStatement.executeUpdate();
		
		if (result!=0) 
		{
			System.out.println("Data Updated");
		} 
		else 
		{
			System.out.println("Data Not Updated");
		}
		
		connection.close();
		
	}
	
//	4. Delete data from the table
	public void deletePerson(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		
		preparedStatement.setInt(1, id);

		int result = preparedStatement.executeUpdate();
		
		if (result!=0) 
		{
			System.out.println("Data Deleted");
		} 
		else 
		{
			System.out.println("Data Not Deleted");
		}
		
		connection.close();
		
	}
}
