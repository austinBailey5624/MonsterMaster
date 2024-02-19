package com.greenwolfgames.MonsterMaster;

import java.util.Map;

/**
 * 
 * @author Austin Bailey
 * @Date 2/16/2024
 *
 */
public class Trait
{

	private final int        m_index;
	private final String     m_name;
//	private final String     m_description;
	private final ETraitType m_traitType;

	public Trait(int index, String name,  ETraitType traitType)
	{
		this.m_index       = index;
		this.m_name        = name;
//		this.m_description = description;
		this.m_traitType   = traitType;
	}

	public int getIndex()
	{
		return m_index;
	}

	public String getName()
	{
		return m_name;
	}

//	public String getDescription()
//	{
//		return m_description;
//	}

	public ETraitType getTraitType()
	{
		return m_traitType;
	}

	public String toString()
	{
		return "Index: " + m_index + " Name: " + m_name + " traitType: " + m_traitType.toString();
	}
}
