package com.greenwolfgames.MonsterMaster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Test class for @link MonsterManager.java
 * 
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
		for (MonsterType monsterType : monsterTypes)
		{
			if (monsterType.getIndex() >= 50 && monsterType.getIndex() <= 100)
			{
				System.out.println(monsterType.toString());
			}
		}
	}

	@Test
	public void testEachMonsterHasACorporealityTrait()
	{
		int numCorporeal     = 0;
		int numFluid         = 0;
		int numVapor         = 0;
		int numFlame         = 0;
		int numShadowOrLight = 0;
		int numGhost         = 0;

		for (MonsterType monsterType : MonsterManager.getMonsterTypes())
		{
			TraitManager monsterTypeTraits = monsterType.getDefaultTraits();
			Trait        corporeality      = TraitConceptManager.getTraitById(1);
			Integer      corporealInt      = monsterTypeTraits.getIntensity(corporeality);
			int          checksum          = 0;
			if (corporealInt == 1)
			{
				checksum++;
				numCorporeal++;
			}
			else if (corporealInt == 2)
			{
				checksum++;
				numFluid++;
			}
			else if (corporealInt == 3)
			{
				checksum++;
				numVapor++;
			}
			else if (corporealInt == 4)
			{
				checksum++;
				numFlame++;
			}
			else if (corporealInt == 5)
			{
				checksum++;
				numShadowOrLight++;
			}
			else if (corporealInt == 6)
			{
				checksum++;
				numGhost++;
			}
			if (checksum != 1)
			{
				System.out.println(monsterType.getName() + corporealInt + ":" + monsterType.getIndex());
			}
		}

		assertEquals(288, numCorporeal);
		assertEquals(6, numFluid);
		assertEquals(27, numVapor);
		assertEquals(1, numFlame);
		assertEquals(14, numShadowOrLight);
		assertEquals(3, numGhost);
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
			Trait        age               = TraitConceptManager.getTraitById(2);
			Integer      ageIntensity      = monsterTypeTraits.getIntensity(age);
			int          checksum          = 0;
			if (ageIntensity == 1)
			{
				checksum++;
				numInfant++;
			}
			if (ageIntensity == 2)
			{
				checksum++;
				numAdolescent++;
			}
			if (ageIntensity == 3)
			{
				checksum++;
				numAdult++;
			}
			if (ageIntensity == 4)
			{
				checksum++;
				numElder++;
			}
			assertEquals(1, checksum);

		}
		assertEquals(36, numInfant);
		assertEquals(95, numAdolescent);
		assertEquals(104, numAdult);
		assertEquals(104, numElder);
		if (printStatistics)
		{
			System.out.println("Number of Infant MonsterTypes: " + numInfant);
			System.out.println("Number of adolescent MonsterTypes: " + numAdolescent);
			System.out.println("Number of adult MonsterTypes: " + numAdult);
			System.out.println("Number of elder MonsterTypes: " + numElder);
			System.out.println("Total: " + (numInfant + numAdolescent + numAdult + numElder));
		}
	}

	@Test
	public void testEachMonsterTypeHasABodyType()
	{
		for (MonsterType monsterType : MonsterManager.getMonsterTypes())
		{
			TraitManager monsterTypeTraits = monsterType.getDefaultTraits();
			Trait        bodyType          = TraitConceptManager.getTraitById(3);
			Integer      bodyTypeInt       = monsterTypeTraits.getIntensity(bodyType);
			if (bodyTypeInt == null)
			{
				System.out.println("MonsterType: " + monsterType.getName() + " Is missing a bodytype!");
				fail();
			}
			System.out.println(monsterType.toString());
		}
	}

	@Test
	public void testSizeOfEachSubelement()
	{
		Multimap<SubElement, MonsterType> monsterTypesBySubelement = HashMultimap.create();
		for (MonsterType monsterType : MonsterManager.getMonsterTypes())
		{
			monsterTypesBySubelement.put(monsterType.getSubElement(), monsterType);
		}
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(0)).size(), 12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(1)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(2)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(3)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(4)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(5)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(10)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(11)).size(), 12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(12)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(13)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(14)).size(), 12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(15)).size(), 12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(20)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(21)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(22)).size(), 14);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(23)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(24)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(25)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(30)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(31)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(32)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(33)).size(), 12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(34)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(35)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(40)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(41)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(42)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(43)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(44)).size(), 12);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(45)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(50)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(51)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(52)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(53)).size(), 10);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(54)).size(), 7);
		assertEquals(monsterTypesBySubelement.get(ElementManager.getSubElementById(55)).size(), 12);

	}
}
