package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to retrieve game content from the SQL server
 * 
 * @author Austin Bailey 2024 All Rights Reserved
 * 
 */
public class SQLContentRetriever implements ContentRetriever
{
	public List<String> getPrompt(int scenario_id)
	{
		List<String> result = new LinkedList();
		try
		{
			connectToSQLDB();
			Statement statement = connectToSQLDB().createStatement();
			ResultSet resultSet    = statement
					.executeQuery("select content from statement where scenario_id = " + scenario_id + " and choice_id = -1");
			while(resultSet.next())
			{
				result.add(resultSet.getString(1));
			}
		}
		catch (Exception e)
		{
			System.err.println("Issue connecting to sql server");
			e.printStackTrace();
		}
		System.out.println("result: " + result);
		return result;
	}

	public List<String> getChoices(int scenario_id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Connection connectToSQLDB()
	{
		Connection connection = null;
		try
		{
			FileReader reader = new FileReader();
			String     user   = reader.getDBUserFromFile();
			String     pass   = reader.getDBPassFromFile();

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/monsterMaster?user=" + user + "&password=" + pass);
		}
		catch (Exception e)
		{
			System.err.println("Failed to connect to SQL DB");
		}
		return connection;
	}

}
