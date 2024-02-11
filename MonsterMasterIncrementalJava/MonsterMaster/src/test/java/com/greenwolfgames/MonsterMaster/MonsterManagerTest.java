package com.greenwolfgames.MonsterMaster;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class MonsterManagerTest
{
	@Test
	public void testGetMonsterTypes()
	{
		MonsterManager manager = new MonsterManager();
		
		List<MonsterType> monsterTypes = manager.getMonsterTypes();
		assertEquals(monsterTypes.size(),339);
	}
}
