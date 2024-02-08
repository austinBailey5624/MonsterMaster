package com.greenwolfgames.MonsterMaster;

/**
 * @author Austin Bailey
 * @date Feb 6, 2024
 *
 */
public class MonsterType
{
	private final int        m_index;
	private final String     m_name;
	private final String     m_description;
	private final SubElement m_subElement;
	// Would like these to be final, but since they're self referential to the
	// MonsterType class, its more trouble than its worth
	private MonsterType   m_previousEvolution;
	private MonsterType   m_physicalEvolution;
	private MonsterType   m_balancedEvolution;
	private MonsterType   m_magicalEvolution;
	private final Integer m_previousEvolutionIndex;
	private final Integer m_physicalEvolutionIndex;
	private final Integer m_balancedEvoltionIndex;
	private final Integer m_magicalEvolutionIndex;

	public MonsterType(int index, String name, String description, SubElement subElement,
			Integer physicalEvolutionIndex, Integer balancedEvolutionIndex, Integer magicalEvolutionIndex,
			Integer prevEvolutionIndex)
	{
		this.m_index                  = index;
		this.m_name                   = name;
		this.m_description            = description;
		this.m_subElement             = subElement;
		this.m_physicalEvolutionIndex = physicalEvolutionIndex;
		this.m_balancedEvoltionIndex  = balancedEvolutionIndex;
		this.m_magicalEvolutionIndex  = magicalEvolutionIndex;
		this.m_previousEvolutionIndex = prevEvolutionIndex;
	}

	public int getIndex()
	{
		return m_index;
	}

	public String getName()
	{
		return m_name;
	}

	public String getDescription()
	{
		return m_description;
	}

	public SubElement getSubElement()
	{
		return m_subElement;
	}

	public MonsterType getPreviousEvolution()
	{
		return m_previousEvolution;
	}

	public MonsterType getPhysicalEvolution()
	{
		return m_physicalEvolution;
	}

	public MonsterType getBalancedEvolution()
	{
		return m_balancedEvolution;
	}

	public MonsterType getMagicalEvolution()
	{
		return m_magicalEvolution;
	}

	public Integer getPreviousEvolutionIndex()
	{
		return m_previousEvolutionIndex;
	}

	public Integer getPhysicalEvolutionIndex()
	{
		return m_physicalEvolutionIndex;
	}

	public Integer getBalancedEvolutionIndex()
	{
		return m_balancedEvoltionIndex;
	}

	public Integer getMagicalEvolutionIndex()
	{
		return m_magicalEvolutionIndex;
	}

	public void setPreviousEvolution(MonsterType m_previousEvolution)
	{
		this.m_previousEvolution = m_previousEvolution;
	}

	public void setPhysicalEvolution(MonsterType m_physicalEvolution)
	{
		this.m_physicalEvolution = m_physicalEvolution;
	}

	public void setBalancedEvolution(MonsterType m_balancedEvolution)
	{
		this.m_balancedEvolution = m_balancedEvolution;
	}

	public void setMagicalEvolution(MonsterType m_magicalEvolution)
	{
		this.m_magicalEvolution = m_magicalEvolution;
	}

	public String toString()
	{
		return "Index: " + m_index + " Name: " + m_name + " SubElement: " + m_subElement.getName()
				+ (m_previousEvolution == null ? "" : (" previous evolution: " + m_previousEvolution.getName()))
			    + (m_physicalEvolution == null ? "" : (" physical evolution: " + m_physicalEvolution.getName()))
			    + (m_balancedEvolution == null ? "" : (" balanced evolution: " + m_balancedEvolution.getName()))
			    + (m_magicalEvolution ==  null ? "" : (" magical evolution: " + m_magicalEvolution.getName()))
				+ " Description: " + m_description;
	}
}
