package com.greenwolfgames.MonsterMaster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.AbstractMap;
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

		for (MonsterType type : m_monsterTypes)
		{
			printMonsterTraits(type, writer);
		}
		writer.close();
	}

	private static void printMonsterTraits(MonsterType type, BufferedWriter writer) throws IOException
	{
		List<Map.Entry<Trait, Integer>> newList = new ArrayList<>();
//		for (Map.Entry<Trait, Integer> entry : getTraitList(type))
//		{
//			newList.add(translateToNewTraits(entry));
//		}
		newList.sort(new TraitIntensityComparator());
		for(Map.Entry<Trait,Integer> entry : newList)
		{
			writer.write("(" + type.getIndex() + "," + entry.getKey().getIndex() + "," + entry.getValue() + "),");
		}
		writer.write("\n");
	}

//	private static Map.Entry<Trait, Integer> translateToNewTraits(Map.Entry<Trait, Integer> old)
//	{
//		if (old.getKey().getIndex() == 1)
//		{
//			return getEntry(1, 1);
//		}
//		if (old.getKey().getIndex() == 2)
//		{
//			return getEntry(1, 3);
//		}
//		if (old.getKey().getIndex() == 3)
//		{
//			return getEntry(1,4);
//		}
//		if (old.getKey().getIndex() == 4)
//		{
//			return getEntry(2,1);
//		}
//		if (old.getKey().getIndex() == 5)
//		{
//			return getEntry(2,2);
//		}
//		if (old.getKey().getIndex() == 6)
//		{
//			return getEntry(2,3);
//		}
//		if (old.getKey().getIndex() == 7)
//		{
//			return getEntry(2,4);
//		}
//		if (old.getKey().getIndex() == 8)
//		{
//			return getEntry(2,5);
//		}
//		if (old.getKey().getIndex() == 9)
//		{
//			return getEntry(7,6);
//		}
//		if (old.getKey().getIndex() == 10)
//		{
//			return getEntry(7,old.getValue());
//		}
//		if (old.getKey().getIndex() == 11)
//		{
//			return getEntry(7,0);
//		}
//		if (old.getKey().getIndex() == 12)
//		{
//			return getEntry(10,old.getValue());
//		}
//		if(old.getKey().getIndex() == 13)
//		{
//			return getEntry(10,-1*old.getValue());
//		}
//		if(old.getKey().getIndex() == 14)
//		{
//			return getEntry(6,-1*old.getValue());
//		}
//		if(old.getKey().getIndex() == 15)
//		{
//			return getEntry(6,0);
//		}
//		if(old.getKey().getIndex() == 16)
//		{
//			return getEntry(6,old.getValue());
//		}
//		if(old.getKey().getIndex() == 17)
//		{
//			return getEntry(18,old.getValue());
//		}
//		if(old.getKey().getIndex() == 18)
//		{
//			return getEntry(19,old.getValue());
//		}
//		if(old.getKey().getIndex() == 19)
//		{
//			return getEntry(20,old.getValue());
//		}
//		if(old.getKey().getIndex() == 20)
//		{
//			return getEntry(41,old.getValue());
//		}
//		if(old.getKey().getIndex() == 21)
//		{
//			return getEntry(35,old.getValue());
//		}
//		if(old.getKey().getIndex() == 22)
//		{
//			return getEntry(43, old.getValue());
//		}
//		if(old.getKey().getIndex() == 23)
//		{
//			return getEntry(8, -1*old.getValue());
//		}
//		if(old.getKey().getIndex() == 24)
//		{
//			return getEntry(31,old.getValue());
//		}
//		if(old.getKey().getIndex() == 25)
//		{
//			return getEntry(49,old.getValue());
//		}
//		if(old.getKey().getIndex() == 26)
//		{
//			return getEntry(8,old.getValue());
//		}
//		if(old.getKey().getIndex() == 27)
//		{
//			return getEntry(28,old.getValue());
//		}
//		if(old.getKey().getIndex() == 28)
//		{
//			return getEntry(33,old.getValue());
//		}
//		if(old.getKey().getIndex() == 29)
//		{
//			return getEntry(37,old.getValue());
//		}
//		if(old.getKey().getIndex() == 30)
//		{
//			return getEntry(48,old.getValue());
//		}
//		if(old.getKey().getIndex() == 31)
//		{
//			return getEntry(39,old.getValue());
//		}
//		if(old.getKey().getIndex() == 32)
//		{
//			return getEntry(50,old.getValue());
//		}
//		if(old.getKey().getIndex() == 33)
//		{
//			return getEntry(46,old.getValue());
//		}
//		if(old.getKey().getIndex() == 34)
//		{
//			return getEntry(30,old.getValue());
//		}
//		if(old.getKey().getIndex() == 35)
//		{
//			return getEntry(36,old.getValue());
//		}
//		if(old.getKey().getIndex() == 36)
//		{
//			return getEntry(51,old.getValue());
//		}
//		if(old.getKey().getIndex() == 37)
//		{
//			return getEntry(11,old.getValue());
//		}
//		if(old.getKey().getIndex() == 38)
//		{
//			return getEntry(11,-1*old.getValue());
//		}
//		if(old.getKey().getIndex() == 39)
//		{
//			return getEntry(44,old.getValue());
//		}
//		if(old.getKey().getIndex() == 40)
//		{
//			return getEntry(47,old.getValue());
//		}
//		if(old.getKey().getIndex() == 41)
//		{
//			return getEntry(27,old.getValue());
//		}
//		if(old.getKey().getIndex() == 42)
//		{
//			return getEntry(29,old.getValue());
//		}
//		if(old.getKey().getIndex() == 43)
//		{
//			return getEntry(38,old.getValue());
//		}
//		if(old.getKey().getIndex() == 44)
//		{
//			return getEntry(40,old.getValue());
//		}
//		if(old.getKey().getIndex() == 45)
//		{
//			return getEntry(42,old.getValue());
//		}
//		if(old.getKey().getIndex() == 46)
//		{
//			return getEntry(45,old.getValue());
//		}
//		if(old.getKey().getIndex() == 47)
//		{
//			return getEntry(34,old.getValue());
//		}
//		if(old.getKey().getIndex() == 48)
//		{
//			return getEntry(32, old.getValue());
//		}
//		if(old.getKey().getIndex() >= 49 && old.getKey().getIndex() <= 54)
//		{
//			return getEntry(old.getKey().getIndex() - 28, old.getValue());
//		}
//		if(old.getKey().getIndex() == 55)
//		{
//			return getEntry(12,old.getValue());
//		}
//		if(old.getKey().getIndex() == 56)
//		{
//			return getEntry(9,old.getValue());
//		}
//		if(old.getKey().getIndex() >= 57 && old.getKey().getIndex() <= 61)
//		{
//			return getEntry(old.getKey().getIndex() - 44, old.getValue());
//		}
//		if(old.getKey().getIndex() == 62)
//		{
//			return getEntry(3,old.getValue());
//		}
//		if(old.getKey().getIndex() == 63)
//		{
//			return getEntry(4,old.getValue());
//		}
//		if(old.getKey().getIndex() == 64)
//		{
//			return getEntry(5,old.getValue());
//		}
//		
//		throw new IllegalArgumentException("Illegal value for trait translation: " + old.getKey().getIndex());
//	}
	

//	private static Map.Entry<Trait, Integer> getEntry(int traitIndex, int value)
//	{
//		return new AbstractMap.SimpleEntry<>(TraitConceptManager.getTraitById(traitIndex), value);
//	}

	public static List<Map.Entry<Trait, Integer>> getTraitList(MonsterType type)
	{
		List<Map.Entry<Trait, Integer>> result = new LinkedList<>();
		for (Map.Entry<Trait, Integer> entry : type.getDefaultTraits().getIntensityByTraits().entrySet())
		{
			result.add(entry);
		}
		result.sort(new TraitIntensityComparator());
		return result;
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