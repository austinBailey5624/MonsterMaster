package com.greenwolfgames.MonsterMaster;

import java.util.HashMap;
import java.util.Map;

/**
 * Custom class to handle the collection of traits for an individual
 * @author Austin Bailey
 * @Date 2/16/2024
 *
 */
public class TraitManager
{
	private final int m_index;
	private final String m_name;
	private final int m_monster_type_id;//0 is empty
	private Map<Trait,Integer> m_trait_intensity;
	
	public TraitManager(int m_index, String m_name, int monster_type_id)
	{
		super();
		this.m_index         = m_index;
		this.m_name          = m_name;
		this.m_monster_type_id = monster_type_id;
		this.m_trait_intensity = new HashMap<>();
	}
	public int getIndex()
	{
		return m_index;
	}
	public String getName()
	{
		return m_name;
	}
	public int getMonsterTypeId()
	{
		return m_monster_type_id;
	}
	
	public String toString()
	{
		String result = "Index: " + m_index + " name: " + m_name + (m_monster_type_id == 0 ? " No Monster Type assocaited" : (" Associated MonsterType ID: " + m_monster_type_id));
		for(Map.Entry<Trait, Integer> entry : m_trait_intensity.entrySet())
		{
			result += "\n    For Trait: " + entry.getKey().toString() + " Value is set to: " + entry.getValue();
		}
		return result;
	}
	
	public void addIntensity(Trait trait, int intensity)
	{
		m_trait_intensity.put(trait, Integer.valueOf(intensity));
	}
	
	public Integer getIntensity(Trait traitToLookup)
	{
		return m_trait_intensity.get(traitToLookup);
	}
	
	public Map<Trait,Integer> getIntensityByTraits()
	{
		return m_trait_intensity;
	}
}
