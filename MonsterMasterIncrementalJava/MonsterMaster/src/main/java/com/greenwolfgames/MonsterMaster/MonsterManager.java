package com.greenwolfgames.MonsterMaster;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MonsterManager
{
	private static ArrayList<MonsterType> m_monsterTypes;
	private static Multimap<SubElement, MonsterType> m_monsterTypesBySubElement;

	public List<MonsterType> getMonsterTypes()
	{
		if (m_monsterTypes != null)
		{
			return m_monsterTypes;
		}
		readMonsterTypesFromDB();
		return m_monsterTypes;
	}
	
	public Multimap<SubElement, MonsterType> getMonsterTypesBySubElement()
	{
		if(m_monsterTypesBySubElement != null)
		{
			return m_monsterTypesBySubElement;
		}
		if(m_monsterTypes == null)
		{
			readMonsterTypesFromDB();
		}
		m_monsterTypesBySubElement = ArrayListMultimap.create();
		for(MonsterType type : m_monsterTypes)
		{
			m_monsterTypesBySubElement.put(type.getSubElement(), type);
		}
		return m_monsterTypesBySubElement;
		
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
		//need to resolve the evolutions by assigning the correct monster types now they are in context
		for(MonsterType type : m_monsterTypes)
		{
			resolveEvolutions(type);
		}
	}
	
	private void resolveEvolutions(MonsterType monsterTypeToResolve)
	{
		for(MonsterType potentialMatch : getMonsterTypesBySubElement().get(monsterTypeToResolve.getSubElement()))
		{
			//Stop resolving evolutions if they're all already resolved
			if(shouldStopResolvingEvolutions(monsterTypeToResolve))
			{
				return;
			}
			if(monsterTypeToResolve.getPreviousEvolutionIndex() == potentialMatch.getIndex())
			{
				monsterTypeToResolve.setPreviousEvolution(potentialMatch);
				continue;//potential match cannot be a different type of evolution as well
			}
			if(monsterTypeToResolve.getPhysicalEvolutionIndex() == potentialMatch.getIndex())
			{
				monsterTypeToResolve.setPhysicalEvolution(potentialMatch);
//				potentialMatch.setPreviousEvolution(monsterTypeToResolve);
				continue;
			}
			if(monsterTypeToResolve.getBalancedEvolutionIndex() == potentialMatch.getIndex())
			{
				monsterTypeToResolve.setBalancedEvolution(potentialMatch);
				continue;
			}
			if(monsterTypeToResolve.getMagicalEvolutionIndex() == potentialMatch.getIndex())
			{
				monsterTypeToResolve.setMagicalEvolution(potentialMatch);
			}			
		}
		
	}
	
	private boolean shouldStopResolvingEvolutions(MonsterType monsterType)
	{
		boolean previousEvolutionsResolved = monsterType.getPreviousEvolution() != null || monsterType.getPreviousEvolutionIndex() == 0;
		boolean physicalEvolutionsResolved = monsterType.getPhysicalEvolution() != null || monsterType.getPhysicalEvolutionIndex() == 0;
		boolean balancedEvolutionsResolved = monsterType.getBalancedEvolution() != null || monsterType.getBalancedEvolutionIndex() == 0;
		boolean magicalEvolutionsResolved  = monsterType.getMagicalEvolution()  != null || monsterType.getMagicalEvolutionIndex() == 0;
		return previousEvolutionsResolved && physicalEvolutionsResolved && balancedEvolutionsResolved && magicalEvolutionsResolved;
	}
}
