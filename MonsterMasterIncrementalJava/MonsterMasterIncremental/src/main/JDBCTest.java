package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBCTest
{

	private Connection        connect           = null;
	private Statement         statement         = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet         resultSet         = null;

	public void readDataBase() throws Exception
	{
		try
		{
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/monsterMaster?user=admin&password=14g13v3K@Chuck");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from primary_element");
//			System.out.println(resultSet);
			writeResultSet(resultSet);

		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			close();
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException
	{
		while (resultSet.next())
		{
			System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
		}
	}
	
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
