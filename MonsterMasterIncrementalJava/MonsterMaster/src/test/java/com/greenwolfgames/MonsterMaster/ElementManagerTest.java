package com.greenwolfgames.MonsterMaster;

import java.util.List;

import org.junit.Test;

public class ElementManagerTest 
{
	@Test
	public void testGetPrimaryElements()
	{
		ElementManager manager = new ElementManager();
		List<PrimaryElement> primaryElements = manager.getPrimaryElements();
		for(PrimaryElement element : primaryElements)
		{
			System.out.println(element.getIndex() + ":" + element.getName() + " " + element.getColor());
		}
	}
	
	@Test
	public void testGetSubElements()
	{
		ElementManager manager = new ElementManager();
		List<SubElement> subElements = manager.getSubElements();
		for(SubElement element : subElements)
		{
			System.out.println(element.toString());
		}
	}
	
	@Test
	public void testGetSubelementById()
	{
		ElementManager manager = new ElementManager();
		SubElement element = manager.getSubElementById(23);
		System.out.println(element.toString());
	}
}
