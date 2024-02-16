package com.greenwolfgames.MonsterMaster;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

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
		if(m_traits == null)
		{
			readTraitsFromDB();
		}
		for(Trait trait: m_traits)
		{
			if(trait.getIndex() == id)
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
		if(m_traitManagers == null)
		{
			m_traitManagers =  getTraitManagers();
		}
		for(TraitManager manager : m_traitManagers)
		{
			if(manager.getIndex() == (index))
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
			ResultSet intensitySet = SQLContentRetriever.connectToSQLDB().createStatement().executeQuery("select * from trait_intensity_lookup");
			while(intensitySet.next())
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
					.executeQuery("select * from trait");
			m_traits = new LinkedList<>();
			while (traitsResultSet.next())
			{
				m_traits.add(new Trait(traitsResultSet.getInt(1), traitsResultSet.getString(2),
						traitsResultSet.getString(3), ETraitType.getEnum(traitsResultSet.getString(4))));
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
			ResultSet managerResultSet = SQLContentRetriever.connectToSQLDB().createStatement().executeQuery("select * from trait_manager");
			m_traitManagers = new LinkedList<>();
			while(managerResultSet.next())
			{
				m_traitManagers.add(new TraitManager(managerResultSet.getInt(1), managerResultSet.getString(2), managerResultSet.getInt(3)));
			}
		}
		catch (Exception e)
		{
			System.err.println("Issue connecting to sql server");
			e.printStackTrace();
		}
	}
	
	
}
