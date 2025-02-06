// package com.greenwolfgames.monstermaster;

// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.List;

// public class ElementManager
// {

// 	private static ArrayList<PrimaryElement> m_primaryElements;
// 	private static ArrayList<SubElement>     m_subElements;

// 	public static List<PrimaryElement> getPrimaryElements()
// 	{
// 		if (m_primaryElements != null)
// 		{
// 			return m_primaryElements;
// 		}
// 		readPrimaryElementsFromDB();
// 		return m_primaryElements;
// 	}

// 	public static List<SubElement> getSubElements()
// 	{
// 		if (m_subElements != null)
// 		{
// 			return m_subElements;
// 		}
// 		readSubElementsFromDB();
// 		return m_subElements;
// 	}
	
// 	public static PrimaryElement getPrimaryElementById(int element_id)
// 	{
// 		if(m_primaryElements == null)
// 		{
// 			readPrimaryElementsFromDB();
// 		}
// 		for(PrimaryElement element : m_primaryElements)
// 		{
// 			if(element.getIndex() == element_id)
// 			{
// 				return element;
// 			}
// 		}
// 		throw new IllegalStateException("Invalid primary element id: " + element_id + " not found, should be between " + m_primaryElements.get(0).getIndex() + " and " + m_primaryElements.get(m_primaryElements.size()).getIndex());
// 	}
	
// 	public static SubElement getSubElementById(int subElement_id)
// 	{
// 		int firstDigit = subElement_id % 10;
// 		if(firstDigit >= 6)
// 		{
// 			throw new IllegalStateException("Invalid Sub Element ID, the number in the '1's place must be between 0-5");
// 		}
// 		if(subElement_id < 0)
// 		{
// 			throw new IllegalStateException("Invalid Sub element Id, negative values not allowed");
// 		}
// 		if(m_subElements == null)
// 		{
// 			readSubElementsFromDB();
// 		}
// 		int maximumIndex = m_subElements.get(m_subElements.size()-1).getIndex();
// 		if(subElement_id > maximumIndex)
// 		{
// 			throw new IllegalStateException("Invalid Sub Element Id, larger than maximum: " + maximumIndex);
// 		}
// 		for(SubElement subElement : m_subElements)
// 		{
// 			if(subElement.getIndex() == subElement_id)
// 			{
// 				return subElement;
// 			}
// 		}
// 		throw new IllegalStateException("Invalid subelement ID lookup, element id: " + subElement_id);
// 	}

// 	private static  void readPrimaryElementsFromDB()
// 	{
// 		try
// 		{
// 			ResultSet primaryElementsResultSet = SQLContentRetriever.connectToSQLDB().createStatement()
// 					.executeQuery("select * from primary_element");
// 			m_primaryElements = new ArrayList<>();
// 			while (primaryElementsResultSet.next())
// 			{
// 				m_primaryElements.add(
// 						new PrimaryElement(primaryElementsResultSet.getInt(1), primaryElementsResultSet.getString(2),
// 								ColorUtilities.readColorFromString(primaryElementsResultSet.getString(3))));
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println("Issue connecting to sql server");
// 			e.printStackTrace();
// 		}
// 	}

// 	private static void readSubElementsFromDB()
// 	{
// 		if (m_primaryElements == null)
// 		{
// 			readPrimaryElementsFromDB();
// 		}
// 		try
// 		{
// 			ResultSet subElementsResultSet = SQLContentRetriever.connectToSQLDB().createStatement()
// 					.executeQuery("select * from secondary_element");
// 			m_subElements = new ArrayList<>();
// 			while (subElementsResultSet.next())
// 			{
// 				m_subElements.add(new SubElement(subElementsResultSet.getInt(1), subElementsResultSet.getString(2),
// 						m_primaryElements.get(subElementsResultSet.getInt(3)), m_primaryElements.get(subElementsResultSet.getInt(4))));
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println("Issue connecting to sql server");
// 			e.printStackTrace();
// 		}
// 	}
// }
