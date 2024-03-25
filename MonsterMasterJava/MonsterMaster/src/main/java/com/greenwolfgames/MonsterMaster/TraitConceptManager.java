package com.greenwolfgames.MonsterMaster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Austin Bailey
 * @Date 2/16/2024
 *
 */
public class TraitConceptManager
{
	private static List<Trait>        m_traits;
	private static List<TraitManager> m_traitManagers;

	public static List<Trait> getTraits()
	{
		if (m_traits != null)
		{
			return m_traits;
		}
		readTraitsFromDB();
		return m_traits;
	}

	public static Trait getTraitById(int id)
	{
		if (m_traits == null)
		{
			readTraitsFromDB();
		}
		for (Trait trait : m_traits)
		{
			if (trait.getIndex() == id)
			{
				return trait;
			}
		}
		throw new IllegalArgumentException("There is no corresponding trait for id: " + id);
	}

	public static List<TraitManager> getTraitManagers()
	{
		if (m_traitManagers != null)
		{
			return m_traitManagers;
		}
		readTraitManagersFromDB();
		loadTraitIntensities();
		return m_traitManagers;
	}

	public static TraitManager getTraitManagerById(int index)
	{
		if (m_traitManagers == null)
		{
			m_traitManagers = getTraitManagers();
		}
		for (TraitManager manager : m_traitManagers)
		{
			if (manager.getIndex() == (index))
			{
				return manager;
			}
		}
		throw new IllegalArgumentException("Trait manager with index: " + index + " could not be found");
	}

	private static void loadTraitIntensities()
	{
		if (m_traitManagers == null)
		{
			readTraitManagersFromDB();
		}
		if (m_traits == null)
		{
			readTraitsFromDB();
		}

		try
		{
			ResultSet intensitySet = SQLContentRetriever.connectToSQLDB().createStatement()
					.executeQuery("select * from trait_intensity_lookup");
			while (intensitySet.next())
			{
				TraitManager manager = getTraitManagerById(intensitySet.getInt(2));
				manager.addIntensity(getTraitById(intensitySet.getInt(3)), intensitySet.getInt(4));
			}
		}
		catch (Exception e)
		{
			System.err.println("Issue connecting to sql server");
			e.printStackTrace();
		}
	}

	private static void readTraitsFromDB()
	{
		try
		{
			ResultSet traitsResultSet = SQLContentRetriever.connectToSQLDB().createStatement()
					.executeQuery("Select * from trait;");
			m_traits = new LinkedList<>();
			while (traitsResultSet.next())
			{
				m_traits.add(new Trait(traitsResultSet.getInt(1), traitsResultSet.getString(2),
						ETraitType.getEnum(traitsResultSet.getString(3)), traitsResultSet.getInt(4), traitsResultSet.getInt(5)));
			}
		}
		catch (Exception e)
		{
			System.err.println("Issue connecting to sql server");
			e.printStackTrace();
		}
//		for(Trait trait : m_traits)
//		{
////			System.out.println(trait.toString());
//		}
		readTraitDescriptionsFromDB();
	}
	
	private static void readTraitDescriptionsFromDB()
	{
		try
		{
			ResultSet traitsResultSet = SQLContentRetriever.connectToSQLDB().createStatement().executeQuery("Select trait_id, trait_value, description from trait_description;");
			Map<Integer, String> traitValueDescriptions = new HashMap<Integer,String>();
			int indexOfCurrentTrait = 1;
			while (traitsResultSet.next())
			{
				int readCurrentIndex = traitsResultSet.getInt(1);
				//Case where we are still on the same trait as last read (or on initial read)
				if(readCurrentIndex == indexOfCurrentTrait)
				{
					traitValueDescriptions.put(traitsResultSet.getInt(2), traitsResultSet.getString(3));
				}
				//Case where we are moving to the next trait
				else
				{
					//we assume that we're incrementing by one, moving from each trait to the next, if we don't we throw an exception
					if(readCurrentIndex != indexOfCurrentTrait+1)
					{
						throw new IllegalStateException("trait description read skipped index " + indexOfCurrentTrait+1 + " Instead was: " + readCurrentIndex);
					}
					//handle moving to next trait
					m_traits.get(indexOfCurrentTrait-1).setTraitValueDescriptions(traitValueDescriptions);
					traitValueDescriptions = new HashMap<Integer,String>();//reset for next trait
					indexOfCurrentTrait++;
					traitValueDescriptions.put(traitsResultSet.getInt(2), traitsResultSet.getString(3));
				}
				for(Trait trait : m_traits)
				{
					if(trait.getIndex() == readCurrentIndex)
					{
						trait.setTraitValueDescriptions(traitValueDescriptions);
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("Issue connecting to sql server");
			e.printStackTrace();
		}
	}

	private static void readTraitManagersFromDB()
	{
		try
		{
			ResultSet managerResultSet = SQLContentRetriever.connectToSQLDB().createStatement()
					.executeQuery("select * from trait_manager");
			m_traitManagers = new LinkedList<>();
			while (managerResultSet.next())
			{
				m_traitManagers.add(new TraitManager(managerResultSet.getInt(1), managerResultSet.getString(2),
						managerResultSet.getInt(3)));
			}
		}
		catch (Exception e)
		{
			System.err.println("Issue connecting to sql server");
			e.printStackTrace();
		}
	}

	public static void printTraits()
	{
		getTraits();
		m_traits.stream().filter(trait -> trait.getTraitType() == ETraitType.INHERITED)
				.sorted(new TraitAlphabatizeComparator()).forEach(System.out::println);
	}

	private static class TraitAlphabatizeComparator implements Comparator<Trait>
	{
		@Override
		public int compare(Trait left, Trait right)
		{
			return left.getName().compareTo(right.getName());
		}
	}

	public static void alphabatizeBodyTypes()
	{
		List<String> bodyTypes = new LinkedList<>();
		bodyTypes.add("Humanoid");
		bodyTypes.add("Soldier");
		bodyTypes.add("Demon");
		bodyTypes.add("Angel");
		bodyTypes.add("Golem");
		bodyTypes.add("Cloud");
		bodyTypes.add("Dragon");
		bodyTypes.add("Fish");
		bodyTypes.add("Wolf");
		bodyTypes.add("Fox");
		bodyTypes.add("Elf");
		bodyTypes.add("Plant");
		bodyTypes.add("Bear");
		bodyTypes.add("Symbol");
		bodyTypes.add("Stone");
		bodyTypes.add("Gem");
		bodyTypes.add("Light Blob");
		bodyTypes.add("Bird");
		bodyTypes.add("Steam Blob");
		bodyTypes.add("Tree");
		bodyTypes.add("Horse");
		bodyTypes.add("Monk");
		bodyTypes.add("Rat");
		bodyTypes.add("Disease");
		bodyTypes.add("Scorpion");
		bodyTypes.add("Camel");
		bodyTypes.add("Sphynx");
		bodyTypes.add("Sword");
		bodyTypes.add("Corpse");
		bodyTypes.add("Bat");
		bodyTypes.add("Scavenger");
		bodyTypes.add("Lizard");
		bodyTypes.add("Raptor");
		bodyTypes.add("Tyrant");
		bodyTypes.add("Turtle");
		bodyTypes.add("Frog");
		bodyTypes.add("Blob");
		bodyTypes.add("Snake");
		bodyTypes.add("Penguin");
		bodyTypes.add("Squid");
		bodyTypes.add("Starfish");
		bodyTypes.add("JellyFish");
		bodyTypes.add("Badger");
		bodyTypes.add("Wasp");
		bodyTypes.add("Ghost");
		bodyTypes.add("Liquid");
		bodyTypes.add("Cow");
		bodyTypes.add("Spider");
		bodyTypes.add("Octopus");
		bodyTypes.add("Spear");
		bodyTypes.add("Shield");
		bodyTypes.add("Fang");
		bodyTypes.add("Claw");
		bodyTypes.add("Beak");
		bodyTypes.add("Other");
		bodyTypes.add("Cat");
		List<String> bodyTypesSorted = bodyTypes.stream().sorted(String::compareTo).collect(Collectors.toList());
		
		for(int i = 0; i < bodyTypesSorted.size();i++)
		{
			if(i % 5 == 0)
			{
				System.out.print("    ");
			}
			System.out.print("('" + bodyTypesSorted.get(i) + "'),");
			if(i % 5 == 4)
			{
				System.out.print("\n");
			}

		}
		System.out.println(bodyTypes.size());
	}
	
	public static void printHelper()
	{
		for(int i = 321; i <=327; i++)
		{
			System.out.print("(" + i + ",62,1),(" + i + ",63,10),");
		}
	}
	
	public static void main(String[] args)
	{
		List<Trait> traits = getTraits();
		Trait bodyType = traits.get(3);
		Map<Integer,String> valueDescriptions = bodyType.getTraitValueDescriptions();
		try
		{
			FileWriter fileWriter = new FileWriter("serverHelper.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String typeName;
			for(int i = 1; i < valueDescriptions.size(); i++)
			{
				typeName = valueDescriptions.get(i).split(" ")[0];
				typeName = typeName.substring(0, typeName.length()-1);
				bufferedWriter.write("    (\"Body Type:" + i + " " + typeName + "\"),\n");
				
			}
			bufferedWriter.close();
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

//		try
//		{
//			FileWriter fileWriter = new FileWriter("traitWikiOutput.txt");
//			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//			bufferedWriter.write(makeWikiContent());
//			bufferedWriter.close();
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
	private static String makeWikiContent()
	{
		String result = "<div align=\"center\">\n<table>\n<tr>\n    <td align=\"center\"><h3>Trait Name</h3></td>";
		result += "\n    <td align=\"center\"><h3>Trait Effect</h3></td>\n</tr>\n";
		List<Trait> traits = getTraits();
		for(Trait trait : traits)
		{
			result+=printTrait(trait);
		}
		result += "</table>\n</div>";
		
		return result;
	}
	
	private static String printTrait(Trait trait)
	{
		if(trait.getIndex() == 4 || trait.getIndex() == 5)
		{
			return "";
		}
		Map<Integer,String> traitDescriptionsByValue = trait.getTraitValueDescriptions();
		String result ="";
		for(int i = trait.getMinimumValue(); i <= trait.getMaximumValue(); i++)
		{
			result+=printTraitValue(trait,i,traitDescriptionsByValue);
		}
		return result;
	}
	
	private static String printTraitValue(Trait trait, int value, Map<Integer,String> traitDescriptionsByValue)
	{
		String result = "<tr>\n    <td align=\"center\">" + trait.getName() + ":" + value + "</td>\n";
		result += "    <td>" + traitDescriptionsByValue.get(value) + "</td>\n";
		result += "</tr>\n";
		return result;
	}
}
