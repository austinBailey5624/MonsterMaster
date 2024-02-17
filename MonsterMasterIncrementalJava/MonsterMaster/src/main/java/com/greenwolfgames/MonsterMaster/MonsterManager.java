package com.greenwolfgames.MonsterMaster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MonsterManager
{
	private static List<MonsterType>                 m_monsterTypes;
	private static Multimap<SubElement, MonsterType> m_monsterTypesBySubElement;
	private static List<MonsterType.Builder>         m_monsterTypeBuilders;

	public static List<MonsterType> getMonsterTypes()
	{
		if (m_monsterTypes != null)
		{
			return m_monsterTypes;
		}
		readMonsterTypesFromDB();
		m_monsterTypes.sort(new MonsterTypeComparator());
		return m_monsterTypes;
	}

	public static Multimap<SubElement, MonsterType> getMonsterTypesBySubElement()
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

	private static MonsterType getMonsterTypeFromIndex(int index, List<MonsterType> monsterTypes)
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

	private static void readMonsterTypesFromDB()
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
			type.setDefaultTraits(TraitConceptManager.getTraitManagerById(type.getIndex()));
		}
		for (MonsterType.Builder type : m_monsterTypeBuilders)
		{
			MonsterType monsterType = type.build();
			monsterType.setPreviousEvolution(
					getMonsterTypeFromIndex(type.getPreviousEvolutionIndex(), MonsterType.getMonsterTypes()));
		}
		m_monsterTypes = MonsterType.getMonsterTypes();
	}

	private static MonsterType.Builder getBuilderByIndex(int index)
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
	private static MonsterType.Builder resolveParentMonsterTypes(MonsterType.Builder monsterTypeToResolve)
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
	
	public static void printTraits() throws IOException
	{
		getMonsterTypes();
		String filepath = "TraitsOutput.txt";

		BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
		
		for(MonsterType type : m_monsterTypes)
		{
			printMonsterTraits(type,writer);
		}
		writer.close();
	}
	
	private static void printMonsterTraits(MonsterType type, BufferedWriter writer) throws IOException
	{
		for(Map.Entry<Trait, Integer> entry : getTraitList(type))
		{
			writer.write("(" + type.getIndex() + "," + entry.getKey().getIndex() + "," + entry.getValue()+ "),");
		}
		writer.write("\n");
	}
	
	public static List<Map.Entry<Trait,Integer>> getTraitList(MonsterType type)
	{
		List<Map.Entry<Trait, Integer>> result = new LinkedList<>();
		for(Map.Entry<Trait, Integer> entry : type.getDefaultTraits().getIntensityByTraits().entrySet())
		{
			result.add(entry);
		}
		result.sort(new TraitIntensityComparator());
		return result;
	}
	
	private static class TraitIntensityComparator implements Comparator<Map.Entry<Trait, Integer>>
	{
		@Override
		public int compare(Map.Entry<Trait,Integer> entry1, Map.Entry<Trait,Integer> entry2)
		{
			return entry1.getKey().getIndex() - (entry2.getKey().getIndex());
		}
	}
	
	private static class MonsterTypeComparator implements Comparator<MonsterType>
	{
		@Override
		public int compare(MonsterType type1, MonsterType type2)
		{
			return type1.getIndex() - type2.getIndex();
		}
	}
}