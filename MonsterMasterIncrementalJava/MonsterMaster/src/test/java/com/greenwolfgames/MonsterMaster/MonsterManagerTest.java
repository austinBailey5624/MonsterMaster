package com.greenwolfgames.MonsterMaster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;


/**
 * Test class for @link MonsterManager.java
 * @author Austin Bailey
 * @date Feb 16,2024
 */
public class MonsterManagerTest
{
	private static boolean printStatistics = true;

	@Test
	public void testGetMonsterTypes()
	{
		List<MonsterType> monsterTypes = MonsterManager.getMonsterTypes();
		assertEquals(monsterTypes.size(), 339);
	}

	@Test
	public void testEachMonsterHasACorporealityTrait()
	{
		int numCorporeal   = 0;
		int numPartially   = 0;
		int numIncorporeal = 0;
		for (MonsterType monsterType : MonsterManager.getMonsterTypes())
		{
			TraitManager monsterTypeTraits  = monsterType.getDefaultTraits();
			Trait        corporeal          = TraitConceptManager.getTraitById(1);
			Trait        partiallyCorporeal = TraitConceptManager.getTraitById(2);
			Trait        incorporeal        = TraitConceptManager.getTraitById(3);
			Integer      corporealInt       = monsterTypeTraits.getIntensity(corporeal);
			Integer      partiallyInt       = monsterTypeTraits.getIntensity(partiallyCorporeal);
			Integer      incorporealInt     = monsterTypeTraits.getIntensity(incorporeal);
			int checksum = 0;
			if (corporealInt != null)
			{
				checksum++;
				numCorporeal++;
			}
			if (partiallyInt != null)
			{
				checksum++;
				numPartially++;
			}
			if (incorporealInt != null)
			{
				checksum++;
				numIncorporeal++;
			}
			assertEquals(1, checksum);

		}
		assertEquals(288,numCorporeal);
		assertEquals(42,numPartially);
		assertEquals(9,numIncorporeal);
		if (printStatistics)
		{
			System.out.println("Number of Corporeal MonsterTypes: " + numCorporeal);
			System.out.println("Number of Partially Corporeal MonsterTypes: " + numPartially);
			System.out.println("Number of Incorporeal MonsterTypes: " + numIncorporeal);
			System.out.println("Total: " + (numCorporeal + numPartially + numIncorporeal));
		}
	}

	@Test
	public void testEachMonsterTypeHasAnAge()
	{
		int numInfant     = 0;
		int numAdolescent = 0;
		int numAdult      = 0;
		int numElder      = 0;

		for (MonsterType monsterType : MonsterManager.getMonsterTypes())
		{
			TraitManager monsterTypeTraits = monsterType.getDefaultTraits();
			Trait        infant            = TraitConceptManager.getTraitById(4);
			Trait        adolescent        = TraitConceptManager.getTraitById(5);
			Trait        adult             = TraitConceptManager.getTraitById(6);
			Trait        elder             = TraitConceptManager.getTraitById(7);
			Integer      infantInt         = monsterTypeTraits.getIntensity(infant);
			Integer      adolescentInt     = monsterTypeTraits.getIntensity(adolescent);
			Integer      adultInt          = monsterTypeTraits.getIntensity(adult);
			Integer      elderInt          = monsterTypeTraits.getIntensity(elder);
			int          checksum          = 0;
			if (infantInt != null)
			{
				checksum++;
				numInfant++;
			}
			if(adolescentInt != null)
			{
				checksum++;
				numAdolescent++;
			}
			if(adultInt != null)
			{
				checksum++;
				numAdult++;
			}
			if(elderInt != null)
			{
				checksum++;
				numElder++;
			}
			assertEquals(1,checksum);

		}
		assertEquals(36,numInfant);
		assertEquals(95,numAdolescent);
		assertEquals(104,numAdult);
		assertEquals(104,numElder);
		if(printStatistics)
		{
			System.out.println("Number of Infant MonsterTypes: " + numInfant);
			System.out.println("Number of adolescent MonsterTypes: " + numAdolescent);
			System.out.println("Number of adult MonsterTypes: " + numAdult);
			System.out.println("Number of elder MonsterTypes: " + numElder);
			System.out.println("Total: " + (numInfant + numAdolescent + numAdult + numElder));
		}
	}
	
	@Test
	public void testSizeOfEachSubelement()
	{
		Multimap<SubElement, MonsterType> monsterTypesBySubelement = HashMultimap.create();
		for(MonsterType monsterType : MonsterManager.getMonsterTypes())
		{
			monsterTypesBySubelement.put(monsterType.getSubElement(), monsterType);
		}
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(0)).size(),12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(1)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(2)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(3)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(4)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(5)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(10)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(11)).size(),12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(12)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(13)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(14)).size(),12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(15)).size(),12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(20)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(21)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(22)).size(),14);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(23)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(24)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(25)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(30)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(31)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(32)).size(),7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(33)).size(),12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(34)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(35)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(40)).size(),10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(41)).size(),7);
		
	}
}
