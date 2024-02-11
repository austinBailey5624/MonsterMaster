package com.greenwolfgames.MonsterMaster;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MonsterManager
{
	private static List<MonsterType>                 m_monsterTypes;
	private static Multimap<SubElement, MonsterType> m_monsterTypesBySubElement;
	private static List<MonsterType.Builder>         m_monsterTypeBuilders;

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
		if (m_monsterTypesBySubElement != null)
		{
			return m_monsterTypesBySubElement;
		}
		if (m_monsterTypes == null)
		{
			readMonsterTypesFromDB();
		}
		m_monsterTypesBySubElement = ArrayListMultimap.create();
		for (MonsterType type : m_monsterTypes)
		{
			m_monsterTypesBySubElement.put(type.getSubElement(), type);
		}
		return m_monsterTypesBySubElement;
	}

	private MonsterType getMonsterTypeFromIndex(int index, List<MonsterType> monsterTypes)
	{
		if (index == 0)
		{
			return null;
		}
		for (MonsterType type : monsterTypes)
		{
			if (type.getIndex() == index)
			{
				return type;
			}
		}
		throw new IllegalStateException("Monster type with index " + index + " not found in list");
	}

	private void readMonsterTypesFromDB()
	{
		ArrayList<IntermediateMonsterType> intermediateMonsterTypes = new ArrayList<>();
		ElementManager.getSubElements();
		m_monsterTypeBuilders = new ArrayList<>();
		try
		{
			ResultSet monsterTypeResultSet = SQLContentRetriever.connectToSQLDB().createStatement()
					.executeQuery("select * from monster_type");

			while (monsterTypeResultSet.next())
			{
				m_monsterTypeBuilders.add(new MonsterType.Builder().setIndex(monsterTypeResultSet.getInt(1))
						.setName(monsterTypeResultSet.getString(2)).setDescription(monsterTypeResultSet.getString(3))
						.setSubElement(ElementManager.getSubElementById(monsterTypeResultSet.getInt(4)))
						.setPhysicalEvolutionIndex(monsterTypeResultSet.getInt(5))
						.setBalancedEvolutionIndex(monsterTypeResultSet.getInt(6))
						.setMagicalEvolutionIndex(monsterTypeResultSet.getInt(7))
						.setPreviousEvolutionIndex(monsterTypeResultSet.getInt(8)));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		for (MonsterType.Builder type : m_monsterTypeBuilders)
		{
			if (type.getPreviousEvolutionIndex() == 0)
			{
				resolveParentMonsterTypes(type);
			}
		}
		for (MonsterType.Builder type : m_monsterTypeBuilders)
		{
			MonsterType monsterType = type.build();
			monsterType.setPreviousEvolution(
					getMonsterTypeFromIndex(type.getPreviousEvolutionIndex(), MonsterType.getMonsterTypes()));
		}
		m_monsterTypes = MonsterType.getMonsterTypes();
	}

	private MonsterType.Builder getBuilderByIndex(int index)
	{
		for (MonsterType.Builder builder : m_monsterTypeBuilders)
		{
			if (builder.getIndex() == index)
			{
				return builder;
			}
		}
		return null;
	}

	// returns itself so the next iteration can use that as its previous evolution;
	private MonsterType.Builder resolveParentMonsterTypes(MonsterType.Builder monsterTypeToResolve)
	{
		MonsterType.Builder physicalEvolution = getBuilderByIndex(monsterTypeToResolve.getPhysicalEvolutionIndex());
		if (physicalEvolution != null)
		{
			monsterTypeToResolve.setPhysicalEvolution(resolveParentMonsterTypes(physicalEvolution));
			physicalEvolution.setPreviousEvolution(monsterTypeToResolve);
		}

		MonsterType.Builder balancedEvolution = getBuilderByIndex(monsterTypeToResolve.getBalancedEvolutionIndex());

		if (balancedEvolution != null)
		{
			monsterTypeToResolve.setBalancedEvolution(resolveParentMonsterTypes(balancedEvolution));
			balancedEvolution.setPreviousEvolution(monsterTypeToResolve);
		}

		MonsterType.Builder magicalEvolution = getBuilderByIndex(monsterTypeToResolve.getMagicalEvolutionIndex());

		if (magicalEvolution != null)
		{
			monsterTypeToResolve.setMagicalEvolution(resolveParentMonsterTypes(magicalEvolution));
			magicalEvolution.setPreviousEvolution(monsterTypeToResolve);
		}
		return monsterTypeToResolve;
	}
}