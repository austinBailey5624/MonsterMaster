// package com.greenwolfgames.monstermaster;

// import java.awt.Color;
// import java.util.Objects;

// public class PrimaryElement
// {
// 	private int m_index;
// 	private String m_name;
// 	private Color m_color;
	
// 	public int getIndex()
// 	{
// 		return m_index;
// 	}
// 	public void setIndex(int m_index)
// 	{
// 		this.m_index = m_index;
// 	}
// 	public String getName()
// 	{
// 		return m_name;
// 	}
// 	public void setName(String m_name)
// 	{
// 		this.m_name = m_name;
// 	}
// 	public Color getColor()
// 	{
// 		return m_color;
// 	}
// 	public void setColor(Color m_color)
// 	{
// 		this.m_color = m_color;
// 	}
// 	@Override
// 	public int hashCode()
// 	{
// 		return Objects.hash(m_color, m_index, m_name);
// 	}
// 	@Override
// 	public boolean equals(Object obj)
// 	{
// 		if (this == obj)
// 			return true;
// 		if (obj == null)
// 			return false;
// 		if (getClass() != obj.getClass())
// 			return false;
// 		PrimaryElement other = (PrimaryElement) obj;
// 		return Objects.equals(m_color, other.m_color) && m_index == other.m_index
// 				&& Objects.equals(m_name, other.m_name);
// 	}
	
// 	public PrimaryElement(int m_index, String m_name, Color m_color)
// 	{
// 		super();
// 		this.m_index = m_index;
// 		this.m_name  = m_name;
// 		this.m_color = m_color;
// 	}
	
	

// }
