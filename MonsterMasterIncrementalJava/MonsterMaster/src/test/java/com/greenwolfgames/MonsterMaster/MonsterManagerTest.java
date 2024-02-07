package com.greenwolfgames.MonsterMaster;

import java.util.List;

import org.junit.Test;

public class MonsterManagerTest
{
	@Test
	public void testGetMonsterTypes()
	{
		MonsterManager manager = new MonsterManager();
		
		List<MonsterType> monsterTypes = manager.getMonsterTypes();
		for(MonsterType type : monsterTypes)
		{
			System.out.println(type.toString());
		}
				
	}
}
