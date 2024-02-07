package com.greenwolfgames.MonsterMaster;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonsterManager
{
	private static ArrayList<MonsterType> m_monsterTypes;

	public List<MonsterType> getMonsterTypes()
	{
		if (m_monsterTypes != null)
		{
			return m_monsterTypes;
		}
		readMonsterTypesFromDB();
		return m_monsterTypes;
	}

	private void readMonsterTypesFromDB()
	{
		ArrayList<IntermediateMonsterType> intermediateMonsterTypes = new ArrayList<>();
		ElementManager.getSubElements();//
		try
		{
			ResultSet monsterTypeResultSet = SQLContentRetriever.connectToSQLDB().createStatement()
					.executeQuery("select * from monster_type");
			m_monsterTypes = new ArrayList<>();
			while (monsterTypeResultSet.next())
			{
				// TODO use builder patter to clean construction up, and fix deprecated Integer class
				m_monsterTypes.add(new MonsterType(monsterTypeResultSet.getInt(1), monsterTypeResultSet.getString(2),
						monsterTypeResultSet.getString(3),
						ElementManager.getSubElementById(monsterTypeResultSet.getInt(4)),
						new Integer(monsterTypeResultSet.getInt(5)), new Integer(monsterTypeResultSet.getInt(6)),
						new Integer(monsterTypeResultSet.getInt(7)), new Integer(monsterTypeResultSet.getInt(8))));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//need to resolve the evolutions by assigning the correct mosnter types now they are in context
		for(MonsterType type : m_monsterTypes)
		{
			resolveEvolutions(type);
		}
	}
	
	private void resolveEvolutions(MonsterType monsterTypeToResolve)
	{
		for(MonsterType potentialMatch : m_monsterTypes)
		{
			if(monsterTypeToResolve.getPreviousEvolutionIndex() != null)
			{
				//TODO logic here
			}
		}
		
	}
}
