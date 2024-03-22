package com.greenwolfgames.MonsterMaster;

import java.util.Objects;

public class SubElement
{
	private final int            m_index;
	private final String         m_name;
	private final PrimaryElement m_firstElement;
	private final PrimaryElement m_secondElement;

	public SubElement(int m_index, String m_name, PrimaryElement m_firstElement, PrimaryElement m_secondElement)
	{
		this.m_index         = m_index;
		this.m_name          = m_name;
		this.m_firstElement  = m_firstElement;
		this.m_secondElement = m_secondElement;
	}

	public int getIndex()
	{
		return m_index;
	}

	public String getName()
	{
		return m_name;
	}

	public PrimaryElement getFirstElement()
	{
		return m_firstElement;
	}

	public PrimaryElement getSecondElement()
	{
		return m_secondElement;
	}

	public String toString()
	{
		return ("SubElement Index: " + m_index + " Name: " + m_name + " First Element: " + m_firstElement.getName()
				+ " Second Element: " + m_secondElement.getName());

	}

	@Override
	public int hashCode()
	{
		return Objects.hash(m_firstElement, m_index, m_name, m_secondElement);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubElement other = (SubElement) obj;
		return Objects.equals(m_firstElement, other.m_firstElement) && m_index == other.m_index
				&& Objects.equals(m_name, other.m_name) && Objects.equals(m_secondElement, other.m_secondElement);
	}

}
