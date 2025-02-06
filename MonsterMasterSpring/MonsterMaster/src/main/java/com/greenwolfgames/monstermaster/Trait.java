// package com.greenwolfgames.monstermaster;

// import java.util.Map;

// /**
//  * 
//  * @author Austin Bailey
//  * @Date 2/16/2024
//  *
//  */
// public class Trait
// {

// 	private final int        m_index;
// 	private final String     m_name;
// 	private final int m_minimumValue;
// 	private final int m_maximumValue;
// 	private final ETraitType m_traitType;
// 	private Map<Integer, String> m_traitValueDescriptions;


// 	public Trait(int index, String name,  ETraitType traitType, int minimumValue, int maximumValue)
// 	{
// 		this.m_index       = index;
// 		this.m_name        = name;
// 		this.m_traitType   = traitType;
// 		this.m_minimumValue = minimumValue;
// 		this.m_maximumValue = maximumValue;
// 	}

// 	public int getIndex()
// 	{
// 		return m_index;
// 	}

// 	public String getName()
// 	{
// 		return m_name;
// 	}

// 	public ETraitType getTraitType()
// 	{
// 		return m_traitType;
// 	}

// 	public int getMinimumValue()
// 	{
// 		return m_minimumValue;
// 	}

// 	public int getMaximumValue()
// 	{
// 		return m_maximumValue;
// 	}
	
// 	public Map<Integer, String> getTraitValueDescriptions()
// 	{
// 		return m_traitValueDescriptions;
// 	}

// 	public void setTraitValueDescriptions(Map<Integer, String> traitValueDescriptions)
// 	{
// 		this.m_traitValueDescriptions = traitValueDescriptions;
// 	}

// 	public String toString()
// 	{
// 		return "Index: " + m_index + " Name: " + m_name + " min: " + m_minimumValue + " max: " + m_maximumValue + " traitType: " + m_traitType.toString();
// 	}
// }
