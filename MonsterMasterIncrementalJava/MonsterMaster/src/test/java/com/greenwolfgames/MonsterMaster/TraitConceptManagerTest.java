package com.greenwolfgames.MonsterMaster;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Austin Bailey
 * @Date 2/16/2024
 *
 */
public class TraitConceptManagerTest
{
	@Test
	public void testGetTraits()
	{
		List<Trait> traits = TraitConceptManager.getTraits();
		for (Trait trait : traits)
		{
			System.out.println(trait.toString());
		}
	}

	@Test
	public void testGetTraitManagers()
	{
		List<TraitManager> traitManagers = TraitConceptManager.getTraitManagers();
		for (TraitManager manager : traitManagers)
		{
			System.out.println(manager.toString());
		}
	}

	@Test
	public void printAlphabetizedInheritedTraits()
	{
//		TraitConceptManager.printTraits();
		TraitConceptManager.alphabatizeBodyTypes();
//		TraitConceptManager.printHelper();
	}
	

}
