package com.greenwolfgames.MonsterMaster;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Austin Bailey
 * @date Feb 6, 2024
 *
 */
public class MonsterType
{
	private static List<MonsterType> m_monsterTypes;
	private final int                m_index;
	private final String             m_name;
	private final String             m_description;
	private final SubElement         m_subElement;
	// can't be final because double linking in construction graph
	private MonsterType        m_previousEvolution;
	private final MonsterType  m_physicalEvolution;
	private final MonsterType  m_balancedEvolution;
	private final MonsterType  m_magicalEvolution;
	private final TraitManager m_defaultTraits;

	public TraitManager getDefaultTraits()
	{
		return m_defaultTraits;
	}

	public static List<MonsterType> getMonsterTypes()
	{
		return m_monsterTypes;
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

	void setPreviousEvolution(MonsterType previous)
	{
		this.m_previousEvolution = previous;
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

	public String toString()
	{
		return "Index: " + m_index + " Name: " + m_name + " SubElement: " + m_subElement.getName()
//				+ (m_previousEvolution == null ? "" : (" previous evolution: " + m_previousEvolution.getName()))
//				+ (m_physicalEvolution == null ? "" : (" physical evolution: " + m_physicalEvolution.getName()))
//				+ (m_balancedEvolution == null ? "" : (" balanced evolution: " + m_balancedEvolution.getName()))
//				+ (m_magicalEvolution == null ? "" : (" magical evolution: " + m_magicalEvolution.getName()))
				+ " Description: " + m_description + m_defaultTraits.toString();
	}

	private MonsterType(Builder builder)
	{
		this.m_index       = builder.m_index;
		this.m_name        = builder.m_name;
		this.m_description = builder.m_description;
		this.m_subElement  = builder.m_subElement;
		if (builder.m_physicalEvolution != null)
		{
			this.m_physicalEvolution = builder.m_physicalEvolution.build();
			m_physicalEvolution.setPreviousEvolution(this);
		}
		else
		{
			this.m_physicalEvolution = null;
		}

		if (builder.m_balancedEvolution != null)
		{
			this.m_balancedEvolution = builder.m_balancedEvolution.build();
			m_balancedEvolution.setPreviousEvolution(this);
		}
		else
		{
			this.m_balancedEvolution = null;
		}
		if (builder.m_magicalEvolution != null)
		{
			this.m_magicalEvolution = builder.m_magicalEvolution.build();
			m_magicalEvolution.setPreviousEvolution(this);
		}
		else
		{
			this.m_magicalEvolution = null;
		}
		this.m_defaultTraits = builder.getDefaultTraits();
		if (m_monsterTypes == null)
		{
			m_monsterTypes = new LinkedList<MonsterType>();
		}
		for (MonsterType existingType : m_monsterTypes)
		{
			if (existingType.getIndex() == this.m_index)
			{
				return;
			}
		}
		m_monsterTypes.add(this);
	}

	public static class Builder
	{
		private int                 m_index;
		private String              m_name;
		private String              m_description;
		private SubElement          m_subElement;
		private MonsterType.Builder m_previousEvolution;
		private MonsterType.Builder m_physicalEvolution;
		private MonsterType.Builder m_balancedEvolution;
		private MonsterType.Builder m_magicalEvolution;
		private int                 m_previousEvolutionIndex;
		private int                 m_physicalEvolutionIndex;
		private int                 m_balancedEvolutionIndex;
		private int                 m_magicalEvolutionIndex;
		private TraitManager        m_defaultTraits;



		public int getIndex()
		{
			return m_index;
		}

		public Builder setIndex(int m_index)
		{
			this.m_index = m_index;
			return this;
		}

		public Builder setName(String m_name)
		{
			this.m_name = m_name;
			return this;
		}

		public Builder setDescription(String m_description)
		{
			this.m_description = m_description;
			return this;
		}

		public Builder setSubElement(SubElement m_subElement)
		{
			this.m_subElement = m_subElement;
			return this;
		}

		public Builder setPreviousEvolution(MonsterType.Builder m_previousEvolution)
		{
			this.m_previousEvolution = m_previousEvolution;
			return this;
		}

		public Builder setPhysicalEvolution(MonsterType.Builder m_physicalEvolution)
		{
			this.m_physicalEvolution = m_physicalEvolution;
			return this;
		}

		public Builder setBalancedEvolution(MonsterType.Builder m_balancedEvolution)
		{
			this.m_balancedEvolution = m_balancedEvolution;
			return this;
		}

		public Builder setMagicalEvolution(MonsterType.Builder m_magicalEvolution)
		{
			this.m_magicalEvolution = m_magicalEvolution;
			return this;
		}

		public int getPreviousEvolutionIndex()
		{
			return m_previousEvolutionIndex;
		}

		public Builder setPreviousEvolutionIndex(int m_previousEvolutionIndex)
		{
			this.m_previousEvolutionIndex = m_previousEvolutionIndex;
			return this;
		}

		public int getPhysicalEvolutionIndex()
		{
			return m_physicalEvolutionIndex;
		}

		public Builder setPhysicalEvolutionIndex(int m_physicalEvolutionIndex)
		{
			this.m_physicalEvolutionIndex = m_physicalEvolutionIndex;
			return this;
		}

		public int getBalancedEvolutionIndex()
		{
			return m_balancedEvolutionIndex;
		}

		public Builder setBalancedEvolutionIndex(int m_balancedEvolutionIndex)
		{
			this.m_balancedEvolutionIndex = m_balancedEvolutionIndex;
			return this;
		}

		public int getMagicalEvolutionIndex()
		{
			return m_magicalEvolutionIndex;
		}

		public Builder setMagicalEvolutionIndex(int m_magicalEvolutionIndex)
		{
			this.m_magicalEvolutionIndex = m_magicalEvolutionIndex;
			return this;
		}
		
		public TraitManager getDefaultTraits()
		{
			return m_defaultTraits;
		}

		public void setDefaultTraits(TraitManager defaultTraits)
		{
			this.m_defaultTraits = defaultTraits;
		}

		public MonsterType build()
		{
			return new MonsterType(this);
		}
	}
}