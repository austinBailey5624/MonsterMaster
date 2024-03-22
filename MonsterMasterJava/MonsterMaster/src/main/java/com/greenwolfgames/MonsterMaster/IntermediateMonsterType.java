package com.greenwolfgames.MonsterMaster;

/**
 * An intermediate step whose goal is to gather the information from the
 * database to convert into monstertypes.
 * 
 * @author Austin Bailey
 * @date Feb 7th, 2024
 *
 */
public class IntermediateMonsterType
{
	// note- because this is an intermediate step to be deleted later we are not
	// concerned with
	public int     m_index;
	public String  m_name;
	public String  m_description;
	public Integer m_previousEvolutionIndex;
	public Integer m_physicalEvolutionIndex;
	public Integer m_balancedEvolutionIndex;
	public Integer m_magicalEvolutionIndex;

	public IntermediateMonsterType(int m_index, String m_name, String m_description, Integer m_previousEvolutionIndex,
			Integer m_physicalEvolutionIndex, Integer m_balancedEvolutionIndex, Integer m_magicalEvolutionIndex)
	{
		this.m_index                  = m_index;
		this.m_name                   = m_name;
		this.m_description            = m_description;
		this.m_previousEvolutionIndex = m_previousEvolutionIndex;
		this.m_physicalEvolutionIndex = m_physicalEvolutionIndex;
		this.m_balancedEvolutionIndex = m_balancedEvolutionIndex;
		this.m_magicalEvolutionIndex  = m_magicalEvolutionIndex;
	}
}
